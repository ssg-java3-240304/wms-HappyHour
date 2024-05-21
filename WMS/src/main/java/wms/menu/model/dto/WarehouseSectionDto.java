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
    private List<InventoryDto> inventoryList;

    public int getCargoSpace() {
        int cargoSpace = 0;
        for (InventoryDto inventoryDto : inventoryList) {
            if (inventoryDto.getProduct() != null) {
                cargoSpace += inventoryDto.getProduct().getCargoSpace() * inventoryDto.getAmount();
            }
        }
        return cargoSpace;
    }

    public int getSectionSpace() {
        int sectionSpace = 0;
        for (WarehouseSectionSpaceDto sectionSpaceDto : sectionSpaceList) {
            sectionSpace += sectionSpaceDto.getZone().getZoneSpace();
        }
        return sectionSpace;
    }

    public int getFreeSpace() {
        int freeSpace = 0;
        // 적재 공간
        freeSpace += getSectionSpace();
        // 적재량
        freeSpace -= getCargoSpace();
        return freeSpace;
    }


}
