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

    private ProductCategoryDto category;
    private List<WarehouseSectionSpaceDto> sectionSpaceList;

    public int getSectionSpace() {
        int sectionSpace = 0;
        for (WarehouseSectionSpaceDto sectionSpaceDto : sectionSpaceList) {
            sectionSpace += sectionSpaceDto.getZone().getZoneSpace();
        }
        return sectionSpace;
    }
}
