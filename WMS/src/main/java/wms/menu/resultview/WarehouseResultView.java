package wms.menu.resultview;

import wms.menu.model.dto.WarehouseSectionDto;

import java.util.List;

public class WarehouseResultView {
    public static void findAllSection(List<WarehouseSectionDto> list) {
        System.out.println("===== 창고 구역 목록 =====");
        for (WarehouseSectionDto warehouseSectionDto : list) {
            System.out.println(warehouseSectionDto);
        }
    }
}
