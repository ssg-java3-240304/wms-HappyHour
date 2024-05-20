package wms.menu.model.service;

import org.apache.ibatis.session.SqlSession;
import wms.common.OrderStatus;
import wms.common.VehicleStatus;
import wms.menu.model.dao.DeliveryMapper;
import wms.menu.model.dto.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static wms.common.MyBatisTemplate.getSqlSession;

public class DeliveryService {

    public List<VehicleDto> findAllVehicles() {
        SqlSession sqlSession =getSqlSession();
        DeliveryMapper deliveryMapper = sqlSession.getMapper(DeliveryMapper.class);
        List<VehicleDto> list = deliveryMapper.findAllVehicles();
        sqlSession.close();
        return list;
    }

    public List<VehicleDto> findUsableVehicles() {
        SqlSession sqlSession =getSqlSession();
        DeliveryMapper deliveryMapper = sqlSession.getMapper(DeliveryMapper.class);
        List<VehicleDto> list = deliveryMapper.findUsableVehicles(VehicleStatus.NOT_DISPATCHED.getStatus());
        sqlSession.close();
        return list;
    }

    public List<DeliveryDto> findDispatchLog(){
        SqlSession sqlSession =getSqlSession();
        DeliveryMapper deliveryMapper = sqlSession.getMapper(DeliveryMapper.class);
        List<DeliveryDto> list = deliveryMapper.findDispatchLog();
        sqlSession.close();
        return list;
    }

    /**
     * 1개의 화물차량을 적재하고 실행 결과를 반환하는 서비스
     * @return
     */
    public DeliveryDto deploySingleVehicle() {
        int vehicleCapacity = 1000;
        SqlSession sqlSession = getSqlSession();
        DeliveryMapper deliveryMapper = sqlSession.getMapper(DeliveryMapper.class);
        DeliveryDto deliveryDto = new DeliveryDto();

//        상품별 전체 재고 목록 받아옴
        List<InventoryForDeploy> totalInventoryList = deliveryMapper.findAllInventory();

//        수주목록 받아옴
        List<OutboundDtoForDeploy> outboundFullList = deliveryMapper.findAllPendingOutbound(OrderStatus.PREPARING.getStatus());
//        재고 내에서 추가 가능한 상품을 추가함
        List<OutboundDtoForDeploy> dispatchedOutboundList = payloadOutbound(totalInventoryList, outboundFullList, vehicleCapacity);
        //배차
        deliveryDto.setOutboundList(dispatchedOutboundList);
        List<VehicleDto> list = deliveryMapper.findUsableVehicles(VehicleStatus.NOT_DISPATCHED.getStatus());
        VehicleDto vehicleDto = list.get(0);
        deliveryDto.setVehicleDto(vehicleDto);
        deliveryDto.setLocalDateTime(LocalDateTime.now());

//        배차가 종료됨과 동시에
        try {
            int result;
            //배차내역 업데이트
            result = deliveryMapper.insertDispatchLog(deliveryDto);
            //차량 업데이트
            deliveryDto.getVehicleDto().setVehicleStatus(VehicleStatus.DISPATCHED.getStatus());
            deliveryMapper.updateVehicleStatus(vehicleDto.getRegistrationNo(), VehicleStatus.DISPATCHED.getStatus());

            //배차수주 업데이트
            for(OutboundDtoForDeploy outboundDto :deliveryDto.getOutboundList()){
                //배차수주 테이블 업데이트
                System.out.println("dispatchNo : " + deliveryDto.getDispatchNo());
                result = deliveryMapper.insertDispatchOutbound(deliveryDto.getDispatchNo(), outboundDto.getOutboundNo());
            }

            //배차상품 업데이트 //delivery_dispatch_product dispatch_no, product_no, amount
            //배차상품 테이블 업데이트 //동시에 재고를 감소
            Map<Integer, Integer> productAmountMap = getDispatchProductMap(deliveryDto);

            for(Map.Entry<Integer, Integer> entry : productAmountMap.entrySet()){
                deliveryMapper.insertDispatchProduct(deliveryDto.getDispatchNo(), entry.getKey(), entry.getValue());    //배차 상품 추가
            }

            //배차 상품 맵을 리스트로 변환
            List<Integer> productKeyList = productAmountMap.keySet().stream().toList();
            //재고 조회
            List<InventoryDto> inventoryList = deliveryMapper.findInventoryByProductNo(productKeyList);

            DispatchDto dispatchDto = new DispatchDto();
            dispatchDto.setDispatchNo();
            dispatchDto.setDate();
            dispatchDto.setProductName();
            dispatchDto.setAmount();
            dispatchDto.setSectionNo();

            //재고 감소 처리
            getDispatchedInventory(inventoryList, productAmountMap);
            //재고 업데이트
            deliveryMapper.dispatchInventory(inventoryList);

            //출고기록 업데이트

            //출고상품 업데이트

            sqlSession.commit();

        } catch (RuntimeException e) {
            sqlSession.rollback();
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
//        배차Dto 반환

        return deliveryDto;
    }

    /**
     * 차량 1대 분량의 수주서 묶음을 반환한다
     * @param inventoryList
     * @param outboundFullList
     * @param vehicleCapacity
     * @return
     */
    private List<OutboundDtoForDeploy> payloadOutbound(List<InventoryForDeploy> inventoryList, List<OutboundDtoForDeploy> outboundFullList, int vehicleCapacity ){
        int payload = 0;
        List<OutboundDtoForDeploy> resultList = new ArrayList<>();
        //        검색하기 편하도록 list를 HashMap으로 변환
        HashMap<Integer, Integer> inventoryHashMap = new HashMap<>();
        for (InventoryForDeploy element : inventoryList) {
            inventoryHashMap.put(element.getProductNo(), element.getAmount());
        }

        for(OutboundDtoForDeploy outboundDto: outboundFullList){
            //적재할 수 없는 크기의 수주일 때 바로 다음 요소를 검사
            if(outboundDto.getCargoSpace() + payload > vehicleCapacity)
                continue;

            //재고 확인
            boolean flag = true;
            for(ProductDtoForDeploy productDto : outboundDto.getProductList()){
                if(productDto.getAmount() > inventoryHashMap.get(productDto.getProductNo())){
                    flag = false;
                }
            }

            //재고가 충분하면 진행 //사용가능한 재고를 감소
            for(ProductDtoForDeploy productDto : outboundDto.getProductList()){
                int amount = inventoryHashMap.get(productDto.getProductNo()) - productDto.getAmount();
                inventoryHashMap.put(productDto.getProductNo(), amount);
            }
            //수주를 resultList에 삽입
            resultList.add(outboundDto);
            payload = payload + outboundDto.getCargoSpace();
        }
        return resultList;
    }

    //배차 상품 삽입
    private Map<Integer, Integer> getDispatchProductMap(DeliveryDto deliveryDto){
        Map<Integer, Integer> productMap = new HashMap<>();

        for(OutboundDtoForDeploy outboundDto : deliveryDto.getOutboundList()){
            for(ProductDtoForDeploy productDto : outboundDto.getProductList()){
                productMap.compute(productDto.getProductNo(),
                        (k, v) -> (v == null) ? productDto.getAmount() : v + productDto.getAmount() );
            }
        }
        return productMap;
    }

    private List<InventoryDto> getDispatchedInventory(List<InventoryDto> inventoryList, Map<Integer, Integer> productAmountMap){
        //            각 재고마다 해쉬 맵을 검사하여 해쉬 맵에 값이 있으면 스스로의 재고를 감소
        for(InventoryDto inventory : inventoryList){
            int productNo = inventory.getProductNo();
            int productAmount = inventory.getAmount();
            if(0 == productAmountMap.get(productNo))
                continue;
            if(productAmountMap.get(productNo) <= productAmount){
                productAmount = productAmount - productAmountMap.get(productNo);
                productAmountMap.put(productNo, 0);
            }else{
                productAmountMap.put(productNo, productAmountMap.get(productNo) - productAmount);
                productAmount = 0;
            }
            inventory.setAmount(productAmount);
        }
        return inventoryList;
    }
}
