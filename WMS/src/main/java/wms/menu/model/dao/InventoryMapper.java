package wms.menu.model.dao;

import org.apache.ibatis.annotations.Param;
import wms.menu.model.dto.InventoryDto;

import java.util.List;

public interface InventoryMapper {
    List<InventoryDto> orderBySectionNo();

    List<InventoryDto> orderByProductName();

    int insertInventory(
            @Param("sectionNo") int sectionNo,
            @Param("productNo") int productNo,
            @Param("amount") int amount);

    int updateInventory(
            @Param("sectionNo") int sectionNo,
            @Param("productNo") int productNo,
            @Param("amount") int amount);

    int deleteInventory(
            @Param("sectionNo") int sectionNo,
            @Param("productNo") int productNo);
}
