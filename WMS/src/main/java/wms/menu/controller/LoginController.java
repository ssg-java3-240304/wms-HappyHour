package wms.menu.controller;

import wms.menu.model.service.LoginService;

public class LoginController {
    private LoginService loginService = new LoginService();
    public String checkId(String id) {
        String result = loginService.checkId(id);
        return result;
    }

    public String checkPw(String id) {
        String result = loginService.checkPw(id);
        return result;
    }
}
