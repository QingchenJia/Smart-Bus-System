package SmartBusSystem.UI.JFD;

import SmartBusSystem.UI.GenerateExcel;
import SmartBusSystem.Util.CipherUtil;
import SmartBusSystem.pojo.User;
import SmartBusSystem.pojo.mediator.RouteGuideRow;
import SmartBusSystem.service.homepage.UserHomePage;
import SmartBusSystem.service.info.UserInfoMdf;
import SmartBusSystem.service.navigation.NavigationSystem;
import SmartBusSystem.service.query.RouteQuery;
import SmartBusSystem.service.query.StopQuery;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Time;
import java.util.List;
import java.util.Objects;

public class UserFunctionUI extends GenerateExcel {
    private static final UserHomePage userHomePage = new UserHomePage();
    private static final UserInfoMdf userInfoMdf = new UserInfoMdf();
    private static final StopQuery stopQuery = new StopQuery();
    private static final RouteQuery routeQuery = new RouteQuery();

    public UserFunctionUI() {
        initComponents();
        initRouteGuide();
        initStopQueryDialog();
        initNavigationDialog();

        this.setVisible(true);
    }

    private void LoginOutMouseReleased(MouseEvent e) {
        this.dispose();
        new LoginUI();
    }

    private void TotalViewMouseReleased(MouseEvent e) {
        String currentUserId = this.getCurrentUserId();
        User currentUser = userHomePage.queryCurrentUserInformation(currentUserId);
        NameText.setText(currentUser.getName());
        IdText.setText(currentUser.getID());
        PhoneNumText.setText(currentUser.getPhoneNum());
        AptitudeText.setText(currentUser.getAptitude() == 1 ? "优惠" : "无");

        showInCenterOfFrame(TotalViewDialog);
    }

    private void InformationModifyMouseReleased(MouseEvent e) {
        String currentUserId = this.getCurrentUserId();
        User currentUser = userHomePage.queryCurrentUserInformation(currentUserId);
        NameInput.setText(currentUser.getName());
        PhoneNumInput.setText(currentUser.getPhoneNum());
        IsAptitude.setSelected(currentUser.getAptitude() == 1);

        showInCenterOfFrame(InformationModifyDialog);
    }

    private void InformationChangeMouseReleased(MouseEvent e) {
        String ID = currentUserId;
        String name = NameInput.getText();

        String phoneNum = PhoneNumInput.getText();
        if (!userInfoMdf.checkPhoneNum(phoneNum)) {
            showInCenterOfFrame(PhoneNumWrong);
            return;
        }

        int aptitude = IsAptitude.isSelected() ? 1 : 0;

        User user = new User();
        user.setID(ID);
        user.setName(name);
        user.setPhoneNum(phoneNum);
        user.setAptitude(aptitude);

        userInfoMdf.updateUserInformation(user);

        showInCenterOfFrame(Pass);
    }

    private void PasswordChangeMouseReleased(MouseEvent e) {
        String ID = currentUserId;
        String oldPassword = new String(OldPasswordInput.getPassword());
        String newPassword = new String(NewPasswordInput.getPassword());
        String newPasswordAgain = new String(NewPasswordAgainInput.getPassword());

        try {
            if (!userInfoMdf.oldPasswordIsRight(ID, oldPassword)) {
                showInCenterOfFrame(OldPasswordWrong);
                return;
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        if (!userInfoMdf.checkPassword(newPassword)) {
            showInCenterOfFrame(PasswordWrong);
            return;
        }
        if (!newPassword.equals(newPasswordAgain)) {
            showInCenterOfFrame(PasswordDifferent);
            return;
        }

        String newPasswordResult = null;
        try {
            newPasswordResult = CipherUtil.encrypt(newPassword);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

        userInfoMdf.updateUserNewPassword(ID, newPasswordResult);

        showInCenterOfFrame(Pass);  // 修改密码成功后 跳出成功提示
        InformationModifyDialog.dispose();
        this.dispose(); // 关闭当前页面
        new LoginUI();  // 回到登录页面
    }

    private void StopQueryMouseReleased(MouseEvent e) {
        showAllStopNameInList(stopQueryListModel);
        showInCenterOfFrame(StopQueryDialog);
    }

    private void SearchStopMouseReleased(MouseEvent e) {
        if (initStopSearchResult()) {
            showInCenterOfFrame(StopSearchResult);
        }
    }

    private void RouteQueryMouseReleased(MouseEvent e) {
        showAllRouteIdInBox();
        showInCenterOfFrame(RouteQueryDialog);
    }

    private void SearchRouteMouseReleased(MouseEvent e) {
        initRouteSearchResult();
        showInCenterOfFrame(RouteSearchResult);
    }

    private void DirectionMouseReleased(MouseEvent e) {
        showAllStopNameInList(startStopQueryListModel);
        showAllStopNameInList(endStopQueryListModel);
        showInCenterOfFrame(NavigationGuideDialog);
    }

    private void NavigationButtonMouseReleased(MouseEvent e) {
        if (initNavigationGuideResult()) {
            showInCenterOfFrame(NavigationGuideResult);
        }
    }

    private void RefreshHomePageMouseReleased(MouseEvent e) {
        String Id = currentUserId;
        this.dispose();
        new UserFunctionUI().setCurrentUserId(Id);
    }

    private void ExportToExcelMouseReleased(MouseEvent e) {
        ExportTable(RouteGuide, "公交线路指南", ExportSuccess, ExportFail);
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
        Direction = new JMenuItem();
        StopQuery = new JMenuItem();
        RouteQuery = new JMenuItem();
        Title = new JLabel();
        TablePane = new JScrollPane();
        RouteGuide = new JTable();
        ExportToExcel = new JLabel();
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
        StopSearchResult = new JDialog();
        StopResultName = new JLabel();
        StopResultNameText = new JLabel();
        PassRoute = new JLabel();
        PassRouteListPane = new JScrollPane();
        PassRouteList = new JList();
        RouteQueryDialog = new JDialog();
        QueryStopName = new JLabel();
        SelectRouteId = new JComboBox();
        SearchRoute = new JButton();
        RouteSearchResult = new JDialog();
        RouteResultName = new JLabel();
        RouteResultNameText = new JLabel();
        PassStop = new JLabel();
        PassStopListPane = new JScrollPane();
        PassStopList = new JList();
        WorkTime = new JLabel();
        WorkTimeText = new JLabel();
        NavigationGuideDialog = new JDialog();
        StartStop = new JLabel();
        StartStopNameInput = new JTextField();
        StartStopListPane = new JScrollPane();
        StartStopNameList = new JList();
        NavigationButton = new JButton();
        EndStop = new JLabel();
        EndStopNameInput = new JTextField();
        EndStopPane = new JScrollPane();
        EndStopNameList = new JList();
        NavigationGuideResult = new JDialog();
        NavigationGuideTitle = new JLabel();
        NavigationGuidePane = new JScrollPane();
        NavigationGuideList = new JList();
        ExportSuccess = new JDialog();
        esm = new JLabel();
        ExportFail = new JDialog();
        efm = new JLabel();

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

                //---- Direction ----
                Direction.setText("\u8def\u5f84\u5bfc\u822a");
                Direction.setBorderPainted(true);
                Direction.setIconTextGap(0);
                Direction.setFont(Direction.getFont().deriveFont(Direction.getFont().getSize() + 1f));
                Direction.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseReleased(MouseEvent e) {
                        DirectionMouseReleased(e);
                    }
                });
                ServiceMenu.add(Direction);

                //---- StopQuery ----
                StopQuery.setText("\u7ad9\u70b9\u67e5\u8be2");
                StopQuery.setBorderPainted(true);
                StopQuery.setIconTextGap(0);
                StopQuery.setFont(StopQuery.getFont().deriveFont(StopQuery.getFont().getSize() + 1f));
                StopQuery.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseReleased(MouseEvent e) {
                        StopQueryMouseReleased(e);
                    }
                });
                ServiceMenu.add(StopQuery);

                //---- RouteQuery ----
                RouteQuery.setText("\u7ebf\u8def\u67e5\u8be2");
                RouteQuery.setFont(RouteQuery.getFont().deriveFont(RouteQuery.getFont().getSize() + 1f));
                RouteQuery.setIconTextGap(0);
                RouteQuery.setBorderPainted(true);
                RouteQuery.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseReleased(MouseEvent e) {
                        RouteQueryMouseReleased(e);
                    }
                });
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
            RouteGuide.setRowHeight(25);
            TablePane.setViewportView(RouteGuide);
        }
        contentPane.add(TablePane);
        TablePane.setBounds(20, 55, 590, 320);

        //---- ExportToExcel ----
        ExportToExcel.setText("\u5bfc\u51fa");
        ExportToExcel.setFont(ExportToExcel.getFont().deriveFont(Font.BOLD|Font.ITALIC));
        ExportToExcel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                ExportToExcelMouseReleased(e);
            }
        });
        contentPane.add(ExportToExcel);
        ExportToExcel.setBounds(new Rectangle(new Point(585, 30), ExportToExcel.getPreferredSize()));

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

            //---- AptitudeText ----
            AptitudeText.setText("\u8d44\u8d28");
            AptitudeText.setFont(AptitudeText.getFont().deriveFont(AptitudeText.getFont().getSize() + 3f));
            TotalViewDialogContentPane.add(AptitudeText);
            AptitudeText.setBounds(105, 107, 55, AptitudeText.getPreferredSize().height);

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
                    PasswordChangeMouseReleased(e);
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
            var StopQueryDialogContentPane = StopQueryDialog.getContentPane();
            StopQueryDialogContentPane.setLayout(null);

            //---- StopName ----
            StopName.setText("\u7ad9\u70b9\u540d\u79f0:");
            StopName.setFont(StopName.getFont().deriveFont(StopName.getFont().getStyle() | Font.BOLD, StopName.getFont().getSize() + 5f));
            StopQueryDialogContentPane.add(StopName);
            StopName.setBounds(new Rectangle(new Point(40, 30), StopName.getPreferredSize()));

            //---- StopNameInput ----
            StopNameInput.setBackground(Color.white);
            StopQueryDialogContentPane.add(StopNameInput);
            StopNameInput.setBounds(130, 35, 135, StopNameInput.getPreferredSize().height);

            //======== StopListPane ========
            {

                //---- StopNameList ----
                StopNameList.setVisibleRowCount(5);
                StopListPane.setViewportView(StopNameList);
            }
            StopQueryDialogContentPane.add(StopListPane);
            StopListPane.setBounds(130, 65, 135, 80);

            //---- SearchStop ----
            SearchStop.setText("\u641c\u7d22");
            SearchStop.setFont(SearchStop.getFont().deriveFont(SearchStop.getFont().getStyle() | Font.BOLD, SearchStop.getFont().getSize() + 1f));
            SearchStop.setFocusPainted(false);
            SearchStop.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseReleased(MouseEvent e) {
                    SearchStopMouseReleased(e);
                }
            });
            StopQueryDialogContentPane.add(SearchStop);
            SearchStop.setBounds(new Rectangle(new Point(120, 165), SearchStop.getPreferredSize()));

            StopQueryDialogContentPane.setPreferredSize(new Dimension(330, 240));
            StopQueryDialog.setSize(330, 240);
            StopQueryDialog.setLocationRelativeTo(StopQueryDialog.getOwner());
        }

        //======== StopSearchResult ========
        {
            StopSearchResult.setTitle("\u7ad9\u70b9\u4fe1\u606f");
            StopSearchResult.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            StopSearchResult.setAlwaysOnTop(true);
            StopSearchResult.setModal(true);
            var StopSearchResultContentPane = StopSearchResult.getContentPane();
            StopSearchResultContentPane.setLayout(null);

            //---- StopResultName ----
            StopResultName.setText("\u540d\u79f0:");
            StopResultName.setFont(StopResultName.getFont().deriveFont(StopResultName.getFont().getStyle() | Font.BOLD, StopResultName.getFont().getSize() + 5f));
            StopSearchResultContentPane.add(StopResultName);
            StopResultName.setBounds(new Rectangle(new Point(60, 30), StopResultName.getPreferredSize()));

            //---- StopResultNameText ----
            StopResultNameText.setText("\u540d\u79f0");
            StopResultNameText.setFont(StopResultNameText.getFont().deriveFont(StopResultNameText.getFont().getSize() + 4f));
            StopSearchResultContentPane.add(StopResultNameText);
            StopResultNameText.setBounds(105, 30, 120, StopResultNameText.getPreferredSize().height);

            //---- PassRoute ----
            PassRoute.setText("\u7ecf\u884c\u7ebf\u8def:");
            PassRoute.setFont(PassRoute.getFont().deriveFont(PassRoute.getFont().getStyle() | Font.BOLD, PassRoute.getFont().getSize() + 5f));
            StopSearchResultContentPane.add(PassRoute);
            PassRoute.setBounds(new Rectangle(new Point(60, 60), PassRoute.getPreferredSize()));

            //======== PassRouteListPane ========
            {

                //---- PassRouteList ----
                PassRouteList.setVisibleRowCount(3);
                PassRouteListPane.setViewportView(PassRouteList);
            }
            StopSearchResultContentPane.add(PassRouteListPane);
            PassRouteListPane.setBounds(60, 90, 160, 65);

            StopSearchResultContentPane.setPreferredSize(new Dimension(280, 240));
            StopSearchResult.setSize(280, 240);
            StopSearchResult.setLocationRelativeTo(StopSearchResult.getOwner());
        }

        //======== RouteQueryDialog ========
        {
            RouteQueryDialog.setTitle("\u7ebf\u8def\u67e5\u8be2");
            RouteQueryDialog.setAlwaysOnTop(true);
            RouteQueryDialog.setModal(true);
            RouteQueryDialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            var RouteQueryDialogContentPane = RouteQueryDialog.getContentPane();
            RouteQueryDialogContentPane.setLayout(null);

            //---- QueryStopName ----
            QueryStopName.setText("\u7ebf\u8def\u540d\u79f0:");
            QueryStopName.setFont(QueryStopName.getFont().deriveFont(QueryStopName.getFont().getStyle() | Font.BOLD, QueryStopName.getFont().getSize() + 5f));
            RouteQueryDialogContentPane.add(QueryStopName);
            QueryStopName.setBounds(new Rectangle(new Point(40, 30), QueryStopName.getPreferredSize()));
            RouteQueryDialogContentPane.add(SelectRouteId);
            SelectRouteId.setBounds(125, 30, 90, SelectRouteId.getPreferredSize().height);

            //---- SearchRoute ----
            SearchRoute.setText("\u641c\u7d22");
            SearchRoute.setFont(SearchRoute.getFont().deriveFont(SearchRoute.getFont().getStyle() | Font.BOLD, SearchRoute.getFont().getSize() + 1f));
            SearchRoute.setFocusPainted(false);
            SearchRoute.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseReleased(MouseEvent e) {
                    SearchRouteMouseReleased(e);
                }
            });
            RouteQueryDialogContentPane.add(SearchRoute);
            SearchRoute.setBounds(new Rectangle(new Point(80, 75), SearchRoute.getPreferredSize()));

            RouteQueryDialogContentPane.setPreferredSize(new Dimension(235, 150));
            RouteQueryDialog.pack();
            RouteQueryDialog.setLocationRelativeTo(RouteQueryDialog.getOwner());
        }

        //======== RouteSearchResult ========
        {
            RouteSearchResult.setTitle("\u7ebf\u8def\u4fe1\u606f");
            RouteSearchResult.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            RouteSearchResult.setAlwaysOnTop(true);
            RouteSearchResult.setModal(true);
            var RouteSearchResultContentPane = RouteSearchResult.getContentPane();
            RouteSearchResultContentPane.setLayout(null);

            //---- RouteResultName ----
            RouteResultName.setText("\u540d\u79f0:");
            RouteResultName.setFont(RouteResultName.getFont().deriveFont(RouteResultName.getFont().getStyle() | Font.BOLD, RouteResultName.getFont().getSize() + 5f));
            RouteSearchResultContentPane.add(RouteResultName);
            RouteResultName.setBounds(new Rectangle(new Point(60, 30), RouteResultName.getPreferredSize()));

            //---- RouteResultNameText ----
            RouteResultNameText.setText("\u540d\u79f0");
            RouteResultNameText.setFont(RouteResultNameText.getFont().deriveFont(RouteResultNameText.getFont().getSize() + 4f));
            RouteSearchResultContentPane.add(RouteResultNameText);
            RouteResultNameText.setBounds(105, 30, 200, RouteResultNameText.getPreferredSize().height);

            //---- PassStop ----
            PassStop.setText("\u9014\u5f84\u7ad9\u70b9:");
            PassStop.setFont(PassStop.getFont().deriveFont(PassStop.getFont().getStyle() | Font.BOLD, PassStop.getFont().getSize() + 5f));
            RouteSearchResultContentPane.add(PassStop);
            PassStop.setBounds(new Rectangle(new Point(60, 90), PassStop.getPreferredSize()));

            //======== PassStopListPane ========
            {

                //---- PassStopList ----
                PassStopList.setVisibleRowCount(5);
                PassStopList.setFont(PassStopList.getFont().deriveFont(PassStopList.getFont().getStyle() & ~Font.BOLD, PassStopList.getFont().getSize() + 3f));
                PassStopListPane.setViewportView(PassStopList);
            }
            RouteSearchResultContentPane.add(PassStopListPane);
            PassStopListPane.setBounds(60, 120, 230, 90);

            //---- WorkTime ----
            WorkTime.setText("\u8fd0\u8425\u65f6\u95f4:");
            WorkTime.setFont(WorkTime.getFont().deriveFont(WorkTime.getFont().getStyle() | Font.BOLD, WorkTime.getFont().getSize() + 5f));
            RouteSearchResultContentPane.add(WorkTime);
            WorkTime.setBounds(new Rectangle(new Point(60, 60), WorkTime.getPreferredSize()));

            //---- WorkTimeText ----
            WorkTimeText.setText("\u8fd0\u8425\u65f6\u95f4");
            WorkTimeText.setFont(WorkTimeText.getFont().deriveFont(WorkTimeText.getFont().getSize() + 4f));
            RouteSearchResultContentPane.add(WorkTimeText);
            WorkTimeText.setBounds(140, 60, 205, 17);

            RouteSearchResultContentPane.setPreferredSize(new Dimension(355, 275));
            RouteSearchResult.setSize(355, 275);
            RouteSearchResult.setLocationRelativeTo(RouteSearchResult.getOwner());
        }

        //======== NavigationGuideDialog ========
        {
            NavigationGuideDialog.setTitle("\u5bfc\u822a\u6307\u5357");
            NavigationGuideDialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            NavigationGuideDialog.setAlwaysOnTop(true);
            NavigationGuideDialog.setModal(true);
            var NavigationGuideDialogContentPane = NavigationGuideDialog.getContentPane();
            NavigationGuideDialogContentPane.setLayout(null);

            //---- StartStop ----
            StartStop.setText("\u8d77\u70b9:");
            StartStop.setFont(StartStop.getFont().deriveFont(StartStop.getFont().getStyle() | Font.BOLD, StartStop.getFont().getSize() + 5f));
            NavigationGuideDialogContentPane.add(StartStop);
            StartStop.setBounds(new Rectangle(new Point(25, 30), StartStop.getPreferredSize()));

            //---- StartStopNameInput ----
            StartStopNameInput.setBackground(Color.white);
            NavigationGuideDialogContentPane.add(StartStopNameInput);
            StartStopNameInput.setBounds(75, 35, 115, StartStopNameInput.getPreferredSize().height);

            //======== StartStopListPane ========
            {

                //---- StartStopNameList ----
                StartStopNameList.setVisibleRowCount(5);
                StartStopListPane.setViewportView(StartStopNameList);
            }
            NavigationGuideDialogContentPane.add(StartStopListPane);
            StartStopListPane.setBounds(75, 65, 115, 80);

            //---- NavigationButton ----
            NavigationButton.setText("\u5bfc\u822a");
            NavigationButton.setFont(NavigationButton.getFont().deriveFont(NavigationButton.getFont().getStyle() | Font.BOLD, NavigationButton.getFont().getSize() + 3f));
            NavigationButton.setFocusPainted(false);
            NavigationButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseReleased(MouseEvent e) {
                    NavigationButtonMouseReleased(e);
                }
            });
            NavigationGuideDialogContentPane.add(NavigationButton);
            NavigationButton.setBounds(new Rectangle(new Point(160, 165), NavigationButton.getPreferredSize()));

            //---- EndStop ----
            EndStop.setText("\u7ec8\u70b9:");
            EndStop.setFont(EndStop.getFont().deriveFont(EndStop.getFont().getStyle() | Font.BOLD, EndStop.getFont().getSize() + 5f));
            NavigationGuideDialogContentPane.add(EndStop);
            EndStop.setBounds(200, 30, 45, 18);

            //---- EndStopNameInput ----
            EndStopNameInput.setBackground(Color.white);
            NavigationGuideDialogContentPane.add(EndStopNameInput);
            EndStopNameInput.setBounds(250, 35, 115, EndStopNameInput.getPreferredSize().height);

            //======== EndStopPane ========
            {
                EndStopPane.setViewportView(EndStopNameList);
            }
            NavigationGuideDialogContentPane.add(EndStopPane);
            EndStopPane.setBounds(250, 65, 115, 80);

            NavigationGuideDialogContentPane.setPreferredSize(new Dimension(405, 240));
            NavigationGuideDialog.setSize(405, 240);
            NavigationGuideDialog.setLocationRelativeTo(NavigationGuideDialog.getOwner());
        }

        //======== NavigationGuideResult ========
        {
            NavigationGuideResult.setTitle("\u7ebf\u8def\u4fe1\u606f");
            NavigationGuideResult.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            NavigationGuideResult.setAlwaysOnTop(true);
            NavigationGuideResult.setModal(true);
            var NavigationGuideResultContentPane = NavigationGuideResult.getContentPane();
            NavigationGuideResultContentPane.setLayout(null);

            //---- NavigationGuideTitle ----
            NavigationGuideTitle.setText("Title");
            NavigationGuideTitle.setFont(NavigationGuideTitle.getFont().deriveFont(NavigationGuideTitle.getFont().getStyle() | Font.BOLD, NavigationGuideTitle.getFont().getSize() + 5f));
            NavigationGuideResultContentPane.add(NavigationGuideTitle);
            NavigationGuideTitle.setBounds(60, 30, 330, NavigationGuideTitle.getPreferredSize().height);

            //======== NavigationGuidePane ========
            {

                //---- NavigationGuideList ----
                NavigationGuideList.setVisibleRowCount(5);
                NavigationGuideList.setFont(NavigationGuideList.getFont().deriveFont(NavigationGuideList.getFont().getStyle() & ~Font.BOLD, NavigationGuideList.getFont().getSize() + 3f));
                NavigationGuidePane.setViewportView(NavigationGuideList);
            }
            NavigationGuideResultContentPane.add(NavigationGuidePane);
            NavigationGuidePane.setBounds(60, 60, 300, 155);

            NavigationGuideResultContentPane.setPreferredSize(new Dimension(420, 290));
            NavigationGuideResult.setSize(420, 290);
            NavigationGuideResult.setLocationRelativeTo(NavigationGuideResult.getOwner());
        }

        //======== ExportSuccess ========
        {
            ExportSuccess.setTitle("\u5bfc\u51fa\u6210\u529f");
            ExportSuccess.setModal(true);
            ExportSuccess.setAlwaysOnTop(true);
            ExportSuccess.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            var ExportSuccessContentPane = ExportSuccess.getContentPane();
            ExportSuccessContentPane.setLayout(null);

            //---- esm ----
            esm.setText("\u5bfc\u51fa\u6210\u529f\uff01");
            esm.setFont(esm.getFont().deriveFont(esm.getFont().getStyle() | Font.BOLD, esm.getFont().getSize() + 6f));
            ExportSuccessContentPane.add(esm);
            esm.setBounds(new Rectangle(new Point(30, 30), esm.getPreferredSize()));

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < ExportSuccessContentPane.getComponentCount(); i++) {
                    Rectangle bounds = ExportSuccessContentPane.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = ExportSuccessContentPane.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                ExportSuccessContentPane.setMinimumSize(preferredSize);
                ExportSuccessContentPane.setPreferredSize(preferredSize);
            }
            ExportSuccess.setSize(155, 115);
            ExportSuccess.setLocationRelativeTo(ExportSuccess.getOwner());
        }

        //======== ExportFail ========
        {
            ExportFail.setTitle("\u5bfc\u51fa\u5931\u8d25");
            ExportFail.setModal(true);
            ExportFail.setAlwaysOnTop(true);
            ExportFail.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            var ExportFailContentPane = ExportFail.getContentPane();
            ExportFailContentPane.setLayout(null);

            //---- efm ----
            efm.setText("\u5bfc\u51fa\u5931\u8d25\uff01");
            efm.setFont(efm.getFont().deriveFont(efm.getFont().getStyle() | Font.BOLD, efm.getFont().getSize() + 6f));
            ExportFailContentPane.add(efm);
            efm.setBounds(new Rectangle(new Point(30, 30), efm.getPreferredSize()));

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < ExportFailContentPane.getComponentCount(); i++) {
                    Rectangle bounds = ExportFailContentPane.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = ExportFailContentPane.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                ExportFailContentPane.setMinimumSize(preferredSize);
                ExportFailContentPane.setPreferredSize(preferredSize);
            }
            ExportFail.setSize(155, 115);
            ExportFail.setLocationRelativeTo(ExportFail.getOwner());
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
    private JMenuItem Direction;
    private JMenuItem StopQuery;
    private JMenuItem RouteQuery;
    private JLabel Title;
    private JScrollPane TablePane;
    private JTable RouteGuide;
    private JLabel ExportToExcel;
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
    private JDialog StopSearchResult;
    private JLabel StopResultName;
    private JLabel StopResultNameText;
    private JLabel PassRoute;
    private JScrollPane PassRouteListPane;
    private JList PassRouteList;
    private JDialog RouteQueryDialog;
    private JLabel QueryStopName;
    private JComboBox SelectRouteId;
    private JButton SearchRoute;
    private JDialog RouteSearchResult;
    private JLabel RouteResultName;
    private JLabel RouteResultNameText;
    private JLabel PassStop;
    private JScrollPane PassStopListPane;
    private JList PassStopList;
    private JLabel WorkTime;
    private JLabel WorkTimeText;
    private JDialog NavigationGuideDialog;
    private JLabel StartStop;
    private JTextField StartStopNameInput;
    private JScrollPane StartStopListPane;
    private JList StartStopNameList;
    private JButton NavigationButton;
    private JLabel EndStop;
    private JTextField EndStopNameInput;
    private JScrollPane EndStopPane;
    private JList EndStopNameList;
    private JDialog NavigationGuideResult;
    private JLabel NavigationGuideTitle;
    private JScrollPane NavigationGuidePane;
    private JList NavigationGuideList;
    private JDialog ExportSuccess;
    private JLabel esm;
    private JDialog ExportFail;
    private JLabel efm;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

    // 当前用户ID BEGIN
    private String currentUserId;

    public String getCurrentUserId() {
        return currentUserId;
    }

    public void setCurrentUserId(String currentUserId) {
        this.currentUserId = currentUserId;
    }
    // 当前用户ID END

    // 初始化主页线路指南部分 BEGIN
    private void initRouteGuide() {
        // 获取表格模型
        DefaultTableModel model = (DefaultTableModel) RouteGuide.getModel();

        // 添加新行数据
        List<RouteGuideRow> allRouteGuideRow = userHomePage.getAllRouteGuideRow();
        for (RouteGuideRow routeGuideRow : allRouteGuideRow) {
            String routeId = routeGuideRow.getRouteId();
            String routeName = routeGuideRow.getRouteName();
            String stopNameResult = routeGuideRow.getStopNameResult();

            model.addRow(new Object[]{routeId, routeName, stopNameResult});
        }
    }
    // 初始化主页线路指南部分 END

    // 站点搜索 BEGIN
    private DefaultListModel<String> stopQueryListModel;

    private void updateStopQueryList() {
        String text = StopNameInput.getText();

        if (text == null) {
            stopQueryListModel.clear();
            return;
        }

        List<String> stopQueryResults = stopQuery.getSimilarStopName(text); // 备选列表内容

        stopQueryListModel.clear();

        for (String stopQueryResult : stopQueryResults) {
            stopQueryListModel.addElement(stopQueryResult);
        }
    }

    private void selectStopQueryList() {
        String selectStopName = (String) StopNameList.getSelectedValue();
        if (selectStopName != null) {
            StopNameInput.setText(selectStopName);
            stopQueryListModel.clear();
        }
    }

    private void initStopQueryDialog() {
        stopQueryListModel = new DefaultListModel<>();
        StopNameList.setModel(stopQueryListModel);

        StopNameInput.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateStopQueryList();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateStopQueryList();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateStopQueryList();
            }
        });

        StopNameList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    selectStopQueryList();
                }
            }
        });
    }

    private void showAllStopNameInList(DefaultListModel<String> listModel) {
        // 备选列表展示全部站点
        List<String> stopQuerySelections = stopQuery.getAllStopName(); // 备选列表中选项内容

        listModel.clear();

        for (String stopQuerySelection : stopQuerySelections) {
            listModel.addElement(stopQuerySelection);
        }
    }

    // 结果展示
    private DefaultListModel<String> passByRouteListModel;

    private boolean initStopSearchResult() {
        String stopName = StopNameInput.getText();
        if (stopName.isEmpty()) return false;
        StopResultNameText.setText(stopName);

        passByRouteListModel = new DefaultListModel<>();
        PassRouteList.setModel(passByRouteListModel);

        List<String> routeBasicInfos = stopQuery.listRoute2listRouteBasicInformation(stopQuery.searchPassByRoute(stopName));  // 经行线路基本信息

        passByRouteListModel.clear();

        for (String routeBasicInfo : routeBasicInfos) {
            passByRouteListModel.addElement(routeBasicInfo);
        }

        return true;
    }
    // 站点搜索 END

    // 线路搜索 BEGIN
    private void showAllRouteIdInBox() {
        List<String> routeQuerySelections = routeQuery.getAllRouteId();  // 备选容器中选项内容

        for (String routeQuerySelection : routeQuerySelections) {
            SelectRouteId.addItem(routeQuerySelection);
        }
    }

    private DefaultListModel<String> passByStopListModel;

    private void initRouteSearchResult() {
        passByStopListModel = new DefaultListModel<>();
        PassStopList.setModel(passByStopListModel);

        String routeId = Objects.requireNonNull(SelectRouteId.getSelectedItem()).toString().split("路")[0];
        String routeName = routeQuery.getRouteById(routeId).getName();
        Time startTime = routeQuery.getRouteById(routeId).getStartTime();
        Time endTime = routeQuery.getRouteById(routeId).getEndTime();
        String workTime = startTime + "->" + endTime;

        RouteResultNameText.setText(routeName);
        WorkTimeText.setText(workTime);

        List<String> stopNames = routeQuery.getPassByStopName(routeId);

        passByStopListModel.clear();

        for (String stopName : stopNames) {
            passByStopListModel.addElement(stopName);
        }
    }
    // 线路搜索 END

    // 路线导航指南 BEGIN
    private DefaultListModel<String> startStopQueryListModel;

    private void updateStartStopQueryList() {
        String text = StartStopNameInput.getText();

        if (text == null) {
            startStopQueryListModel.clear();
            return;
        }

        List<String> startStopQueryResults = stopQuery.getSimilarStopName(text); // 备选列表内容

        startStopQueryListModel.clear();

        for (String startStopQueryResult : startStopQueryResults) {
            startStopQueryListModel.addElement(startStopQueryResult);
        }
    }

    private void selectStartStopQueryList() {
        String selectStartStopName = (String) StartStopNameList.getSelectedValue();
        if (selectStartStopName != null) {
            StartStopNameInput.setText(selectStartStopName);
            startStopQueryListModel.clear();
        }
    }

    private DefaultListModel<String> endStopQueryListModel;

    private void updateEndStopQueryList() {
        String text = EndStopNameInput.getText();

        if (text == null) {
            endStopQueryListModel.clear();
            return;
        }

        List<String> endStopQueryResults = stopQuery.getSimilarStopName(text); // 备选列表内容

        endStopQueryListModel.clear();

        for (String endStopQueryResult : endStopQueryResults) {
            endStopQueryListModel.addElement(endStopQueryResult);
        }
    }

    private void selectEndStopQueryList() {
        String selectEndStopName = (String) EndStopNameList.getSelectedValue();
        if (selectEndStopName != null) {
            EndStopNameInput.setText(selectEndStopName);
            endStopQueryListModel.clear();
        }
    }

    private void initNavigationDialog() {
        startStopQueryListModel = new DefaultListModel<>();
        StartStopNameList.setModel(startStopQueryListModel);

        StartStopNameInput.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateStartStopQueryList();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateStartStopQueryList();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateStartStopQueryList();
            }
        });

        StartStopNameList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    selectStartStopQueryList();
                }
            }
        });

        endStopQueryListModel = new DefaultListModel<>();
        EndStopNameList.setModel(endStopQueryListModel);

        EndStopNameInput.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateEndStopQueryList();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateEndStopQueryList();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateEndStopQueryList();
            }
        });

        EndStopNameList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    selectEndStopQueryList();
                }
            }
        });
    }

    // 展示结果
    private DefaultListModel<String> navigationGuideModel;

    private boolean initNavigationGuideResult() {
        String startStopName = StartStopNameInput.getText();
        String endStopName = EndStopNameInput.getText();
        if (startStopName.isEmpty() || endStopName.isEmpty()) return false;

        List<String> navigationGuides = NavigationSystem.getNavigationGuide(startStopName, endStopName);
        String title = navigationGuides.removeFirst();

        NavigationGuideTitle.setText(title);

        navigationGuideModel = new DefaultListModel<>();
        NavigationGuideList.setModel(navigationGuideModel);

        for (String navigationGuide : navigationGuides) {
            navigationGuideModel.addElement(navigationGuide);
        }

        return true;
    }
    // 路线导航指南 END
}
