package wms.menu.model.dto;

/**
 * * 상품 id
 *   * 상품명
 *   * 상품 카테고리
 *   * 제조사
 *   * 도수
 *   * 용량
 *   * 적재 공간
 *   * 주문 가능 여부
 */
public class ProductDto {
    private int productNo; // 상품번호
    private String productName; // 상품명
    private int productPrice; // 상품가격
    private int categoryNo; // 상품 카테고리 번호
    private int manufacturerNo; // 제조사 번호
    private double alcoholVolume; // 도수
    private int capacity; // 용량
    private int cargoSpace; // 단위당 적재공간
    private char orderableStatus; // 주문 가능 여부
    private int inbound_quantity;

    public ProductDto() {
    }

    public ProductDto(int productNo, char orderableStatus, int inbound_quantity) {
        this.productNo = productNo;
        this.orderableStatus = orderableStatus;
        this.inbound_quantity = inbound_quantity;
    }

    public ProductDto(int productNo, String productName, int productPrice, int productCategory, int manufacturerNo) {
        this.productNo = productNo;
        this.productName = productName;
        this.productPrice = productPrice;
        this.categoryNo = productCategory;
        this.manufacturerNo = manufacturerNo;
    }

    public ProductDto(String productName, int productPrice, int productCategory, int manufacturerNo, double alcoholVolume, int capacity, int cargoSpace, char orderableStatus) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.categoryNo = productCategory;
        this.manufacturerNo = manufacturerNo;
        this.alcoholVolume = alcoholVolume;
        this.capacity = capacity;
        this.cargoSpace = cargoSpace;
        this.orderableStatus = orderableStatus;
    }

    public ProductDto(int productNo, String productName, int productPrice, int categoryNo, int manufacturerNo, double alcoholVolume, int capacity, int cargoSpace, char orderableStatus) {
        this.productNo = productNo;
        this.productName = productName;
        this.productPrice = productPrice;
        this.categoryNo = categoryNo;
        this.manufacturerNo = manufacturerNo;
        this.alcoholVolume = alcoholVolume;
        this.capacity = capacity;
        this.cargoSpace = cargoSpace;
        this.orderableStatus = orderableStatus;
    }

    public int getProductNo() {
        return productNo;
    }

    public void setProductNo(int productNo) {
        this.productNo = productNo;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public int getCategoryNo() {
        return categoryNo;
    }

    public void setCategoryNo(int categoryNo) {
        this.categoryNo = categoryNo;
    }

    public int getManufacturerNo() {
        return manufacturerNo;
    }

    public void setManufacturerNo(int manufacturerNo) {
        this.manufacturerNo = manufacturerNo;
    }

    public double getAlcoholVolume() {
        return alcoholVolume;
    }

    public void setAlcoholVolume(double alcoholVolume) {
        this.alcoholVolume = alcoholVolume;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCargoSpace() {
        return cargoSpace;
    }

    public void setCargoSpace(int cargoSpace) {
        this.cargoSpace = cargoSpace;
    }

    public char getOrderableStatus() {
        return orderableStatus;
    }

    public int getInbound_quantity() {
        return inbound_quantity;
    }

    public void setInbound_quantity(int inbound_quantity) {
        this.inbound_quantity = inbound_quantity;
    }

    public void setOrderableStatus(char orderableStatus) {
        this.orderableStatus = orderableStatus;
    }

    @Override
    public String toString() {
        return "ProductDto{" +
                "productNo=" + productNo +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", productCategory=" + categoryNo +
                ", manufacturer=" + manufacturerNo +
                ", alcoholVolume=" + alcoholVolume +
                ", capacity=" + capacity +
                ", loadVolume=" + cargoSpace +
                ", orderableStatus='" + orderableStatus + '\'' +
                '}';
    }
}