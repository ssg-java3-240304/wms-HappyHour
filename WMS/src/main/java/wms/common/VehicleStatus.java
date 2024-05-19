package wms.common;

public enum VehicleStatus {
    DISPATCHED("배차완료"), NOT_DISPATCHED("배차전");
    final private String status;

    private VehicleStatus(String status) {
        this.status = status;
    }

    public String getStatus(){
        return status;
    }
}