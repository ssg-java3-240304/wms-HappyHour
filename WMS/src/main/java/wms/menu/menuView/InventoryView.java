package wms.menu.menuView;

import wms.common.StringPadding;
import wms.menu.controller.InventoryController;
import wms.menu.controller.WarehouseController;
import wms.menu.model.dto.InventoryDto;
import wms.menu.model.dto.WarehouseSectionDto;

import java.util.List;
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
    private WarehouseController warehouseController = new WarehouseController();
    private Scanner sc = new Scanner(System.in);
    private List<InventoryDto> cashInventoryList;

    private void inventoryMenu() {
        String menu = """
                1. 재고 조회 기준
                2. 재고 이동
                0. 나가기
                원하시는 메뉴는 선택해주세요.""";
        orderBySectionNo();
        while (true) {
            System.out.println(menu);
            String choice = sc.nextLine();
            switch (choice) {
                case "1" -> sortInventory();
                case "2" -> moveInventory();
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
                0. 취소""";
        System.out.println(menu);
        while (true) {
            String choice = this.sc.nextLine();
            switch (choice) {
                case "1" -> {
                    orderBySectionNo();
                    return;
                }
                case "2" -> {
                    orderByProduct();
                    return;
                }
                case "0" -> {
                    return;
                }
                default -> System.out.println("잘 못 입력하셨습니다. 다시 입력해주세요.");
            }
        }
    }

    // 구역 기준 정렬
    private void orderBySectionNo() {
        this.cashInventoryList = this.inventoryController.orderBySectionNo();
    }

    // 상품 기준 정렬
    private void orderByProduct() {
        this.cashInventoryList = this.inventoryController.orderByProductName();
    }

    // 재고 이동
    private void moveInventory() {
        System.out.println("이동을 원하시는 재고를 선택해주세요.(순번으로 선택)");
        String choice;
        while (true) {
            choice = this.sc.nextLine();
            if (isNumeric(choice)) { // int 로 변환 가능 여부 확인
                int order = Integer.parseInt(choice);
                if (order >= 1 && order <= this.cashInventoryList.size()) { // 재고 목록의 인덱스 범위내인지 확인
                    InventoryDto chosenInventory = this.cashInventoryList.get(order - 1);
                    printSelectInventory(chosenInventory); // 선택한 재고 출력
                    // 이동 가능한 창고 목록 출력
                    List<WarehouseSectionDto> sectionList = warehouseController.findMoveableSection(chosenInventory.getCategoryNo(), chosenInventory.getSectionNo(), chosenInventory.getCargoSpace());
                    // 이동할 창고 선택
                    System.out.println("이동을 원하시는 창고를 선택해주세요.(순번으로 선택)");
                    while (!sectionList.isEmpty()) {
                        choice = this.sc.nextLine();
                        if (isNumeric(choice)) {
                            order = Integer.parseInt(choice);
                            if (order >= 1 && order <= sectionList.size()) {
                                WarehouseSectionDto chosenSection = sectionList.get(order - 1);
                                inventoryController.moveInventory(chosenInventory.getProductNo(), chosenInventory.getSectionNo(), chosenSection.getSectionNo());
                            }
                            break;
                        }
                        System.out.println("잘 못 입력하셨습니다. 다시 입력해주세요.");
                    }
                    break;
                }
            }
            System.out.println("잘 못 입력하셨습니다. 다시 입력해주세요.");
        }
    }

    private void printSelectInventory(InventoryDto chosenInventory) {
        System.out.println("===== 선택한 재고 =====");
        System.out.printf("|%-10s\t|%-10s\t|%-6s\t|%-10s\t|%-6s\t|\n", "구역", "상품", "수량", "단위당 적재 공간", "적재 공간");
        final int COLUMN_WIDTH = 10;
        String sectionName = StringPadding.padLeft(chosenInventory.getSectionName(), COLUMN_WIDTH);
        String productName = StringPadding.padLeft(chosenInventory.getProductName(), COLUMN_WIDTH);
        String amount = StringPadding.padLeft(chosenInventory.getAmount(), COLUMN_WIDTH);
        String perCargoSpace = StringPadding.padLeft(chosenInventory.getPerCargoSpace(), COLUMN_WIDTH);
        String cargoSpace = StringPadding.padLeft(chosenInventory.getCargoSpace(), COLUMN_WIDTH);
        System.out.printf("|%s\t|%s\t|%s\t|%s\t\t|%s\t|\n", sectionName, productName, amount, perCargoSpace, cargoSpace);
        System.out.println();
    }

    // int 로 변환 가능 여부 확인
    private boolean isNumeric(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
