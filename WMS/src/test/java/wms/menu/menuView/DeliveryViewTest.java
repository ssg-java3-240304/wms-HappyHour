package wms.menu.menuView;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeliveryViewTest {

    DeliveryView deliveryView = new DeliveryView();

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void deliveryMenu() {
    }

    @Test
    void findAllVehicles() {
        deliveryView.findAllVehicles();
    }

    @Test
    void deploySingleVehicle() {
        deliveryView.deploySingleVehicle();
    }

    @DisplayName("배차 가능한 모든 차량 조회")
    @Test
    public void testFindAllVehicles() {
        //given
        findAllVehicles();
        //when
        //then
    }

    @DisplayName("차량 1대 배차")
    @Test
    public void testDeploySingleVehicle() {
        //given
        deliveryView.deploySingleVehicle();
        //when
        //then
    }

    @DisplayName("배차 내역 조회")
    @Test
    public void findAllDeployList() {
        //given
        deliveryView.findAllDeployList();
        //when
        //then
    }
}