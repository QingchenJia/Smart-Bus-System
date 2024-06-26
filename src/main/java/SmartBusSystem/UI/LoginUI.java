/*
 * Created by JFormDesigner on Wed Jun 26 23:27:45 CST 2024
 */

package SmartBusSystem.UI;

import java.awt.*;
import javax.swing.*;

/**
 * @author 87948
 */
public class LoginUI extends JFrame {
    public LoginUI() {
        initComponents();
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

        //======== this ========
        setAlwaysOnTop(true);
        setTitle("\u667a\u6167\u516c\u4ea4\u7cfb\u7edf");
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
        Id.setBounds(new Rectangle(new Point(110, 125), Id.getPreferredSize()));

        //---- Password ----
        Password.setText("\u5bc6\u7801:");
        Password.setFont(Password.getFont().deriveFont(Password.getFont().getSize() + 12f));
        contentPane.add(Password);
        Password.setBounds(new Rectangle(new Point(110, 175), Password.getPreferredSize()));

        //---- Code ----
        Code.setText("\u9a8c\u8bc1\u7801:");
        Code.setFont(Code.getFont().deriveFont(Code.getFont().getSize() + 12f));
        contentPane.add(Code);
        Code.setBounds(new Rectangle(new Point(110, 225), Code.getPreferredSize()));
        contentPane.add(CodeInput);
        CodeInput.setBounds(210, 225, 55, 25);

        //---- RightCode ----
        RightCode.setText("\u70b9\u51fb\u4e00\u4e0b!");
        RightCode.setFont(new Font("\u5b8b\u4f53", Font.BOLD, 15));
        contentPane.add(RightCode);
        RightCode.setBounds(280, 225, RightCode.getPreferredSize().width, 25);

        contentPane.setPreferredSize(new Dimension(540, 330));
        setSize(540, 330);
        setLocationRelativeTo(getOwner());
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
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
