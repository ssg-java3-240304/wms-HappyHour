package wms.menu.model.service;

import org.apache.ibatis.session.SqlSession;
import wms.common.VehicleStatus;
import wms.menu.model.dao.DeliveryMapper;
import wms.menu.model.dto.DeliveryDto;
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

    public DeliveryDto deploySingleVehicle() {

    }
}
