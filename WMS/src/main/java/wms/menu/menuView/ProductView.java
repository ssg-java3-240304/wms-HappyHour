package wms.menu.menuView;

import wms.menu.controller.ProductCategoryController;
import wms.menu.controller.ProductController;
import wms.menu.model.dto.ManufacturerDto;
import wms.menu.model.dto.ProductCategoryDto;
import wms.menu.model.dto.ProductDto;

import java.util.List;
import java.util.Objects;
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
                case "1" -> showProductManage();
                case "2" -> showProductCategoryManage();
                case "0" -> {return;}
                default ->
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
                case "0" : return null;
                default:
                    System.out.println("잘못 입력하셨습니다.");
            }
        }
    }

    // 상품 수정
    private ProductDto inputProductUpdate() {
        int productPrice;
        int categoryNo;
        int inputCategoryNo;
        int inputManufacturer;
        int manufacturer;
        // 전체 상품 조회
        List<ProductDto> list = displayProductList();

        ProductDto chosenProduct = null;
        int productNo = 0;
        do {
            try {
                System.out.println("> 수정할 상품 번호를 작성해주세요");
                productNo = sc.nextInt();
                // 수정할 상품 번호 입력했을 때, 입력한 값의 리스트만 조회
                displayFindByNo(productNo);
                int finalProductNo = productNo;
                chosenProduct = list.stream()
                        .filter((p) -> p.getProductNo() == finalProductNo)
                        .findFirst()
                        .orElse(null); // 값이 존재하면, 값을 반환. 값이 존재하지 않으면 지정한 other값이 반환.
//            if (chosenProduct != null)
//                System.out.println(chosenProduct);
//            else
//                System.out.println("상품 번호를 잘못 입력하셨습니다. 다시 입력해주세요.");
                if (chosenProduct == null)
                    System.out.println("상품 번호를 잘못 입력하셨습니다. 다시 입력해주세요.");
            } catch (Exception e) {
                sc.nextLine();
                System.out.println("숫자가 아닌 값을 입력하셨습니다. 양의 정수를 입력해주세요.");
            }
        } while (chosenProduct == null);

        System.out.println("> 수정할 상품정보를 작성해주세요");
        System.out.println("💣💣💣상품 등록 중 종료하시려면 0을 작성해주세요💣💣💣");
        System.out.print("> 상품명 : ");
        String productName = sc.next();
        if(Objects.equals(productName, "0")) {
            System.out.println("입력을 종료합니다.");
            return showProductManage();
        }

        while (true) {
            try {
                System.out.print("> 상품 가격 : ");
                productPrice = sc.nextInt();
                if(productPrice == 0) {
                    System.out.println("입력을 종료합니다.");
                    return showProductManage();
                }
                if (productPrice > 0) {
                    break;
                } else {
                    System.out.println("잘못된 숫자를 입력하셨습니다. 양의 정수를 입력해주세요.");
                }
            } catch (Exception e) {
                sc.nextLine();
                System.out.println("숫자가 아닌 값을 입력하셨습니다. 양의 정수를 입력해주세요.");
            }
        }
        while (true) {
            try {
                System.out.print("> 상품 카테고리 번호 : ");
                inputCategoryNo = sc.nextInt();
                if(inputCategoryNo == 0) {
                    System.out.println("입력을 종료합니다.");
                    return showProductManage();
                }
                int finalCategoryNo = inputCategoryNo;
                boolean isValid = list.stream()
                        .anyMatch(l -> l.getCategoryNo() == finalCategoryNo);
                if(isValid) {
                    categoryNo = inputCategoryNo;
                    break;
                } else {
                    System.out.println("잘못된 숫자를 입력하셨습니다. 양의 정수 입력해주세요.");
                }
            } catch (Exception e) {
                sc.nextLine();
                System.out.println("숫자가 아닌 값을 입력하셨습니다. 양의 정수를 입력해주세요.");
            }
        }

        List<ManufacturerDto> manufacturerFindAll = productController.findManufacturers();
        while (true) {
            try {
                System.out.print("> 제조사 : ");
                inputManufacturer = sc.nextInt();
                if(inputManufacturer == 0) {
                    System.out.println("입력을 종료합니다.");
                    return showProductManage();
                }
                // 사용자가 없는 번호를 입력했을 때 어떻게 할지 생각하고 코드 작성
                int finalInputManufacturer = inputManufacturer;
                boolean isValid = manufacturerFindAll.stream()
                        .anyMatch(m -> m.getManufacturerNo() == finalInputManufacturer);
                if (isValid) {
                    manufacturer = inputManufacturer;
                    break;
                } else {
                    System.out.println("잘못된 숫자를 입력하셨습니다. 양의 정수 입력해주세요.");
                }
            } catch (Exception e) {
                sc.nextLine();
                System.out.println("숫자가 아닌 값을 입력하셨습니다. 양의 정수를 입력해주세요.");
            }
        }
        return new ProductDto(productNo, productName, productPrice, categoryNo, manufacturer);
    }

    private void displayFindByNo(int productNo) {
        productController.findByNo(productNo);
    }

    // 상품 삭제
    private int inputProductNo(String type) {
        List<ProductDto> list = displayProductList();
        System.out.printf("> %s할 상품번호 : ", type);
        return sc.nextInt();
    }

    // 상품 등록
    private ProductDto inputProduct() {
        String productName;
        int productPrice;
        int categoryNo;
        int manufacturer;
        double alcoholVolume;
        int capacity;
        int cargoSpace;
        String orderableStatus;

        System.out.println("> 등록할 상품정보를 작성해주세요.");
        System.out.println("💣💣💣상품 등록 중 종료하시려면 0을 작성해주세요💣💣💣");
        System.out.print("> 상품명 : ");
        sc.nextLine();
        productName = sc.nextLine();
        if(Objects.equals(productName, "0")) {
            System.out.println("입력을 종료합니다.");
            return showProductManage();
        }

        while (true) {
            try {
                System.out.print("> 상품 가격 : ");
                productPrice = sc.nextInt();
                if(productPrice == 0) {
                    System.out.println("입력을 종료합니다.");
                    return showProductManage();
                }
                if (productPrice > 0) {
                    break;
                } else {
                    System.out.println("잘못된 숫자를 입력하셨습니다. 양의 정수를 입력해주세요.");
                }
            } catch (Exception e) {
                sc.nextLine();
                System.out.println("숫자가 아닌 값을 입력하셨습니다. 양의 정수를 입력해주세요.");
            }
        }

        // 상품 카테고리 전체 조회
        List<ProductCategoryDto> list = productCategoryController.findAll();
        // 사용자가 없는 번호를 입력했을 때 어떻게 할지 생각하고 코드 작성
        while (true) {
            try {
                System.out.print("> 상품 카테고리 번호 : ");
                int inputCategoryNo = sc.nextInt();
                if(inputCategoryNo == 0) {
                    System.out.println("입력을 종료합니다.");
                    return showProductManage();
                }
                boolean isValid = list.stream()
                        .anyMatch(l -> l.getCategoryNo() == inputCategoryNo);
                if(isValid) {
                    categoryNo = inputCategoryNo;
                    break;
                } else {
                    System.out.println("잘못된 숫자를 입력하셨습니다. 양의 정수 입력해주세요.");
                }
            } catch (Exception e) {
                sc.nextLine();
                System.out.println("숫자가 아닌 값을 입력하셨습니다. 양의 정수를 입력해주세요.");
            }
        }
//        System.out.print("> 상품 카테고리 : ");
//        int productCategory = sc.nextInt();
        // 제조사 전체 조회
//        displayManufacturerList();
        List<ManufacturerDto> manufacturerFindAll = productController.findManufacturers();

        while (true) {
            try {
                System.out.print("> 제조사 : ");
                int inputManufacturer = sc.nextInt();
                if(inputManufacturer == 0) {
                    System.out.println("입력을 종료합니다.");
                    return showProductManage();
                }
                // 사용자가 없는 번호를 입력했을 때 어떻게 할지 생각하고 코드 작성
                boolean isValid = manufacturerFindAll.stream()
                        .anyMatch(m -> m.getManufacturerNo() == inputManufacturer);
                if (isValid) {
                    manufacturer = inputManufacturer;
                    break;
                } else {
                    System.out.println("잘못된 숫자를 입력하셨습니다. 양의 정수 입력해주세요.");
                }
            } catch (Exception e) {
                sc.nextLine();
                System.out.println("숫자가 아닌 값을 입력하셨습니다. 양의 정수를 입력해주세요.");
            }
        }
//        System.out.print("> 제조사 : ");
//        int manufacturer = sc.nextInt();

        while (true) {
            try {
                System.out.print("> 도수 : ");
                alcoholVolume = sc.nextDouble();
                if(alcoholVolume == 0) {
                    System.out.println("입력을 종료합니다.");
                    return showProductManage();
                }
                if (alcoholVolume > 0) {
                    break;
                } else {
                    System.out.println("잘못된 숫자를 입력하셨습니다. 양의 정수를 입력해주세요.");
                }
            } catch (Exception e) {
                sc.nextLine();
                System.out.println("숫자가 아닌 값을 입력하셨습니다. 양의 정수를 입력해주세요.");
            }
        }
        while (true) {
            try {
                System.out.print("> 용량 : ");
                capacity = sc.nextInt();
                if(capacity == 0) {
                    System.out.println("입력을 종료합니다.");
                    return showProductManage();
                }
                if (capacity > 0) {
                    break;
                } else {
                    System.out.println("잘못된 숫자를 입력하셨습니다. 양의 정수를 입력해주세요.");
                }
            } catch (Exception e) {
                sc.nextLine();
                System.out.println("숫자가 아닌 값을 입력하셨습니다. 양의 정수를 입력해주세요.");
            }
        }
        while (true) {
            try {
                System.out.print("> 적재공간 : ");
                cargoSpace = sc.nextInt();
                if(cargoSpace == 0) {
                    System.out.println("입력을 종료합니다.");
                    return showProductManage();
                }
                if (cargoSpace > 0) {
                    break;
                } else {
                    System.out.println("잘못된 숫자를 입력하셨습니다. 양의 정수를 입력해주세요.");
                }
            } catch (Exception e) {
                sc.nextLine();
                System.out.println("숫자가 아닌 값을 입력하셨습니다. 양의 정수를 입력해주세요.");
            }
        }
        while (true){
            System.out.print("> 주문 가능 여부(Y/N) : ");
            orderableStatus = sc.next().toUpperCase();
            if(orderableStatus.equalsIgnoreCase("0")) {
                System.out.println("입력을 종료합니다.");
                return showProductManage();
            }
            if (orderableStatus.equals("Y") || orderableStatus.equals("N")){
                break;
            } else {
                System.out.println("잘못 입력하셨습니다. 제시된 글자로 다시 입력해주세요.");
            }
        }
        return new ProductDto(productName, productPrice, categoryNo, manufacturer, alcoholVolume, capacity, cargoSpace, orderableStatus);
    }

    // 상품 카테고리 목록 조회
    private List<ProductCategoryDto> displayCategoryList() {
//        List<ProductCategoryDto> list = productCategoryController.findAll();
        return productCategoryController.findAll();
    }

    // 상품 목록 조회
    private List<ProductDto> displayProductList() {
        return productController.findAll();
    }

    // 제조사 목록 조회
    private void displayManufacturerList() {
        productController.findManufacturers();
    }

    private ProductCategoryDto showProductCategoryManage() {
        // 상품 카테고리 목록 조회 코드 작성
//        List<ProductCategoryDto> list = productCategoryController.findAll();
//        for (ProductCategoryDto productCategoryDto : list) {
//            System.out.println(productCategoryDto);
//        }
        displayCategoryList();
        System.out.println();
        String menu = """
                =====================
                1. 상품 카테고리 등록
                2. 상품 카테고리 삭제
                3. 상품 카테고리 수정
                0. 나가기
                =====================
                입력 : """;
        while (true) {
            System.out.print(menu);
            String choice = sc.next();
            switch (choice) {
                case "1" : productCategoryController.insertProductCategory(inputProductCategory()); break;
                case "2" : productCategoryController.deleteProductCategory(inputProductCategoryNo("삭제")); break;
                case "3" : productCategoryController.updateProductCategory(inputProductCategoryUpdate()); break;
                case "0" : return null;
                default:
                    System.out.println("잘못 입력하셨습니다.");
            }
        }
    }

    private ProductCategoryDto inputProductCategoryUpdate() {
        System.out.println("> 수정할 상품 카테고리 정보를 작성해주세요");
        // 카테고리 정보 조회
        List<ProductCategoryDto> list = displayCategoryList();

        ProductCategoryDto chosenProductCategory = null;
        int categoryNo = 0; // 카테고리 번호 초기화

        // 유효한 카테고리 번호 입력받기
        do {
            System.out.println("> 수정할 상품 카테고리 번호를 작성해주세요");
            System.out.println("💣💣💣상품 등록 중 종료하시려면 0을 작성해주세요💣💣💣");
            categoryNo = sc.nextInt();
                // 수정할 카테고리 번호 입력했을 때, 입력한 값의 리스트만 조회
            displayFindByCategoryNo(categoryNo);
            int finalCategoryNo = categoryNo;
            chosenProductCategory = list.stream()
                        .filter((pc) -> pc.getCategoryNo() == finalCategoryNo)
                        .findFirst()
                        .orElse(null);
//                if (chosenProductCategory != null) {
//                    System.out.println(chosenProductCategory);
//                } else
//                    System.out.println("카테고리 번호를 잘못 입력하셨습니다. 다시 입력해주세요.");
            if (chosenProductCategory == null)
                System.out.println("카테고리 번호를 잘못 입력하셨습니다. 다시 입력해주세요.");
        } while (chosenProductCategory == null);
        System.out.print("> 수정할 상품 카테고리명 : ");
        sc.nextLine();
        String categoryName = sc.next();
        if(Objects.equals(categoryName, "0")) {
            System.out.println("입력을 종료합니다.");
            return showProductCategoryManage();
        }
        return new ProductCategoryDto(categoryNo, categoryName);
    }

    private void displayFindByCategoryNo(int categoryNo) {
        productCategoryController.findByCategoryNo(categoryNo);
    }

    // 상품 카테고리 삭제
    private int inputProductCategoryNo(String type) {
        System.out.printf("> %s할 상품 카테고리 번호 : ", type);
        return sc.nextInt();
    }

    // 상품 카테고리 등록
    private ProductCategoryDto inputProductCategory() {
        int categoryNo;
        String categoryName;

        System.out.println("> 등록할 상품 카테고리 정보를 작성해주세요.");
        System.out.println("💣💣💣상품 등록 중 종료하시려면 0을 작성해주세요💣💣💣");

        // 상품 카테고리 전체 조회
        List<ProductCategoryDto> list = productCategoryController.findAll();
        // 사용자가 없는 번호를 입력했을 때 어떻게 할지 생각하고 코드 작성
        while (true) {
            try {
                System.out.print("> 상품 카테고리 번호 : ");
                int inputCategoryNo = sc.nextInt();
                if(inputCategoryNo == 0) {
                    System.out.println("입력을 종료합니다.");
                    return showProductCategoryManage();
                }
                boolean isValid = list.stream()
                        .anyMatch(l -> l.getCategoryNo() == inputCategoryNo);
                if(isValid) {
                    categoryNo = inputCategoryNo;
                    break;
                } else {
                    System.out.println("잘못된 숫자를 입력하셨습니다. 양의 정수 입력해주세요.");
                }
            } catch (Exception e) {
                sc.nextLine();
                System.out.println("숫자가 아닌 값을 입력하셨습니다. 양의 정수를 입력해주세요.");
            }
        }

        System.out.print("> 상품 카테고리명 : ");
        categoryName = sc.nextLine();
        if(Objects.equals(categoryName, "0")) {
            System.out.println("입력을 종료합니다.");
            return showProductCategoryManage();
        }
        return new ProductCategoryDto(categoryNo, categoryName);
    }

}
