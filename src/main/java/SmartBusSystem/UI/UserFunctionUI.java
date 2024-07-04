/*
 * Created by JFormDesigner on Mon Jul 01 20:22:42 CST 2024
 */

package SmartBusSystem.UI;

import javax.swing.table.*;

import SmartBusSystem.pojo.TableRow.RouteGuideRow;
import SmartBusSystem.pojo.User;
import SmartBusSystem.service.SecurityProtect;
import SmartBusSystem.service.function.UserHomePage;
import SmartBusSystem.service.function.UserInformationModify;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

/**
 * @author 87948
 */
public class UserFunctionUI extends JFrame {
    public UserFunctionUI() {
        initComponents();
        initRouteGuide();
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
        User currentUser = UserHomePage.queryCurrentUserInformation(currentUserId);
        NameText.setText(currentUser.getName());
        IdText.setText(currentUser.getID());
        PhoneNumText.setText(currentUser.getPhoneNum());
        AptitudeText.setText(currentUser.getAptitude() == 1 ? "优惠" : "无");

        TotalViewDialog.setVisible(true);
    }

    private void InformationModifyMouseReleased(MouseEvent e) {
        // TODO add your code here
        String currentUserId = this.getCurrentUserId();
        User currentUser = UserHomePage.queryCurrentUserInformation(currentUserId);
        NameInput.setText(currentUser.getName());
        PhoneNumInput.setText(currentUser.getPhoneNum());
        IsAptitude.setSelected(currentUser.getAptitude() == 1);

        InformationModifyDialog.setVisible(true);
    }

    private void InformationChangeMouseReleased(MouseEvent e) {
        // TODO add your code here
        String ID = currentUserId;
        String name = NameInput.getText();

        String phoneNum = PhoneNumInput.getText();
        if (!UserInformationModify.checkPhoneNum(phoneNum)) {
            PhoneNumWrong.setVisible(true);
            return;
        }

        int aptitude = IsAptitude.isSelected() ? 1 : 0;

        User user = new User();
        user.setID(ID);
        user.setName(name);
        user.setPhoneNum(phoneNum);
        user.setAptitude(aptitude);

        UserInformationModify.updateUserInformation(user);

        Pass.setVisible(true);
    }

    private void PasswordChangeMouseReleased(MouseEvent e) throws Exception {
        // TODO add your code here
        String ID = currentUserId;
        String oldPassword = new String(OldPasswordInput.getPassword());
        String newPassword = new String(NewPasswordInput.getPassword());
        String newPasswordAgain = new String(NewPasswordAgainInput.getPassword());

        if (!UserInformationModify.oldPasswordIsRight(ID, oldPassword)) {
            OldPasswordWrong.setVisible(true);
            return;
        }
        if (!UserInformationModify.checkPassword(newPassword)) {
            PasswordWrong.setVisible(true);
            return;
        }
        if (!newPassword.equals(newPasswordAgain)) {
            PasswordDifferent.setVisible(true);
            return;
        }

        String newPasswordResult = SecurityProtect.encrypt(newPassword);

        UserInformationModify.updateUserNewPassword(ID, newPasswordResult);

        Pass.setVisible(true);  // 修改密码成功后 跳出成功提示
        InformationModifyDialog.dispose();
        this.dispose(); // 关闭当前页面
        new LoginUI();  // 回到登录页面
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
        Title = new JLabel();
        TablePane = new JScrollPane();
        RouteGuide = new JTable();
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
        PasswordDifferent = new JDialog();
        tips2 = new JLabel();
        PhoneNumWrong = new JDialog();
        tips3 = new JLabel();
        PasswordWrong = new JDialog();
        tips1 = new JLabel();
        Pass = new JDialog();
        PassMessage = new JLabel();
        OldPasswordWrong = new JDialog();
        tips4 = new JLabel();
        StopQueryDialog = new JDialog();
        StopName = new JLabel();
        StopNameInput = new JTextField();
        StopListPane = new JScrollPane();
        StopNameList = new JList();
        SearchStop = new JButton();

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

        //---- Title ----
        Title.setText("\u516c\u4ea4\u7ebf\u8def\u6307\u5357");
        Title.setFont(Title.getFont().deriveFont(Title.getFont().getStyle() | Font.BOLD, Title.getFont().getSize() + 13f));
        contentPane.add(Title);
        Title.setBounds(new Rectangle(new Point(235, 20), Title.getPreferredSize()));

        //======== TablePane ========
        {

            //---- RouteGuide ----
            RouteGuide.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                    "\u7ebf\u8def", "\u540d\u79f0", "\u7ad9\u70b9\u987a\u5e8f"
                }
            ) {
                boolean[] columnEditable = new boolean[] {
                    false, false, false
                };
                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return columnEditable[columnIndex];
                }
            });
            {
                TableColumnModel cm = RouteGuide.getColumnModel();
                cm.getColumn(0).setPreferredWidth(35);
                cm.getColumn(1).setPreferredWidth(135);
                cm.getColumn(2).setPreferredWidth(420);
            }
            TablePane.setViewportView(RouteGuide);
        }
        contentPane.add(TablePane);
        TablePane.setBounds(20, 55, 590, 320);

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
            InformationChange.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseReleased(MouseEvent e) {
                    InformationChangeMouseReleased(e);
                }
            });
            InformationModifyDialogContentPane.add(InformationChange);
            InformationChange.setBounds(new Rectangle(new Point(110, 110), InformationChange.getPreferredSize()));

            //---- PasswordChange ----
            PasswordChange.setText("\u4fdd\u5b58");
            PasswordChange.setFont(PasswordChange.getFont().deriveFont(PasswordChange.getFont().getStyle() | Font.BOLD, PasswordChange.getFont().getSize() + 1f));
            PasswordChange.setFocusPainted(false);
            PasswordChange.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseReleased(MouseEvent e) {
                    try {
PasswordChangeMouseReleased(e);} catch (Exception ex) {
    throw new RuntimeException(ex);
}
                }
            });
            InformationModifyDialogContentPane.add(PasswordChange);
            PasswordChange.setBounds(new Rectangle(new Point(110, 225), PasswordChange.getPreferredSize()));

            InformationModifyDialogContentPane.setPreferredSize(new Dimension(280, 300));
            InformationModifyDialog.setSize(280, 300);
            InformationModifyDialog.setLocationRelativeTo(InformationModifyDialog.getOwner());
        }

        //======== PasswordDifferent ========
        {
            PasswordDifferent.setTitle("\u9519\u8bef\u63d0\u9192");
            PasswordDifferent.setModal(true);
            PasswordDifferent.setAlwaysOnTop(true);
            PasswordDifferent.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            var PasswordDifferentContentPane = PasswordDifferent.getContentPane();
            PasswordDifferentContentPane.setLayout(null);

            //---- tips2 ----
            tips2.setText("\u524d\u540e\u5bc6\u7801\u4e0d\u4e00\u81f4\uff0c\u8bf7\u91cd\u65b0\u8f93\u5165");
            tips2.setFont(tips2.getFont().deriveFont(tips2.getFont().getStyle() | Font.BOLD, tips2.getFont().getSize() + 5f));
            PasswordDifferentContentPane.add(tips2);
            tips2.setBounds(new Rectangle(new Point(30, 30), tips2.getPreferredSize()));

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
            PasswordDifferent.setSize(280, 120);
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

        //======== OldPasswordWrong ========
        {
            OldPasswordWrong.setTitle("\u9519\u8bef\u63d0\u9192");
            OldPasswordWrong.setModal(true);
            OldPasswordWrong.setAlwaysOnTop(true);
            OldPasswordWrong.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            var OldPasswordWrongContentPane = OldPasswordWrong.getContentPane();
            OldPasswordWrongContentPane.setLayout(null);

            //---- tips4 ----
            tips4.setText("\u5bc6\u7801\u9519\u8bef\uff0c\u8bf7\u91cd\u65b0\u8f93\u5165");
            tips4.setFont(tips4.getFont().deriveFont(tips4.getFont().getStyle() | Font.BOLD, tips4.getFont().getSize() + 5f));
            OldPasswordWrongContentPane.add(tips4);
            tips4.setBounds(new Rectangle(new Point(30, 30), tips4.getPreferredSize()));

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < OldPasswordWrongContentPane.getComponentCount(); i++) {
                    Rectangle bounds = OldPasswordWrongContentPane.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = OldPasswordWrongContentPane.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                OldPasswordWrongContentPane.setMinimumSize(preferredSize);
                OldPasswordWrongContentPane.setPreferredSize(preferredSize);
            }
            OldPasswordWrong.setSize(280, 120);
            OldPasswordWrong.setLocationRelativeTo(OldPasswordWrong.getOwner());
        }

        //======== StopQueryDialog ========
        {
            StopQueryDialog.setTitle("\u7ad9\u70b9\u67e5\u8be2");
            StopQueryDialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            StopQueryDialog.setAlwaysOnTop(true);
            StopQueryDialog.setModal(true);
            StopQueryDialog.setFocusable(false);
            StopQueryDialog.setFocusableWindowState(false);
            var StopQueryDialogContentPane = StopQueryDialog.getContentPane();
            StopQueryDialogContentPane.setLayout(null);

            //---- StopName ----
            StopName.setText("\u7ad9\u70b9\u540d\u79f0:");
            StopName.setFont(StopName.getFont().deriveFont(StopName.getFont().getStyle() | Font.BOLD, StopName.getFont().getSize() + 5f));
            StopQueryDialogContentPane.add(StopName);
            StopName.setBounds(new Rectangle(new Point(40, 30), StopName.getPreferredSize()));
            StopQueryDialogContentPane.add(StopNameInput);
            StopNameInput.setBounds(130, 35, 135, StopNameInput.getPreferredSize().height);

            //======== StopListPane ========
            {
                StopListPane.setViewportView(StopNameList);
            }
            StopQueryDialogContentPane.add(StopListPane);
            StopListPane.setBounds(130, 65, 135, 80);

            //---- SearchStop ----
            SearchStop.setText("\u641c\u7d22");
            SearchStop.setFont(SearchStop.getFont().deriveFont(SearchStop.getFont().getStyle() | Font.BOLD, SearchStop.getFont().getSize() + 1f));
            SearchStop.setFocusPainted(false);
            StopQueryDialogContentPane.add(SearchStop);
            SearchStop.setBounds(new Rectangle(new Point(120, 165), SearchStop.getPreferredSize()));

            StopQueryDialogContentPane.setPreferredSize(new Dimension(330, 240));
            StopQueryDialog.setSize(330, 240);
            StopQueryDialog.setLocationRelativeTo(StopQueryDialog.getOwner());
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
    private JLabel Title;
    private JScrollPane TablePane;
    private JTable RouteGuide;
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
    private JDialog PasswordDifferent;
    private JLabel tips2;
    private JDialog PhoneNumWrong;
    private JLabel tips3;
    private JDialog PasswordWrong;
    private JLabel tips1;
    private JDialog Pass;
    private JLabel PassMessage;
    private JDialog OldPasswordWrong;
    private JLabel tips4;
    private JDialog StopQueryDialog;
    private JLabel StopName;
    private JTextField StopNameInput;
    private JScrollPane StopListPane;
    private JList StopNameList;
    private JButton SearchStop;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
    private String currentUserId;

    public String getCurrentUserId() {
        return currentUserId;
    }

    public void setCurrentUserId(String currentUserId) {
        this.currentUserId = currentUserId;
    }

    private void initRouteGuide() {
        // 获取表格模型
        DefaultTableModel model = (DefaultTableModel) RouteGuide.getModel();

        // 添加新行数据
        List<RouteGuideRow> allRouteGuideRow = UserHomePage.getAllRouteGuideRow();
        for (RouteGuideRow routeGuideRow : allRouteGuideRow) {
            String routeId = routeGuideRow.getRouteId();
            String routeName = routeGuideRow.getRouteName();
            String stopNameResult = routeGuideRow.getStopNameResult();

            model.addRow(new Object[]{routeId, routeName, stopNameResult});
        }
    }
}
