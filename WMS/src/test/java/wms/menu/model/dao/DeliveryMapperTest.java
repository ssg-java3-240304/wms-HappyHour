package wms.menu.model.dao;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.*;
import wms.common.OrderStatus;
import wms.common.VehicleStatus;
import wms.menu.model.dto.*;
import wms.menu.resultview.DeliveryResultView;

import java.time.LocalDateTime;
import java.util.ArrayList;
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

    }

    @DisplayName("수주 추가")
    @Test
    public void updateDispatchOutbound() {
        //given
//        deliveryMapper.insertDispatchOutbound(1, 9990);
        //when
        //then
        deliveryMapper.updateVehicleStatus("12나 8484", VehicleStatus.DISPATCHED.getStatus());
    }

    @DisplayName("배차상품 추가")
    @Test
    public void dispatchProductTest() {
        //given
        //when
//        deliveryMapper.insertDispatchProduct();
        //then

    }

    @Test
    void inventoryByProductNo() {
        List<Integer> list = List.of(60001, 60002, 60003);
        deliveryMapper.findInventoryByProductNo(list).forEach(System.out::println);

    }

    @Test
    void updateInventoryTest() {
        List<InventoryDto> list = new ArrayList<>();
        list.add(new InventoryDto(501, 60001, 35,"","",0));
        list.add(new InventoryDto(500, 60003, 100,"","",0));
        list.add(new InventoryDto(500, 60004, 60,"","",0));
        deliveryMapper.dispatchInventory(list);

        List<Integer> prodNo = new ArrayList<>();
        prodNo.add(60003);
        prodNo.add(60001);
        List<InventoryDto> inv = deliveryMapper.findInventoryByProductNo(prodNo);
        int k = 0;
        System.out.println("result = " + inv.get(k).getSectionNo()+" , " +inv.get(k).getProductNo() +" , "+ inv.get(k).getAmount());
        k = 1;
        System.out.println("result = " + inv.get(k).getSectionNo()+" , " +inv.get(k).getProductNo() +" , "+ inv.get(k).getAmount());
    }
}