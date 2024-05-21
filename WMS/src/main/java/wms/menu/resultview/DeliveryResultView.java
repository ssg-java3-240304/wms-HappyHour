package wms.menu.resultview;

import wms.menu.model.dto.DeliveryDto;
import wms.menu.model.dto.OutboundDtoForDeploy;
import wms.menu.model.dto.VehicleDto;

import java.util.List;

public class DeliveryResultView {
    public static void findAllvehicles(List<VehicleDto> list) {
        System.out.println("=====모든 차량 조회=====");
        vehicleList(list);
    }
    public static void findUsableVehicles(List<VehicleDto> list) throws Exception {
        System.out.println("=====이용 가능한 차량 조회=====");
        if(list == null){
            System.out.println("배차 가능한 차량이 없습니다");
            throw new Exception("조회된 차량이 없습니다");
        }
        vehicleList(list);
    }


    public static void vehicleList(List<VehicleDto> list){
        for(VehicleDto vehicle :list){
            System.out.printf("등록번호: %s , 상태: %s, 적재용량: %d\n",
                    vehicle.getRegistrationNo(), vehicle.getVehicleStatus(), vehicle.getCargoSpace());
        }
    }

    public static void deploySingleVehicle(DeliveryDto deliveryDto) {
        if(deliveryDto == null){
            System.out.println("배차 할 수 없습니다");
            return ;
        }
        System.out.println("배차 결과");
        System.out.printf("배차번호 : %d, 차량번호 : %s , 작성시간 : %s\n",deliveryDto.getDispatchNo(), deliveryDto.getVehicleDto().getRegistrationNo(), deliveryDto.getLocalDateTime());
        System.out.println("적재 주문 목록 : ");
        for(OutboundDtoForDeploy outbound : deliveryDto.getOutboundList()){
            System.out.printf("[%d]  ", outbound.getOutboundNo());
        }
        System.out.println("\n");
    }

    public static void showAllDeployList(List<DeliveryDto> deliveryDtoList) {
        System.out.print("""
                ========전체 배차 내역을 출력합니다========
                """);
        if(deliveryDtoList.isEmpty())
            System.out.println("배차내역이 없습니다");
        for(DeliveryDto deliveryDto : deliveryDtoList){
            System.out.printf("배차번호 : %d, 차량번호 : %S, 배차시간 : %s\n", deliveryDto.getDispatchNo(), deliveryDto.getVehicleDto().getRegistrationNo(), deliveryDto.getLocalDateTime());
            System.out.print(" - 배정된 주문서 : ");
            for(OutboundDtoForDeploy outbound: deliveryDto.getOutboundList()) {
                System.out.print(outbound.getOutboundNo() + " ");
            }
            System.out.println();
        }
    }
}