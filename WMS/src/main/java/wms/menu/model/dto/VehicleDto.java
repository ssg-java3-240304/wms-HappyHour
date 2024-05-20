package wms.menu.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class VehicleDto {
    private String registrationNo;
    private String vehicleStatus;
    private int cargoSpace;

}
