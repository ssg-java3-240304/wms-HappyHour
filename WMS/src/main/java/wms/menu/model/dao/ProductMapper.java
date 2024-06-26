package wms.menu.model.dao;

import org.apache.ibatis.annotations.Param;
import wms.menu.model.dto.ManufacturerDto;
import wms.menu.model.dto.ProductDto;

import java.util.List;

public interface ProductMapper {
    // 카테고리

    // 상품 목록 조회
    List<ProductDto> findAll();

    // 제조사 전체 조회
    List<ManufacturerDto> findManufacturers();

    // 원래 상품 정보
    ProductDto findByNo(int productNo);

    // 상품 등록
    int insertProduct(ProductDto productDto);

    // 상품 삭제
    int deleteProduct(int productNo);

    // 상품 수정
    int updateProduct(ProductDto productDto);

    // 상품 등록 후 inbound_orderable 테이블에 데이터 자동등록
    int insertProductToInboundOrderable(@Param("productNo") int productNo, @Param("orderableStatus") String orderableStatus);

    ProductDto findByProductNo(int productNo);
}