package wms;

import org.apache.ibatis.session.SqlSession;
import wms.menu.menuView.LoginView;

import static wms.common.MyBatisTemplate.getSqlSession;

public class Main {
    public static void main(String[] args) {
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
        new LoginView().loginView();
    }
}