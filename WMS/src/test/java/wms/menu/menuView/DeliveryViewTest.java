package wms.menu.menuView;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
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
}