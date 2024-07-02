/*
 * Created by JFormDesigner on Mon Jul 01 20:22:42 CST 2024
 */

package SmartBusSystem.UI;

import SmartBusSystem.pojo.User;
import SmartBusSystem.service.function.UserFunction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author 87948
 */
public class UserFunctionUI extends JFrame {
    public UserFunctionUI() {
        initComponents();
        this.setVisible(true);
    }

    private void LoginOutMouseReleased(MouseEvent e) {
        // TODO add your code here
        this.dispose();
        new LoginUI();
    }

    private void TotalViewMouseReleased(MouseEvent e) {
        // TODO add your code here
        String currentUserId = this.getCurrentUserId();
        User currentUser = UserFunction.queryCurrentUserInformation(currentUserId);
        NameText.setText(currentUser.getName());
        IdText.setText(currentUser.getID());
        PhoneNumText.setText(currentUser.getPhoneNum());
        AptitudeText.setText(currentUser.getAptitude() == 1 ? "优惠" : "无");

        TotalViewDialog.setVisible(true);
    }

    private void InformationModifyMouseReleased(MouseEvent e) {
        // TODO add your code here
        String currentUserId = this.getCurrentUserId();
        User currentUser = UserFunction.queryCurrentUserInformation(currentUserId);
        NameInput.setText(currentUser.getName());
        PhoneNumInput.setText(currentUser.getPhoneNum());
        IsAptitude.setSelected(currentUser.getAptitude() == 1);

        InformationModifyDialog.setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        TopMenu = new JMenuBar();
        Me = new JMenu();
        TotalView = new JMenuItem();
        InformationModify = new JMenuItem();
        LoginOut = new JMenuItem();
        ServiceMenu = new JMenu();
        ReturnHomePage = new JMenuItem();
        Direction = new JMenuItem();
        StopQuery = new JMenuItem();
        RouteQuery = new JMenuItem();
        TotalViewDialog = new JDialog();
        Id = new JLabel();
        PhoneNum = new JLabel();
        Name = new JLabel();
        Aptitude = new JLabel();
        NameText = new JLabel();
        IdText = new JLabel();
        PhoneNumText = new JLabel();
        AptitudeText = new JLabel();
        InformationModifyDialog = new JDialog();
        OldPassword = new JLabel();
        OldPhoneNum = new JLabel();
        OldName = new JLabel();
        OldAptitude = new JLabel();
        NewPassword = new JLabel();
        NameInput = new JTextField();
        PhoneNumInput = new JTextField();
        IsAptitude = new JCheckBox();
        NewPasswordAgain = new JLabel();
        OldPasswordInput = new JPasswordField();
        NewPasswordInput = new JPasswordField();
        NewPasswordAgainInput = new JPasswordField();
        InformationChange = new JButton();
        PasswordChange = new JButton();
        PasswordDifferent2 = new JDialog();
        tips2 = new JLabel();
        PhoneNumWrong = new JDialog();
        tips3 = new JLabel();
        PasswordWrong = new JDialog();
        tips1 = new JLabel();
        Pass = new JDialog();
        PassMessage = new JLabel();

        //======== this ========
        setTitle("\u4e58\u5ba2\u7aef");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== TopMenu ========
        {

            //======== Me ========
            {
                Me.setText("\u5173\u4e8e\u6211");
                Me.setFont(Me.getFont().deriveFont(Me.getFont().getSize() + 4f));

                //---- TotalView ----
                TotalView.setText("\u4e2a\u4eba\u603b\u89c8");
                TotalView.setBorderPainted(true);
                TotalView.setIconTextGap(0);
                TotalView.setFont(TotalView.getFont().deriveFont(TotalView.getFont().getSize() + 1f));
                TotalView.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseReleased(MouseEvent e) {
                        TotalViewMouseReleased(e);
                    }
                });
                Me.add(TotalView);

                //---- InformationModify ----
                InformationModify.setText("\u4fe1\u606f\u4fee\u6539");
                InformationModify.setBorderPainted(true);
                InformationModify.setIconTextGap(0);
                InformationModify.setFont(InformationModify.getFont().deriveFont(InformationModify.getFont().getSize() + 1f));
                InformationModify.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseReleased(MouseEvent e) {
                        InformationModifyMouseReleased(e);
                    }
                });
                Me.add(InformationModify);

                //---- LoginOut ----
                LoginOut.setText("\u8d26\u53f7\u9000\u51fa");
                LoginOut.setBorderPainted(true);
                LoginOut.setIconTextGap(0);
                LoginOut.setFont(LoginOut.getFont().deriveFont(LoginOut.getFont().getSize() + 1f));
                LoginOut.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseReleased(MouseEvent e) {
                        LoginOutMouseReleased(e);
                    }
                });
                Me.add(LoginOut);
            }
            TopMenu.add(Me);

            //======== ServiceMenu ========
            {
                ServiceMenu.setText("\u529f\u80fd");
                ServiceMenu.setFont(ServiceMenu.getFont().deriveFont(ServiceMenu.getFont().getSize() + 4f));

                //---- ReturnHomePage ----
                ReturnHomePage.setText("\u8fd4\u56de\u4e3b\u9875");
                ReturnHomePage.setBorderPainted(true);
                ReturnHomePage.setIconTextGap(0);
                ReturnHomePage.setFont(ReturnHomePage.getFont().deriveFont(ReturnHomePage.getFont().getSize() + 1f));
                ServiceMenu.add(ReturnHomePage);

                //---- Direction ----
                Direction.setText("\u8def\u5f84\u5bfc\u822a");
                Direction.setBorderPainted(true);
                Direction.setIconTextGap(0);
                Direction.setFont(Direction.getFont().deriveFont(Direction.getFont().getSize() + 1f));
                ServiceMenu.add(Direction);

                //---- StopQuery ----
                StopQuery.setText("\u7ad9\u70b9\u67e5\u8be2");
                StopQuery.setBorderPainted(true);
                StopQuery.setIconTextGap(0);
                StopQuery.setFont(StopQuery.getFont().deriveFont(StopQuery.getFont().getSize() + 1f));
                ServiceMenu.add(StopQuery);

                //---- RouteQuery ----
                RouteQuery.setText("\u7ebf\u8def\u67e5\u8be2");
                RouteQuery.setFont(RouteQuery.getFont().deriveFont(RouteQuery.getFont().getSize() + 1f));
                RouteQuery.setIconTextGap(0);
                RouteQuery.setBorderPainted(true);
                ServiceMenu.add(RouteQuery);
            }
            TopMenu.add(ServiceMenu);
        }
        setJMenuBar(TopMenu);

        contentPane.setPreferredSize(new Dimension(640, 480));
        setSize(640, 480);
        setLocationRelativeTo(getOwner());

        //======== TotalViewDialog ========
        {
            TotalViewDialog.setTitle("\u4e2a\u4eba\u603b\u89c8");
            TotalViewDialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            TotalViewDialog.setAlwaysOnTop(true);
            TotalViewDialog.setModal(true);
            var TotalViewDialogContentPane = TotalViewDialog.getContentPane();
            TotalViewDialogContentPane.setLayout(null);

            //---- Id ----
            Id.setText("\u8d26\u53f7:");
            Id.setFont(Id.getFont().deriveFont(Id.getFont().getStyle() | Font.BOLD, Id.getFont().getSize() + 5f));
            TotalViewDialogContentPane.add(Id);
            Id.setBounds(new Rectangle(new Point(60, 55), Id.getPreferredSize()));

            //---- PhoneNum ----
            PhoneNum.setText("\u624b\u673a\u53f7:");
            PhoneNum.setFont(PhoneNum.getFont().deriveFont(PhoneNum.getFont().getStyle() | Font.BOLD, PhoneNum.getFont().getSize() + 5f));
            TotalViewDialogContentPane.add(PhoneNum);
            PhoneNum.setBounds(new Rectangle(new Point(60, 80), PhoneNum.getPreferredSize()));

            //---- Name ----
            Name.setText("\u540d\u79f0:");
            Name.setFont(Name.getFont().deriveFont(Name.getFont().getStyle() | Font.BOLD, Name.getFont().getSize() + 5f));
            TotalViewDialogContentPane.add(Name);
            Name.setBounds(new Rectangle(new Point(60, 30), Name.getPreferredSize()));

            //---- Aptitude ----
            Aptitude.setText("\u8d44\u8d28:");
            Aptitude.setFont(Aptitude.getFont().deriveFont(Aptitude.getFont().getStyle() | Font.BOLD, Aptitude.getFont().getSize() + 5f));
            TotalViewDialogContentPane.add(Aptitude);
            Aptitude.setBounds(new Rectangle(new Point(60, 105), Aptitude.getPreferredSize()));

            //---- NameText ----
            NameText.setText("\u540d\u79f0");
            NameText.setFont(NameText.getFont().deriveFont(NameText.getFont().getSize() + 2f));
            TotalViewDialogContentPane.add(NameText);
            NameText.setBounds(105, 30, 120, 20);

            //---- IdText ----
            IdText.setText("\u8d26\u53f7");
            IdText.setFont(IdText.getFont().deriveFont(IdText.getFont().getSize() + 2f));
            TotalViewDialogContentPane.add(IdText);
            IdText.setBounds(105, 55, 120, 20);

            //---- PhoneNumText ----
            PhoneNumText.setText("\u624b\u673a\u53f7");
            PhoneNumText.setFont(PhoneNumText.getFont().deriveFont(PhoneNumText.getFont().getSize() + 2f));
            TotalViewDialogContentPane.add(PhoneNumText);
            PhoneNumText.setBounds(125, 80, 100, 20);

            //---- AptitudeText ----
            AptitudeText.setText("\u8d44\u8d28");
            AptitudeText.setFont(AptitudeText.getFont().deriveFont(AptitudeText.getFont().getSize() + 2f));
            TotalViewDialogContentPane.add(AptitudeText);
            AptitudeText.setBounds(105, 105, 55, 20);

            TotalViewDialogContentPane.setPreferredSize(new Dimension(280, 240));
            TotalViewDialog.setSize(280, 240);
            TotalViewDialog.setLocationRelativeTo(TotalViewDialog.getOwner());
        }

        //======== InformationModifyDialog ========
        {
            InformationModifyDialog.setTitle("\u4fe1\u606f\u4fee\u6539");
            InformationModifyDialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            InformationModifyDialog.setAlwaysOnTop(true);
            InformationModifyDialog.setModal(true);
            var InformationModifyDialogContentPane = InformationModifyDialog.getContentPane();
            InformationModifyDialogContentPane.setLayout(null);

            //---- OldPassword ----
            OldPassword.setText("\u539f\u5bc6\u7801:");
            OldPassword.setFont(OldPassword.getFont().deriveFont(OldPassword.getFont().getStyle() | Font.BOLD, OldPassword.getFont().getSize() + 5f));
            InformationModifyDialogContentPane.add(OldPassword);
            OldPassword.setBounds(new Rectangle(new Point(60, 145), OldPassword.getPreferredSize()));

            //---- OldPhoneNum ----
            OldPhoneNum.setText("\u624b\u673a\u53f7:");
            OldPhoneNum.setFont(OldPhoneNum.getFont().deriveFont(OldPhoneNum.getFont().getStyle() | Font.BOLD, OldPhoneNum.getFont().getSize() + 5f));
            InformationModifyDialogContentPane.add(OldPhoneNum);
            OldPhoneNum.setBounds(new Rectangle(new Point(60, 55), OldPhoneNum.getPreferredSize()));

            //---- OldName ----
            OldName.setText("\u540d\u79f0:");
            OldName.setFont(OldName.getFont().deriveFont(OldName.getFont().getStyle() | Font.BOLD, OldName.getFont().getSize() + 5f));
            InformationModifyDialogContentPane.add(OldName);
            OldName.setBounds(new Rectangle(new Point(60, 30), OldName.getPreferredSize()));

            //---- OldAptitude ----
            OldAptitude.setText("\u8d44\u8d28:");
            OldAptitude.setFont(OldAptitude.getFont().deriveFont(OldAptitude.getFont().getStyle() | Font.BOLD, OldAptitude.getFont().getSize() + 5f));
            InformationModifyDialogContentPane.add(OldAptitude);
            OldAptitude.setBounds(new Rectangle(new Point(60, 80), OldAptitude.getPreferredSize()));

            //---- NewPassword ----
            NewPassword.setText("\u65b0\u5bc6\u7801:");
            NewPassword.setFont(NewPassword.getFont().deriveFont(NewPassword.getFont().getStyle() | Font.BOLD, NewPassword.getFont().getSize() + 5f));
            InformationModifyDialogContentPane.add(NewPassword);
            NewPassword.setBounds(new Rectangle(new Point(60, 170), NewPassword.getPreferredSize()));
            InformationModifyDialogContentPane.add(NameInput);
            NameInput.setBounds(110, 35, 120, NameInput.getPreferredSize().height);
            InformationModifyDialogContentPane.add(PhoneNumInput);
            PhoneNumInput.setBounds(125, 60, 105, 19);

            //---- IsAptitude ----
            IsAptitude.setText("\u4f18\u60e0");
            IsAptitude.setFont(IsAptitude.getFont().deriveFont(IsAptitude.getFont().getStyle() | Font.BOLD, IsAptitude.getFont().getSize() + 1f));
            InformationModifyDialogContentPane.add(IsAptitude);
            IsAptitude.setBounds(new Rectangle(new Point(110, 80), IsAptitude.getPreferredSize()));

            //---- NewPasswordAgain ----
            NewPasswordAgain.setText("\u786e\u8ba4:");
            NewPasswordAgain.setFont(NewPasswordAgain.getFont().deriveFont(NewPasswordAgain.getFont().getStyle() | Font.BOLD, NewPasswordAgain.getFont().getSize() + 5f));
            InformationModifyDialogContentPane.add(NewPasswordAgain);
            NewPasswordAgain.setBounds(new Rectangle(new Point(60, 195), NewPasswordAgain.getPreferredSize()));
            InformationModifyDialogContentPane.add(OldPasswordInput);
            OldPasswordInput.setBounds(125, 150, 105, OldPasswordInput.getPreferredSize().height);
            InformationModifyDialogContentPane.add(NewPasswordInput);
            NewPasswordInput.setBounds(125, 175, 105, 19);
            InformationModifyDialogContentPane.add(NewPasswordAgainInput);
            NewPasswordAgainInput.setBounds(110, 200, 120, 19);

            //---- InformationChange ----
            InformationChange.setText("\u4fdd\u5b58");
            InformationChange.setFont(InformationChange.getFont().deriveFont(InformationChange.getFont().getStyle() | Font.BOLD, InformationChange.getFont().getSize() + 1f));
            InformationChange.setFocusPainted(false);
            InformationModifyDialogContentPane.add(InformationChange);
            InformationChange.setBounds(new Rectangle(new Point(110, 110), InformationChange.getPreferredSize()));

            //---- PasswordChange ----
            PasswordChange.setText("\u4fdd\u5b58");
            PasswordChange.setFont(PasswordChange.getFont().deriveFont(PasswordChange.getFont().getStyle() | Font.BOLD, PasswordChange.getFont().getSize() + 1f));
            PasswordChange.setFocusPainted(false);
            InformationModifyDialogContentPane.add(PasswordChange);
            PasswordChange.setBounds(new Rectangle(new Point(110, 225), PasswordChange.getPreferredSize()));

            InformationModifyDialogContentPane.setPreferredSize(new Dimension(280, 300));
            InformationModifyDialog.setSize(280, 300);
            InformationModifyDialog.setLocationRelativeTo(InformationModifyDialog.getOwner());
        }

        //======== PasswordDifferent2 ========
        {
            PasswordDifferent2.setTitle("\u9519\u8bef\u63d0\u9192");
            PasswordDifferent2.setModal(true);
            PasswordDifferent2.setAlwaysOnTop(true);
            PasswordDifferent2.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            var PasswordDifferent2ContentPane = PasswordDifferent2.getContentPane();
            PasswordDifferent2ContentPane.setLayout(null);

            //---- tips2 ----
            tips2.setText("\u524d\u540e\u5bc6\u7801\u4e0d\u4e00\u81f4\uff0c\u8bf7\u91cd\u65b0\u8f93\u5165");
            tips2.setFont(tips2.getFont().deriveFont(tips2.getFont().getStyle() | Font.BOLD, tips2.getFont().getSize() + 5f));
            PasswordDifferent2ContentPane.add(tips2);
            tips2.setBounds(new Rectangle(new Point(30, 30), tips2.getPreferredSize()));

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < PasswordDifferent2ContentPane.getComponentCount(); i++) {
                    Rectangle bounds = PasswordDifferent2ContentPane.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = PasswordDifferent2ContentPane.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                PasswordDifferent2ContentPane.setMinimumSize(preferredSize);
                PasswordDifferent2ContentPane.setPreferredSize(preferredSize);
            }
            PasswordDifferent2.setSize(280, 120);
            PasswordDifferent2.setLocationRelativeTo(PasswordDifferent2.getOwner());
        }

        //======== PhoneNumWrong ========
        {
            PhoneNumWrong.setTitle("\u9519\u8bef\u63d0\u9192");
            PhoneNumWrong.setModal(true);
            PhoneNumWrong.setAlwaysOnTop(true);
            PhoneNumWrong.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            var PhoneNumWrongContentPane = PhoneNumWrong.getContentPane();
            PhoneNumWrongContentPane.setLayout(null);

            //---- tips3 ----
            tips3.setText("\u624b\u673a\u53f7\u683c\u5f0f\u9519\u8bef\uff0c\u8bf7\u91cd\u65b0\u8f93\u5165");
            tips3.setFont(tips3.getFont().deriveFont(tips3.getFont().getStyle() | Font.BOLD, tips3.getFont().getSize() + 5f));
            PhoneNumWrongContentPane.add(tips3);
            tips3.setBounds(new Rectangle(new Point(30, 30), tips3.getPreferredSize()));

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
            PhoneNumWrong.setSize(280, 120);
            PhoneNumWrong.setLocationRelativeTo(PhoneNumWrong.getOwner());
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
            tips1.setText("\u5bc6\u7801\u683c\u5f0f\u9519\u8bef\uff0c\u8bf7\u91cd\u65b0\u8f93\u5165");
            tips1.setFont(tips1.getFont().deriveFont(tips1.getFont().getStyle() | Font.BOLD, tips1.getFont().getSize() + 5f));
            PasswordWrongContentPane.add(tips1);
            tips1.setBounds(new Rectangle(new Point(30, 30), tips1.getPreferredSize()));

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
            PasswordWrong.setSize(280, 120);
            PasswordWrong.setLocationRelativeTo(PasswordWrong.getOwner());
        }

        //======== Pass ========
        {
            Pass.setTitle("\u4fdd\u5b58\u6210\u529f");
            Pass.setModal(true);
            Pass.setAlwaysOnTop(true);
            Pass.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            var PassContentPane = Pass.getContentPane();
            PassContentPane.setLayout(null);

            //---- PassMessage ----
            PassMessage.setText("\u4fdd\u5b58\u6210\u529f\uff01");
            PassMessage.setFont(PassMessage.getFont().deriveFont(PassMessage.getFont().getStyle() | Font.BOLD, PassMessage.getFont().getSize() + 6f));
            PassContentPane.add(PassMessage);
            PassMessage.setBounds(new Rectangle(new Point(30, 30), PassMessage.getPreferredSize()));

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
            Pass.setSize(155, 115);
            Pass.setLocationRelativeTo(Pass.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JMenuBar TopMenu;
    private JMenu Me;
    private JMenuItem TotalView;
    private JMenuItem InformationModify;
    private JMenuItem LoginOut;
    private JMenu ServiceMenu;
    private JMenuItem ReturnHomePage;
    private JMenuItem Direction;
    private JMenuItem StopQuery;
    private JMenuItem RouteQuery;
    private JDialog TotalViewDialog;
    private JLabel Id;
    private JLabel PhoneNum;
    private JLabel Name;
    private JLabel Aptitude;
    private JLabel NameText;
    private JLabel IdText;
    private JLabel PhoneNumText;
    private JLabel AptitudeText;
    private JDialog InformationModifyDialog;
    private JLabel OldPassword;
    private JLabel OldPhoneNum;
    private JLabel OldName;
    private JLabel OldAptitude;
    private JLabel NewPassword;
    private JTextField NameInput;
    private JTextField PhoneNumInput;
    private JCheckBox IsAptitude;
    private JLabel NewPasswordAgain;
    private JPasswordField OldPasswordInput;
    private JPasswordField NewPasswordInput;
    private JPasswordField NewPasswordAgainInput;
    private JButton InformationChange;
    private JButton PasswordChange;
    private JDialog PasswordDifferent2;
    private JLabel tips2;
    private JDialog PhoneNumWrong;
    private JLabel tips3;
    private JDialog PasswordWrong;
    private JLabel tips1;
    private JDialog Pass;
    private JLabel PassMessage;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
    private String currentUserId;

    public String getCurrentUserId() {
        return currentUserId;
    }

    public void setCurrentUserId(String currentUserId) {
        this.currentUserId = currentUserId;
    }
}
