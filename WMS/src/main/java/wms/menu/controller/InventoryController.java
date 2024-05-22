package wms.menu.controller;

import wms.common.ErrorView;
import wms.common.error.ErrorCode;
import wms.menu.model.dto.InventoryDto;
import wms.menu.model.dto.WarehouseSectionDto;
import wms.menu.model.service.InventoryService;
import wms.menu.resultview.InventoryResultView;

import java.util.List;

public class InventoryController {
    private InventoryService inventoryService =  new InventoryService();

    public List<InventoryDto> orderBySectionNo() {
        List<InventoryDto> list = inventoryService.orderBySectionNo();
        InventoryResultView.orderBySectionNo(list);
        return list;
    }

    public List<InventoryDto> orderByProductName() {
        List<InventoryDto> list = inventoryService.orderByProductName();
        InventoryResultView.orderByProductName(list);
        return list;
    }

    public void moveInventory(InventoryDto inventory, int moveAmount, int toSectionNo) {
        try {
            int result = 0;
            int productNo = inventory.getProductNo();
            int inventoryAmount = inventory.getAmount();
            int fromSectionNo = inventory.getSectionNo();
            result += inventoryService.insertInventory(productNo, moveAmount, toSectionNo);
            if (inventoryAmount != moveAmount) {
                result += inventoryService.updateInventory(productNo, inventoryAmount - moveAmount, fromSectionNo);
            } else {
                result += inventoryService.deleteInventory(productNo, fromSectionNo);
            }
            result = result >= 2 ? result : 0;
            InventoryResultView.moveInventory("재고 이동", result);
        } catch (Exception e) {
            ErrorView.displayError(ErrorCode.MOVE_INVENTORY_ERROR);
        }
    }
}
