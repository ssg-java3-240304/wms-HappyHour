package wms.menu.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WarehouseSectionDto {
    private int sectionNo;
    private String sectionName;
    private int categoryNo;

    private List<WarehouseSectionSpaceDto> sectionSpaceList;
    private ProductCategoryDto category;
}
