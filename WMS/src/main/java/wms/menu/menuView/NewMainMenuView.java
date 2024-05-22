package wms.menu.menuView;

import wms.menu.controller.MainMenuController;

import java.util.Scanner;

public class NewMainMenuView {
    MainMenuController mainMenuController=new MainMenuController();

    public void mainView()
    {
        Scanner sc=new Scanner(System.in);
        int choice;
        String menu= """
                        1. 수주 x
                        2. 발주 o
                        3. 상품 o
                        4. 재고 x
                        5. 창고 x
                        6. 입출고 내역 o
                        7. 배송 O
                        0. 종료
                        """;
        while(true) {
            System.out.print(menu);
            System.out.print("메뉴를 입력해주세요 : ");
            choice = sc.nextInt();

            switch (choice) {
                //case 1->new InboundManagementView().InboundManagementMenu();
                case 2 -> new InboundMenuView().InboundMenu();
                case 3 -> new ProductView().productMainMenu();
                //case 4->new ProductView().productMainMenu();
                //case 5->new ProductView().productMainMenu();
                case 6 -> new InOutboundView().inOutboundView();
                case 7 -> new DeliveryView().deliveryMenu();
                case 0 -> {
                    return;
                }
            }
        }
    }
}
