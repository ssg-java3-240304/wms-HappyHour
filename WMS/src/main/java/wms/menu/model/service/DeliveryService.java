package wms.menu.model.service;

import org.apache.ibatis.session.SqlSession;
import wms.menu.model.dao.DeliveryMapper;
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
}
