package wms.menu.model.dto;

public class ProductCategoryDto {
    private String categoryName; // 카테고리명
    private int categoryNo; // 카테고리 번호

    public ProductCategoryDto() {
    }

    public ProductCategoryDto(int categoryNo, String categoryName) {
        this.categoryNo = categoryNo;
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getCategoryNo() {
        return categoryNo;
    }

    public void setCategoryNo(int categoryNo) {
        this.categoryNo = categoryNo;
    }

    @Override
    public String toString() {
        return "ProductCategoryDto{" +
                "productCategoryName='" + categoryName + '\'' +
                ", productCategoryNo=" + categoryNo +
                '}';
    }
}
