package wms.menu.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WarehouseZoneDto {
    private int zoneNo;
    private String zoneName;
    private int zoneSpace;
}
