package wms.menu.model.dto;

public class ManufacturerDto {
    // 우리에게 납품해주는 제조사 공장

    private Long manufacturerNo; // 제조사 번호
    private String manufacturerName; // 제조사 이름
    private String address; // 주소
    private String phone; // 전화번호

    public ManufacturerDto() {
    }

    public ManufacturerDto(Long manufacturerNo) {
        this.manufacturerNo = manufacturerNo;
    }

    public ManufacturerDto(Long manufacturerNo, String manufacturerName, String address, String phone) {
        this.manufacturerNo = manufacturerNo;
        this.manufacturerName = manufacturerName;
        this.address = address;
        this.phone = phone;
    }

    public Long getManufacturerNo() {
        return manufacturerNo;
    }

    public void setManufacturerNo(Long manufacturerNo) {
        this.manufacturerNo = manufacturerNo;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "ManufacturerDto{" +
                "manufacturerNo=" + manufacturerNo +
                ", manufacturerName='" + manufacturerName + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
