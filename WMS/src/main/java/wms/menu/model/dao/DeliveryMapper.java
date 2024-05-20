package wms.menu.model.dao;

import org.apache.ibatis.annotations.Param;
import wms.menu.model.dto.DeliveryDto;
import wms.menu.model.dto.InventoryForDeploy;
import wms.menu.model.dto.OutboundDtoForDeploy;
import wms.menu.model.dto.VehicleDto;

import java.util.List;

public interface DeliveryMapper {

    List<VehicleDto> findAllVehicles();
    List<VehicleDto> findUsableVehicles(String status);

    List<InventoryForDeploy> findAllInventory();

    List<OutboundDtoForDeploy> findAllPendingOutbound(String status);

    int insertDispatchLog(DeliveryDto deliveryDto);

    List<DeliveryDto> findDispatchLog();

    int insertDispatchOutbound(@Param("dispatchNo") int dispatchNo, @Param("outboundNo") int outboundNo);


    void updateVehicleStatus(@Param("registrationNo") String registrationNo, @Param("vehicleStatus") String status);

    void insertDispatchProduct(@Param("dispatchNo")int dispatchNo, @Param("productNo") Integer productNo, @Param("productNo") Integer amount);
}