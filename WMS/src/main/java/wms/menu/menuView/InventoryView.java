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
                case "1" -> sortInventory(); // 재고 조회 기준
                case "2" -> moveInventory(); // 재고 이동
                case "0" -> { // 나가기
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
                case "1" -> { // 창고 기준 정렬
                    orderBySectionNo();
                    return;
                }
                case "2" -> { // 상품 카테고리 기준 정렬
                    orderByProduct();
                    return;
                }
                case "0" -> { // 취소
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
        // 이동할 재고 선택
        System.out.println("이동을 원하시는 재고를 선택해주세요.(순번으로 선택)");
        InventoryDto chosenInventory;
        String choice;
        while (true) {
            choice = this.sc.nextLine(); // 재고 순번 입력 받기
            if (isNumeric(choice)) { // 입력값 int 변환 가능 여부 확인
                int order = Integer.parseInt(choice); // 입력값 int 변환
                if (order >= 1 && order <= this.cashInventoryList.size()) { // 입력값 재고 목록 인덱스 범위내 확인
                    chosenInventory = this.cashInventoryList.get(order - 1);
                    printSelectInventory(chosenInventory); // 선택한 재고 출력
                    System.out.println();
                    break;
                }
            }
            System.out.println("잘 못 입력하셨습니다. 다시 입력해주세요.");
        }
        // 이동시킬 재고 수량 선택
        System.out.println("이동시킬 재고 수량을 입력해주세요.(최대: " + chosenInventory.getAmount() + ")");
        int chosenAmount;
        while (true) {
            choice = this.sc.nextLine();
            if (isNumeric(choice)) {
                chosenAmount = Integer.parseInt(choice);
                if (chosenAmount >= 1 && chosenAmount <= chosenInventory.getAmount()) {
                    System.out.println();
                    break;
                }
            }
            System.out.println("잘 못 입력하셨습니다. 다시 입력해주세요.");
        }

        // 창고 선택
        List<WarehouseSectionDto> sectionList = warehouseController.findMoveableSection(
                chosenInventory.getCategoryNo(),
                chosenInventory.getSectionNo(),
                chosenInventory.getCargoSpace()); // 수용 가능한 창고 목록
        if (!sectionList.isEmpty()) { // 수용 가능한 창고가 있을 경우
            System.out.println("이동을 원하시는 창고를 선택해주세요.(순번으로 선택)");
            while (true) {
                choice = this.sc.nextLine(); // 창고 순번 입력 받기
                if (isNumeric(choice)) { // 입력값 int 변환 가능 여부 확인
                    int order = Integer.parseInt(choice); // 입력값 int 변환
                    if (order >= 1 && order <= sectionList.size()) { // 입력값 창고 목록 인덱스 범위내 확인
                        WarehouseSectionDto chosenSection = sectionList.get(order - 1);
                        inventoryController.moveInventory(chosenInventory, chosenAmount, chosenSection.getSectionNo()); // 재고 이동
                    }
                    System.out.println();
                    break;
                }
                System.out.println("잘 못 입력하셨습니다. 다시 입력해주세요.");
            }
        }
    }

    // 선택한 재고 출력
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
