package wms.menu.menuView;

import wms.menu.controller.InventoryController;

import java.util.Scanner;

public class InventoryView {
    // 재고관리 뷰
    /**
     * 1. 재고 보기 형식
     * 2. 재고 목록
     * 3. 이동
     */
    public static void main(String[] args) {
        new InventoryView().inventoryMenu();
    }
    private InventoryController inventoryController = new InventoryController();
    private Scanner sc = new Scanner(System.in);

    private void inventoryMenu() {
        String menu = """
                1. 재고 조회 기준
                2. 재고 이동
                0. 나가기
                원하시는 메뉴는 선택해주세요.""";
        while (true) {
            findBySection();
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

    private void sortInventory() {
        String menu = """
                원하시는 정렬 기준을 선택해주세요.
                1. 창고
                2. 상품 카테고리
                0. 취소
                """;
    }

    private void findByCategory() {

    }

    private void findBySection() {

    }
}
