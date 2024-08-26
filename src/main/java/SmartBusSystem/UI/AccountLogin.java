package SmartBusSystem.UI;

import SmartBusSystem.UI.JFD.AdminFunctionUI;
import SmartBusSystem.service.TableRow.Account;
import SmartBusSystem.service.login.Login;

import javax.swing.*;

public class AccountLogin extends CenterWindow {
    protected Account collectAccountInfo(JFormattedTextField IdInput, JPasswordField PasswordInput, JFormattedTextField CodeInput, JLabel RightCode) {
        Account account = new Account();

        account.setID(IdInput.getText());
        account.setPassword(new String(PasswordInput.getPassword()));
        account.setCode(CodeInput.getText());
        account.setRightCode(RightCode.getText());

        return account;
    }

    protected Account collectAccountInf(JFormattedTextField AdminIdInput, JPasswordField AdminPasswordInput) {
        Account account = new Account();

        account.setID(AdminIdInput.getText());
        account.setPassword(new String(AdminPasswordInput.getPassword()));

        return account;
    }

    protected boolean verifyAccount(Login login,
                                    Account account,
                                    JDialog IdNoExist, JDialog PasswordWrong, JDialog CodeWrong) {
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
                IdNoExist, PasswordWrong, CodeWrong))
            showInCenterOfFrame(Pass);
    }

    protected void loginAccount(Login login, Account account, JDialog AdminLoginDialog) {
        if (verifyAccount(login, account)) {
            AdminLoginDialog.dispose();
            this.dispose();
            new AdminFunctionUI();
        }
    }
}

