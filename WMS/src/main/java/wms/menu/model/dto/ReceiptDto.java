package wms.menu.model.dto;

public class ReceiptDto {
    private int receiptNo;
    private String date;
    private String productName;
    private int amount;
    private int sectionNo;

    public ReceiptDto() {
    }

    public ReceiptDto(int receiptNo, String date, String productName, int amount, int sectionNo) {
        this.receiptNo = receiptNo;
        this.date = date;
        this.productName = productName;
        this.amount = amount;
        this.sectionNo = sectionNo;
    }

    public int getReceiptNo() {
        return receiptNo;
    }

    public void setReceiptNo(int receiptNo) {
        this.receiptNo = receiptNo;
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
}
