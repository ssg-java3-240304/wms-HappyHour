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

    // 구역명
    private String sectionName;
    // 상품명
    private String productName;
    // 상품의 적재 공간
    private int cargoSpace;
}