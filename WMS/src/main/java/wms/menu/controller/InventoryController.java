package wms.menu.controller;

import wms.menu.model.dto.InventoryDto;
import wms.menu.model.service.InventoryService;
import wms.menu.resultview.InventoryResultView;

import java.util.List;

public class InventoryController {
    private InventoryService inventoryService =  new InventoryService();

    public void orderBySection() {
        List<InventoryDto> list = inventoryService.orderBySection();
        InventoryResultView.orderBySection(list);
    }

    public void orderByProduct() {
        List<InventoryDto> list = inventoryService.orderByProduct();
        InventoryResultView.orderByProduct(list);
    }
}
