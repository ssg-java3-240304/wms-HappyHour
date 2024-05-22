package wms.menu.resultview;

import wms.menu.model.dto.ProductCategoryDto;

import java.util.List;

public class ProductCategoryResultView {
    public static void displayResult(String type, int result) {
        System.out.println("> " + type + " " + (result > 0 ? "성공하였습니다." : "실패하였습니다."));
    }

    // 상품 카테고리 목록
    public static void displayCategoryList(List<ProductCategoryDto> list) {
        if (list.isEmpty()) {
            System.out.println("조회된 카테고리 목록이 없습니다.");
        } else {
            System.out.println("------------------------");
            System.out.println("      카테고리 목록");
            System.out.println("------------------------");
            System.out.printf("%s\t %-10s\n", "Ct No.", "Ct Name.");
            System.out.println("------------------------");
            for (ProductCategoryDto pcDto : list) {
                System.out.printf("%s\t\t %-10s\n",
                        pcDto.getCategoryNo(),
                        pcDto.getCategoryName()
                );
            }
            System.out.println("------------------------");
        }
    }

    public static void displayFindByCategoryNo(ProductCategoryDto productCategoryDto) {
        if (productCategoryDto == null) {
            System.out.println("조회된 상품 카테고리 번호가 없습니다.");
        } else {
            System.out.println("------------------------------");
            System.out.println("CategoryNo : " + productCategoryDto.getCategoryNo());
            System.out.println("CategoryName : " + productCategoryDto.getCategoryName());
            System.out.println("------------------------------");
        }
    }
}