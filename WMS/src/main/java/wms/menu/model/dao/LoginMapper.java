package wms.menu.model.dao;

public interface LoginMapper {
    String checkId(String id);

    String checkPw(String pw);
}