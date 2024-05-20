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

import static wms.common.MyBatisTemplate.getSqlSession;

public class DeliveryService {
//    public List<VehicleDto> findAllVehicles() {
//        SqlSession sqlSession =getSqlSession();
//        DeliveryMapper deliveryMapper = sqlSession.getMapper(DeliveryMapper.class);
//        List<VehicleDto> list = deliveryMapper.findAllVehicles();
//        sqlSession.close();
//        return list;
//    }
//
//    public List<VehicleDto> findUsableVehicles() {
//        SqlSession sqlSession =getSqlSession();
//        DeliveryMapper deliveryMapper = sqlSession.getMapper(DeliveryMapper.class);
//        List<VehicleDto> list = deliveryMapper.findUsableVehicles(VehicleStatus.NOT_DISPATCHED.getStatus());
//        sqlSession.close();
//        return list;
//    }
//
//    public List<DeliveryDto> findDispatchLog(){
//        SqlSession sqlSession =getSqlSession();
//        DeliveryMapper deliveryMapper = sqlSession.getMapper(DeliveryMapper.class);
//        List<DeliveryDto> list = deliveryMapper.findDispatchLog();
//        sqlSession.close();
//        return list;
//    }
//
//    /**
//     * 1개의 화물차량을 적재하고 실행 결과를 반환하는 서비스
//     * @return
//     */
//    public DeliveryDto deploySingleVehicle() {
//        int vehicleCapacity = 1000;
//        SqlSession sqlSession = getSqlSession();
//        DeliveryMapper deliveryMapper = sqlSession.getMapper(DeliveryMapper.class);
//        DeliveryDto deliveryDto = new DeliveryDto();
//
////        전체 재고 목록 받아옴
//        List<InventoryForDeploy> inventoryList = deliveryMapper.findAllInventory();
//
////        수주목록 받아옴
//        List<OutboundDtoForDeploy> outboundFullList = deliveryMapper.findAllPendingOutbound(OrderStatus.PREPARING.getStatus());
////        재고 내에서 추가 가능한 상품을 추가함
//        List<OutboundDtoForDeploy> dispatchedOutboundList = payloadOutbound(inventoryList, outboundFullList, vehicleCapacity);
//        //배차
//        deliveryDto.setOutboundList(dispatchedOutboundList);
//        List<VehicleDto> list = deliveryMapper.findUsableVehicles(VehicleStatus.NOT_DISPATCHED.getStatus());
//        deliveryDto.setVehicleDto(list.get(0));
//        deliveryDto.setLocalDateTime(LocalDateTime.now());
//
////        배차가 종료됨과 동시에
//        try {
//            int result;
//            //배차내역 업데이트
//            result = deliveryMapper.insertDispatchLog(deliveryDto);
//            //차량 업데이트
//            //배차수주 업데이트
//            //배차상품 업데이트
//            //재고 업데이트
//            //출고기록 업데이트
//            //출고상품 업데이트
//            sqlSession.commit();
//        } catch (RuntimeException e) {
//            sqlSession.rollback();
//        }finally {
//            sqlSession.close();
//        }
////        배차Dto 반환
//
//        return deliveryDto;
//    }
//
//    /**
//     * 차량 1대 분량의 수주서 묶음을 반환한다
//     * @param inventoryList
//     * @param outboundFullList
//     * @param vehicleCapacity
//     * @return
//     */
//    private List<OutboundDtoForDeploy> payloadOutbound(List<InventoryForDeploy> inventoryList, List<OutboundDtoForDeploy> outboundFullList, int vehicleCapacity ){
//        int payload = 0;
//        List<OutboundDtoForDeploy> resultList = new ArrayList<>();
//        //        검색하기 편하도록 list를 HashMap으로 변환
//        HashMap<Integer, Integer> inventoryHashMap = new HashMap<>();
//        for (InventoryForDeploy element : inventoryList) {
//            inventoryHashMap.put(element.getProductNo(), element.getAmount());
//        }
//
//        for(OutboundDtoForDeploy outboundDto: outboundFullList){
//            //적재할 수 없는 크기의 수주일 때 바로 다음 요소를 검사
//            if(outboundDto.getCargoSpace() + payload > vehicleCapacity)
//                continue;
//
//            //재고 확인
//            boolean flag = true;
//            for(ProductDtoForDeploy productDto : outboundDto.getProductList()){
//                if(productDto.getAmount() > inventoryHashMap.get(productDto.getProductNo())){
//                    flag = false;
//                }
//            }
//
//            //재고가 충분하면 진행 //사용가능한 재고를 감소
//            for(ProductDtoForDeploy productDto : outboundDto.getProductList()){
//                int amount = inventoryHashMap.get(productDto.getProductNo()) - productDto.getAmount();
//                inventoryHashMap.put(productDto.getProductNo(), amount);
//            }
//            //수주를 resultList에 삽입
//            resultList.add(outboundDto);
//            payload = payload + outboundDto.getCargoSpace();
//        }
//        return resultList;
//    }
}
