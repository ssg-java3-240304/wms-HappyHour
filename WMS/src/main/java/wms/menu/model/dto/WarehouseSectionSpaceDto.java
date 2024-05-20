package wms.menu.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WarehouseSectionSpaceDto {
    private int sectionNo;
    private int zoneNo;

    private WarehouseZoneDto zoneList;
}
