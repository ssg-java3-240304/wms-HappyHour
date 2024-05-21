package wms.menu.menuView;

import wms.menu.controller.InOutboundController;

import java.util.Scanner;

public class InOutboundView {
    // 입출고 관리
    /**
     * 1. 입출고 목록
     * 입고 따로, 출고 따로 볼건지가 잇으면 좋지 않을까 싶습니다
     */
    private InOutboundController inOutboundController = new InOutboundController();
    private Scanner sc = new Scanner(System.in);
    public void inOutboundView(){
        String menu = """
                =================
                1. 입고 내역
                2. 출고 내역
                3. 입출고 내역
                0. 나가기
                =================
                입력 : """;
        while (true) {
            System.out.print(menu);
            String choice = sc.next();
            switch (choice){
                case "1" : inOutboundController.findReceiptLog(); break;
                case "2" : inOutboundController.findDispatchLog(); break;
                case "3" : inOutboundController.findReceiptDispatchLog(); break;
                case "0" : return;
                default:
                    System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
            }
        }
    }
}
