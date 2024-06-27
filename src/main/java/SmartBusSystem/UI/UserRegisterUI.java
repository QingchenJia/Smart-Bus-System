/*
 * Created by JFormDesigner on Thu Jun 27 13:40:09 CST 2024
 */

package SmartBusSystem.UI;

import SmartBusSystem.service.register.UserRegister;

import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import javax.swing.*;

/**
 * @author 87948
 */
public class UserRegisterUI extends JFrame {
    public UserRegisterUI() {
        initComponents();
        this.setVisible(true);
    }

    private void CheckMouseReleased(MouseEvent e) {
        // TODO add your code here
        String ID = IdInput.getText();
        String password = new String(PasswordInput.getPassword());
        String passwordAgain = new String(PasswordAgainInput.getPassword());
        String phoneNum = PhoneNumIdInput.getText();
        int aptitude = IsAptitude.isSelected() ? 0 : 1;

        if (!UserRegister.checkID(ID)) {
            IdWrong.setVisible(true);
            return;
        }
        if (UserRegister.containUser(ID)) {
            IdExist.setVisible(true);
            return;
        }
        if (!UserRegister.checkPassword(password)) {
            PasswordWrong.setVisible(true);
            return;
        }
        if (!password.equals(passwordAgain)) {
            PasswordDifferent.setVisible(true);
            return;
        }
        if (!UserRegister.checkPhoneNum(phoneNum)) {
            PasswordDifferent.setVisible(true);
            return;
        }
        Pass.setVisible(true);
    }

    private void BackwardMouseReleased(MouseEvent e) {
        // TODO add your code here
        this.dispose();
        new LoginUI();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        Id = new JLabel();
        Password = new JLabel();
        PhoneNum = new JLabel();
        PasswordAgain = new JLabel();
        Aptitude = new JLabel();
        IdInput = new JFormattedTextField();
        PhoneNumIdInput = new JFormattedTextField();
        PasswordInput = new JPasswordField();
        PasswordAgainInput = new JPasswordField();
        IsAptitude = new JCheckBox();
        Check = new JButton();
        Backward = new JButton();
        IdExist = new JDialog();
        tips1 = new JLabel();
        IdWrong = new JDialog();
        tips2 = new JLabel();
        PasswordWrong = new JDialog();
        tips3 = new JLabel();
        PasswordDifferent = new JDialog();
        tips4 = new JLabel();
        PhoneNumWrong = new JDialog();
        tips5 = new JLabel();
        Pass = new JDialog();
        Register = new JButton();

        //======== this ========
        setTitle("\u4e58\u5ba2\u6ce8\u518c");
        setAlwaysOnTop(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- Id ----
        Id.setText("\u8d26\u53f7:");
        Id.setFont(Id.getFont().deriveFont(Id.getFont().getSize() + 12f));
        contentPane.add(Id);
        Id.setBounds(new Rectangle(new Point(40, 50), Id.getPreferredSize()));

        //---- Password ----
        Password.setText("\u5bc6\u7801:");
        Password.setFont(Password.getFont().deriveFont(Password.getFont().getSize() + 12f));
        contentPane.add(Password);
        Password.setBounds(new Rectangle(new Point(40, 90), Password.getPreferredSize()));

        //---- PhoneNum ----
        PhoneNum.setText("\u624b\u673a\u53f7:");
        PhoneNum.setFont(PhoneNum.getFont().deriveFont(PhoneNum.getFont().getSize() + 12f));
        contentPane.add(PhoneNum);
        PhoneNum.setBounds(new Rectangle(new Point(40, 170), PhoneNum.getPreferredSize()));

        //---- PasswordAgain ----
        PasswordAgain.setText("\u518d\u6b21\u8f93\u5165:");
        PasswordAgain.setFont(PasswordAgain.getFont().deriveFont(PasswordAgain.getFont().getSize() + 12f));
        contentPane.add(PasswordAgain);
        PasswordAgain.setBounds(new Rectangle(new Point(40, 130), PasswordAgain.getPreferredSize()));

        //---- Aptitude ----
        Aptitude.setText("\u8d44\u8d28:");
        Aptitude.setFont(Aptitude.getFont().deriveFont(Aptitude.getFont().getSize() + 12f));
        contentPane.add(Aptitude);
        Aptitude.setBounds(new Rectangle(new Point(40, 210), Aptitude.getPreferredSize()));
        contentPane.add(IdInput);
        IdInput.setBounds(110, 55, 195, 25);
        contentPane.add(PhoneNumIdInput);
        PhoneNumIdInput.setBounds(130, 175, 175, 25);
        contentPane.add(PasswordInput);
        PasswordInput.setBounds(110, 95, 195, 25);
        contentPane.add(PasswordAgainInput);
        PasswordAgainInput.setBounds(155, 135, 150, 25);

        //---- IsAptitude ----
        IsAptitude.setText("\u4f18\u60e0");
        IsAptitude.setFont(IsAptitude.getFont().deriveFont(IsAptitude.getFont().getStyle() | Font.BOLD, IsAptitude.getFont().getSize() + 7f));
        contentPane.add(IsAptitude);
        IsAptitude.setBounds(new Rectangle(new Point(110, 210), IsAptitude.getPreferredSize()));

        //---- Check ----
        Check.setText("\u68c0\u67e5");
        Check.setFont(Check.getFont().deriveFont(Check.getFont().getStyle() | Font.BOLD, Check.getFont().getSize() + 10f));
        Check.setFocusPainted(false);
        Check.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                CheckMouseReleased(e);
            }
        });
        contentPane.add(Check);
        Check.setBounds(new Rectangle(new Point(195, 250), Check.getPreferredSize()));

        //---- Backward ----
        Backward.setText("\u8fd4\u56de");
        Backward.setFont(Backward.getFont().deriveFont(Backward.getFont().getStyle() | Font.BOLD, Backward.getFont().getSize() + 10f));
        Backward.setFocusPainted(false);
        Backward.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                BackwardMouseReleased(e);
            }
        });
        contentPane.add(Backward);
        Backward.setBounds(new Rectangle(new Point(60, 250), Backward.getPreferredSize()));

        contentPane.setPreferredSize(new Dimension(360, 340));
        setSize(360, 340);
        setLocationRelativeTo(getOwner());

        //======== IdExist ========
        {
            IdExist.setTitle("\u9519\u8bef\u63d0\u9192");
            IdExist.setModal(true);
            IdExist.setAlwaysOnTop(true);
            IdExist.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            var IdExistContentPane = IdExist.getContentPane();
            IdExistContentPane.setLayout(null);

            //---- tips1 ----
            tips1.setText("\u8d26\u53f7\u5df2\u5b58\u5728\uff0c\u8bf7\u91cd\u65b0\u8f93\u5165");
            tips1.setFont(tips1.getFont().deriveFont(tips1.getFont().getStyle() | Font.BOLD, tips1.getFont().getSize() + 8f));
            IdExistContentPane.add(tips1);
            tips1.setBounds(new Rectangle(new Point(45, 30), tips1.getPreferredSize()));

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < IdExistContentPane.getComponentCount(); i++) {
                    Rectangle bounds = IdExistContentPane.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = IdExistContentPane.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                IdExistContentPane.setMinimumSize(preferredSize);
                IdExistContentPane.setPreferredSize(preferredSize);
            }
            IdExist.setSize(360, 125);
            IdExist.setLocationRelativeTo(IdExist.getOwner());
        }

        //======== IdWrong ========
        {
            IdWrong.setTitle("\u9519\u8bef\u63d0\u9192");
            IdWrong.setModal(true);
            IdWrong.setAlwaysOnTop(true);
            IdWrong.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            var IdWrongContentPane = IdWrong.getContentPane();
            IdWrongContentPane.setLayout(null);

            //---- tips2 ----
            tips2.setText("\u8d26\u53f7\u683c\u5f0f\u9519\u8bef\uff0c\u8bf7\u91cd\u65b0\u8f93\u5165");
            tips2.setFont(tips2.getFont().deriveFont(tips2.getFont().getStyle() | Font.BOLD, tips2.getFont().getSize() + 8f));
            IdWrongContentPane.add(tips2);
            tips2.setBounds(new Rectangle(new Point(45, 30), tips2.getPreferredSize()));

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < IdWrongContentPane.getComponentCount(); i++) {
                    Rectangle bounds = IdWrongContentPane.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = IdWrongContentPane.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                IdWrongContentPane.setMinimumSize(preferredSize);
                IdWrongContentPane.setPreferredSize(preferredSize);
            }
            IdWrong.setSize(360, 125);
            IdWrong.setLocationRelativeTo(IdWrong.getOwner());
        }

        //======== PasswordWrong ========
        {
            PasswordWrong.setTitle("\u9519\u8bef\u63d0\u9192");
            PasswordWrong.setModal(true);
            PasswordWrong.setAlwaysOnTop(true);
            PasswordWrong.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            var PasswordWrongContentPane = PasswordWrong.getContentPane();
            PasswordWrongContentPane.setLayout(null);

            //---- tips3 ----
            tips3.setText("\u5bc6\u7801\u683c\u5f0f\u9519\u8bef\uff0c\u8bf7\u91cd\u65b0\u8f93\u5165");
            tips3.setFont(tips3.getFont().deriveFont(tips3.getFont().getStyle() | Font.BOLD, tips3.getFont().getSize() + 8f));
            PasswordWrongContentPane.add(tips3);
            tips3.setBounds(new Rectangle(new Point(45, 30), tips3.getPreferredSize()));

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
            PasswordWrong.setSize(360, 125);
            PasswordWrong.setLocationRelativeTo(PasswordWrong.getOwner());
        }

        //======== PasswordDifferent ========
        {
            PasswordDifferent.setTitle("\u9519\u8bef\u63d0\u9192");
            PasswordDifferent.setModal(true);
            PasswordDifferent.setAlwaysOnTop(true);
            PasswordDifferent.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            var PasswordDifferentContentPane = PasswordDifferent.getContentPane();
            PasswordDifferentContentPane.setLayout(null);

            //---- tips4 ----
            tips4.setText("\u524d\u540e\u5bc6\u7801\u4e0d\u4e00\u81f4\uff0c\u8bf7\u91cd\u65b0\u8f93\u5165");
            tips4.setFont(tips4.getFont().deriveFont(tips4.getFont().getStyle() | Font.BOLD, tips4.getFont().getSize() + 8f));
            PasswordDifferentContentPane.add(tips4);
            tips4.setBounds(new Rectangle(new Point(35, 30), tips4.getPreferredSize()));

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < PasswordDifferentContentPane.getComponentCount(); i++) {
                    Rectangle bounds = PasswordDifferentContentPane.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = PasswordDifferentContentPane.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                PasswordDifferentContentPane.setMinimumSize(preferredSize);
                PasswordDifferentContentPane.setPreferredSize(preferredSize);
            }
            PasswordDifferent.setSize(360, 125);
            PasswordDifferent.setLocationRelativeTo(PasswordDifferent.getOwner());
        }

        //======== PhoneNumWrong ========
        {
            PhoneNumWrong.setTitle("\u9519\u8bef\u63d0\u9192");
            PhoneNumWrong.setModal(true);
            PhoneNumWrong.setAlwaysOnTop(true);
            PhoneNumWrong.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            var PhoneNumWrongContentPane = PhoneNumWrong.getContentPane();
            PhoneNumWrongContentPane.setLayout(null);

            //---- tips5 ----
            tips5.setText("\u624b\u673a\u53f7\u683c\u5f0f\u9519\u8bef\uff0c\u8bf7\u91cd\u65b0\u8f93\u5165");
            tips5.setFont(tips5.getFont().deriveFont(tips5.getFont().getStyle() | Font.BOLD, tips5.getFont().getSize() + 8f));
            PhoneNumWrongContentPane.add(tips5);
            tips5.setBounds(new Rectangle(new Point(35, 30), tips5.getPreferredSize()));

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
            PhoneNumWrong.setSize(360, 125);
            PhoneNumWrong.setLocationRelativeTo(PhoneNumWrong.getOwner());
        }

        //======== Pass ========
        {
            Pass.setTitle("\u68c0\u6d4b\u901a\u8fc7");
            Pass.setModal(true);
            Pass.setAlwaysOnTop(true);
            Pass.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            var PassContentPane = Pass.getContentPane();
            PassContentPane.setLayout(null);

            //---- Register ----
            Register.setText("\u901a\u8fc7\u68c0\u6d4b\uff01\u6ce8\u518c");
            Register.setFont(Register.getFont().deriveFont(Register.getFont().getStyle() | Font.BOLD, Register.getFont().getSize() + 10f));
            Register.setFocusPainted(false);
            PassContentPane.add(Register);
            Register.setBounds(new Rectangle(new Point(70, 25), Register.getPreferredSize()));

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
            Pass.setSize(360, 125);
            Pass.setLocationRelativeTo(Pass.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel Id;
    private JLabel Password;
    private JLabel PhoneNum;
    private JLabel PasswordAgain;
    private JLabel Aptitude;
    private JFormattedTextField IdInput;
    private JFormattedTextField PhoneNumIdInput;
    private JPasswordField PasswordInput;
    private JPasswordField PasswordAgainInput;
    private JCheckBox IsAptitude;
    private JButton Check;
    private JButton Backward;
    private JDialog IdExist;
    private JLabel tips1;
    private JDialog IdWrong;
    private JLabel tips2;
    private JDialog PasswordWrong;
    private JLabel tips3;
    private JDialog PasswordDifferent;
    private JLabel tips4;
    private JDialog PhoneNumWrong;
    private JLabel tips5;
    private JDialog Pass;
    private JButton Register;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
