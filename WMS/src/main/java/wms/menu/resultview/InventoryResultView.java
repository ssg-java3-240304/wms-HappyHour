package wms.menu.resultview;

import wms.common.StringPadding;
import wms.menu.model.dto.InventoryDto;

import java.util.List;

public class InventoryResultView {
    private static final int COLUMN_WIDTH = 10;

    public static void orderBySection(List<InventoryDto> list) {
        System.out.println("===== 재고 목록: 창고 기준 정렬 =====");
        System.out.printf("|%-10s\t|%-10s\t|%-8s\t|%-8s\t|\n", "구역", "상품", "수량", "적재 공간");
        for (InventoryDto inventoryDto : list) {
            String sectionName = StringPadding.padLeft(inventoryDto.getSectionName(), COLUMN_WIDTH);
            String productName = StringPadding.padLeft(inventoryDto.getProductName(), COLUMN_WIDTH);
            String amount = StringPadding.padLeft(inventoryDto.getAmount(), COLUMN_WIDTH);
            String cargoSpace = StringPadding.padLeft(inventoryDto.getCargoSpace() * inventoryDto.getAmount(), COLUMN_WIDTH);
            System.out.printf("|%s\t|%s\t|%s\t|%s\t|\n", sectionName, productName, amount, cargoSpace);
        }
    }

    public static void orderByProduct(List<InventoryDto> list) {
        System.out.println("===== 재고 목록: 상품 기준 정렬 =====");
        System.out.printf("|%-10s\t|%-10s\t|%-8s\t|%-8s\t|\n", "상품", "구역", "수량", "적재 공간");
        for (InventoryDto inventoryDto : list) {
            String productName = StringPadding.padLeft(inventoryDto.getProductName(), COLUMN_WIDTH);
            String sectionName = StringPadding.padLeft(inventoryDto.getSectionName(), COLUMN_WIDTH);
            String amount = StringPadding.padLeft(inventoryDto.getAmount(), COLUMN_WIDTH);
            String cargoSpace = StringPadding.padLeft(inventoryDto.getCargoSpace() * inventoryDto.getAmount(), COLUMN_WIDTH);
            System.out.printf("|%s\t|%s\t|%s\t|%s\t|\n", productName, sectionName, amount, cargoSpace);
        }
    }
}
