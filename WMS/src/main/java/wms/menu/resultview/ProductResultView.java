package wms.menu.resultview;

public class ProductResultView {
    public static void displayResult(String type, int result) {
        System.out.println("> " + type + " " + (result > 0 ? "성공!" : "실패!"));
    }
}