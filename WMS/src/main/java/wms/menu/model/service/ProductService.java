package wms.menu.model.service;

import org.apache.ibatis.session.SqlSession;
import wms.menu.model.dao.ProductMapper;
import wms.menu.model.dto.ManufacturerDto;
import wms.menu.model.dto.ProductDto;

import java.util.List;

import static wms.common.MyBatisTemplate.getSqlSession;

public class ProductService {
    // 상품목록조회
    public List<ProductDto> findAll() {
        SqlSession sqlSession = getSqlSession();
        ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
        List<ProductDto> list = productMapper.findAll();
        sqlSession.close();
        return list;
    }

    // 제조사 전체 조회
    public List<ManufacturerDto> findManufacturers() {
        SqlSession sqlSession = getSqlSession();
        ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
        List<ManufacturerDto> list = productMapper.findManufacturers();
        sqlSession.close();
        return list;
    }

    // 상품 등록
    public int insertProduct(ProductDto productDto) {
        SqlSession sqlSession = getSqlSession();
        ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
        try {
            int result = productMapper.insertProduct(productDto);
            sqlSession.commit();
            return result;
        } catch (Exception e) {
            sqlSession.rollback();
            throw new RuntimeException(e);
        } finally {
            sqlSession.close();
        }
    }

    // 상품 삭제
    public int deleteProduct(int productNo) {
        SqlSession sqlSession = getSqlSession();
        ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
        try{
            int result = productMapper.deleteProduct(productNo);
            sqlSession.commit();
            return result;
        } catch (Exception e) {
            sqlSession.rollback();
            throw new RuntimeException(e);
        } finally {
            sqlSession.close();
        }
    }

    // 상품 수정
    public int updateProduct(ProductDto productDto) {
        SqlSession sqlSession = getSqlSession();
        ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
        try {
            int result = productMapper.updateProduct(productDto);
            sqlSession.commit();
            return result;
        } catch (Exception e) {
            sqlSession.rollback();
            throw new RuntimeException();
        } finally {
            sqlSession.close();
        }
    }

    // 상품 수정 -> 원래 상품 정보
    public ProductDto findByNo(int productNo) {
        SqlSession sqlSession = getSqlSession();
        ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
        ProductDto productDto = productMapper.findByNo(productNo);
        sqlSession.close();
        return productDto;
    }

    // 상품 등록 후 inbound_orderable 테이블에 데이터 자동등록
    public int insertProductToInboundOrderable(int productNo, String orderableStatus) {
        SqlSession sqlSession = getSqlSession();
        ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
        try {
            int result = productMapper.insertProductToInboundOrderable(productNo, orderableStatus);
            sqlSession.commit();
            return result;
        } catch (Exception e) {
            sqlSession.rollback();
            throw new RuntimeException(e);
        } finally {
            sqlSession.close();
        }
    }
}
