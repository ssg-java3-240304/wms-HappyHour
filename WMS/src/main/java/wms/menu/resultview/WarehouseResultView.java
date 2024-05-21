package wms.menu.resultview;

import wms.common.StringPadding;
import wms.menu.model.dto.WarehouseSectionDto;

import java.util.List;

public class WarehouseResultView {
    private static final int COLUMN_WIDTH = 10;

    public static void findAllSection(List<WarehouseSectionDto> list) {
        System.out.println("===== 창고 구역 목록 =====");
        System.out.printf("|%-6s\t|%-10s\t|%-10s\t|%-6s\t|%-6s\t|%-6s\t|%-10s\t|\n", "순번", "구역명", "상품 카테고리", "상품 적재량", "여유 적재량", "적재 공간", "창고 존");
        int order = 0;
        for (WarehouseSectionDto warehouseSectionDto : list) {
            order++;
            String sectionName = StringPadding.padLeft(warehouseSectionDto.getSectionName(), COLUMN_WIDTH);
            String categoryName = StringPadding.padLeft(warehouseSectionDto.getCategory().getCategoryName(), COLUMN_WIDTH);
            String cargoSpace = StringPadding.padLeft(warehouseSectionDto.getCargoSpace(), COLUMN_WIDTH);
            String freeSpace = StringPadding.padLeft(warehouseSectionDto.getFreeSpace(), COLUMN_WIDTH);
            String sectionSpace = StringPadding.padLeft(warehouseSectionDto.getSectionSpace(), COLUMN_WIDTH);
            System.out.printf("|%-6d\t\t|%s\t|%s\t|%s\t|%s\t|%s\t|\n", order, sectionName, categoryName, cargoSpace, freeSpace, sectionSpace);
        }
    }

    public static void findMoveableSection(List<WarehouseSectionDto> list) {
        if (list == null || list.isEmpty()) {
            System.out.println("이동 가능한 창고가 없습니다.");
        } else {
            System.out.println("===== 이동 가능한 창고 구역 목록 =====");
            System.out.printf("|%-6s\t|%-10s\t|%-10s\t|%-6s\t|%-6s\t|%-6s\t|\n", "순번", "구역명", "상품 카테고리", "상품 적재량", "여유 적재량", "적재 공간");
            int order = 0;
            for (WarehouseSectionDto warehouseSectionDto : list) {
                order++;
                String sectionName = StringPadding.padLeft(warehouseSectionDto.getSectionName(), COLUMN_WIDTH);
                String categoryName = StringPadding.padLeft(warehouseSectionDto.getCategory().getCategoryName(), COLUMN_WIDTH);
                String cargoSpace = StringPadding.padLeft(warehouseSectionDto.getCargoSpace(), COLUMN_WIDTH);
                String freeSpace = StringPadding.padLeft(warehouseSectionDto.getFreeSpace(), COLUMN_WIDTH);
                String sectionSpace = StringPadding.padLeft(warehouseSectionDto.getSectionSpace(), COLUMN_WIDTH);
                System.out.printf("|%-6d\t\t|%s\t|%s\t|%s\t|%s\t|%s\t|\n", order, sectionName, categoryName, cargoSpace, freeSpace, sectionSpace);
            }
        }
    }
}
