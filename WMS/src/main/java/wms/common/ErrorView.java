package wms.common;

import wms.common.error.ErrorCode;

public class ErrorView {
    public static void displayError(ErrorCode errorCode) {
        System.out.println(errorCode);

    }
}
