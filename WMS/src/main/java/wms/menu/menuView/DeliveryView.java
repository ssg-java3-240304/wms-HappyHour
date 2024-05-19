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
//                case "3" -> deliveryController.findAllDeployList();
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

    /**
     * - 차량 배정 전략
     *      수주번호가 빠른 순으로 정렬
     *      수주서를 추가하여 차량 1대분의 출고 내역을 작성
     *      (이때 출고 내역은 배송준비중 으로 한다)
     *      현재 사용 가능한 차량을 조회한다
     *      출고 내역을 차량에 배정 (차량은 배차완료 상태로 한다)
     *
     * - 출고 내역서 1개에 1개의 주문만 포함
     * - 패킹과 출고 내역서는 별개
     * - packDto를 만들 필요가 있음
     *
     */

    public void deploySingleVehicle(){
        //배차가능한 차량이 있는지 조회
        //배차가능 or 배차불가
        //차량에 1대 분량 용량이 될때까지 수주를 추가
        //빈 공간이 현재 입력하고자 하는 수주보다 작다면 다음 수주를 삽입시도
        //적재율 90%를 만족할때까지 반복
        //배차 내역서를 작성
        //배차번호, 차량Dto, 일자,
        System.out.println("배차 가능한 차량을 조회합니다.....");
        try {
            deliveryController.findUsableVehicle();
        }catch (Exception e){
            //조회된 차량이 없을 경우 조기 종료
            return;
        }
        System.out.println("자동 배차를 시작합니다");
        deliveryController.deploySingleVehicle();



    }


}
