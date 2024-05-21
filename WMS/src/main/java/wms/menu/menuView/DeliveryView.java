package wms.menu.menuView;

import wms.menu.controller.DeliveryController;

import java.util.Scanner;

public class DeliveryView {
    //배차 관련 뷰
    DeliveryController deliveryController = new DeliveryController();
    private Scanner sc = new Scanner(System.in);

    public void deliveryMenu(){
        String menu = """
                1. 차량 조회
                2. 배차
                3. 배차내역
                4. 출고
                0. 뒤로가기
                > 메뉴를 선택하세요 : """;
        while(true) {
            System.out.print(menu);
            String choice = sc.next();
            switch (choice) {
                case "1" -> findAllVehicles();
                case "2" -> deploySingleVehicle();
                case "3" -> findAllDeployList();
//                case "4" -> deliveryController.shipment();
                case "0" -> {return;}
                default -> System.out.println("잘못 입력하셨습니다.");
            }
        }
    }
    public void findAllVehicles(){
        System.out.println("모든 차량 조회");
        deliveryController.findAllVehicles();
    }

    public void deploySingleVehicle(){
        System.out.println("배차 가능한 차량을 조회합니다.....");
        try {
            deliveryController.findUsableVehicle();
        }catch (Exception e){
            //조회된 차량이 없을 경우 조기 종료
            return;
        }
        System.out.println("배차 가능 합니다...");
        System.out.println("자동 배차를 시작합니다");
        deliveryController.deploySingleVehicle();
    }

    public void findAllDeployList(){
        System.out.println("모든 배차 목록을 조회 합니다");
        deliveryController.findAllDeployList();
    }

}
