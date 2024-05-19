package wms.menu.controller;

import wms.common.ErrorView;
import wms.common.error.ErrorCode;
import wms.menu.model.dto.ManufacturerDto;
import wms.menu.model.dto.ProductDto;
import wms.menu.model.service.ProductService;
import wms.menu.resultview.ProductResultView;

import java.util.List;

public class ProductController {
    private ProductService productService = new ProductService();

    public void productManage(ProductDto productDto) {
    }

    // 목록 조회
    public List<ProductDto> findAll() {
        return productService.findAll();
    }

    // 제조사 목록 조회
    public List<ManufacturerDto> findManufactruers() {
        return productService.findManufacturers();
    }

    // 상품 등록
    public void insertProduct(ProductDto productDto) {
        int result = productService.insertProduct(productDto);
        ProductResultView.displayResult("상품 등록", result);
    }

    // 상품 삭제
    public void deleteProduct(int productNo) {
        try {
            int result = productService.deleteProduct(productNo);
            ProductResultView.displayResult("상품 삭제", result);
        } catch (Exception e) {
            e.printStackTrace();
            ErrorView.displayError(ErrorCode.DELETE_PRODUCT_ERROR);
        }
    }

    // 상품 수정
    public void updateProduct(ProductDto productDto) {
        try {
            int result = productService.updateProduct(productDto);
            ProductResultView.displayResult("상품 수정", productDto.getProductNo());
        } catch (Exception e) {
            e.printStackTrace();
            ErrorView.displayError(ErrorCode.UPDATE_PRODUCT_ERROR);
        }
    }

    // 원래 상품 정보
    public ProductDto findByNo(int productNo) {
        return productService.findByNo(productNo);
    }


}
