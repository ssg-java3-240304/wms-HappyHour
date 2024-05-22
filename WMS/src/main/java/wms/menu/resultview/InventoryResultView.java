package wms.menu.resultview;

import wms.common.StringPadding;
import wms.menu.model.dto.InventoryDto;

import java.util.List;

public class InventoryResultView {
    private static final int COLUMN_WIDTH = 10;

    public static void orderBySectionNo(List<InventoryDto> list) {
        System.out.println("===== 재고 목록: 창고 기준 정렬 =====");
        System.out.printf("|%-6s|%-10s\t|%-10s\t|%-6s\t|%-10s\t|%-6s\t|\n", "순번", "구역", "상품", "수량", "단위당 적재 공간", "적재 공간");
        int order = 0;
        for (InventoryDto inventoryDto : list) {
            order++;
            String sectionName = StringPadding.padLeft(inventoryDto.getSectionName(), COLUMN_WIDTH);
            String productName = StringPadding.padLeft(inventoryDto.getProductName(), COLUMN_WIDTH);
            String amount = StringPadding.padLeft(inventoryDto.getAmount(), COLUMN_WIDTH);
            String perCargoSpace = StringPadding.padLeft(inventoryDto.getPerCargoSpace(), COLUMN_WIDTH);
            String cargoSpace = StringPadding.padLeft(inventoryDto.getCargoSpace(), COLUMN_WIDTH);
            System.out.printf("|%-6d\t|%s\t|%s\t|%s\t|%s\t\t|%s\t|\n", order, sectionName, productName, amount, perCargoSpace, cargoSpace);
        }
    }

    public static void orderByProductName(List<InventoryDto> list) {
        System.out.println("===== 재고 목록: 상품 기준 정렬 =====");
        System.out.printf("|%-6s|%-10s\t|%-10s\t|%-6s\t|%-10s\t|%-6s\t|\n", "순번", "상품", "구역", "수량", "단위당 적재 공간", "적재 공간");
        int order = 0;
        for (InventoryDto inventoryDto : list) {
            order++;
            String productName = StringPadding.padLeft(inventoryDto.getProductName(), COLUMN_WIDTH);
            String sectionName = StringPadding.padLeft(inventoryDto.getSectionName(), COLUMN_WIDTH);
            String amount = StringPadding.padLeft(inventoryDto.getAmount(), COLUMN_WIDTH);
            String perCargoSpace = StringPadding.padLeft(inventoryDto.getPerCargoSpace(), COLUMN_WIDTH);
            String cargoSpace = StringPadding.padLeft(inventoryDto.getCargoSpace(), COLUMN_WIDTH);
            System.out.printf("|%-6d\t|%s\t|%s\t|%s\t|%s\t\t|%s\t|\n", order, productName, sectionName, amount, perCargoSpace, cargoSpace);
        }
    }

    public static void moveInventory(String type, int result) {
        if (result > 0) {
            System.out.println(type + " 성공");
        } else {
            System.out.println(type + " 실패");
        }
    }
}
