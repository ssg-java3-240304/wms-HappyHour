package wms.menu.model.dto;

import lombok.*;
import wms.common.OrderStatus;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class OutboundDtoForDeploy {
    private int outboundNo; //수주번호
    private int franchiseNo;    //주문점
    private LocalDateTime date; //수주시간
    private String outboundStatus;  //수주상태
    private List<ProductDtoForDeploy> productList;  //상품 목록
    private int cargoSpace; //수주의 부피
}
