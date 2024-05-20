package wms.menu.menuView;

import wms.menu.controller.ProductCategoryController;
import wms.menu.controller.ProductController;
import wms.menu.model.dto.ManufacturerDto;
import wms.menu.model.dto.ProductCategoryDto;
import wms.menu.model.dto.ProductDto;

import java.util.List;
import java.util.Scanner;

public class ProductView {
    // 상품관리 메뉴
    // 카테고리 검색 메뉴도 넣어야 할 듯
    /**
     * product class = 상품관련
     * product category class= 상품 카테고리 관련
     *
     * 메뉴
     * 1. 상품 관리 -> ProductController 이동
     *  1) 상품 목록 보기
     *  2) 카테고리 별 상품 목록 보기
     *  3) 상품 등록하기
     *  4) 상품 삭제하기
     *  5) 상품 수정하기
     *
     * 2. 상품 카테고리 관리 -> ProductCategoryController
     *  1) 상품 카테고리 목록 보기
     *  2) 전체 카테고리 목록 보기
     *  3) 상품 카테고리 등록 하기
     *  4) 상품 카테고리 삭제 하기
     *  5) 상품 카테고리 수정 하기
     *
     */
    private Scanner sc = new Scanner(System.in);
    private ProductController productController = new ProductController();
    private ProductCategoryController productCategoryController = new ProductCategoryController();

    // 상품 관리 화면
    public void productMainMenu() {
        String menu = """
                =======================
                1. 상품 관리
                2. 상품 카테고리 관리
                0. 나가기
                =======================
                입력 : """;
        while(true) {
            System.out.print(menu);
            String choice = sc.next();
            switch (choice) {
                case "1" : productController.productManage(showProductManage()); break;
                case "2" : productCategoryController.productCategoryManage(showProductCategoryManage()); break;
                case "0" : return;
                default:
                    System.out.println("잘못 입력하셨습니다.");
            }
        }
    }

    // 상품 관리 화면
    private ProductDto showProductManage() {
        // 상품목록 조회 코드 작성
        displayProductList();
        String menu = """
                =======================
                1. 상품 등록
                2. 상품 삭제
                3. 상품 수정
                0. 나가기
                =======================
                입력 : """;
        while (true) {
            System.out.print(menu);
            String choice = sc.next();
            switch (choice) {
                case "1" : productController.insertProduct(inputProduct()); break;
                case "2" : productController.deleteProduct(inputProductNo("삭제")); break;
                case "3" : productController.updateProduct(inputProductUpdate()); break;
                case "0" : productMainMenu();
                default:
                    System.out.println("잘못 입력하셨습니다.");
            }
        }
    }

    // 상품 수정
    private ProductDto inputProductUpdate() {
        // 전체 상품 조회
        displayProductList();
        System.out.println("> 수정할 상품 번호를 작성해주세요");
        System.out.print("> 상품번호 : ");
        int productNo = sc.nextInt();
        // 원래 상품 정보
//        ProductDto productDto = productController.findByNo(productNo);
//        System.out.println(productDto);
        System.out.println("> 수정할 상품정보를 작성해주세요");
        System.out.println("> 상품명 : ");
        String productName = sc.next();
        System.out.println("> 상품 가격 : ");
        int productPrice = sc.nextInt();
        System.out.println("> 상품 카테고리 : ");
        int productCategory = sc.nextInt();
        System.out.println("> 제조사 : ");
        int manufacturer = sc.nextInt();
        return new ProductDto(productNo, productName, productPrice, productCategory, manufacturer);
    }

    // 상품 삭제
    private int inputProductNo(String type) {
        System.out.printf("> %s할 상품번호 : ", type);
        return sc.nextInt();
    }

    // 상품 등록
    private ProductDto inputProduct() {
        System.out.println("> 등록할 상품정보를 작성해주세요.");
        System.out.print("> 상품명 : ");
        sc.nextLine();
        String productName = sc.nextLine();
        System.out.print("> 상품 가격 : ");
        int productPrice = sc.nextInt();
        // 상품 카테고리 전체 조회
        List<ProductCategoryDto> list = productCategoryController.findAll();
        for (ProductCategoryDto productCategoryDto : list) {
            System.out.println(productCategoryDto);
        }
        System.out.print("> 상품 카테고리 : ");
        int productCategory = sc.nextInt();
        // 제조사 전체 조회
        displayManufacturerList();
        // 사용자가 없는 번호를 입력했을 때 어떻게 할지 생각하고 코드 작성해보기...
        System.out.print("> 제조사 : ");
        int manufacturer = sc.nextInt();
        System.out.print("> 도수 : ");
        double alcoholVolume = sc.nextDouble();
        System.out.print("> 용량 : ");
        int capacity = sc.nextInt();
        System.out.print("> 적재공간 : ");
        int cargoSpace = sc.nextInt();
        System.out.print("> 주문 가능 여부(Y/N) : ");
        String orderableStatus = sc.next();
        return new ProductDto(productName, productPrice, productCategory, manufacturer, alcoholVolume, capacity, cargoSpace, orderableStatus);
    }

    private void displayProductList() {
        productController.findAll();
    }

    private void displayManufacturerList() {
        productController.findManufacturers();
    }

    private ProductCategoryDto showProductCategoryManage() {
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("                                                                          상품 카테고리 목록");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        // 상품 카테고리 목록 조회 코드 작성
        List<ProductCategoryDto> list = productCategoryController.findAll();
        for (ProductCategoryDto productCategoryDto : list) {
            System.out.println(productCategoryDto);
        }
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        String menu = """
                =====================
                1. 상품 카테고리 등록
                2. 상품 카테고리 삭제
                3. 상품 카테고리 수정
                0. 나가기
                입력 : """;
        while (true) {
            System.out.println(menu);
            String choice = sc.next();
            switch (choice) {
                case "1" : productCategoryController.insertProductCategory(inputProductCategory()); break;
                case "2" : productCategoryController.deleteProductCategory(inputProductCategoryNo("삭제")); break;
                case "3" : productCategoryController.updateProductCategory(inputProductCategoryUpdate()); break;
                case "0" : productMainMenu();
                default:
                    System.out.println("잘못 입력하셨습니다.");
            }
        }
    }

    private ProductCategoryDto inputProductCategoryUpdate() {
        System.out.println("> 수정할 상품 카테고리 정보를 작성해주세요");
        // 카테고리 정보 조회
        List<ProductCategoryDto> list = productCategoryController.findAll();
        for (ProductCategoryDto productCategoryDto : list) {
            System.out.println(productCategoryDto);
        }
        System.out.print("> 상품 카테고리명 : ");
        String productCategoryName = sc.next();
        // 상품 카테고리 조회 후 사용자가 잘못 입력했을 때는 잘못입력했음을 보여준다. --> 이것도 해보기...
        System.out.println();
        System.out.print("> 상품 카테고리 번호 : ");
        int productCategoryNo = sc.nextInt();
        return new ProductCategoryDto(productCategoryName, productCategoryNo);
    }

    // 상품 카테고리 삭제
    private int inputProductCategoryNo(String type) {
        System.out.printf("> %s할 상품 카테고리 번호 : ", type);
        return sc.nextInt();
    }

    // 상품 카테고리 등록
    private ProductCategoryDto inputProductCategory() {
        System.out.println("> 등록할 상품 카테고리 정보를 작성해주세요.");
        System.out.print("> 상품 카테고리명 : ");
        String productCategoryName = sc.next();
        System.out.println("> 상품 카테고리 번호 : ");
        int productCategoryNo = sc.nextInt();
        return new ProductCategoryDto(productCategoryName, productCategoryNo);
    }
}
