package wms.menu.model.dao;

import wms.menu.model.dto.ProductCategoryDto;

import java.util.List;

public interface ProductCategoryMapper {

    // 상품 카테고리 목록
    List<ProductCategoryDto> findAll();

    // 상품 카테고리 등록
    int insertProductCategory(ProductCategoryDto productCategoryDto);

    // 상품 카테고리 삭제
    int deleteProductCategory(int productCategoryNo);

    // 상품 카테고리 수정
    int updateProductCategory(ProductCategoryDto productCategoryDto);

    ProductCategoryDto findByCategoryNo(int categoryNo);
}
