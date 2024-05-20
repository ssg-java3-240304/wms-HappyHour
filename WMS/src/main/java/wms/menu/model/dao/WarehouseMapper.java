package wms.menu.model.dao;

import wms.menu.model.dto.WarehouseSectionDto;

import java.util.List;

public interface WarehouseMapper {
    List<WarehouseSectionDto> findAllSection();
}
