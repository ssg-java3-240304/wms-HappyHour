package wms.menu.menuView;

import wms.menu.controller.LoginController;

import java.util.Scanner;

public class LoginView {
    private LoginController loginController = new LoginController();
    private Scanner sc = new Scanner(System.in);
    public void loginView(){
        String menu = """
                ===================
                       Login      
                ===================
                > id : """;
        String menu2 = """
                > pw : """;
        String id;
        while (true){
            System.out.print(menu);
            id = sc.nextLine();
            if (id.equals(loginController.checkId(id))){
                break;
            } else {
                System.out.println("id를 잘못 입력하셨습니다. 다시 입력해주세요.");
            }
        }
        while (true){
            System.out.print(menu2);
            String pw = sc.nextLine();
            if (pw.equals(loginController.checkPw(id))){
                break;
            } else {
                System.out.println("pw를 잘못 입력하셨습니다. 다시 입력해주세요.");
            }
        }
    }
}