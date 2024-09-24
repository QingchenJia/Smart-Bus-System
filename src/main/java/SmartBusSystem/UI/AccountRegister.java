package SmartBusSystem.UI;

import SmartBusSystem.pojo.mediator.Account;
import SmartBusSystem.service.register.Register;
import lombok.extern.slf4j.Slf4j;

import javax.swing.*;

@Slf4j
public class AccountRegister extends CenterWindow {
    protected Account collectAccountInfo(JFormattedTextField IdInput, JPasswordField PasswordInput, JPasswordField PasswordAgainInput, JFormattedTextField PhoneNumInput) {
        Account account = new Account();

        account.setID(IdInput.getText());
        account.setPassword(new String(PasswordInput.getPassword()));
        account.setPasswordAgain(new String(PasswordAgainInput.getPassword()));
        account.setPhoneNum(PhoneNumInput.getText());

        return account;
    }

    protected void registerAccount(Register register,
                                   Account account,
                                   JDialog IdWrong, JDialog IdExist, JDialog PasswordWrong, JDialog PasswordDifferent, JDialog PhoneNumWrong, JDialog Pass) {
        if (!register.checkID(account.getID())) {
            showInCenterOfFrame(IdWrong);
            return;
        }
        if (register.containObject(account.getID())) {
            showInCenterOfFrame(IdExist);
            return;
        }
        if (!register.checkPassword(account.getPassword())) {
            showInCenterOfFrame(PasswordWrong);
            return;
        }
        if (!account.getPassword().equals(account.getPasswordAgain())) {
            showInCenterOfFrame(PasswordDifferent);
            return;
        }
        if (!register.checkPhoneNum(account.getPhoneNum())) {
            showInCenterOfFrame(PhoneNumWrong);
            return;
        }

        log.info("注册成功");

        showInCenterOfFrame(Pass);
    }
}
