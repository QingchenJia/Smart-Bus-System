package SmartBusSystem.UI;

import SmartBusSystem.UI.JFD.AdminFunctionUI;
import SmartBusSystem.Util.CipherUtil;
import SmartBusSystem.pojo.mediator.Account;
import SmartBusSystem.service.login.Login;
import SmartBusSystem.service.recover.Recover;
import SmartBusSystem.service.recover.impl.DriverRecover;
import SmartBusSystem.service.recover.impl.UserRecover;
import lombok.extern.slf4j.Slf4j;

import javax.swing.*;
import java.util.Objects;

@Slf4j
public class AccountLogin extends CenterWindow {
    protected Account collectAccountInfo(JFormattedTextField IdInput, JPasswordField PasswordInput, JFormattedTextField CodeInput, JLabel RightCode) {
        // 收集UI组件中的内容 组成对象 适用于乘客和司机
        Account account = new Account();

        account.setID(IdInput.getText());
        account.setPassword(new String(PasswordInput.getPassword()));
        account.setCode(CodeInput.getText());
        account.setRightCode(RightCode.getText());

        return account;
    }

    protected Account collectAccountInfo(JFormattedTextField AdminIdInput, JPasswordField AdminPasswordInput) {
        // 收集UI组件中的内容 组成对象 适用于管理员
        Account account = new Account();

        account.setID(AdminIdInput.getText());
        account.setPassword(new String(AdminPasswordInput.getPassword()));

        return account;
    }

    protected boolean verifyAccount(Login login,
                                    Account account,
                                    JDialog IdNoExist, JDialog PasswordWrong, JDialog CodeWrong) {
        log.info("登录验证");

        // 登录验证
        if (account.getID().isEmpty() || account.getPassword().isEmpty() || account.getCode().isEmpty()) return false;
        if (!login.verifyID(account.getID())) {
            showInCenterOfFrame(IdNoExist);
            return false;
        }
        try {
            if (!login.verifyPassword(account.getID(), account.getPassword())) {
                showInCenterOfFrame(PasswordWrong);
                return false;
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        if (!login.verifyVerifyCode(account.getCode(), account.getRightCode())) {
            showInCenterOfFrame(CodeWrong);
            return false;
        }

        return true;
    }

    protected boolean verifyAccount(Login login, Account account) {
        log.info("登录验证");

        if (account.getID().isEmpty() || account.getPassword().isEmpty()) return false;
        if (!login.verifyID(account.getID())) {
            return false;
        }
        try {
            if (!login.verifyPassword(account.getID(), account.getPassword())) {
                return false;
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

        return true;
    }

    protected void loginAccount(Login login,
                                Account account,
                                JDialog IdNoExist, JDialog PasswordWrong, JDialog CodeWrong,
                                JDialog Pass) {
        if (verifyAccount(login,
                account,
                IdNoExist, PasswordWrong, CodeWrong)) {
            log.info("登陆成功");

            showInCenterOfFrame(Pass);
        }
    }

    protected void loginAccount(Login login, Account account, JDialog AdminLoginDialog) {
        if (verifyAccount(login, account)) {
            log.info("登陆成功");

            AdminLoginDialog.dispose();
            this.dispose();
            new AdminFunctionUI();
        }
    }

    protected Account gainNewAccountInfo(JTextField RecoverIdInput, JTextField RecoverPhoneNumInput, JPasswordField NewPasswordInput, JPasswordField NewPasswordAgainInput, JComboBox<String> RoleSelect) {
        // 收集信息用以验证恢复账号
        Account account = new Account();

        account.setID(RecoverIdInput.getText());
        account.setPhoneNum(RecoverPhoneNumInput.getText());
        account.setNewPassword(new String(NewPasswordInput.getPassword()));
        account.setNewPasswordAgain(new String(NewPasswordAgainInput.getPassword()));
        account.setRole(Objects.requireNonNull(RoleSelect.getSelectedItem()).toString());

        return account;
    }

    protected Recover chooseRole(String role) {
        if ("乘客".equals(role)) {
            return new UserRecover();
        } else if ("司机".equals(role)) {
            return new DriverRecover();
        }

        return null;
    }

    protected void resetAccountPassword(Recover recover,
                                        Account account,
                                        JDialog IdNoExist, JDialog PhoneNumWrong, JDialog PasswordFormatError, JDialog PasswordNotSame) {
        String newPasswordResult = null;
        try {
            newPasswordResult = CipherUtil.encrypt(account.getNewPassword());
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

        if (!recover.verifyID(account.getID())) {
            showInCenterOfFrame(IdNoExist);
            return;
        }
        if (!recover.verifyPhoneNum(account.getID(), account.getPhoneNum())) {
            showInCenterOfFrame(PhoneNumWrong);
            return;
        }
        if (!recover.checkPassword(account.getNewPassword())) {
            showInCenterOfFrame(PasswordFormatError);
            return;
        }
        if (!account.getNewPassword().equals(account.getNewPasswordAgain())) {
            showInCenterOfFrame(PasswordNotSame);
            return;
        }

        log.info("修改成功");

        recover.resetPassword(account.getID(), newPasswordResult);
    }
}
