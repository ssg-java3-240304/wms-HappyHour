package wms.menu.model.dao;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.*;
import wms.common.OrderStatus;
import wms.common.VehicleStatus;
import wms.menu.model.dto.DeliveryDto;
import wms.menu.model.dto.InventoryForDeploy;
import wms.menu.model.dto.OutboundDtoForDeploy;
import wms.menu.model.dto.VehicleDto;
import wms.menu.resultview.DeliveryResultView;

import java.time.LocalDateTime;
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
                .allSatisfy((vehicle)->{
                    assertThat(vehicle.getRegistrationNo()).isNotNull();
                    assertThat(vehicle.getVehicleStatus()).isNotNull();
                    assertThat(vehicle.getCargoSpace()).isNotZero().isPositive();
                    // nullable한 컬럼은 검증제외
                });
        try {
            DeliveryResultView.findUsableVehicles(list);
        } catch (Exception e) {
            System.out.println("이용가능한 차량이 없습니다");
        }
    }

    @Test
    void findAllInventory() {
        List<InventoryForDeploy> list = deliveryMapper.findAllInventory();
        assertThat(list)
                .isNotNull()
                .isNotEmpty()
                .allMatch((vehicle)->vehicle != null)
                .allSatisfy((inventory)->{
                    assertThat(inventory.getProductNo()).isNotNull();
                    assertThat(inventory.getAmount()).isNotNull().isNotZero();
                    // nullable한 컬럼은 검증제외
                });
        System.out.println(list);
    }

    @Test
    void findAllOutbound() {
        List<OutboundDtoForDeploy> list = deliveryMapper.findAllPendingOutbound(OrderStatus.PREPARING.getStatus());

        assertThat(list)
                .isNotNull()
                .isNotEmpty()
                .allMatch((outbound)->outbound != null)
                .allSatisfy((outbound)->{
                    assertThat(outbound.getOutboundNo()).isNotNull();
                    assertThat(outbound.getFranchiseNo()).isNotNull();
                    assertThat(outbound.getDate()).isNotNull();
                    assertThat(outbound.getOutboundStatus()).isNotNull();
                    // nullable한 컬럼은 검증제외
                });
        System.out.println(list);
        for(OutboundDtoForDeploy element : list){
            System.out.println("outbound_NO: " + element.getOutboundNo());
            System.out.println(element.getProductList());
        }

    }

    @Test
    void deploySingleVehicle(){

    }

    @DisplayName("배차내역 삽입")
    @Test
    public void dispatchLogTest() {
        //given
        DeliveryDto deliveryDto = new DeliveryDto();
        VehicleDto vehicleDto = new VehicleDto();
        vehicleDto.setRegistrationNo("58누 5999");
        deliveryDto.setVehicleDto(vehicleDto);
        deliveryDto.setLocalDateTime(LocalDateTime.now());
        //when
        deliveryMapper.insertDispatchLog(deliveryDto);
        //then
        List<DeliveryDto> list = deliveryMapper.findDispatchLog();
//        System.out.println(list);
        list.stream().forEach(System.out::println);

    }
}