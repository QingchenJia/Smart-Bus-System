/*
 * Created by JFormDesigner on Wed Jun 26 23:27:45 CST 2024
 */

package SmartBusSystem.UI;

import SmartBusSystem.service.login.DriverLogin;
import SmartBusSystem.service.login.UserLogin;
import SmartBusSystem.service.login.VerifyCode;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author 87948
 */
public class LoginUI extends JFrame {
    public LoginUI() {
        initComponents();
        this.setVisible(true);
    }

    private void RegisterMouseReleased(MouseEvent e) {
        // TODO add your code here
        RegisterSelect.setVisible(true);
    }

    private void UserRegisterMouseReleased(MouseEvent e) {
        // TODO add your code here
        RegisterSelect.dispose();
        this.dispose();
        new UserRegisterUI();
    }

    private void RightCodeMouseReleased(MouseEvent e) {
        // TODO add your code here
        RightCode.setText(VerifyCode.getVerifyCode());
    }

    private void UserLoginButtonMouseReleased(MouseEvent e) throws Exception {
        // TODO add your code here
        String ID = IdInput.getText();
        String password = new String(PasswordInput.getPassword());
        String code = CodeInput.getText();
        String rightCode = RightCode.getText();

        if (!UserLogin.verifyID(ID)) {
            IdNoExist.setVisible(true);
            return;
        }
        if (!UserLogin.verifyPassword(ID, password)) {
            PasswordWrong.setVisible(true);
            return;
        }
        if (!UserLogin.verifyVerifyCode(code, rightCode)) {
            CodeWrong.setVisible(true);
            return;
        }
        Pass.setVisible(true);
    }

    private void DriverLoginButtonMouseReleased(MouseEvent e) throws Exception {
        // TODO add your code here
        String ID = IdInput.getText();
        String password = new String(PasswordInput.getPassword());
        String code = CodeInput.getText();
        String rightCode = RightCode.getText();

        if (!DriverLogin.verifyID(ID)) {
            IdNoExist.setVisible(true);
            return;
        }
        if (!DriverLogin.verifyPassword(ID, password)) {
            PasswordWrong.setVisible(true);
            return;
        }
        if (!DriverLogin.verifyVerifyCode(code, rightCode)) {
            CodeWrong.setVisible(true);
            return;
        }
        Pass.setVisible(true);
    }

    private void DriverRegisterMouseReleased(MouseEvent e) {
        // TODO add your code here
        RegisterSelect.dispose();
        this.dispose();
        new DriverRegisterUI();
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
        AdminLogin = new JButton();
        RegisterSelect = new JDialog();
        UserRegister = new JButton();
        DriverRegister = new JButton();
        PasswordWrong = new JDialog();
        tips1 = new JLabel();
        IdNoExist = new JDialog();
        tips2 = new JLabel();
        CodeWrong = new JDialog();
        tips3 = new JLabel();
        Pass = new JDialog();
        EnterSystem = new JButton();

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
        Id.setBounds(new Rectangle(new Point(110, 120), Id.getPreferredSize()));

        //---- Password ----
        Password.setText("\u5bc6\u7801:");
        Password.setFont(Password.getFont().deriveFont(Password.getFont().getSize() + 12f));
        contentPane.add(Password);
        Password.setBounds(new Rectangle(new Point(110, 170), Password.getPreferredSize()));

        //---- Code ----
        Code.setText("\u9a8c\u8bc1\u7801:");
        Code.setFont(Code.getFont().deriveFont(Code.getFont().getSize() + 12f));
        contentPane.add(Code);
        Code.setBounds(new Rectangle(new Point(110, 220), Code.getPreferredSize()));
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
                try {
UserLoginButtonMouseReleased(e);} catch (Exception ex) {
    throw new RuntimeException(ex);
}
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
                try {
DriverLoginButtonMouseReleased(e);} catch (Exception ex) {
    throw new RuntimeException(ex);
}
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
        contentPane.add(Recover);
        Recover.setBounds(390, 175, Recover.getPreferredSize().width, 25);

        //---- AdminLogin ----
        AdminLogin.setText("\u7ba1\u7406\u5458\u5165\u53e3");
        AdminLogin.setFont(AdminLogin.getFont().deriveFont(AdminLogin.getFont().getStyle() | Font.BOLD, AdminLogin.getFont().getSize() + 5f));
        AdminLogin.setFocusPainted(false);
        contentPane.add(AdminLogin);
        AdminLogin.setBounds(420, 5, 125, 30);

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
            tips1.setFont(tips1.getFont().deriveFont(tips1.getFont().getStyle() | Font.BOLD, tips1.getFont().getSize() + 8f));
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
            tips2.setFont(tips2.getFont().deriveFont(tips2.getFont().getStyle() | Font.BOLD, tips2.getFont().getSize() + 8f));
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
            tips3.setFont(tips3.getFont().deriveFont(tips3.getFont().getStyle() | Font.BOLD, tips3.getFont().getSize() + 8f));
            CodeWrongContentPane.add(tips3);
            tips3.setBounds(new Rectangle(new Point(45, 30), tips3.getPreferredSize()));

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

        //======== Pass ========
        {
            Pass.setTitle("\u767b\u9646\u6210\u529f");
            Pass.setModal(true);
            Pass.setAlwaysOnTop(true);
            Pass.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            var PassContentPane = Pass.getContentPane();
            PassContentPane.setLayout(null);

            //---- EnterSystem ----
            EnterSystem.setText("\u8fdb\u5165\u7cfb\u7edf");
            EnterSystem.setFont(EnterSystem.getFont().deriveFont(EnterSystem.getFont().getStyle() | Font.BOLD, EnterSystem.getFont().getSize() + 10f));
            EnterSystem.setFocusPainted(false);
            PassContentPane.add(EnterSystem);
            EnterSystem.setBounds(new Rectangle(new Point(40, 35), EnterSystem.getPreferredSize()));

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < PassContentPane.getComponentCount(); i++) {
                    Rectangle bounds = PassContentPane.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = PassContentPane.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                PassContentPane.setMinimumSize(preferredSize);
                PassContentPane.setPreferredSize(preferredSize);
            }
            Pass.setSize(215, 145);
            Pass.setLocationRelativeTo(Pass.getOwner());
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
    private JButton AdminLogin;
    private JDialog RegisterSelect;
    private JButton UserRegister;
    private JButton DriverRegister;
    private JDialog PasswordWrong;
    private JLabel tips1;
    private JDialog IdNoExist;
    private JLabel tips2;
    private JDialog CodeWrong;
    private JLabel tips3;
    private JDialog Pass;
    private JButton EnterSystem;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
