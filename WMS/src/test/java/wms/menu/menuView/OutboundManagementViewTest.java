package wms.menu.menuView;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OutboundManagementViewTest {

    OutboundManagementView outboundManagementView = new OutboundManagementView();
    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void OutBoundMangementView() {

        outboundManagementView.outboundManagementMenu();

    }
}