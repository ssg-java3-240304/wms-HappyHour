package wms.menu.resultview;

import wms.menu.model.dto.VehicleDto;

import java.util.List;

public class DeliveryResultView {
    public static void findAllvehicles(List<VehicleDto> list) {
        System.out.println("=====모든 차량 조회=====");
        for(VehicleDto vehicle :list){
            System.out.printf("등록번호: %s , 상태: %s, 적재용량: %d\n",
                    vehicle.getRegistrationNo(), vehicle.getVehicleStatus(), vehicle.getCargoSpace());
        }
    }
}
