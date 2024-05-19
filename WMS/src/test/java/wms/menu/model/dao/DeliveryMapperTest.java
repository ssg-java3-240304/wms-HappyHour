package wms.menu.model.dao;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.*;
import wms.common.VehicleStatus;
import wms.menu.model.dto.VehicleDto;
import wms.menu.model.service.DeliveryService;
import wms.menu.resultview.DeliveryResultView;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static wms.common.MyBatisTemplate.getSqlSession;

class DeliveryMapperTest {

    //1. 실제 쿼리테스트를 수행 전에 세션이 필요하므로 세션 Fixture 부터 생성
    SqlSession sqlSession;
    DeliveryMapper deliveryMapper;

    @BeforeEach
    void setUp() {
        this.sqlSession = getSqlSession();
        this.deliveryMapper = this.sqlSession.getMapper(DeliveryMapper.class);
    }

    @AfterEach
    void tearDown() {
//        this.sqlSession.commit();
        this.sqlSession.rollback();
        this.sqlSession.close();

    }

    @DisplayName("모든 차량을 조회한다")
    @Test
    void findAll() {
        //given
        //when
        List<VehicleDto> list = deliveryMapper.findAllVehicles();
        //then
        assertThat(list)
                .isNotNull()
                .isNotEmpty()
                .allMatch((vehicle)->vehicle != null)
                .allSatisfy((menu)->{
                    assertThat(menu.getRegistrationNo()).isNotNull();
                    assertThat(menu.getVehicleStatus()).isNotNull();
                    assertThat(menu.getCargoSpace()).isNotZero().isPositive();
                    // nullable한 컬럼은 검증제외
                });
        System.out.println(list);
    }

    @Test
    void enumTest() {
        VehicleStatus status = VehicleStatus.NOT_DISPATCHED;
        System.out.println(status.getStatus());
    }

    @DisplayName("이용 가능한 차량을 조회한다")
    @Test
    void findUsable() {
        //given
        //when
        List<VehicleDto> list = deliveryMapper.findUsableVehicles(VehicleStatus.NOT_DISPATCHED.getStatus());
        //then
        assertThat(list)
                .isNotNull()
                .isNotEmpty()
                .allMatch((vehicle)->vehicle != null)
                .allSatisfy((menu)->{
                    assertThat(menu.getRegistrationNo()).isNotNull();
                    assertThat(menu.getVehicleStatus()).isNotNull();
                    assertThat(menu.getCargoSpace()).isNotZero().isPositive();
                    // nullable한 컬럼은 검증제외
                });
        DeliveryResultView.findUsableVehicles(list);
    }
}