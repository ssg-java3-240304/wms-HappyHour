package wms.menu.model.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class DeliveryDto {
    private int dispatchNo;
    private VehicleDto vehicleDto;
    private LocalDateTime localDateTime;
    private List<OutboundOrderDto> outboundList;
    Map<Integer, Integer> productMap = new HashMap<>();
}
