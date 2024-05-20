package wms.menu.controller;

import wms.menu.model.dto.OutboundOrderDto;

import java.util.ArrayList;
import java.util.List;

public class OutboundManagementController {

    public List<OutboundOrderDto> getAllOrders() {
        // 실제로는 데이터베이스나 다른 소스에서 수주 목록을 가져옵니다.
        // 여기서는 예제용으로 몇 개의 수주 데이터를 반환합니다.
        List<OutboundOrderDto> orders = new ArrayList<>();
        return orders;
    }

    public OutboundOrderDto getOrderById(int orderId) {
        // 실제로는 데이터베이스나 다른 소스에서 특정 수주 데이터를 가져옵니다.
        return null;
    }

    public void acceptOrder(int orderId) {
        // 실제로는 데이터베이스나 다른 소스에서 수주 수락 처리를 합니다.
        System.out.println("주문 ID " + orderId + " 수락 처리됨.");
    }

    public void cancelOrder(int orderId) {
        // 실제로는 데이터베이스나 다른 소스에서 수주 취소 처리를 합니다.
        System.out.println("주문 ID " + orderId + " 취소 처리됨.");
    }
}
