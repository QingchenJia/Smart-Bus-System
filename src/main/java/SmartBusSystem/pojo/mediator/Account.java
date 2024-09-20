package SmartBusSystem.pojo.mediator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
}
