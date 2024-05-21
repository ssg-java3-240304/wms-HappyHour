package wms;


import wms.menu.controller.MainMenuController;


public class Main {
    public static void main(String[] args) {
        MainMenuController mainMenuController=new MainMenuController();
        // 메인메뉴컨트롤러에 로그인 + 메인메뉴 화면이 있습니다
        // 각 기능별 메뉴에, MainMenuController 객체 생성 해주시고
        // 0번을 입력하면  mainMenuController.mainMenuView(); 메인 메뉴가 보이는
        // 메소드를 실행해주시면 됩니다
        mainMenuController.loginView();
        mainMenuController.mainMenuView();
        /**
         * 1. ManuFacturer(제조사, 공장)에서 객체만 사용하는거 같아 controller, service, resultview를 생성 안했습니다
         * 2. product class = 상품관련
         *    product category class= 상품 카테고리 관련
         * 3. View 디렉토리가 2가지 있습니다
         *   - menuView
         *   - resultView
         * 4. resoureces 에서는 MyBatis.xml만 적용 했습니다
         * 5. JDBC, mybatis-config.xml 안에 주소를 확인해주시고 접속을 확인을 해주세요
         */


    }
}