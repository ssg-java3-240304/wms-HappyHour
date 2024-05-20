package wms.menu.model.service;

import org.apache.ibatis.session.SqlSession;
import wms.menu.model.dao.InventoryMapper;
import wms.menu.model.dao.WarehouseMapper;
import wms.menu.model.dto.InventoryDto;
import wms.menu.model.dto.WarehouseSectionDto;

import java.util.List;

import static wms.common.MyBatisTemplate.getSqlSession;

public class InventoryService {

    public List<InventoryDto> orderBySection() {
        SqlSession sqlSession = getSqlSession();
        InventoryMapper mapper = sqlSession.getMapper(InventoryMapper.class);
        List<InventoryDto> list = mapper.orderBySection();
        sqlSession.close();
        return list;
    }

    public List<InventoryDto> orderByProduct() {
        SqlSession sqlSession = getSqlSession();
        InventoryMapper mapper = sqlSession.getMapper(InventoryMapper.class);
        List<InventoryDto> list = mapper.orderByProduct();
        sqlSession.close();
        return list;
    }
}
