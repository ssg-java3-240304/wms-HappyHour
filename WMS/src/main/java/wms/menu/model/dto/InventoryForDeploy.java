package wms.menu.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class InventoryForDeploy {
    private int productNo;
    private int amount;
}
