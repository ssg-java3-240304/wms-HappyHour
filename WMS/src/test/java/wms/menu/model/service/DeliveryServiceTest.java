package wms.menu.model.service;

import org.junit.jupiter.api.Test;
import wms.menu.model.dto.DeliveryDto;
import wms.menu.model.dto.OutboundDtoForDeploy;
import wms.menu.model.dto.VehicleDto;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DeliveryServiceTest {
    DeliveryService deliveryService = new DeliveryService();

    @Test
    void deploySingleVehicle() {
        for(VehicleDto vehicleDto : deliveryService.findAllVehicles()){
            System.out.println(vehicleDto);
        }
//        System.out.println(deliveryService.findDispatchLog());
        System.out.println("-----------------------------");

        DeliveryDto deliveryDto = deliveryService.deploySingleVehicle();
        System.out.println("차량번호: " + deliveryDto.getVehicleDto());
        for(OutboundDtoForDeploy outboundDtoForDeploy : deliveryDto.getOutboundList()){
            System.out.println(outboundDtoForDeploy);
        }
        System.out.println("-----------------------------");

        for(VehicleDto vehicleDto : deliveryService.findAllVehicles()){
            System.out.println(vehicleDto);
        }
        System.out.println("-----------------------------");
    }
}