package wms.menu.model.dao;

import wms.menu.model.dto.InventoryDto;

import java.util.List;

public interface InventoryMapper {
    List<InventoryDto> orderBySection();
    List<InventoryDto> orderByProduct();
}
