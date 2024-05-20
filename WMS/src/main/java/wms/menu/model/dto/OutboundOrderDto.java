package wms.menu.model.dto;

import lombok.*;

import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class OutboundOrderDto {
    private int id;
    private String orderDate;
    private String orderStatus;
    private String deliveryStatus;
    private String productSummary;
    private List<OrderItemDto> items;
    private String productDetails;




/* public OutboundOrderDto(int id, String orderDate, String orderStatus, String deliveryStatus, String productSummary, List<OrderItemDto> items) {
        this.id = id;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
        this.deliveryStatus = deliveryStatus;
        this.productSummary = productSummary;
        this.items = items;
    }

    public int getId() {
        return id;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public String getProductSummary() {
        return productSummary;
    }

    public List<OrderItemDto> getItems() {
        return items;
    }

    @Override
    public String toString() {
        return "OutboundOrderDto{" +
                "id=" + id +
                ", orderDate='" + orderDate + '\'' +
                ", orderStatus='" + orderStatus + '\'' +
                ", deliveryStatus='" + deliveryStatus + '\'' +
                ", productSummary='" + productSummary + '\'' +
                ", items=" + items +
                '}';
    }
*/
}
