package wms.common;

public class StringPadding {
    public static String padLeft(String s, int width) {
        return String.format("%-" + width + "s", s);
    }

    public static String padLeft(int n, int width) {
        return String.format("%-" + width + "d", n);
    }
}
