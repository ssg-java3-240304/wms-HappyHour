package wms.menu.model.service;

import org.apache.ibatis.session.SqlSession;
import wms.common.error.ErrorCode;
import wms.menu.model.dao.InventoryMapper;
import wms.menu.model.dto.InventoryDto;
import wms.menu.model.dto.WarehouseSectionDto;

import java.util.List;

import static wms.common.MyBatisTemplate.getSqlSession;

public class InventoryService {

    public List<InventoryDto> orderBySectionNo() {
        SqlSession sqlSession = getSqlSession();
        InventoryMapper mapper = sqlSession.getMapper(InventoryMapper.class);
        List<InventoryDto> list = mapper.orderBySectionNo();
        sqlSession.close();
        return list;
    }

    public List<InventoryDto> orderByProductName() {
        SqlSession sqlSession = getSqlSession();
        InventoryMapper mapper = sqlSession.getMapper(InventoryMapper.class);
        List<InventoryDto> list = mapper.orderByProductName();
        sqlSession.close();
        return list;
    }

    public int moveInventory(int productNo, int fromSectionNo, int toSectionNo) {
        SqlSession sqlSession = getSqlSession();
        InventoryMapper mapper = sqlSession.getMapper(InventoryMapper.class);
        try {
            int result = mapper.moveInventory(productNo, fromSectionNo, toSectionNo);
            sqlSession.commit();
            return result;
        } catch (Exception e) {
            sqlSession.rollback();
            throw new RuntimeException(e);
        } finally {
            sqlSession.close();
        }
    }
}
