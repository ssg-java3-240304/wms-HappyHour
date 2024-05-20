package wms.menu.controller;

import org.junit.jupiter.api.*;
import wms.menu.model.dto.OutboundOrderDto;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OutboundManagementControllerTest {

    private OutboundManagementController controller;

    @BeforeEach
    void setUp() {
        controller = new OutboundManagementController();
    }

    @Test
    void testGetAllOrders() {
        List<OutboundOrderDto> orders = controller.getAllOrders();
        assertNotNull(orders);
        assertFalse(orders.isEmpty());
        // 여기에 추가적인 검증 로직을 작성하세요
    }

    @Test
    void testGetOrderById() {
        // 존재하는 주문 ID를 사용하여 테스트하세요
        int orderId = 1;
        OutboundOrderDto order = controller.getOrderById(orderId);
        assertNotNull(order);
        assertEquals(orderId, order.getId());
        // 여기에 추가적인 검증 로직을 작성하세요
    }

    @Test
    void testAcceptOrder() {
        // 테스트를 위한 주문 ID를 사용하세요
        int orderId = 1;
        // 테스트 전에 주문 상태를 확인하세요
        OutboundOrderDto orderBefore = controller.getOrderById(orderId);
        assertNotNull(orderBefore);
        String statusBefore = orderBefore.getOrderStatus();

        // 주문 수락을 실행하세요
        controller.acceptOrder(orderId);

        // 주문을 다시 가져와서 주문 상태가 변경되었는지 확인하세요
        OutboundOrderDto orderAfter = controller.getOrderById(orderId);
        assertNotNull(orderAfter);
        assertNotEquals(statusBefore, orderAfter.getOrderStatus());
        assertEquals("Accepted", orderAfter.getOrderStatus());
        // 여기에 추가적인 검증 로직을 작성하세요
    }

    @Test
    void testCancelOrder() {
        // 테스트를 위한 주문 ID를 사용하세요
        int orderId = 1;
        // 테스트 전에 주문 상태를 확인하세요
        OutboundOrderDto orderBefore = controller.getOrderById(orderId);
        assertNotNull(orderBefore);
        String statusBefore = orderBefore.getOrderStatus();

        // 주문 취소를 실행하세요
        controller.cancelOrder(orderId);

        // 주문을 다시 가져와서 주문 상태가 변경되었는지 확인하세요
        OutboundOrderDto orderAfter = controller.getOrderById(orderId);
        assertNotNull(orderAfter);
        assertNotEquals(statusBefore, orderAfter.getOrderStatus());
        assertEquals("Cancelled", orderAfter.getOrderStatus());
        // 여기에 추가적인 검증 로직을 작성하세요
    }
}
