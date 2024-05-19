package wms.menu.model.dto;

import lombok.*;
import wms.common.OrderStatus;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class OutboundDtoForDeploy {
    private int outboundNo;
    private int franchiseNo;
    private LocalDateTime date;
    private String outboundStatus;
}
