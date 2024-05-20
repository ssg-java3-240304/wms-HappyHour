package wms.menu.menuView;

import wms.menu.controller.WarehouseController;
import wms.menu.model.service.WarehouseService;

import java.util.Scanner;

public class WarehouseView {
    // 창고관리 뷰

    /**
     * 1. 창고 구역 목록
     * 2. 창고 구역 등록
     * 3. 창고 구역 삭제
     * 4. 창고 구역 수정
     */
    public static void main(String[] args) {
        new WarehouseView().warehouseMenu();
    }

    private WarehouseController warehouseController = new WarehouseController();
    private Scanner sc = new Scanner(System.in);

    public void warehouseMenu() {
        String menu = """
                1. 창고 구역 등록
                2. 창고 구역 삭제
                3. 창고 구역 수정
                0. 나가기
                원하시는 메뉴는 선택해주세요.""";
        while (true) {
            findAllSection();
            System.out.println(menu);
            String choice = sc.nextLine();
            switch (choice) {
//                case "1" ->
                case "0" -> {
                    return;
                }
                default -> System.out.println("잘 못 입력하셨습니다. 다시 입력해주세요.");
            }
        }
    }

    private void findAllSection() {
        warehouseController.findAllSection();
    }
}
