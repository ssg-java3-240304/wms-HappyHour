package wms.menu.model.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class DeliveryDto {
    private int dispatchNo; //배차번호
    private VehicleDto vehicleDto;  //차량번호
    private LocalDateTime localDateTime;    //배차시간
    private List<OutboundDtoForDeploy> outboundList;    //화물 목록
}
