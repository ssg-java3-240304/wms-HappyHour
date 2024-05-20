package wms.menu.resultview;

import wms.menu.model.dto.WarehouseSectionDto;

import java.util.List;

public class WarehouseResultView {
    public static void findAllSection(List<WarehouseSectionDto> list) {
        System.out.println("===== 창고 구역 목록 =====");
        System.out.println("|구역\t\t|카테고리\t\t|적재 공간\t|");
        for (WarehouseSectionDto warehouseSectionDto : list) {
            String sectionName = warehouseSectionDto.getSectionName();
            String categoryName = warehouseSectionDto.getCategory().getCategoryName();
            int sectionSpace = warehouseSectionDto.getSectionSpace();

            System.out.printf("|%s\t|%s\t\t|%d\t\t|\n", sectionName, categoryName, sectionSpace);
        }
    }
}
