package wms.menu.model.service;

import org.apache.ibatis.session.SqlSession;
import wms.menu.model.dao.InOutboundMapper;
import wms.menu.model.dto.DispatchDto;
import wms.menu.model.dto.ReceiptDto;

import java.util.List;

import static wms.common.MyBatisTemplate.getSqlSession;

public class InOutboundService {
    public List<ReceiptDto> findReceiptLog() {
        SqlSession sqlSession = getSqlSession();
        InOutboundMapper inOutboundMapper = sqlSession.getMapper(InOutboundMapper.class);
        List<ReceiptDto> list = inOutboundMapper.findReceiptLog();
        sqlSession.close();
        return list;
    }

    public List<DispatchDto> findDispatchLog() {
        SqlSession sqlSession = getSqlSession();
        InOutboundMapper inOutboundMapper = sqlSession.getMapper(InOutboundMapper.class);
        List<DispatchDto> list = inOutboundMapper.findDispatchLog();
        sqlSession.close();
        return list;
    }
}
