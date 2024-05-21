package wms.menu.resultview;

import wms.menu.model.dto.ManufacturerDto;
import wms.menu.model.dto.ProductCategoryDto;
import wms.menu.model.dto.ProductDto;

import java.util.List;

public class ProductResultView {
    public static void displayResult(String type, int result) {
        System.out.println("> " + type + " " + (result > 0 ? "성공!" : "실패!"));
    }

    // 제조사 목록
    public static void displayManufacturers(List<ManufacturerDto> list) {
        if (list.isEmpty()) {
            System.out.println("조회된 제조사 목록이 없습니다.");
        } else {
            System.out.println("--------------------------------------------------------------------------------------------------------------");
            System.out.printf("%-5s\t %-25s\t %-50s\t %-40s\n", "No.", "Name", "Address", "Phone");
            System.out.println("--------------------------------------------------------------------------------------------------------------");
            for (ManufacturerDto mDto : list) {
                System.out.printf("%-5d\t %-20s\t %-40s\t %-40s\n",
                        mDto.getManufacturerNo(),
                        mDto.getManufacturerName(),
                        mDto.getAddress(),
                        mDto.getPhone()
                        );
            }
            System.out.println("--------------------------------------------------------------------------------------------------------------");
        }
    }

    // 상품 목록
    public static void displayAllProduct(List<ProductDto> list) {
        if (list.isEmpty()) {
            System.out.println("조회된 상품 목록이 없습니다.");
        } else {
            System.out.println("----------------------------------------------------------------------------------------------------------");
            System.out.println("                                        상품목록");
            System.out.println("----------------------------------------------------------------------------------------------------------");
            System.out.printf("%s\t %-10s\t %-10s\t %-10s\t %-10s\t %-10s\t %-10s\t %-10s\t %-10s\n", "Pr No.", "Name", "Price", "Ct No.", "Mf No.", "alc.Vol", "Capacity", "Cargo Space", "Orderable");
            System.out.println("----------------------------------------------------------------------------------------------------------");
            for (ProductDto pDto : list) {
                System.out.printf("%d\t %-10s\t %-10d\t %-10d\t %-10d\t %-10.1f\t %-10d\t %-10d\t %-10s\n",
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
            System.out.println("----------------------------------------------------------------------------------------------------------");
        }
    }

    public static void displayFindByNo(ProductDto productDto) {
        if (productDto == null) {
            System.out.println("조회된 상품 번호가 없습니다.");
        } else {
            System.out.println("----------------------------------------------");
            System.out.println("ProductNo : " + productDto.getProductNo());
            System.out.println("ProductName : " + productDto.getProductName());
            System.out.println("ProductPrice : " + productDto.getProductPrice());
            System.out.println("CategoryNo : " + productDto.getCategoryNo());
            System.out.println("ManufacturerNo : " + productDto.getManufacturerNo());
            System.out.println("AlcoholVolume : " + productDto.getAlcoholVolume());
            System.out.println("Capacity : " + productDto.getCapacity());
            System.out.println("CargoSpace : " + productDto.getCargoSpace());
            System.out.println("OrderableStatus : " + productDto.getOrderableStatus());
            System.out.println("----------------------------------------------");
        }
    }
}