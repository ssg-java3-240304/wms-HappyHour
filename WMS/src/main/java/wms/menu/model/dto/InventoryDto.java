package wms.menu.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventoryDto {
    private int sectionNo;
    private int productNo;
    private int amount;

    private WarehouseSectionDto warehouseSection;
    private ProductDto product;

    public String getSectionName() {
        return this.warehouseSection.getSectionName();
    }
    public String getProductName() {
        return this.product.getProductName();
    }
    public int getPerCargoSpace() {
        return this.product.getCargoSpace();
    }
    public int getCargoSpace() {
        return this.product.getCargoSpace() * this.amount;
    }
    public int getCategoryNo() {
        return this.product.getCategoryNo();
    }
}