package wms.menu.menuView;

import wms.menu.controller.ProductCategoryController;
import wms.menu.controller.WarehouseController;
import wms.menu.model.dto.ProductCategoryDto;
import wms.menu.model.dto.WarehouseSectionDto;
import wms.menu.model.dto.WarehouseZoneDto;
import wms.menu.model.service.WarehouseService;

import java.util.List;
import java.util.Scanner;

public class WarehouseView {
    // 창고관리 뷰

    /**
     * 1. 창고 구역 목록
     * 2. 창고 구역 등록
     * 3. 창고 구역 삭제
     * 4. 창고 구역 수정
     */
    public static void main(String[] args) {
        new WarehouseView().warehouseMenu();
    }

    private WarehouseController warehouseController = new WarehouseController();
    private ProductCategoryController productCategoryController = new ProductCategoryController();
    private Scanner sc = new Scanner(System.in);
    private List<WarehouseSectionDto> cashSectionList;

    public void warehouseMenu() {
        String menu = """
                1. 창고 구역 등록
                2. 창고 구역 삭제
                3. 창고 구역 수정
                0. 나가기
                원하시는 메뉴는 선택해주세요.""";
        while (true) {
            findAllSection();
            System.out.println(menu);
            String choice = sc.nextLine();
            switch (choice) {
                case "1" -> insertSection();
                case "0" -> {
                    return;
                }
                default -> System.out.println("잘 못 입력하셨습니다. 다시 입력해주세요.");
            }
        }
    }

    private void findAllSection() {
        this.cashSectionList = warehouseController.findAllSection();
    }

    private void insertSection() {
        // 구역명 입력 받기
        System.out.println("새로 등록할 구역명을 입력해주세요.(최대 10자)");
        String sectionName;
        while (true) {
            System.out.print("입력: ");
            sectionName = sc.nextLine();
            if (sectionName.length() <= 10) {
                break;
            } else {
                System.out.println("10자를 초과했습니다. 다시 입력해주세요.");
            }
        }

        // 상품 카테고리 목록 출력
        List<ProductCategoryDto> categoryList = productCategoryController.findAll();

        // 상품 카테고리 선택

        // 지정되지 않은 창고 존 목록 출력
        List<WarehouseZoneDto> undesignatedZone = findUndesignatedZone();

        System.out.println("새로운 창고 구역의 존을 선택해주세요.");
        // 지정할 창고 존 선택

        // 등록 완료
    }

    private List<WarehouseZoneDto> findUndesignatedZone() {
        return null;
    }
}
