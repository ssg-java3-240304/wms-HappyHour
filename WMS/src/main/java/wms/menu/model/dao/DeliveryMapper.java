package wms.menu.model.dao;

import wms.menu.model.dto.InventoryForDeploy;
import wms.menu.model.dto.OutboundDtoForDeploy;
import wms.menu.model.dto.VehicleDto;

import java.util.List;

public interface DeliveryMapper {
    List<VehicleDto> findAllVehicles();
    List<VehicleDto> findUsableVehicles(String status);

    List<InventoryForDeploy> findAllInventory();

    List<OutboundDtoForDeploy> findAllPendingOutbound(String status);
}
