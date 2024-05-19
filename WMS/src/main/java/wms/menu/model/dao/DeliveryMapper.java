package wms.menu.model.dao;

import wms.menu.model.dto.VehicleDto;

import java.util.List;

public interface DeliveryMapper {
    List<VehicleDto> findAllVehicles();
}
