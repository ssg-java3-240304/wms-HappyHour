package wms.menu.resultview;

public class ProductCategoryResultView {
    public static void displayResult(String type, int result) {
        System.out.println("> " + type + " " + (result > 0 ? "성공하였습니다." : "실패하였습니다."));
    }
}