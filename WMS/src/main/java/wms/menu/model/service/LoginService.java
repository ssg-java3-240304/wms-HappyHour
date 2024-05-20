package wms.menu.model.service;

import org.apache.ibatis.session.SqlSession;
import wms.menu.model.dao.LoginMapper;

import static wms.common.MyBatisTemplate.getSqlSession;

public class LoginService {
    public static String checkId(String id) {
        SqlSession sqlSession = getSqlSession();
        LoginMapper loginMapper = sqlSession.getMapper(LoginMapper.class);
        String result = loginMapper.checkId(id);
        sqlSession.close();
        return String.valueOf(result);
    }

    public String checkPw(String id) {
        SqlSession sqlSession = getSqlSession();
        LoginMapper loginMapper = sqlSession.getMapper(LoginMapper.class);
        String result = loginMapper.checkPw(id);
        sqlSession.close();
        return result;
    }
}
