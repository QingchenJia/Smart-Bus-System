/*
 * Created by JFormDesigner on Wed Jun 26 23:27:45 CST 2024
 */

package SmartBusSystem.UI;

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
        UserLogin = new JButton();
        DriverLogin = new JButton();
        Register = new JButton();
        Recover = new JButton();
        AdminLogin = new JButton();
        RegisterSelect = new JDialog();
        UserRegister = new JButton();
        DriverRegister = new JButton();

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
        contentPane.add(RightCode);
        RightCode.setBounds(280, 225, RightCode.getPreferredSize().width, 25);

        //---- UserLogin ----
        UserLogin.setText("\u4e58\u5ba2\u767b\u5f55");
        UserLogin.setFont(UserLogin.getFont().deriveFont(UserLogin.getFont().getStyle() | Font.BOLD, UserLogin.getFont().getSize() + 10f));
        UserLogin.setFocusPainted(false);
        contentPane.add(UserLogin);
        UserLogin.setBounds(110, 265, UserLogin.getPreferredSize().width, 31);

        //---- DriverLogin ----
        DriverLogin.setText("\u53f8\u673a\u767b\u5f55");
        DriverLogin.setFont(DriverLogin.getFont().deriveFont(DriverLogin.getFont().getStyle() | Font.BOLD, DriverLogin.getFont().getSize() + 10f));
        DriverLogin.setFocusPainted(false);
        contentPane.add(DriverLogin);
        DriverLogin.setBounds(255, 265, DriverLogin.getPreferredSize().width, 31);

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
            RegisterSelectContentPane.add(DriverRegister);
            DriverRegister.setBounds(40, 65, DriverRegister.getPreferredSize().width, 26);

            RegisterSelectContentPane.setPreferredSize(new Dimension(215, 145));
            RegisterSelect.setSize(215, 145);
            RegisterSelect.setLocationRelativeTo(RegisterSelect.getOwner());
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
    private JButton UserLogin;
    private JButton DriverLogin;
    private JButton Register;
    private JButton Recover;
    private JButton AdminLogin;
    private JDialog RegisterSelect;
    private JButton UserRegister;
    private JButton DriverRegister;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
