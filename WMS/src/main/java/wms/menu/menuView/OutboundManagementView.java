package wms.menu.menuView;

import wms.menu.controller.OutboundManagementController;
import wms.menu.model.dto.OutboundOrderDto;

import java.util.List;
import java.util.Scanner;

public class OutboundManagementView {
    private Scanner sc = new Scanner(System.in);
    private OutboundManagementController outboundManagementController = new OutboundManagementController();

    public void outboundManagementMenu() {
        String menu = """
                ===================
                1. 수주 목록 (요약)
                0. 나가기
                ===================
                입력 : """;
        while (true) {
            System.out.print(menu);
            if (!sc.hasNextInt()) {
                System.out.println("잘못된 입력입니다. 숫자를 입력하세요.");
                sc.next(); // 잘못된 입력을 소비
                continue;
            }
            int choice = sc.nextInt();
            sc.nextLine(); // 입력 버퍼 비우기
            switch (choice) {
                case 1:
                    //showOrderSummary();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("잘못 입력하셨습니다.");
            }
        }
    }

    // 수주 요약 내역을 보여주는 메서드
    private void showOrderSummary() {
        System.out.println("수주 요약 내역:");
        List<OutboundOrderDto> orders = outboundManagementController.getAllOrders();
        int index = 1;
        for (OutboundOrderDto order : orders) {
            System.out.println(index + ". 주문 ID: " + order.getId() +
                    ", 수주 일자: " + order.getOrderDate() +
                    ", 수주 상태: " + order.getOrderStatus() +
                    ", 배송 상태: " + order.getDeliveryStatus() +
                    ", 상품 요약 정보: " + order.getProductSummary() +
                    ", 상세보기: " + "상세보기");
            index++;
        }
        System.out.print("상세보기를 보시려면 항목 번호를 누르세요 뒤로가시려면 0번을 누르세요 : ");
        if (!sc.hasNextInt()) {
            System.out.println("잘못된 입력입니다. 숫자를 입력하세요.");
            sc.next(); // 잘못된 입력을 소비
            return;
        }
        int itemNumber = sc.nextInt();
        sc.nextLine(); // 입력 버퍼 비우기
        if (itemNumber == 0) {
            return;
        } else {
            if (itemNumber > 0 && itemNumber <= orders.size()) {
                int orderId = orders.get(itemNumber - 1).getId();
                showOrderDetails(orderId);
            } else {
                System.out.println("잘못된 항목 번호입니다.");
            }
        }
    }

    // 수주 상세 내역을 보여주는 메서드
    private void showOrderDetails() {
        System.out.print("상세 내역을 볼 주문 ID를 입력하세요: ");
        if (!sc.hasNextInt()) {
            System.out.println("잘못된 입력입니다. 숫자를 입력하세요.");
            sc.next(); // 잘못된 입력을 소비
            return;
        }
        int orderId = sc.nextInt();
        sc.nextLine(); // 입력 버퍼 비우기
        showOrderDetails(orderId);
    }

    // 특정 주문의 상세 내역을 보여주는 메서드
    private void showOrderDetails(int orderId) {
        OutboundOrderDto order = outboundManagementController.getOrderById(orderId);
        if (order != null) {
            System.out.println("주문 ID: " + order.getId());
            System.out.println("주문 날짜: " + order.getOrderDate());
            System.out.println("주문 상태: " + order.getOrderStatus());
            System.out.println("배송 상태: " + order.getDeliveryStatus());
            System.out.println("상품 상세 정보: " + order.getProductDetails());

            System.out.println("1. 수락");
            System.out.println("2. 취소");
            System.out.print("입력: ");
            if (!sc.hasNextInt()) {
                System.out.println("잘못된 입력입니다. 숫자를 입력하세요.");
                sc.next(); // 잘못된 입력을 소비
                return;
            }
            int action = sc.nextInt();
            sc.nextLine(); // 입력 버퍼 비우기
            handleOrderAction(orderId, action);
        } else {
            System.out.println("해당 ID의 주문을 찾을 수 없습니다.");
        }
    }

    // 수주 수락 또는 취소를 처리하는 메서드
    private void handleOrderAction(int orderId, int action) {
        switch (action) {
            case 1:
                outboundManagementController.acceptOrder(orderId);
                System.out.println("주문이 수락되었습니다.");
                break;
            case 2:
                outboundManagementController.cancelOrder(orderId);
                System.out.println("주문이 취소되었습니다.");
                break;
            default:
                System.out.println("잘못된 입력입니다.");
        }
    }
}
