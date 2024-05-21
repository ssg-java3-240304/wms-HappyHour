package wms.menu.controller;

import wms.menu.menuView.LoginView;
import wms.menu.menuView.NewMainMenuView;


public class MainMenuController {

    public void loginView() {
        new LoginView().loginView();
    }

    public void mainMenuView() {
        new NewMainMenuView().mainView();
    }
}
