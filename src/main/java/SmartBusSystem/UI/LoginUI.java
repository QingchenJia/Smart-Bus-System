/*
 * Created by JFormDesigner on Wed Jun 26 23:27:45 CST 2024
 */

package SmartBusSystem.UI;

import SmartBusSystem.service.login.Login;
import SmartBusSystem.service.login.VerifyCode;
import SmartBusSystem.service.login.impl.AdminLogin;
import SmartBusSystem.service.login.impl.DriverLogin;
import SmartBusSystem.service.login.impl.UserLogin;
import SmartBusSystem.service.recover.Recover;
import SmartBusSystem.service.recover.impl.DriverRecover;
import SmartBusSystem.service.recover.impl.UserRecover;
import SmartBusSystem.service.tool.SecurityProtect;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Objects;

/**
 * @author 87948
 */
public class LoginUI extends JFrame {
    public LoginUI() {
        initComponents();
        this.setVisible(true);
    }

    private void RegisterMouseReleased(MouseEvent e) {
        showInCenterOfFrame(RegisterSelect);
    }

    private void UserRegisterMouseReleased(MouseEvent e) {
        RegisterSelect.dispose();
        this.dispose();
        new UserRegisterUI();
    }

    private void RightCodeMouseReleased(MouseEvent e) {
        RightCode.setText(VerifyCode.getVerifyCode());
    }

    private void UserLoginButtonMouseReleased(MouseEvent e) {
        String ID = IdInput.getText();
        String password = new String(PasswordInput.getPassword());
        String code = CodeInput.getText();
        String rightCode = RightCode.getText();

        roleLogin("乘客", ID, password, code, rightCode);
    }

    private void DriverLoginButtonMouseReleased(MouseEvent e) {
        String ID = IdInput.getText();
        String password = new String(PasswordInput.getPassword());
        String code = CodeInput.getText();
        String rightCode = RightCode.getText();

        roleLogin("司机", ID, password, code, rightCode);
    }

    private void DriverRegisterMouseReleased(MouseEvent e) {
        RegisterSelect.dispose();
        this.dispose();
        new DriverRegisterUI();
    }

    private void AdminEnterMouseReleased(MouseEvent e) {
        showInCenterOfFrame(AdminLoginDialog);
    }

    private void AdminLoginButtonMouseReleased(MouseEvent e) {
        String ID = AdminIdInput.getText();
        String password = new String(AdminPasswordInput.getPassword());

        roleLogin(ID, password);
    }

    private void UserEnterSystemMouseReleased(MouseEvent e) {
        UserPass.dispose();
        this.dispose();
        String ID = IdInput.getText();
        new UserFunctionUI().setCurrentUserId(ID);  //打开功能界面 同时记录当前用户ID
    }

    private void RecoverButtonMouseReleased(MouseEvent e) {
        String ID = RecoverIdInput.getText();
        String phoneNum = RecoverPhoneNumInput.getText();
        String newPassword = new String(NewPasswordInput.getPassword());
        String newPasswordAgain = new String(NewPasswordAgainInput.getPassword());
        String role = Objects.requireNonNull(RoleSelect.getSelectedItem()).toString();

        resetPassword(role, ID, phoneNum, newPassword, newPasswordAgain);
    }

    private void RecoverMouseReleased(MouseEvent e) {
        showInCenterOfFrame(RecoverDialog);
    }

    private void DriverEnterSystemMouseReleased(MouseEvent e) {
        DriverPass.dispose();
        this.dispose();
        String ID = IdInput.getText();
        new DriverFunctionUI(ID);  //打开功能界面 同时记录当前司机ID
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        IdInput = new JFormattedTextField();
        PasswordInput = new JPasswordField();
        Title = new JLabel();
        Id = new JLabel();
        Password = new JLabel();
        Code = new JLabel();
        CodeInput = new JFormattedTextField();
        RightCode = new JLabel();
        UserLoginButton = new JButton();
        DriverLoginButton = new JButton();
        Register = new JButton();
        Recover = new JButton();
        AdminEnter = new JButton();
        RegisterSelect = new JDialog();
        UserRegister = new JButton();
        DriverRegister = new JButton();
        PasswordWrong = new JDialog();
        tips1 = new JLabel();
        IdNoExist = new JDialog();
        tips2 = new JLabel();
        CodeWrong = new JDialog();
        tips3 = new JLabel();
        DriverPass = new JDialog();
        DriverEnterSystem = new JButton();
        AdminLoginDialog = new JDialog();
        AdminId = new JLabel();
        AdminPassword = new JLabel();
        AdminIdInput = new JFormattedTextField();
        AdminPasswordInput = new JPasswordField();
        AdminLoginButton = new JButton();
        UserPass = new JDialog();
        UserEnterSystem = new JButton();
        RecoverDialog = new JDialog();
        RecoverId = new JLabel();
        RecoverPhoneNum = new JLabel();
        NewPassword = new JLabel();
        NewPasswordAgain = new JLabel();
        RecoverIdInput = new JTextField();
        RecoverPhoneNumInput = new JTextField();
        NewPasswordInput = new JPasswordField();
        NewPasswordAgainInput = new JPasswordField();
        RoleSelect = new JComboBox<>();
        Role = new JLabel();
        RecoverButton = new JButton();
        PhoneNumWrong = new JDialog();
        tips4 = new JLabel();
        PasswordFormatError = new JDialog();
        tips5 = new JLabel();
        PasswordNotSame = new JDialog();
        PasswordDifferent = new JLabel();

        //======== this ========
        setAlwaysOnTop(true);
        setTitle("\u667a\u6167\u516c\u4ea4\u7cfb\u7edf");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        var contentPane = getContentPane();
        contentPane.setLayout(null);
        contentPane.add(IdInput);
        IdInput.setBounds(185, 125, 195, 25);
        contentPane.add(PasswordInput);
        PasswordInput.setBounds(185, 175, 195, 25);

        //---- Title ----
        Title.setText("\u667a\u6167\u516c\u4ea4\u7cfb\u7edf");
        Title.setFont(Title.getFont().deriveFont(Title.getFont().getSize() + 25f));
        contentPane.add(Title);
        Title.setBounds(new Rectangle(new Point(160, 45), Title.getPreferredSize()));

        //---- Id ----
        Id.setText("\u8d26\u53f7:");
        Id.setFont(Id.getFont().deriveFont(Id.getFont().getSize() + 12f));
        contentPane.add(Id);
        Id.setBounds(new Rectangle(new Point(110, 118), Id.getPreferredSize()));

        //---- Password ----
        Password.setText("\u5bc6\u7801:");
        Password.setFont(Password.getFont().deriveFont(Password.getFont().getSize() + 12f));
        contentPane.add(Password);
        Password.setBounds(new Rectangle(new Point(110, 168), Password.getPreferredSize()));

        //---- Code ----
        Code.setText("\u9a8c\u8bc1\u7801:");
        Code.setFont(Code.getFont().deriveFont(Code.getFont().getSize() + 12f));
        contentPane.add(Code);
        Code.setBounds(new Rectangle(new Point(110, 218), Code.getPreferredSize()));
        contentPane.add(CodeInput);
        CodeInput.setBounds(210, 225, 55, 25);

        //---- RightCode ----
        RightCode.setText("\u70b9\u51fb\u4e00\u4e0b!");
        RightCode.setFont(new Font("\u5b8b\u4f53", Font.BOLD, 15));
        RightCode.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                RightCodeMouseReleased(e);
            }
        });
        contentPane.add(RightCode);
        RightCode.setBounds(280, 225, RightCode.getPreferredSize().width, 25);

        //---- UserLoginButton ----
        UserLoginButton.setText("\u4e58\u5ba2\u767b\u5f55");
        UserLoginButton.setFont(UserLoginButton.getFont().deriveFont(UserLoginButton.getFont().getStyle() | Font.BOLD, UserLoginButton.getFont().getSize() + 10f));
        UserLoginButton.setFocusPainted(false);
        UserLoginButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                UserLoginButtonMouseReleased(e);
            }
        });
        contentPane.add(UserLoginButton);
        UserLoginButton.setBounds(110, 265, UserLoginButton.getPreferredSize().width, 31);

        //---- DriverLoginButton ----
        DriverLoginButton.setText("\u53f8\u673a\u767b\u5f55");
        DriverLoginButton.setFont(DriverLoginButton.getFont().deriveFont(DriverLoginButton.getFont().getStyle() | Font.BOLD, DriverLoginButton.getFont().getSize() + 10f));
        DriverLoginButton.setFocusPainted(false);
        DriverLoginButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                DriverLoginButtonMouseReleased(e);
            }
        });
        contentPane.add(DriverLoginButton);
        DriverLoginButton.setBounds(255, 265, DriverLoginButton.getPreferredSize().width, 31);

        //---- Register ----
        Register.setText("\u6ce8\u518c");
        Register.setFont(Register.getFont().deriveFont(Register.getFont().getStyle() | Font.BOLD, Register.getFont().getSize() + 7f));
        Register.setFocusPainted(false);
        Register.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                RegisterMouseReleased(e);
            }
        });
        contentPane.add(Register);
        Register.setBounds(390, 125, Register.getPreferredSize().width, 25);

        //---- Recover ----
        Recover.setText("\u627e\u56de\u5bc6\u7801");
        Recover.setFont(Recover.getFont().deriveFont(Recover.getFont().getStyle() | Font.BOLD, Recover.getFont().getSize() + 7f));
        Recover.setFocusPainted(false);
        Recover.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                RecoverMouseReleased(e);
            }
        });
        contentPane.add(Recover);
        Recover.setBounds(390, 175, Recover.getPreferredSize().width, 25);

        //---- AdminEnter ----
        AdminEnter.setText("\u7ba1\u7406\u5458\u5165\u53e3");
        AdminEnter.setFont(AdminEnter.getFont().deriveFont(AdminEnter.getFont().getStyle() | Font.BOLD, AdminEnter.getFont().getSize() + 5f));
        AdminEnter.setFocusPainted(false);
        AdminEnter.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                AdminEnterMouseReleased(e);
            }
        });
        contentPane.add(AdminEnter);
        AdminEnter.setBounds(420, 5, 125, 30);

        contentPane.setPreferredSize(new Dimension(560, 355));
        setSize(560, 355);
        setLocationRelativeTo(getOwner());

        //======== RegisterSelect ========
        {
            RegisterSelect.setAlwaysOnTop(true);
            RegisterSelect.setTitle("\u6ce8\u518c\u9009\u9879");
            RegisterSelect.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            RegisterSelect.setModal(true);
            var RegisterSelectContentPane = RegisterSelect.getContentPane();
            RegisterSelectContentPane.setLayout(null);

            //---- UserRegister ----
            UserRegister.setText("\u4e58\u5ba2\u6ce8\u518c");
            UserRegister.setFont(UserRegister.getFont().deriveFont(UserRegister.getFont().getStyle() | Font.BOLD, UserRegister.getFont().getSize() + 10f));
            UserRegister.setFocusPainted(false);
            UserRegister.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseReleased(MouseEvent e) {
                    UserRegisterMouseReleased(e);
                }
            });
            RegisterSelectContentPane.add(UserRegister);
            UserRegister.setBounds(40, 20, UserRegister.getPreferredSize().width, 26);

            //---- DriverRegister ----
            DriverRegister.setText("\u53f8\u673a\u6ce8\u518c");
            DriverRegister.setFont(DriverRegister.getFont().deriveFont(DriverRegister.getFont().getStyle() | Font.BOLD, DriverRegister.getFont().getSize() + 10f));
            DriverRegister.setFocusPainted(false);
            DriverRegister.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseReleased(MouseEvent e) {
                    DriverRegisterMouseReleased(e);
                }
            });
            RegisterSelectContentPane.add(DriverRegister);
            DriverRegister.setBounds(40, 65, DriverRegister.getPreferredSize().width, 26);

            RegisterSelectContentPane.setPreferredSize(new Dimension(215, 145));
            RegisterSelect.setSize(215, 145);
            RegisterSelect.setLocationRelativeTo(RegisterSelect.getOwner());
        }

        //======== PasswordWrong ========
        {
            PasswordWrong.setTitle("\u9519\u8bef\u63d0\u9192");
            PasswordWrong.setModal(true);
            PasswordWrong.setAlwaysOnTop(true);
            PasswordWrong.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            var PasswordWrongContentPane = PasswordWrong.getContentPane();
            PasswordWrongContentPane.setLayout(null);

            //---- tips1 ----
            tips1.setText("\u5bc6\u7801\u9519\u8bef\uff0c\u8bf7\u91cd\u65b0\u8f93\u5165");
            tips1.setFont(tips1.getFont().deriveFont(tips1.getFont().getStyle() | Font.BOLD, tips1.getFont().getSize() + 7f));
            PasswordWrongContentPane.add(tips1);
            tips1.setBounds(new Rectangle(new Point(45, 30), tips1.getPreferredSize()));

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < PasswordWrongContentPane.getComponentCount(); i++) {
                    Rectangle bounds = PasswordWrongContentPane.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = PasswordWrongContentPane.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                PasswordWrongContentPane.setMinimumSize(preferredSize);
                PasswordWrongContentPane.setPreferredSize(preferredSize);
            }
            PasswordWrong.setSize(315, 125);
            PasswordWrong.setLocationRelativeTo(PasswordWrong.getOwner());
        }

        //======== IdNoExist ========
        {
            IdNoExist.setTitle("\u9519\u8bef\u63d0\u9192");
            IdNoExist.setModal(true);
            IdNoExist.setAlwaysOnTop(true);
            IdNoExist.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            var IdNoExistContentPane = IdNoExist.getContentPane();
            IdNoExistContentPane.setLayout(null);

            //---- tips2 ----
            tips2.setText("\u8d26\u53f7\u4e0d\u5b58\u5728\uff0c\u8bf7\u91cd\u65b0\u8f93\u5165");
            tips2.setFont(tips2.getFont().deriveFont(tips2.getFont().getStyle() | Font.BOLD, tips2.getFont().getSize() + 7f));
            IdNoExistContentPane.add(tips2);
            tips2.setBounds(new Rectangle(new Point(40, 30), tips2.getPreferredSize()));

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < IdNoExistContentPane.getComponentCount(); i++) {
                    Rectangle bounds = IdNoExistContentPane.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = IdNoExistContentPane.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                IdNoExistContentPane.setMinimumSize(preferredSize);
                IdNoExistContentPane.setPreferredSize(preferredSize);
            }
            IdNoExist.setSize(315, 125);
            IdNoExist.setLocationRelativeTo(IdNoExist.getOwner());
        }

        //======== CodeWrong ========
        {
            CodeWrong.setTitle("\u9519\u8bef\u63d0\u9192");
            CodeWrong.setModal(true);
            CodeWrong.setAlwaysOnTop(true);
            CodeWrong.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            var CodeWrongContentPane = CodeWrong.getContentPane();
            CodeWrongContentPane.setLayout(null);

            //---- tips3 ----
            tips3.setText("\u9a8c\u8bc1\u7801\u9519\u8bef\uff0c\u8bf7\u91cd\u65b0\u8f93\u5165");
            tips3.setFont(tips3.getFont().deriveFont(tips3.getFont().getStyle() | Font.BOLD, tips3.getFont().getSize() + 7f));
            CodeWrongContentPane.add(tips3);
            tips3.setBounds(new Rectangle(new Point(40, 30), tips3.getPreferredSize()));

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < CodeWrongContentPane.getComponentCount(); i++) {
                    Rectangle bounds = CodeWrongContentPane.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = CodeWrongContentPane.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                CodeWrongContentPane.setMinimumSize(preferredSize);
                CodeWrongContentPane.setPreferredSize(preferredSize);
            }
            CodeWrong.setSize(315, 125);
            CodeWrong.setLocationRelativeTo(CodeWrong.getOwner());
        }

        //======== DriverPass ========
        {
            DriverPass.setTitle("\u767b\u9646\u6210\u529f(\u53f8\u673a)");
            DriverPass.setModal(true);
            DriverPass.setAlwaysOnTop(true);
            DriverPass.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            var DriverPassContentPane = DriverPass.getContentPane();
            DriverPassContentPane.setLayout(null);

            //---- DriverEnterSystem ----
            DriverEnterSystem.setText("\u8fdb\u5165\u7cfb\u7edf");
            DriverEnterSystem.setFont(DriverEnterSystem.getFont().deriveFont(DriverEnterSystem.getFont().getStyle() | Font.BOLD, DriverEnterSystem.getFont().getSize() + 10f));
            DriverEnterSystem.setFocusPainted(false);
            DriverEnterSystem.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseReleased(MouseEvent e) {
                    DriverEnterSystemMouseReleased(e);
                }
            });
            DriverPassContentPane.add(DriverEnterSystem);
            DriverEnterSystem.setBounds(new Rectangle(new Point(40, 35), DriverEnterSystem.getPreferredSize()));

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < DriverPassContentPane.getComponentCount(); i++) {
                    Rectangle bounds = DriverPassContentPane.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = DriverPassContentPane.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                DriverPassContentPane.setMinimumSize(preferredSize);
                DriverPassContentPane.setPreferredSize(preferredSize);
            }
            DriverPass.setSize(215, 145);
            DriverPass.setLocationRelativeTo(DriverPass.getOwner());
        }

        //======== AdminLoginDialog ========
        {
            AdminLoginDialog.setTitle("\u7ba1\u7406\u5458\u767b\u5f55");
            AdminLoginDialog.setAlwaysOnTop(true);
            AdminLoginDialog.setModal(true);
            var AdminLoginDialogContentPane = AdminLoginDialog.getContentPane();
            AdminLoginDialogContentPane.setLayout(null);

            //---- AdminId ----
            AdminId.setText("\u8d26\u53f7:");
            AdminId.setFont(AdminId.getFont().deriveFont(AdminId.getFont().getSize() + 7f));
            AdminLoginDialogContentPane.add(AdminId);
            AdminId.setBounds(10, 25, 60, 25);

            //---- AdminPassword ----
            AdminPassword.setText("\u5bc6\u7801:");
            AdminPassword.setFont(AdminPassword.getFont().deriveFont(AdminPassword.getFont().getSize() + 7f));
            AdminLoginDialogContentPane.add(AdminPassword);
            AdminPassword.setBounds(10, 55, 60, 25);
            AdminLoginDialogContentPane.add(AdminIdInput);
            AdminIdInput.setBounds(70, 30, 130, 20);
            AdminLoginDialogContentPane.add(AdminPasswordInput);
            AdminPasswordInput.setBounds(70, 60, 130, 20);

            //---- AdminLoginButton ----
            AdminLoginButton.setText("\u7ba1\u7406\u5458\u767b\u5f55");
            AdminLoginButton.setFont(AdminLoginButton.getFont().deriveFont(AdminLoginButton.getFont().getStyle() | Font.BOLD, AdminLoginButton.getFont().getSize() + 6f));
            AdminLoginButton.setFocusPainted(false);
            AdminLoginButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseReleased(MouseEvent e) {
                    AdminLoginButtonMouseReleased(e);
                }
            });
            AdminLoginDialogContentPane.add(AdminLoginButton);
            AdminLoginButton.setBounds(new Rectangle(new Point(40, 100), AdminLoginButton.getPreferredSize()));

            AdminLoginDialogContentPane.setPreferredSize(new Dimension(220, 185));
            AdminLoginDialog.setSize(220, 185);
            AdminLoginDialog.setLocationRelativeTo(AdminLoginDialog.getOwner());
        }

        //======== UserPass ========
        {
            UserPass.setTitle("\u767b\u9646\u6210\u529f(\u4e58\u5ba2)");
            UserPass.setModal(true);
            UserPass.setAlwaysOnTop(true);
            UserPass.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            var UserPassContentPane = UserPass.getContentPane();
            UserPassContentPane.setLayout(null);

            //---- UserEnterSystem ----
            UserEnterSystem.setText("\u8fdb\u5165\u7cfb\u7edf");
            UserEnterSystem.setFont(UserEnterSystem.getFont().deriveFont(UserEnterSystem.getFont().getStyle() | Font.BOLD, UserEnterSystem.getFont().getSize() + 10f));
            UserEnterSystem.setFocusPainted(false);
            UserEnterSystem.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseReleased(MouseEvent e) {
                    UserEnterSystemMouseReleased(e);
                }
            });
            UserPassContentPane.add(UserEnterSystem);
            UserEnterSystem.setBounds(new Rectangle(new Point(40, 35), UserEnterSystem.getPreferredSize()));

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < UserPassContentPane.getComponentCount(); i++) {
                    Rectangle bounds = UserPassContentPane.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = UserPassContentPane.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                UserPassContentPane.setMinimumSize(preferredSize);
                UserPassContentPane.setPreferredSize(preferredSize);
            }
            UserPass.setSize(215, 145);
            UserPass.setLocationRelativeTo(UserPass.getOwner());
        }

        //======== RecoverDialog ========
        {
            RecoverDialog.setTitle("\u627e\u56de\u5bc6\u7801");
            RecoverDialog.setAlwaysOnTop(true);
            var RecoverDialogContentPane = RecoverDialog.getContentPane();
            RecoverDialogContentPane.setLayout(null);

            //---- RecoverId ----
            RecoverId.setText("\u8d26\u53f7:");
            RecoverId.setFont(RecoverId.getFont().deriveFont(RecoverId.getFont().getStyle() | Font.BOLD, RecoverId.getFont().getSize() + 7f));
            RecoverDialogContentPane.add(RecoverId);
            RecoverId.setBounds(new Rectangle(new Point(40, 35), RecoverId.getPreferredSize()));

            //---- RecoverPhoneNum ----
            RecoverPhoneNum.setText("\u624b\u673a\u53f7:");
            RecoverPhoneNum.setFont(RecoverPhoneNum.getFont().deriveFont(RecoverPhoneNum.getFont().getStyle() | Font.BOLD, RecoverPhoneNum.getFont().getSize() + 7f));
            RecoverDialogContentPane.add(RecoverPhoneNum);
            RecoverPhoneNum.setBounds(new Rectangle(new Point(40, 65), RecoverPhoneNum.getPreferredSize()));

            //---- NewPassword ----
            NewPassword.setText("\u65b0\u5bc6\u7801:");
            NewPassword.setFont(NewPassword.getFont().deriveFont(NewPassword.getFont().getStyle() | Font.BOLD, NewPassword.getFont().getSize() + 7f));
            RecoverDialogContentPane.add(NewPassword);
            NewPassword.setBounds(new Rectangle(new Point(40, 95), NewPassword.getPreferredSize()));

            //---- NewPasswordAgain ----
            NewPasswordAgain.setText("\u786e\u8ba4:");
            NewPasswordAgain.setFont(NewPasswordAgain.getFont().deriveFont(NewPasswordAgain.getFont().getStyle() | Font.BOLD, NewPasswordAgain.getFont().getSize() + 7f));
            RecoverDialogContentPane.add(NewPasswordAgain);
            NewPasswordAgain.setBounds(new Rectangle(new Point(40, 125), NewPasswordAgain.getPreferredSize()));
            RecoverDialogContentPane.add(RecoverIdInput);
            RecoverIdInput.setBounds(90, 40, 155, 20);
            RecoverDialogContentPane.add(RecoverPhoneNumInput);
            RecoverPhoneNumInput.setBounds(110, 70, 135, 20);
            RecoverDialogContentPane.add(NewPasswordInput);
            NewPasswordInput.setBounds(110, 100, 135, 20);
            RecoverDialogContentPane.add(NewPasswordAgainInput);
            NewPasswordAgainInput.setBounds(90, 130, 155, 20);

            //---- RoleSelect ----
            RoleSelect.setModel(new DefaultComboBoxModel<>(new String[] {
                "\u4e58\u5ba2",
                "\u53f8\u673a"
            }));
            RoleSelect.setFont(RoleSelect.getFont().deriveFont(RoleSelect.getFont().getStyle() | Font.BOLD, RoleSelect.getFont().getSize() + 4f));
            RecoverDialogContentPane.add(RoleSelect);
            RoleSelect.setBounds(new Rectangle(new Point(90, 155), RoleSelect.getPreferredSize()));

            //---- Role ----
            Role.setText("\u8eab\u4efd:");
            Role.setFont(Role.getFont().deriveFont(Role.getFont().getStyle() | Font.BOLD, Role.getFont().getSize() + 7f));
            RecoverDialogContentPane.add(Role);
            Role.setBounds(new Rectangle(new Point(40, 155), Role.getPreferredSize()));

            //---- RecoverButton ----
            RecoverButton.setText("\u4fdd\u5b58");
            RecoverButton.setFont(RecoverButton.getFont().deriveFont(RecoverButton.getFont().getStyle() | Font.BOLD, RecoverButton.getFont().getSize() + 4f));
            RecoverButton.setFocusPainted(false);
            RecoverButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseReleased(MouseEvent e) {
                    RecoverButtonMouseReleased(e);
                }
            });
            RecoverDialogContentPane.add(RecoverButton);
            RecoverButton.setBounds(new Rectangle(new Point(120, 195), RecoverButton.getPreferredSize()));

            RecoverDialogContentPane.setPreferredSize(new Dimension(315, 275));
            RecoverDialog.setSize(315, 275);
            RecoverDialog.setLocationRelativeTo(RecoverDialog.getOwner());
        }

        //======== PhoneNumWrong ========
        {
            PhoneNumWrong.setTitle("\u9519\u8bef\u63d0\u9192");
            PhoneNumWrong.setModal(true);
            PhoneNumWrong.setAlwaysOnTop(true);
            PhoneNumWrong.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            var PhoneNumWrongContentPane = PhoneNumWrong.getContentPane();
            PhoneNumWrongContentPane.setLayout(null);

            //---- tips4 ----
            tips4.setText("\u624b\u673a\u53f7\u9519\u8bef\uff0c\u8bf7\u91cd\u65b0\u8f93\u5165");
            tips4.setFont(tips4.getFont().deriveFont(tips4.getFont().getStyle() | Font.BOLD, tips4.getFont().getSize() + 7f));
            PhoneNumWrongContentPane.add(tips4);
            tips4.setBounds(new Rectangle(new Point(40, 30), tips4.getPreferredSize()));

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < PhoneNumWrongContentPane.getComponentCount(); i++) {
                    Rectangle bounds = PhoneNumWrongContentPane.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = PhoneNumWrongContentPane.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                PhoneNumWrongContentPane.setMinimumSize(preferredSize);
                PhoneNumWrongContentPane.setPreferredSize(preferredSize);
            }
            PhoneNumWrong.setSize(315, 125);
            PhoneNumWrong.setLocationRelativeTo(PhoneNumWrong.getOwner());
        }

        //======== PasswordFormatError ========
        {
            PasswordFormatError.setTitle("\u9519\u8bef\u63d0\u9192");
            PasswordFormatError.setModal(true);
            PasswordFormatError.setAlwaysOnTop(true);
            PasswordFormatError.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            var PasswordFormatErrorContentPane = PasswordFormatError.getContentPane();
            PasswordFormatErrorContentPane.setLayout(null);

            //---- tips5 ----
            tips5.setText("\u5bc6\u7801\u683c\u5f0f\u9519\u8bef\uff0c\u8bf7\u91cd\u65b0\u8f93\u5165");
            tips5.setFont(tips5.getFont().deriveFont(tips5.getFont().getStyle() | Font.BOLD, tips5.getFont().getSize() + 7f));
            PasswordFormatErrorContentPane.add(tips5);
            tips5.setBounds(new Rectangle(new Point(40, 30), tips5.getPreferredSize()));

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < PasswordFormatErrorContentPane.getComponentCount(); i++) {
                    Rectangle bounds = PasswordFormatErrorContentPane.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = PasswordFormatErrorContentPane.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                PasswordFormatErrorContentPane.setMinimumSize(preferredSize);
                PasswordFormatErrorContentPane.setPreferredSize(preferredSize);
            }
            PasswordFormatError.setSize(315, 125);
            PasswordFormatError.setLocationRelativeTo(PasswordFormatError.getOwner());
        }

        //======== PasswordNotSame ========
        {
            PasswordNotSame.setTitle("\u9519\u8bef\u63d0\u9192");
            PasswordNotSame.setModal(true);
            PasswordNotSame.setAlwaysOnTop(true);
            PasswordNotSame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            var PasswordNotSameContentPane = PasswordNotSame.getContentPane();
            PasswordNotSameContentPane.setLayout(null);

            //---- PasswordDifferent ----
            PasswordDifferent.setText("\u524d\u540e\u5bc6\u7801\u4e0d\u4e00\u81f4\uff0c\u8bf7\u91cd\u65b0\u8f93\u5165");
            PasswordDifferent.setFont(PasswordDifferent.getFont().deriveFont(PasswordDifferent.getFont().getStyle() | Font.BOLD, PasswordDifferent.getFont().getSize() + 7f));
            PasswordNotSameContentPane.add(PasswordDifferent);
            PasswordDifferent.setBounds(new Rectangle(new Point(40, 30), PasswordDifferent.getPreferredSize()));

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < PasswordNotSameContentPane.getComponentCount(); i++) {
                    Rectangle bounds = PasswordNotSameContentPane.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = PasswordNotSameContentPane.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                PasswordNotSameContentPane.setMinimumSize(preferredSize);
                PasswordNotSameContentPane.setPreferredSize(preferredSize);
            }
            PasswordNotSame.setSize(315, 125);
            PasswordNotSame.setLocationRelativeTo(PasswordNotSame.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JFormattedTextField IdInput;
    private JPasswordField PasswordInput;
    private JLabel Title;
    private JLabel Id;
    private JLabel Password;
    private JLabel Code;
    private JFormattedTextField CodeInput;
    private JLabel RightCode;
    private JButton UserLoginButton;
    private JButton DriverLoginButton;
    private JButton Register;
    private JButton Recover;
    private JButton AdminEnter;
    private JDialog RegisterSelect;
    private JButton UserRegister;
    private JButton DriverRegister;
    private JDialog PasswordWrong;
    private JLabel tips1;
    private JDialog IdNoExist;
    private JLabel tips2;
    private JDialog CodeWrong;
    private JLabel tips3;
    private JDialog DriverPass;
    private JButton DriverEnterSystem;
    private JDialog AdminLoginDialog;
    private JLabel AdminId;
    private JLabel AdminPassword;
    private JFormattedTextField AdminIdInput;
    private JPasswordField AdminPasswordInput;
    private JButton AdminLoginButton;
    private JDialog UserPass;
    private JButton UserEnterSystem;
    private JDialog RecoverDialog;
    private JLabel RecoverId;
    private JLabel RecoverPhoneNum;
    private JLabel NewPassword;
    private JLabel NewPasswordAgain;
    private JTextField RecoverIdInput;
    private JTextField RecoverPhoneNumInput;
    private JPasswordField NewPasswordInput;
    private JPasswordField NewPasswordAgainInput;
    private JComboBox<String> RoleSelect;
    private JLabel Role;
    private JButton RecoverButton;
    private JDialog PhoneNumWrong;
    private JLabel tips4;
    private JDialog PasswordFormatError;
    private JLabel tips5;
    private JDialog PasswordNotSame;
    private JLabel PasswordDifferent;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

    // 会话窗口始终位于主窗体中心 BEGIN
    private void setCenterOfFrame(JDialog jDialog) {
        jDialog.setLocationRelativeTo(this);
    }

    private void showInCenterOfFrame(JDialog jDialog) {
        setCenterOfFrame(jDialog);
        jDialog.setVisible(true);
    }
    // 会话窗口始终位于主窗体中心 END

    // 登录 BEGIN
    private Login login;

    private void roleLogin(String role, String ID, String password, String code, String rightCode) {
        if (ID.isEmpty() || password.isEmpty() || code.isEmpty()) return;

        if ("乘客".equals(role)) {
            login = new UserLogin();
        } else if ("司机".equals(role)) {
            login = new DriverLogin();
        }

        if (!login.verifyID(ID)) {
            showInCenterOfFrame(IdNoExist);
            return;
        }
        try {
            if (!login.verifyPassword(ID, password)) {
                showInCenterOfFrame(PasswordWrong);
                return;
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        if (!login.verifyVerifyCode(code, rightCode)) {
            showInCenterOfFrame(CodeWrong);
            return;
        }

        if ("乘客".equals(role)) {
            showInCenterOfFrame(UserPass);
        } else if ("司机".equals(role)) {
            showInCenterOfFrame(DriverPass);
        }

    }

    private void roleLogin(String ID, String password) {
        if (ID.isEmpty() || password.isEmpty()) return;

        login = new AdminLogin();

        if (!login.verifyID(ID)) {
            return;
        }
        try {
            if (!login.verifyPassword(ID, password)) {
                return;
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

        AdminLoginDialog.dispose();
        this.dispose();
        new AdminFunctionUI();
    }
    // 登录 END

    // 恢复(重设密码) BEGIN
    private Recover recover;

    private void resetPassword(String role, String ID, String phoneNum, String newPassword, String newPasswordAgain) {
        String newPasswordResult = null;
        try {
            newPasswordResult = SecurityProtect.encrypt(newPassword);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

        if ("乘客".equals(role)) {
            recover = new UserRecover();
        } else if ("司机".equals(role)) {
            recover = new DriverRecover();
        }

        if (!recover.verifyID(ID)) {
            showInCenterOfFrame(IdNoExist);
            return;
        }
        if (!recover.verifyPhoneNum(ID, phoneNum)) {
            showInCenterOfFrame(PhoneNumWrong);
            return;
        }
        if (!recover.checkPassword(newPassword)) {
            showInCenterOfFrame(PasswordFormatError);
            return;
        }
        if (!newPassword.equals(newPasswordAgain)) {
            showInCenterOfFrame(PasswordNotSame);
            return;
        }

        recover.resetPassword(ID, newPasswordResult);
    }
    // 恢复(重设密码) END
}