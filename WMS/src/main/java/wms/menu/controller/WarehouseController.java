package wms.menu.controller;

import wms.menu.model.dto.WarehouseSectionDto;
import wms.menu.model.service.WarehouseService;
import wms.menu.resultview.WarehouseResultView;

import java.util.List;

public class WarehouseController {
    private WarehouseService warehouseService = new WarehouseService();

    public void findAllSection() {
        List<WarehouseSectionDto> list = warehouseService.findAllSection();
        WarehouseResultView.findAllSection(list);
    }
}
