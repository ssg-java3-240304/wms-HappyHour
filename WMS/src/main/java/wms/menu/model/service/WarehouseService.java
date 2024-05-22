package wms.menu.model.service;

import org.apache.ibatis.session.SqlSession;
import wms.menu.model.dao.WarehouseMapper;
import wms.menu.model.dto.WarehouseSectionDto;

import java.util.List;

import static wms.common.MyBatisTemplate.getSqlSession;

public class WarehouseService {
    public List<WarehouseSectionDto> findAllSection() {
        SqlSession sqlSession = getSqlSession();
        WarehouseMapper mapper = sqlSession.getMapper(WarehouseMapper.class);
        List<WarehouseSectionDto> list = mapper.findAllSection();
        sqlSession.close();
        return list;
    }

    public List<WarehouseSectionDto> findMoveableSection(int categoryNo, int sectionNo) {
        SqlSession sqlSession = getSqlSession();
        WarehouseMapper mapper = sqlSession.getMapper(WarehouseMapper.class);
        List<WarehouseSectionDto> list = mapper.findMoveableSection(categoryNo, sectionNo);
        sqlSession.close();
        return list;
    }
}
