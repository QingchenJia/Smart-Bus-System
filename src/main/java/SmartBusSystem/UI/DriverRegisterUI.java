/*
 * Created by JFormDesigner on Fri Jun 28 19:16:35 CST 2024
 */

package SmartBusSystem.UI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author 87948
 */
public class DriverRegisterUI extends JFrame {
    public DriverRegisterUI() {
        initComponents();
    }

    private void CheckMouseReleased(MouseEvent e) {
        // TODO add your code here
    }

    private void BackwardMouseReleased(MouseEvent e) {
        // TODO add your code here
    }

    private void RegisterMouseReleased(MouseEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        Id = new JLabel();
        Password = new JLabel();
        PhoneNum = new JLabel();
        PasswordAgain = new JLabel();
        DrivingYears = new JLabel();
        IdInput = new JFormattedTextField();
        PhoneNumIdInput = new JFormattedTextField();
        PasswordInput = new JPasswordField();
        PasswordAgainInput = new JPasswordField();
        Check = new JButton();
        Backward = new JButton();
        DrvingYearsInput = new JFormattedTextField();
        IdWrong = new JDialog();
        tips1 = new JLabel();
        IdExist = new JDialog();
        tips2 = new JLabel();
        PasswordWrong = new JDialog();
        tips3 = new JLabel();
        PasswordDifferent = new JDialog();
        tips4 = new JLabel();
        PhoneNumWrong = new JDialog();
        tips5 = new JLabel();
        DrivingYearsWrong = new JDialog();
        tips6 = new JLabel();
        Pass = new JDialog();
        Register = new JButton();

        //======== this ========
        setTitle("\u53f8\u673a\u6ce8\u518c");
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

        //---- DrivingYears ----
        DrivingYears.setText("\u9a7e\u9f84:");
        DrivingYears.setFont(DrivingYears.getFont().deriveFont(DrivingYears.getFont().getSize() + 12f));
        contentPane.add(DrivingYears);
        DrivingYears.setBounds(new Rectangle(new Point(40, 210), DrivingYears.getPreferredSize()));
        contentPane.add(IdInput);
        IdInput.setBounds(110, 55, 195, 25);
        contentPane.add(PhoneNumIdInput);
        PhoneNumIdInput.setBounds(130, 175, 175, 25);
        contentPane.add(PasswordInput);
        PasswordInput.setBounds(110, 95, 195, 25);
        contentPane.add(PasswordAgainInput);
        PasswordAgainInput.setBounds(155, 135, 150, 25);

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
        contentPane.add(DrvingYearsInput);
        DrvingYearsInput.setBounds(110, 210, 35, 25);

        contentPane.setPreferredSize(new Dimension(360, 340));
        setSize(360, 340);
        setLocationRelativeTo(getOwner());

        //======== IdWrong ========
        {
            IdWrong.setTitle("\u9519\u8bef\u63d0\u9192");
            IdWrong.setModal(true);
            IdWrong.setAlwaysOnTop(true);
            IdWrong.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            var IdWrongContentPane = IdWrong.getContentPane();
            IdWrongContentPane.setLayout(null);

            //---- tips1 ----
            tips1.setText("\u8d26\u53f7\u683c\u5f0f\u9519\u8bef\uff0c\u8bf7\u91cd\u65b0\u8f93\u5165");
            tips1.setFont(tips1.getFont().deriveFont(tips1.getFont().getStyle() | Font.BOLD, tips1.getFont().getSize() + 8f));
            IdWrongContentPane.add(tips1);
            tips1.setBounds(new Rectangle(new Point(45, 30), tips1.getPreferredSize()));

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

        //======== IdExist ========
        {
            IdExist.setTitle("\u9519\u8bef\u63d0\u9192");
            IdExist.setModal(true);
            IdExist.setAlwaysOnTop(true);
            IdExist.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            var IdExistContentPane = IdExist.getContentPane();
            IdExistContentPane.setLayout(null);

            //---- tips2 ----
            tips2.setText("\u8d26\u53f7\u5df2\u5b58\u5728\uff0c\u8bf7\u91cd\u65b0\u8f93\u5165");
            tips2.setFont(tips2.getFont().deriveFont(tips2.getFont().getStyle() | Font.BOLD, tips2.getFont().getSize() + 8f));
            IdExistContentPane.add(tips2);
            tips2.setBounds(new Rectangle(new Point(45, 30), tips2.getPreferredSize()));

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

        //======== DrivingYearsWrong ========
        {
            DrivingYearsWrong.setTitle("\u9519\u8bef\u63d0\u9192");
            DrivingYearsWrong.setModal(true);
            DrivingYearsWrong.setAlwaysOnTop(true);
            DrivingYearsWrong.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            var DrivingYearsWrongContentPane = DrivingYearsWrong.getContentPane();
            DrivingYearsWrongContentPane.setLayout(null);

            //---- tips6 ----
            tips6.setText("\u9a7e\u9f84\u683c\u5f0f\u9519\u8bef\uff0c\u8bf7\u91cd\u65b0\u8f93\u5165");
            tips6.setFont(tips6.getFont().deriveFont(tips6.getFont().getStyle() | Font.BOLD, tips6.getFont().getSize() + 8f));
            DrivingYearsWrongContentPane.add(tips6);
            tips6.setBounds(new Rectangle(new Point(35, 30), tips6.getPreferredSize()));

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < DrivingYearsWrongContentPane.getComponentCount(); i++) {
                    Rectangle bounds = DrivingYearsWrongContentPane.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = DrivingYearsWrongContentPane.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                DrivingYearsWrongContentPane.setMinimumSize(preferredSize);
                DrivingYearsWrongContentPane.setPreferredSize(preferredSize);
            }
            DrivingYearsWrong.setSize(360, 125);
            DrivingYearsWrong.setLocationRelativeTo(DrivingYearsWrong.getOwner());
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
            Register.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseReleased(MouseEvent e) {
                    RegisterMouseReleased(e);
                }
            });
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
    private JLabel DrivingYears;
    private JFormattedTextField IdInput;
    private JFormattedTextField PhoneNumIdInput;
    private JPasswordField PasswordInput;
    private JPasswordField PasswordAgainInput;
    private JButton Check;
    private JButton Backward;
    private JFormattedTextField DrvingYearsInput;
    private JDialog IdWrong;
    private JLabel tips1;
    private JDialog IdExist;
    private JLabel tips2;
    private JDialog PasswordWrong;
    private JLabel tips3;
    private JDialog PasswordDifferent;
    private JLabel tips4;
    private JDialog PhoneNumWrong;
    private JLabel tips5;
    private JDialog DrivingYearsWrong;
    private JLabel tips6;
    private JDialog Pass;
    private JButton Register;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
