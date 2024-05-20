package wms.menu.controller;

import wms.menu.model.dto.OutboundOrderDto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OutboundManagementController {

    // 모든 수주 목록을 가져오는 메서드
    public List<OutboundOrderDto> getAllOrders() {
        List<OutboundOrderDto> orders = new ArrayList<>();
        String query = "SELECT * FROM outbound_orders";

        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                OutboundOrderDto order = new OutboundOrderDto(
                        rs.getInt("id"),
                        rs.getDate("order_date").toString(),
                        rs.getString("order_status"),
                        rs.getString("delivery_status"),
                        rs.getString("product_summary"),
                        rs.getString("product_details")
                );
                orders.add(order);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orders;
    }

    // 특정 ID의 수주를 가져오는 메서드
    public OutboundOrderDto getOrderById(int orderId) {
        OutboundOrderDto order = null;
        String query = "SELECT * FROM outbound_orders WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, orderId);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    order = new OutboundOrderDto(
                            rs.getInt("id"),
                            rs.getDate("order_date").toString(),
                            rs.getString("order_status"),
                            rs.getString("delivery_status"),
                            rs.getString("product_summary"),
                            rs.getString("product_details")
                    );
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return order;
    }

    // 수주를 수락하는 메서드
    public void acceptOrder(int orderId) {
        String query = "UPDATE outbound_orders SET order_status = 'Accepted' WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, orderId);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 수주를 취소하는 메서드
    public void cancelOrder(int orderId) {
        String query = "UPDATE outbound_orders SET order_status = 'Cancelled' WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, orderId);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
