package wms.menu.controller;

import wms.menu.model.dto.WarehouseSectionDto;
import wms.menu.model.service.WarehouseService;
import wms.menu.resultview.WarehouseResultView;

import java.util.List;

public class WarehouseController {
    private WarehouseService warehouseService = new WarehouseService();

    public void findAllSection() {
        List<WarehouseSectionDto> list = this.warehouseService.findAllSection();
        WarehouseResultView.findAllSection(list);
    }

    public List<WarehouseSectionDto> findMoveableSection(int categoryNo, int sectionNo, int cargoSpace) {
        List<WarehouseSectionDto> list = this.warehouseService.findMoveableSection(categoryNo, sectionNo);
        list.removeIf(section -> section.getFreeSpace() <= cargoSpace);
        WarehouseResultView.findMoveableSection(list);
        return list;
    }
}
