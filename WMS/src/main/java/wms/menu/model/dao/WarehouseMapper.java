package wms.menu.model.dao;

import org.apache.ibatis.annotations.Param;
import wms.menu.model.dto.WarehouseSectionDto;

import java.util.List;

public interface WarehouseMapper {
    List<WarehouseSectionDto> findAllSection();
    List<WarehouseSectionDto> findMoveableSection(@Param("categoryNo") int categoryNo,
                                                  @Param("sectionNo") int sectionNo);
}
