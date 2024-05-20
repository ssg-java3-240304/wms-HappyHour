package wms.menu.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ProductDtoForDeploy {
    int productNo;
    int outboundNo;
    int amount;
}
