package wms.menu.model.service;

import org.apache.ibatis.session.SqlSession;
import wms.common.OrderStatus;
import wms.common.VehicleStatus;
import wms.menu.model.dao.DeliveryMapper;
import wms.menu.model.dto.DeliveryDto;
import wms.menu.model.dto.InventoryForDeploy;
import wms.menu.model.dto.OutboundDtoForDeploy;
import wms.menu.model.dto.VehicleDto;

import java.util.List;

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

    /**
     * 1개의 화물차량을 적재하고 실행 결과를 반환하는 서비스
     * @return
     */
    public DeliveryDto deploySingleVehicle() {
        SqlSession sqlSession =getSqlSession();
        DeliveryMapper deliveryMapper = sqlSession.getMapper(DeliveryMapper.class);
        DeliveryDto deliveryDto = new DeliveryDto();
//        전체 재고 목록 받아옴
        List<InventoryForDeploy> inventoryList = deliveryMapper.findAllInventory();
//        수주목록 받아옴
        List<OutboundDtoForDeploy> outboundFullList = deliveryMapper.findAllPendingOutbound(OrderStatus.PREPARING.getStatus());
//        재고 내에서 추가 가능한 상품을 추가함

//        배차가 종료됨과 동시에
//        출고, 재고 업데이트

//        배차내역, 차량, 배차수주, 배차상품 업데이트

//        배차Dto 반환

        return null;
    }
}
