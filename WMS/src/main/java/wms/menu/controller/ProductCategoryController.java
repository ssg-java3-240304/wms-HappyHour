package wms.menu.controller;

import wms.menu.model.dto.ProductCategoryDto;
import wms.menu.model.service.ProductCategoryService;
import wms.menu.resultview.ProductCategoryResultView;

import java.util.List;

public class ProductCategoryController {
    private ProductCategoryService productCategoryService = new ProductCategoryService();

    public void productCategoryManage(ProductCategoryDto productCategoryDto) {
    }

    // 상품 카테고리 목록 조회
    public List<ProductCategoryDto> findAll() {
        return productCategoryService.findAll();
    }

    // 상품 카테고리 등록
    public void insertProductCategory(ProductCategoryDto productCategoryDto) {
        int result = productCategoryService.insertProductCategory(productCategoryDto);
        ProductCategoryResultView.displayResult("상품 카테고리 등록", result);
    }

    // 상품 카테고리 삭제
    public void deleteProductCategory(int productCategoryNo) {
        int result = productCategoryService.deleteProductCategory(productCategoryNo);
        ProductCategoryResultView.displayResult("상품 카테고리 삭제", result);
    }

    // 상품 카테고리 수정
    public void updateProductCategory(ProductCategoryDto productCategoryDto) {
        int result = productCategoryService.updateProductCategory(productCategoryDto);
        ProductCategoryResultView.displayResult("상품 카테고리 수정", productCategoryDto.getCategoryNo());
    }
}
