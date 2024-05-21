package wms.menu.model.service;

import org.apache.ibatis.session.SqlSession;
import wms.menu.model.dao.ProductCategoryMapper;
import wms.menu.model.dto.ProductCategoryDto;

import java.util.List;

import static wms.common.MyBatisTemplate.getSqlSession;

public class ProductCategoryService {
    // 상품 카테고리 목록
    public List<ProductCategoryDto> findAll() {
        SqlSession sqlSession = getSqlSession();
        ProductCategoryMapper productCategoryMapper = sqlSession.getMapper(ProductCategoryMapper.class);
        List<ProductCategoryDto> list = productCategoryMapper.findAll();
        sqlSession.close();
        return list;
    }

    // 상품 카테고리 등록
    public int insertProductCategory(ProductCategoryDto productCategoryDto) {
        SqlSession sqlSession = getSqlSession();
        ProductCategoryMapper productCategoryMapper = sqlSession.getMapper(ProductCategoryMapper.class);
        try {
            int result = productCategoryMapper.insertProductCategory(productCategoryDto);
            sqlSession.commit();
            return result;
        } catch (Exception e) {
            sqlSession.rollback();
            throw new RuntimeException(e);
        } finally {
            sqlSession.close();
        }
    }

    // 상품 카테고리 삭제
    public int deleteProductCategory(int productCategoryNo) {
        SqlSession sqlSession = getSqlSession();
        ProductCategoryMapper productCategoryMapper = sqlSession.getMapper(ProductCategoryMapper.class);
        try {
            int result = productCategoryMapper.deleteProductCategory(productCategoryNo);
            sqlSession.commit();
            return result;
        } catch (Exception e) {
            sqlSession.rollback();
            throw new RuntimeException(e);
        } finally {
            sqlSession.close();
        }
    }

    // 상품 카테고리 수정
    public int updateProductCategory(ProductCategoryDto productCategoryDto) {
        SqlSession sqlSession = getSqlSession();
        ProductCategoryMapper productCategoryMapper = sqlSession.getMapper(ProductCategoryMapper.class);
        try {
            int result = productCategoryMapper.updateProductCategory(productCategoryDto);
            sqlSession.commit();
            return result;
        } catch (Exception e) {
            sqlSession.rollback();
            throw new RuntimeException(e);
        } finally {
            sqlSession.close();
        }
    }

    public ProductCategoryDto findByCategoryNo(int categoryNo) {
        SqlSession sqlSession = getSqlSession();
        ProductCategoryMapper productCategoryMapper = sqlSession.getMapper(ProductCategoryMapper.class);
        ProductCategoryDto productCategoryDto = productCategoryMapper.findByCategoryNo(categoryNo);
        sqlSession.close();
        return productCategoryDto;
    }
}
