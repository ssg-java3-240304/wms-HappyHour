package wms.menu.model.dto;

public class DispatchDto {
    private int dispatchNo;
    private String date;
    private String productName;
    private int amount;
    private int sectionNo;

    public DispatchDto() {
    }

    public DispatchDto(int dispatchNo, String date, String productName, int amount, int sectionNo) {
        this.dispatchNo = dispatchNo;
        this.date = date;
        this.productName = productName;
        this.amount = amount;
        this.sectionNo = sectionNo;
    }

    public int getDispatchNo() {
        return dispatchNo;
    }

    public void setDispatchNo(int dispatchNo) {
        this.dispatchNo = dispatchNo;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getSectionNo() {
        return sectionNo;
    }

    public void setSectionNo(int sectionNo) {
        this.sectionNo = sectionNo;
    }

    @Override
    public String toString() {
        return "OutboundOrderDto{" +
                "dispatchNo=" + dispatchNo +
                ", date='" + date + '\'' +
                ", ProductName='" + productName + '\'' +
                ", amount=" + amount +
                ", sectionNo=" + sectionNo +
                '}';
    }
}
