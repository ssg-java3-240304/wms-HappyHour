package wms.menu.model.dto;

public class LoginDto {
    // 관리자 id, password 정보
    private String adminId;
    private String adminPw;
    public LoginDto(){}

    public LoginDto(String adminId, String adminPw) {
        this.adminId = adminId;
        this.adminPw = adminPw;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getAdminPw() {
        return adminPw;
    }

    public void setAdminPw(String adminPw) {
        this.adminPw = adminPw;
    }

    @Override
    public String toString() {
        return "LoginDto{" +
                "adminId='" + adminId + '\'' +
                ", adminPw='" + adminPw + '\'' +
                '}';
    }
}