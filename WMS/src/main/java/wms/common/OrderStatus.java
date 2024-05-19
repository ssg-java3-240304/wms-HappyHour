package wms.common;

public enum OrderStatus {
    COMPLETED("completed"), PREPARING("preparing"), DEPLOYED("deployed"), CANCELED("canceled");
    final private String status;

    private OrderStatus(String status) {
        this.status = status;
    }

    public String getStatus(){
        return status;
    }
}
