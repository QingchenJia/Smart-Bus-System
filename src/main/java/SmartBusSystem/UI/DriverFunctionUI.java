/*
 * Created by JFormDesigner on Tue Jul 09 13:46:35 CST 2024
 */

package SmartBusSystem.UI;

import javax.swing.table.*;

import SmartBusSystem.pojo.Driver;
import SmartBusSystem.service.SecurityProtect;
import SmartBusSystem.service.TableRow.WorkArrangeRow;
import SmartBusSystem.service.function.DriverHomePage;
import SmartBusSystem.service.function.DriverInformationModify;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Objects;

/**
 * @author 87948
 */
public class DriverFunctionUI extends JFrame {
    public DriverFunctionUI() {
        initComponents();
        initWorkArrange();

        this.setVisible(true);
    }

    public DriverFunctionUI(String currentDriverId) {
        this.currentDriverId = currentDriverId;
        initComponents();
        initWorkArrange();

        this.setVisible(true);
    }

    private void RefreshHomePageMouseReleased(MouseEvent e) {
        // TODO add your code here
        String Id = currentDriverId;
        this.dispose();
        new DriverFunctionUI(Id);
    }

    private void TotalViewMouseReleased(MouseEvent e) {
        // TODO add your code here
        String currentId = this.getCurrentDriverId();
        Driver driver = DriverHomePage.queryCurrentDriverInformation(currentId);
        NameText.setText(driver.getName());
        IdText.setText(driver.getID());
        PhoneNumText.setText(driver.getPhoneNum());
        DrivingYearsText.setText(String.valueOf(driver.getDrivingYears()));

        TotalViewDialog.setVisible(true);
    }

    private void InformationModifyMouseReleased(MouseEvent e) {
        // TODO add your code here
        String currentId = this.getCurrentDriverId();
        Driver driver = DriverHomePage.queryCurrentDriverInformation(currentId);
        NameInput.setText(driver.getName());
        PhoneNumInput.setText(driver.getPhoneNum());
        SelectDrivingYears.setSelectedItem(String.valueOf(driver.getDrivingYears()));

        InformationModifyDialog.setVisible(true);
    }

    private void InformationChangeMouseReleased(MouseEvent e) {
        // TODO add your code here
        String ID = currentDriverId;
        String name = NameInput.getText();

        String phoneNum = PhoneNumInput.getText();
        if (!DriverInformationModify.checkPhoneNum(phoneNum)) {
            PhoneNumWrong.setVisible(true);
            return;
        }

        int drivingYears = Integer.parseInt(Objects.requireNonNull(SelectDrivingYears.getSelectedItem()).toString());

        Driver driver = new Driver();
        driver.setID(ID);
        driver.setName(name);
        driver.setPhoneNum(phoneNum);
        driver.setDrivingYears(drivingYears);

        DriverInformationModify.updateDriverInformation(driver);

        Pass.setVisible(true);
    }

    private void PasswordChangeMouseReleased(MouseEvent e) throws Exception {
        // TODO add your code here
        String ID = currentDriverId;
        String oldPassword = new String(OldPasswordInput.getPassword());
        String newPassword = new String(NewPasswordInput.getPassword());
        String newPasswordAgain = new String(NewPasswordAgainInput.getPassword());

        if (!DriverInformationModify.oldPasswordIsRight(ID, oldPassword)) {
            OldPasswordWrong.setVisible(true);
            return;
        }
        if (!DriverInformationModify.checkPassword(newPassword)) {
            PasswordWrong.setVisible(true);
            return;
        }
        if (!newPassword.equals(newPasswordAgain)) {
            PasswordDifferent.setVisible(true);
            return;
        }

        String newPasswordResult = SecurityProtect.encrypt(newPassword);

        DriverInformationModify.updateDriverNewPassword(ID, newPasswordResult);

        Pass.setVisible(true);  // 修改密码成功后 跳出成功提示
        InformationModifyDialog.dispose();
        this.dispose(); // 关闭当前页面
        new LoginUI();  // 回到登录页面
    }

    private void LoginOutMouseReleased(MouseEvent e) {
        // TODO add your code here
        this.dispose();
        new LoginUI();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        TopMenu = new JMenuBar();
        Me = new JMenu();
        TotalView = new JMenuItem();
        InformationModify = new JMenuItem();
        LoginOut = new JMenuItem();
        ServiceMenu = new JMenu();
        RefreshHomePage = new JMenuItem();
        Title = new JLabel();
        TablePane = new JScrollPane();
        WorkArrange = new JTable();
        TotalViewDialog = new JDialog();
        Id = new JLabel();
        PhoneNum = new JLabel();
        Name = new JLabel();
        DrivingYears = new JLabel();
        NameText = new JLabel();
        IdText = new JLabel();
        PhoneNumText = new JLabel();
        DrivingYearsText = new JLabel();
        InformationModifyDialog = new JDialog();
        OldPassword = new JLabel();
        OldPhoneNum = new JLabel();
        OldName = new JLabel();
        OldDrivingYears = new JLabel();
        NewPassword = new JLabel();
        NameInput = new JTextField();
        PhoneNumInput = new JTextField();
        NewPasswordAgain = new JLabel();
        OldPasswordInput = new JPasswordField();
        NewPasswordInput = new JPasswordField();
        NewPasswordAgainInput = new JPasswordField();
        InformationChange = new JButton();
        PasswordChange = new JButton();
        SelectDrivingYears = new JComboBox<>();
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

        //======== this ========
        setTitle("\u53f8\u673a\u7aef");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
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

                //---- RefreshHomePage ----
                RefreshHomePage.setText("\u5237\u65b0\u4e3b\u9875");
                RefreshHomePage.setBorderPainted(true);
                RefreshHomePage.setIconTextGap(0);
                RefreshHomePage.setFont(RefreshHomePage.getFont().deriveFont(RefreshHomePage.getFont().getSize() + 1f));
                RefreshHomePage.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseReleased(MouseEvent e) {
                        RefreshHomePageMouseReleased(e);
                    }
                });
                ServiceMenu.add(RefreshHomePage);
            }
            TopMenu.add(ServiceMenu);
        }
        setJMenuBar(TopMenu);

        //---- Title ----
        Title.setText("\u5de5\u4f5c\u6392\u73ed\u8868");
        Title.setFont(Title.getFont().deriveFont(Title.getFont().getStyle() | Font.BOLD, Title.getFont().getSize() + 13f));
        contentPane.add(Title);
        Title.setBounds(new Rectangle(new Point(235, 20), Title.getPreferredSize()));

        //======== TablePane ========
        {

            //---- WorkArrange ----
            WorkArrange.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                    "\u65e5\u671f", "\u8f66\u8f86", "\u7ebf\u8def", "\u8fd0\u8425\u65f6\u95f4"
                }
            ));
            {
                TableColumnModel cm = WorkArrange.getColumnModel();
                cm.getColumn(0).setPreferredWidth(70);
                cm.getColumn(1).setPreferredWidth(120);
                cm.getColumn(2).setPreferredWidth(180);
                cm.getColumn(3).setPreferredWidth(175);
            }
            TablePane.setViewportView(WorkArrange);
        }
        contentPane.add(TablePane);
        TablePane.setBounds(45, 55, 545, 310);

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

            //---- DrivingYears ----
            DrivingYears.setText("\u9a7e\u9f84:");
            DrivingYears.setFont(DrivingYears.getFont().deriveFont(DrivingYears.getFont().getStyle() | Font.BOLD, DrivingYears.getFont().getSize() + 5f));
            TotalViewDialogContentPane.add(DrivingYears);
            DrivingYears.setBounds(new Rectangle(new Point(60, 105), DrivingYears.getPreferredSize()));

            //---- NameText ----
            NameText.setText("\u540d\u79f0");
            NameText.setFont(NameText.getFont().deriveFont(NameText.getFont().getSize() + 3f));
            TotalViewDialogContentPane.add(NameText);
            NameText.setBounds(105, 32, 120, NameText.getPreferredSize().height);

            //---- IdText ----
            IdText.setText("\u8d26\u53f7");
            IdText.setFont(IdText.getFont().deriveFont(IdText.getFont().getSize() + 3f));
            TotalViewDialogContentPane.add(IdText);
            IdText.setBounds(105, 57, 120, IdText.getPreferredSize().height);

            //---- PhoneNumText ----
            PhoneNumText.setText("\u624b\u673a\u53f7");
            PhoneNumText.setFont(PhoneNumText.getFont().deriveFont(PhoneNumText.getFont().getSize() + 3f));
            TotalViewDialogContentPane.add(PhoneNumText);
            PhoneNumText.setBounds(125, 82, 100, PhoneNumText.getPreferredSize().height);

            //---- DrivingYearsText ----
            DrivingYearsText.setText("\u9a7e\u9f84");
            DrivingYearsText.setFont(DrivingYearsText.getFont().deriveFont(DrivingYearsText.getFont().getSize() + 3f));
            TotalViewDialogContentPane.add(DrivingYearsText);
            DrivingYearsText.setBounds(105, 107, 55, DrivingYearsText.getPreferredSize().height);

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

            //---- OldDrivingYears ----
            OldDrivingYears.setText("\u9a7e\u9f84:");
            OldDrivingYears.setFont(OldDrivingYears.getFont().deriveFont(OldDrivingYears.getFont().getStyle() | Font.BOLD, OldDrivingYears.getFont().getSize() + 5f));
            InformationModifyDialogContentPane.add(OldDrivingYears);
            OldDrivingYears.setBounds(new Rectangle(new Point(60, 80), OldDrivingYears.getPreferredSize()));

            //---- NewPassword ----
            NewPassword.setText("\u65b0\u5bc6\u7801:");
            NewPassword.setFont(NewPassword.getFont().deriveFont(NewPassword.getFont().getStyle() | Font.BOLD, NewPassword.getFont().getSize() + 5f));
            InformationModifyDialogContentPane.add(NewPassword);
            NewPassword.setBounds(new Rectangle(new Point(60, 170), NewPassword.getPreferredSize()));
            InformationModifyDialogContentPane.add(NameInput);
            NameInput.setBounds(110, 35, 120, NameInput.getPreferredSize().height);
            InformationModifyDialogContentPane.add(PhoneNumInput);
            PhoneNumInput.setBounds(125, 60, 105, 19);

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

            //---- SelectDrivingYears ----
            SelectDrivingYears.setModel(new DefaultComboBoxModel<>(new String[] {
                "1",
                "2",
                "3",
                "4",
                "5",
                "6",
                "7",
                "8",
                "9",
                "10",
                "11",
                "12",
                "13",
                "14",
                "15",
                "16",
                "17",
                "18",
                "19",
                "20"
            }));
            InformationModifyDialogContentPane.add(SelectDrivingYears);
            SelectDrivingYears.setBounds(110, 85, 45, 20);

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
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JMenuBar TopMenu;
    private JMenu Me;
    private JMenuItem TotalView;
    private JMenuItem InformationModify;
    private JMenuItem LoginOut;
    private JMenu ServiceMenu;
    private JMenuItem RefreshHomePage;
    private JLabel Title;
    private JScrollPane TablePane;
    private JTable WorkArrange;
    private JDialog TotalViewDialog;
    private JLabel Id;
    private JLabel PhoneNum;
    private JLabel Name;
    private JLabel DrivingYears;
    private JLabel NameText;
    private JLabel IdText;
    private JLabel PhoneNumText;
    private JLabel DrivingYearsText;
    private JDialog InformationModifyDialog;
    private JLabel OldPassword;
    private JLabel OldPhoneNum;
    private JLabel OldName;
    private JLabel OldDrivingYears;
    private JLabel NewPassword;
    private JTextField NameInput;
    private JTextField PhoneNumInput;
    private JLabel NewPasswordAgain;
    private JPasswordField OldPasswordInput;
    private JPasswordField NewPasswordInput;
    private JPasswordField NewPasswordAgainInput;
    private JButton InformationChange;
    private JButton PasswordChange;
    private JComboBox<String> SelectDrivingYears;
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
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

    // 当前司机ID BEGIN
    private String currentDriverId;

    public String getCurrentDriverId() {
        return currentDriverId;
    }

    public void setCurrentDriverId(String currentDriverId) {
        this.currentDriverId = currentDriverId;
    }
    // 当前司机ID END

    // 加载工作排班情况 BEGIN
    private void initWorkArrange() {
        // 获取表格模型
        DefaultTableModel model = (DefaultTableModel) WorkArrange.getModel();

        // 添加新行数据
        List<WorkArrangeRow> ownWorkArrangeRows = DriverHomePage.getOwnWorkArrangeRow(currentDriverId);
        for (WorkArrangeRow ownWorkArrangeRow : ownWorkArrangeRows) {
            String time = ownWorkArrangeRow.getDayOfWeek();
            String busLicenseNum = ownWorkArrangeRow.getBus().getLicenseNumber();
            String routeIdAndName = "[" + ownWorkArrangeRow.getRoute().getID() + "]" + ownWorkArrangeRow.getRoute().getName();
            String workTimeInDay = ownWorkArrangeRow.getRoute().getStartTime() + "->" + ownWorkArrangeRow.getRoute().getEndTime();

            model.addRow(new Object[]{time, busLicenseNum, routeIdAndName, workTimeInDay});
        }
    }
    // 加载工作排班情况 END
}
