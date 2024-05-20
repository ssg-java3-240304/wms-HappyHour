package wms.menu.controller;

import wms.menu.model.dto.OutboundOrderDto;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.util.List;

public class OutboundManagementController {
    private final SqlSessionFactory sqlSessionFactory;

    public OutboundManagementController() {
        // MyBatis 설정 파일을 로드하여 SqlSessionFactory 생성
        String resource = "mybatis-config.xml";
        this.sqlSessionFactory = new SqlSessionFactoryBuilder().build(
                this.getClass().getClassLoader().getResourceAsStream(resource)
        );
    }

    // 모든 수주 목록을 가져오는 메서드
    public List<OutboundOrderDto> getAllOrders() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            return session.selectList("OutboundOrderMapper.getAllOrders");
        }
    }

    // 특정 ID의 수주를 가져오는 메서드
    public OutboundOrderDto getOrderById(int orderId) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            return session.selectOne("OutboundOrderMapper.getOrderById", orderId);
        }
    }

    // 수주를 수락하는 메서드
    public void acceptOrder(int orderId) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            session.update("OutboundOrderMapper.acceptOrder", orderId);
            session.commit();
        }
    }

    // 수주를 취소하는 메서드
    public void cancelOrder(int orderId) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            session.update("OutboundOrderMapper.cancelOrder", orderId);
            session.commit();
        }
    }
}
