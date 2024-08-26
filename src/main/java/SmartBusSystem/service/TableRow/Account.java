package SmartBusSystem.service.TableRow;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Account {
    private String ID;
    private String password;
    private String passwordAgain;
    private String phoneNum;
    private String code;
    private String rightCode;
    private String role;
    private String newPassword;
    private String newPasswordAgain;

    public Account() {
    }

    public Account(String ID, String password, String passwordAgain, String phoneNum, String code, String rightCode, String role, String newPassword, String newPasswordAgain) {
        this.ID = ID;
        this.password = password;
        this.passwordAgain = passwordAgain;
        this.phoneNum = phoneNum;
        this.code = code;
        this.rightCode = rightCode;
        this.role = role;
        this.newPassword = newPassword;
        this.newPasswordAgain = newPasswordAgain;
    }
}
