package wms.menu.controller;

import wms.menu.model.dto.WarehouseSectionDto;
import wms.menu.model.service.WarehouseService;
import wms.menu.resultview.WarehouseResultView;

import java.util.List;

public class WarehouseController {
    private WarehouseService warehouseService = new WarehouseService();

    // 창고 구역 조회
    public List<WarehouseSectionDto> findAllSection() {
        List<WarehouseSectionDto> list = this.warehouseService.findAllSection();
        WarehouseResultView.findAllSection(list);
        return list;
    }

    // 재고가 이동할 수 있는 창고 목록 출력
    public List<WarehouseSectionDto> findMoveableSection(int categoryNo, int sectionNo, int cargoSpace) {
        List<WarehouseSectionDto> list = this.warehouseService.findMoveableSection(categoryNo, sectionNo);
        list.removeIf(section -> section.getFreeSpace() <= cargoSpace);
        WarehouseResultView.findMoveableSection(list);
        return list;
    }
}
