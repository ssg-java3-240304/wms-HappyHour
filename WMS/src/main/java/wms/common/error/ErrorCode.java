package wms.common.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ErrorCode {
    CREATE_ORDER_ERROR("주문중 오류가 발생했습니다"),
    FIND_ALL_MENU_ERROR("메뉴 전체 조회중 오류가 발했습니다"),
    USER_INVALIDE_INPUT_ERROR("사용자 입력값이 유효하지 않습니다"),
    FIND_A_MENU_ERROR("메뉴 한 건 조회중 오류가 발생했습니다"),

    // 전현선 작업 시작
    DELETE_PRODUCT_ERROR("상품 삭제 중 오류가 발생했습니다."),
    UPDATE_PRODUCT_ERROR("상품 수정 중 오류가 발생했습니다.");
    // 전현선 작업 끝

    @Getter
    final String msg;


}
