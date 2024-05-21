package wms.menu.resultview;

import wms.menu.model.dto.ManufacturerDto;
import wms.menu.model.dto.ProductDto;

import java.util.List;

public class ProductResultView {
    public static void displayResult(String type, int result) {
        System.out.println("> " + type + " " + (result > 0 ? "성공!" : "실패!"));
    }

    public static void displayManufacturers(List<ManufacturerDto> list) {
        if (list.isEmpty()) {
            System.out.println("조회된 제조사 목록이 없습니다.");
        } else {
            System.out.println("------------------------------------------------");
            System.out.printf("%s\t%s\t%s\t%s\n", "No.", "Name", "Address", "Phone");
            System.out.println("------------------------------------------------");
            for (ManufacturerDto mDto : list) {
                System.out.printf("%d\t%s\t%s\t%s\n",
                        mDto.getManufacturerNo(),
                        mDto.getManufacturerName(),
                        mDto.getAddress(),
                        mDto.getPhone()
                        );
            }
            System.out.println("------------------------------------------------");
        }
    }

    public static void displayAllProduct(List<ProductDto> list) {
        if (list.isEmpty()) {
            System.out.println("조회된 상품 목록이 없습니다.");
        } else {
            System.out.println("----------------------------------------------------------------------------------------------------");
            System.out.println("                                        상품목록");
            System.out.println("----------------------------------------------------------------------------------------------------");
            System.out.printf("%s %10s %10s %13s %11s %10s %10s %10s %10s\n", "Pr No.", "Name", "Price", "Ct No.", "Mf No.", "alc.Vol", "Capacity", "Cargo Space", "Orderable");
            System.out.println("----------------------------------------------------------------------------------------------------");
            for (ProductDto pDto : list) {
                System.out.printf("%d %10s %10d %10d %10d %10.1f %10d %10d %10s\n",
                        pDto.getProductNo(),
                        pDto.getProductName(),
                        pDto.getProductPrice(),
                        pDto.getCategoryNo(),
                        pDto.getManufacturerNo(),
                        pDto.getAlcoholVolume(),
                        pDto.getCapacity(),
                        pDto.getCargoSpace(),
                        pDto.getOrderableStatus()
                );
            }
            System.out.println("----------------------------------------------------------------------------------------------------");
        }
    }
}