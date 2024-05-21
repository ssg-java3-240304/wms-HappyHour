package wms.menu.model.dao;

import org.apache.ibatis.annotations.Param;
import wms.menu.model.dto.InventoryDto;

import java.util.List;

public interface InventoryMapper {
    List<InventoryDto> orderBySectionNo();
    List<InventoryDto> orderByProductName();
    int moveInventory(@Param("productNo") int productNo,
                      @Param("fromSectionNo") int fromSectionNo,
                      @Param("toSectionNo") int toSectionNo);
}
