/*
 * Created by JFormDesigner on Thu Jul 11 14:44:36 CST 2024
 */

package SmartBusSystem.UI;

import SmartBusSystem.pojo.Bus;
import SmartBusSystem.pojo.Schedule;
import SmartBusSystem.service.TableRow.WorkArrangeRow;
import SmartBusSystem.service.function.AdminEditBus;
import SmartBusSystem.service.function.AdminEditSchedule;
import SmartBusSystem.service.function.AdminHomePage;
import SmartBusSystem.service.tool.ExportTable;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

/**
 * @author 87948
 */
public class AdminFunctionUI extends JFrame {
    public AdminFunctionUI() {
        initComponents();
        initAllWorkArrange();
        initAddNewScheduleDialog();
        initScheduleQueryDialog();

        this.setVisible(true);
    }

    private void QueryBusMouseReleased(MouseEvent e) {
        showAllBusLicenseNum();
        QueryBusDialog.setVisible(true);
    }

    private void SearchBusButtonMouseReleased(MouseEvent e) {
        initBusSearchResult();
        BusSearchResult.setVisible(true);
    }

    private void BusInformationModifyButtonMouseReleased(MouseEvent e) {
        Bus bus = new Bus();
        bus.setLicenseNumber(BusResultLicenseNumText.getText());
        bus.setStatus(SelectBusStatus.isSelected() ? 1 : 0);
        AdminEditBus.updateBusStatus(bus);

        Pass.setVisible(true);
        BusSearchResult.dispose();
    }

    private void LoginOutMouseReleased(MouseEvent e) {
        this.dispose();
        new LoginUI();
    }

    private void RefreshHomePageMouseReleased(MouseEvent e) {
        this.dispose();
        new AdminFunctionUI();
    }

    private void AddBusMouseReleased(MouseEvent e) {
        showAllRouteId();
        BusAddDialog.setVisible(true);
    }

    private void AddBusButtonMouseReleased(MouseEvent e) {
        String licenseNum = NewBusLicenseNumberInput.getText();
        String routeId = ((String) Objects.requireNonNull(NewSelectRouteId.getSelectedItem())).split("路")[0];
        int status = NewSelectBusStatus.isSelected() ? 1 : 0;

        if (!AdminEditBus.checkLicenseNumber(licenseNum)) {
            LicenseNumberWrong.setVisible(true);
            return;
        }
        if (AdminEditBus.containBus(licenseNum)) {
            BusExistDialog.setVisible(true);
            return;
        }

        Bus bus = new Bus(licenseNum, status, routeId);
        AdminEditBus.addNewBus(bus);

        Pass.setVisible(true);
        BusAddDialog.dispose();
    }

    private void DeleteBusButtonMouseReleased(MouseEvent e) {
        String licenseNum = BusResultLicenseNumText.getText();
        AdminEditBus.deleteBus(licenseNum);

        Pass.setVisible(true);
        BusSearchResult.dispose();
        showAllBusLicenseNum();
    }

    private void QueryScheduleMouseReleased(MouseEvent e) {
        showAllTime(SelectTime);

        QueryScheduleDialog.setVisible(true);
    }

    private void SearchScheduleButtonMouseReleased(MouseEvent e) {
        initQueryScheduleResult();
        ScheduleSearchResult.setVisible(true);
    }

    private void ScheduleInformationModifyButtonMouseReleased(MouseEvent e) {
        String DID = ScheduleResultDIDText.getText();
        String time = ScheduleResultTimeText.getText();
        String licenseNum = (String) ScheduleSelectBusLicenseNum.getSelectedItem();

        Schedule schedule = new Schedule(DID, time, licenseNum);

        AdminEditSchedule.updateSchedule(schedule);

        Pass.setVisible(true);
        ScheduleSearchResult.dispose();
    }

    private void DeleteScheduleButtonMouseReleased(MouseEvent e) {
        String DID = ScheduleResultDIDText.getText();
        String time = ScheduleResultTimeText.getText();

        AdminEditSchedule.deleteScheduleById(DID, time);

        showDriverIsArrangedOnTheDay(time);

        Pass.setVisible(true);
        ScheduleSearchResult.dispose();
    }

    private void AddScheduleMouseReleased(MouseEvent e) {
        showAllTime(SelectAddScheduleTime);

        AddNewScheduleDialog.setVisible(true);
    }

    private void AddScheduleButtonMouseReleased(MouseEvent e) {
        String DID = (String) SelectAddScheduleDID.getSelectedItem();
        String time = (String) SelectAddScheduleTime.getSelectedItem();
        String licenseNum = (String) SelectScheduleLicenseNum.getSelectedItem();

        Schedule schedule = new Schedule(DID, time, licenseNum);

        AdminEditSchedule.addNewSchedule(schedule);

        Pass.setVisible(true);
        AddNewScheduleDialog.dispose();
    }

    private void ExportTableMouseReleased(MouseEvent e){
        try {
            ExportTable.JTable2Excel(AllWorkArrange.getModel(), "工作排班表", this);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        TopMenu = new JMenuBar();
        Me = new JMenu();
        LoginOut = new JMenuItem();
        ServiceMenu = new JMenu();
        RefreshHomePage = new JMenuItem();
        AboutBus = new JMenu();
        QueryBus = new JMenuItem();
        AddBus = new JMenuItem();
        AboutSchedule = new JMenu();
        QuerySchedule = new JMenuItem();
        AddSchedule = new JMenuItem();
        Title = new JLabel();
        TablePane = new JScrollPane();
        AllWorkArrange = new JTable();
        ExportToExcel = new JLabel();
        QueryBusDialog = new JDialog();
        BusLicenseNum = new JLabel();
        BusSelectBusLicenseNum = new JComboBox();
        SearchBusButton = new JButton();
        BusSearchResult = new JDialog();
        BusResultLicenseNum = new JLabel();
        BusResultLicenseNumText = new JLabel();
        BusStatus = new JLabel();
        BelongRoute = new JLabel();
        BelongRouteIdText = new JLabel();
        BusInformationModifyButton = new JButton();
        SelectBusStatus = new JCheckBox();
        DeleteBusButton = new JButton();
        Pass = new JDialog();
        PassMessage = new JLabel();
        BusAddDialog = new JDialog();
        NewBusLicenseNum = new JLabel();
        NewBusStatus = new JLabel();
        NewBelongRoute = new JLabel();
        NewSelectBusStatus = new JCheckBox();
        NewBusLicenseNumberInput = new JTextField();
        NewSelectRouteId = new JComboBox();
        AddBusButton = new JButton();
        LicenseNumberWrong = new JDialog();
        PassMessage2 = new JLabel();
        BusExistDialog = new JDialog();
        PassMessage3 = new JLabel();
        ScheduleSearchResult = new JDialog();
        ScheduleResultDIID = new JLabel();
        ScheduleResultLicenseNum = new JLabel();
        ScheduleResultTime = new JLabel();
        ScheduleSelectBusLicenseNum = new JComboBox();
        ScheduleResultDIDText = new JLabel();
        ScheduleResultTimeText = new JLabel();
        DeleteScheduleButton = new JButton();
        ScheduleInformationModifyButton = new JButton();
        QueryScheduleDialog = new JDialog();
        DID = new JLabel();
        SelectDID = new JComboBox();
        SearchScheduleButton = new JButton();
        Time = new JLabel();
        SelectTime = new JComboBox();
        AddNewScheduleDialog = new JDialog();
        AddScheduleDID = new JLabel();
        AddScheduleLicenseNum = new JLabel();
        AddScheduleTime = new JLabel();
        SelectScheduleLicenseNum = new JComboBox();
        AddScheduleButton = new JButton();
        SelectAddScheduleDID = new JComboBox();
        SelectAddScheduleTime = new JComboBox();

        //======== this ========
        setTitle("\u7ba1\u7406\u5458\u7aef");
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

                //======== AboutBus ========
                {
                    AboutBus.setText("\u5173\u4e8e\u8f66\u8f86");
                    AboutBus.setFocusable(false);
                    AboutBus.setIconTextGap(0);
                    AboutBus.setFont(AboutBus.getFont().deriveFont(AboutBus.getFont().getSize() + 1f));

                    //---- QueryBus ----
                    QueryBus.setText("\u8f66\u8f86\u67e5\u8be2");
                    QueryBus.setIconTextGap(0);
                    QueryBus.setFont(QueryBus.getFont().deriveFont(QueryBus.getFont().getSize() + 1f));
                    QueryBus.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseReleased(MouseEvent e) {
                            QueryBusMouseReleased(e);
                        }
                    });
                    AboutBus.add(QueryBus);

                    //---- AddBus ----
                    AddBus.setText("\u8f66\u8f86\u65b0\u589e");
                    AddBus.setFont(AddBus.getFont().deriveFont(AddBus.getFont().getSize() + 1f));
                    AddBus.setIconTextGap(0);
                    AddBus.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseReleased(MouseEvent e) {
                            AddBusMouseReleased(e);
                        }
                    });
                    AboutBus.add(AddBus);
                }
                ServiceMenu.add(AboutBus);

                //======== AboutSchedule ========
                {
                    AboutSchedule.setText("\u5173\u4e8e\u6392\u73ed");
                    AboutSchedule.setFont(AboutSchedule.getFont().deriveFont(AboutSchedule.getFont().getSize() + 1f));
                    AboutSchedule.setIconTextGap(0);

                    //---- QuerySchedule ----
                    QuerySchedule.setText("\u6392\u73ed\u67e5\u8be2");
                    QuerySchedule.setFont(QuerySchedule.getFont().deriveFont(QuerySchedule.getFont().getSize() + 1f));
                    QuerySchedule.setIconTextGap(0);
                    QuerySchedule.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseReleased(MouseEvent e) {
                            QueryScheduleMouseReleased(e);
                        }
                    });
                    AboutSchedule.add(QuerySchedule);

                    //---- AddSchedule ----
                    AddSchedule.setText("\u6392\u73ed\u65b0\u589e");
                    AddSchedule.setFont(AddSchedule.getFont().deriveFont(AddSchedule.getFont().getSize() + 1f));
                    AddSchedule.setIconTextGap(0);
                    AddSchedule.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseReleased(MouseEvent e) {
                            AddScheduleMouseReleased(e);
                        }
                    });
                    AboutSchedule.add(AddSchedule);
                }
                ServiceMenu.add(AboutSchedule);
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

            //---- AllWorkArrange ----
            AllWorkArrange.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                    "\u65e5\u671f", "\u53f8\u673a", "\u8f66\u8f86", "\u7ebf\u8def", "\u8fd0\u8425\u65f6\u95f4"
                }
            ) {
                boolean[] columnEditable = new boolean[] {
                    false, false, false, false, false
                };
                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return columnEditable[columnIndex];
                }
            });
            {
                TableColumnModel cm = AllWorkArrange.getColumnModel();
                cm.getColumn(0).setPreferredWidth(60);
                cm.getColumn(1).setPreferredWidth(70);
                cm.getColumn(2).setPreferredWidth(105);
                cm.getColumn(3).setPreferredWidth(160);
                cm.getColumn(4).setPreferredWidth(160);
            }
            TablePane.setViewportView(AllWorkArrange);
        }
        contentPane.add(TablePane);
        TablePane.setBounds(45, 55, 545, 310);

        //---- ExportToExcel ----
        ExportToExcel.setText("\u5bfc\u51fa");
        ExportToExcel.setFont(ExportToExcel.getFont().deriveFont(Font.BOLD|Font.ITALIC));
        ExportToExcel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                ExportTableMouseReleased(e);
            }
        });
        contentPane.add(ExportToExcel);
        ExportToExcel.setBounds(new Rectangle(new Point(565, 30), ExportToExcel.getPreferredSize()));

        contentPane.setPreferredSize(new Dimension(640, 480));
        setSize(640, 480);
        setLocationRelativeTo(getOwner());

        //======== QueryBusDialog ========
        {
            QueryBusDialog.setTitle("\u8f66\u8f86\u67e5\u8be2");
            QueryBusDialog.setAlwaysOnTop(true);
            QueryBusDialog.setModal(true);
            var QueryBusDialogContentPane = QueryBusDialog.getContentPane();
            QueryBusDialogContentPane.setLayout(null);

            //---- BusLicenseNum ----
            BusLicenseNum.setText("\u8f66\u724c\u53f7:");
            BusLicenseNum.setFont(BusLicenseNum.getFont().deriveFont(BusLicenseNum.getFont().getStyle() | Font.BOLD, BusLicenseNum.getFont().getSize() + 5f));
            QueryBusDialogContentPane.add(BusLicenseNum);
            BusLicenseNum.setBounds(35, 30, BusLicenseNum.getPreferredSize().width, 20);
            QueryBusDialogContentPane.add(BusSelectBusLicenseNum);
            BusSelectBusLicenseNum.setBounds(105, 30, 120, 20);

            //---- SearchBusButton ----
            SearchBusButton.setText("\u641c\u7d22");
            SearchBusButton.setFocusPainted(false);
            SearchBusButton.setFont(SearchBusButton.getFont().deriveFont(SearchBusButton.getFont().getStyle() | Font.BOLD, SearchBusButton.getFont().getSize() + 3f));
            SearchBusButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseReleased(MouseEvent e) {
                    SearchBusButtonMouseReleased(e);
                }
            });
            QueryBusDialogContentPane.add(SearchBusButton);
            SearchBusButton.setBounds(90, 85, SearchBusButton.getPreferredSize().width, 24);

            QueryBusDialogContentPane.setPreferredSize(new Dimension(255, 160));
            QueryBusDialog.setSize(255, 160);
            QueryBusDialog.setLocationRelativeTo(QueryBusDialog.getOwner());
        }

        //======== BusSearchResult ========
        {
            BusSearchResult.setTitle("\u8f66\u8f86\u4fe1\u606f");
            BusSearchResult.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            BusSearchResult.setAlwaysOnTop(true);
            BusSearchResult.setModal(true);
            var BusSearchResultContentPane = BusSearchResult.getContentPane();
            BusSearchResultContentPane.setLayout(null);

            //---- BusResultLicenseNum ----
            BusResultLicenseNum.setText("\u8f66\u724c\u53f7:");
            BusResultLicenseNum.setFont(BusResultLicenseNum.getFont().deriveFont(BusResultLicenseNum.getFont().getStyle() | Font.BOLD, BusResultLicenseNum.getFont().getSize() + 5f));
            BusSearchResultContentPane.add(BusResultLicenseNum);
            BusResultLicenseNum.setBounds(new Rectangle(new Point(60, 30), BusResultLicenseNum.getPreferredSize()));

            //---- BusResultLicenseNumText ----
            BusResultLicenseNumText.setText("\u8f66\u724c\u53f7");
            BusResultLicenseNumText.setFont(BusResultLicenseNumText.getFont().deriveFont(BusResultLicenseNumText.getFont().getSize() + 3f));
            BusSearchResultContentPane.add(BusResultLicenseNumText);
            BusResultLicenseNumText.setBounds(125, 32, 140, BusResultLicenseNumText.getPreferredSize().height);

            //---- BusStatus ----
            BusStatus.setText("\u72b6\u6001:");
            BusStatus.setFont(BusStatus.getFont().deriveFont(BusStatus.getFont().getStyle() | Font.BOLD, BusStatus.getFont().getSize() + 5f));
            BusSearchResultContentPane.add(BusStatus);
            BusStatus.setBounds(new Rectangle(new Point(60, 90), BusStatus.getPreferredSize()));

            //---- BelongRoute ----
            BelongRoute.setText("\u6240\u5c5e\u7ebf\u8def:");
            BelongRoute.setFont(BelongRoute.getFont().deriveFont(BelongRoute.getFont().getStyle() | Font.BOLD, BelongRoute.getFont().getSize() + 5f));
            BusSearchResultContentPane.add(BelongRoute);
            BelongRoute.setBounds(new Rectangle(new Point(60, 60), BelongRoute.getPreferredSize()));

            //---- BelongRouteIdText ----
            BelongRouteIdText.setText("\u6240\u5c5e\u7ebf\u8def");
            BelongRouteIdText.setFont(BelongRouteIdText.getFont().deriveFont(BelongRouteIdText.getFont().getSize() + 3f));
            BusSearchResultContentPane.add(BelongRouteIdText);
            BelongRouteIdText.setBounds(145, 64, 120, 17);

            //---- BusInformationModifyButton ----
            BusInformationModifyButton.setText("\u4fdd\u5b58");
            BusInformationModifyButton.setFocusPainted(false);
            BusInformationModifyButton.setFont(BusInformationModifyButton.getFont().deriveFont(BusInformationModifyButton.getFont().getStyle() | Font.BOLD, BusInformationModifyButton.getFont().getSize() + 3f));
            BusInformationModifyButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseReleased(MouseEvent e) {
                    BusInformationModifyButtonMouseReleased(e);
                }
            });
            BusSearchResultContentPane.add(BusInformationModifyButton);
            BusInformationModifyButton.setBounds(new Rectangle(new Point(145, 130), BusInformationModifyButton.getPreferredSize()));

            //---- SelectBusStatus ----
            SelectBusStatus.setText("\u6b63\u5e38");
            SelectBusStatus.setFont(SelectBusStatus.getFont().deriveFont(SelectBusStatus.getFont().getStyle() | Font.BOLD, SelectBusStatus.getFont().getSize() + 3f));
            SelectBusStatus.setFocusPainted(false);
            BusSearchResultContentPane.add(SelectBusStatus);
            SelectBusStatus.setBounds(new Rectangle(new Point(110, 90), SelectBusStatus.getPreferredSize()));

            //---- DeleteBusButton ----
            DeleteBusButton.setText("\u5220\u9664");
            DeleteBusButton.setFocusPainted(false);
            DeleteBusButton.setFont(DeleteBusButton.getFont().deriveFont(DeleteBusButton.getFont().getStyle() | Font.BOLD, DeleteBusButton.getFont().getSize() + 3f));
            DeleteBusButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseReleased(MouseEvent e) {
                    DeleteBusButtonMouseReleased(e);
                }
            });
            BusSearchResultContentPane.add(DeleteBusButton);
            DeleteBusButton.setBounds(new Rectangle(new Point(55, 130), DeleteBusButton.getPreferredSize()));

            BusSearchResultContentPane.setPreferredSize(new Dimension(290, 209));
            BusSearchResult.setSize(290, 209);
            BusSearchResult.setLocationRelativeTo(BusSearchResult.getOwner());
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

        //======== BusAddDialog ========
        {
            BusAddDialog.setTitle("\u8f66\u8f86\u65b0\u589e");
            BusAddDialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            BusAddDialog.setAlwaysOnTop(true);
            BusAddDialog.setModal(true);
            var BusAddDialogContentPane = BusAddDialog.getContentPane();
            BusAddDialogContentPane.setLayout(null);

            //---- NewBusLicenseNum ----
            NewBusLicenseNum.setText("\u8f66\u724c\u53f7:");
            NewBusLicenseNum.setFont(NewBusLicenseNum.getFont().deriveFont(NewBusLicenseNum.getFont().getStyle() | Font.BOLD, NewBusLicenseNum.getFont().getSize() + 5f));
            BusAddDialogContentPane.add(NewBusLicenseNum);
            NewBusLicenseNum.setBounds(new Rectangle(new Point(45, 30), NewBusLicenseNum.getPreferredSize()));

            //---- NewBusStatus ----
            NewBusStatus.setText("\u72b6\u6001:");
            NewBusStatus.setFont(NewBusStatus.getFont().deriveFont(NewBusStatus.getFont().getStyle() | Font.BOLD, NewBusStatus.getFont().getSize() + 5f));
            BusAddDialogContentPane.add(NewBusStatus);
            NewBusStatus.setBounds(new Rectangle(new Point(45, 90), NewBusStatus.getPreferredSize()));

            //---- NewBelongRoute ----
            NewBelongRoute.setText("\u6240\u5c5e\u7ebf\u8def:");
            NewBelongRoute.setFont(NewBelongRoute.getFont().deriveFont(NewBelongRoute.getFont().getStyle() | Font.BOLD, NewBelongRoute.getFont().getSize() + 5f));
            BusAddDialogContentPane.add(NewBelongRoute);
            NewBelongRoute.setBounds(new Rectangle(new Point(45, 60), NewBelongRoute.getPreferredSize()));

            //---- NewSelectBusStatus ----
            NewSelectBusStatus.setText("\u6b63\u5e38");
            NewSelectBusStatus.setFont(NewSelectBusStatus.getFont().deriveFont(NewSelectBusStatus.getFont().getStyle() | Font.BOLD, NewSelectBusStatus.getFont().getSize() + 3f));
            NewSelectBusStatus.setFocusPainted(false);
            BusAddDialogContentPane.add(NewSelectBusStatus);
            NewSelectBusStatus.setBounds(new Rectangle(new Point(90, 90), NewSelectBusStatus.getPreferredSize()));
            BusAddDialogContentPane.add(NewBusLicenseNumberInput);
            NewBusLicenseNumberInput.setBounds(115, 30, 120, 20);
            BusAddDialogContentPane.add(NewSelectRouteId);
            NewSelectRouteId.setBounds(130, 60, 105, 20);

            //---- AddBusButton ----
            AddBusButton.setText("\u65b0\u589e");
            AddBusButton.setFocusPainted(false);
            AddBusButton.setFont(AddBusButton.getFont().deriveFont(AddBusButton.getFont().getStyle() | Font.BOLD, AddBusButton.getFont().getSize() + 3f));
            AddBusButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseReleased(MouseEvent e) {
                    AddBusButtonMouseReleased(e);
                }
            });
            BusAddDialogContentPane.add(AddBusButton);
            AddBusButton.setBounds(new Rectangle(new Point(115, 130), AddBusButton.getPreferredSize()));

            BusAddDialogContentPane.setPreferredSize(new Dimension(300, 210));
            BusAddDialog.setSize(300, 210);
            BusAddDialog.setLocationRelativeTo(BusAddDialog.getOwner());
        }

        //======== LicenseNumberWrong ========
        {
            LicenseNumberWrong.setTitle("\u9519\u8bef\u4fe1\u606f");
            LicenseNumberWrong.setModal(true);
            LicenseNumberWrong.setAlwaysOnTop(true);
            LicenseNumberWrong.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            var LicenseNumberWrongContentPane = LicenseNumberWrong.getContentPane();
            LicenseNumberWrongContentPane.setLayout(null);

            //---- PassMessage2 ----
            PassMessage2.setText("\u8f66\u724c\u53f7\u683c\u5f0f\u9519\u8bef\uff01\u8bf7\u91cd\u65b0\u8f93\u5165");
            PassMessage2.setFont(PassMessage2.getFont().deriveFont(PassMessage2.getFont().getStyle() | Font.BOLD, PassMessage2.getFont().getSize() + 6f));
            LicenseNumberWrongContentPane.add(PassMessage2);
            PassMessage2.setBounds(new Rectangle(new Point(25, 30), PassMessage2.getPreferredSize()));

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < LicenseNumberWrongContentPane.getComponentCount(); i++) {
                    Rectangle bounds = LicenseNumberWrongContentPane.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = LicenseNumberWrongContentPane.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                LicenseNumberWrongContentPane.setMinimumSize(preferredSize);
                LicenseNumberWrongContentPane.setPreferredSize(preferredSize);
            }
            LicenseNumberWrong.setSize(300, 115);
            LicenseNumberWrong.setLocationRelativeTo(LicenseNumberWrong.getOwner());
        }

        //======== BusExistDialog ========
        {
            BusExistDialog.setTitle("\u9519\u8bef\u4fe1\u606f");
            BusExistDialog.setModal(true);
            BusExistDialog.setAlwaysOnTop(true);
            BusExistDialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            var BusExistDialogContentPane = BusExistDialog.getContentPane();
            BusExistDialogContentPane.setLayout(null);

            //---- PassMessage3 ----
            PassMessage3.setText("\u6b64\u8f66\u8f86\u5df2\u5b58\u5728\uff01\u8bf7\u91cd\u65b0\u8f93\u5165");
            PassMessage3.setFont(PassMessage3.getFont().deriveFont(PassMessage3.getFont().getStyle() | Font.BOLD, PassMessage3.getFont().getSize() + 6f));
            BusExistDialogContentPane.add(PassMessage3);
            PassMessage3.setBounds(new Rectangle(new Point(25, 30), PassMessage3.getPreferredSize()));

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < BusExistDialogContentPane.getComponentCount(); i++) {
                    Rectangle bounds = BusExistDialogContentPane.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = BusExistDialogContentPane.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                BusExistDialogContentPane.setMinimumSize(preferredSize);
                BusExistDialogContentPane.setPreferredSize(preferredSize);
            }
            BusExistDialog.setSize(300, 115);
            BusExistDialog.setLocationRelativeTo(BusExistDialog.getOwner());
        }

        //======== ScheduleSearchResult ========
        {
            ScheduleSearchResult.setTitle("\u6392\u73ed\u4fe1\u606f");
            ScheduleSearchResult.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            ScheduleSearchResult.setAlwaysOnTop(true);
            ScheduleSearchResult.setModal(true);
            var ScheduleSearchResultContentPane = ScheduleSearchResult.getContentPane();
            ScheduleSearchResultContentPane.setLayout(null);

            //---- ScheduleResultDIID ----
            ScheduleResultDIID.setText("\u53f8\u673a:");
            ScheduleResultDIID.setFont(ScheduleResultDIID.getFont().deriveFont(ScheduleResultDIID.getFont().getStyle() | Font.BOLD, ScheduleResultDIID.getFont().getSize() + 5f));
            ScheduleSearchResultContentPane.add(ScheduleResultDIID);
            ScheduleResultDIID.setBounds(new Rectangle(new Point(60, 60), ScheduleResultDIID.getPreferredSize()));

            //---- ScheduleResultLicenseNum ----
            ScheduleResultLicenseNum.setText("\u8f66\u724c\u53f7:");
            ScheduleResultLicenseNum.setFont(ScheduleResultLicenseNum.getFont().deriveFont(ScheduleResultLicenseNum.getFont().getStyle() | Font.BOLD, ScheduleResultLicenseNum.getFont().getSize() + 5f));
            ScheduleSearchResultContentPane.add(ScheduleResultLicenseNum);
            ScheduleResultLicenseNum.setBounds(new Rectangle(new Point(60, 90), ScheduleResultLicenseNum.getPreferredSize()));

            //---- ScheduleResultTime ----
            ScheduleResultTime.setText("\u65f6\u95f4:");
            ScheduleResultTime.setFont(ScheduleResultTime.getFont().deriveFont(ScheduleResultTime.getFont().getStyle() | Font.BOLD, ScheduleResultTime.getFont().getSize() + 5f));
            ScheduleSearchResultContentPane.add(ScheduleResultTime);
            ScheduleResultTime.setBounds(60, 30, ScheduleResultTime.getPreferredSize().width, 18);

            //---- ScheduleSelectBusLicenseNum ----
            ScheduleSelectBusLicenseNum.setFont(ScheduleSelectBusLicenseNum.getFont().deriveFont(ScheduleSelectBusLicenseNum.getFont().getSize() + 3f));
            ScheduleSearchResultContentPane.add(ScheduleSelectBusLicenseNum);
            ScheduleSelectBusLicenseNum.setBounds(130, 90, 105, ScheduleSelectBusLicenseNum.getPreferredSize().height);

            //---- ScheduleResultDIDText ----
            ScheduleResultDIDText.setText("\u53f8\u673a");
            ScheduleResultDIDText.setFont(ScheduleResultDIDText.getFont().deriveFont(ScheduleResultDIDText.getFont().getSize() + 3f));
            ScheduleSearchResultContentPane.add(ScheduleResultDIDText);
            ScheduleResultDIDText.setBounds(110, 65, 140, 16);

            //---- ScheduleResultTimeText ----
            ScheduleResultTimeText.setText("\u65f6\u95f4");
            ScheduleResultTimeText.setFont(ScheduleResultTimeText.getFont().deriveFont(ScheduleResultTimeText.getFont().getSize() + 3f));
            ScheduleSearchResultContentPane.add(ScheduleResultTimeText);
            ScheduleResultTimeText.setBounds(110, 35, 120, 17);

            //---- DeleteScheduleButton ----
            DeleteScheduleButton.setText("\u5220\u9664");
            DeleteScheduleButton.setFocusPainted(false);
            DeleteScheduleButton.setFont(DeleteScheduleButton.getFont().deriveFont(DeleteScheduleButton.getFont().getStyle() | Font.BOLD, DeleteScheduleButton.getFont().getSize() + 3f));
            DeleteScheduleButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseReleased(MouseEvent e) {
                    DeleteScheduleButtonMouseReleased(e);
                }
            });
            ScheduleSearchResultContentPane.add(DeleteScheduleButton);
            DeleteScheduleButton.setBounds(new Rectangle(new Point(55, 130), DeleteScheduleButton.getPreferredSize()));

            //---- ScheduleInformationModifyButton ----
            ScheduleInformationModifyButton.setText("\u4fdd\u5b58");
            ScheduleInformationModifyButton.setFocusPainted(false);
            ScheduleInformationModifyButton.setFont(ScheduleInformationModifyButton.getFont().deriveFont(ScheduleInformationModifyButton.getFont().getStyle() | Font.BOLD, ScheduleInformationModifyButton.getFont().getSize() + 3f));
            ScheduleInformationModifyButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseReleased(MouseEvent e) {
                    ScheduleInformationModifyButtonMouseReleased(e);
                }
            });
            ScheduleSearchResultContentPane.add(ScheduleInformationModifyButton);
            ScheduleInformationModifyButton.setBounds(new Rectangle(new Point(145, 130), ScheduleInformationModifyButton.getPreferredSize()));

            ScheduleSearchResultContentPane.setPreferredSize(new Dimension(290, 220));
            ScheduleSearchResult.setSize(290, 220);
            ScheduleSearchResult.setLocationRelativeTo(ScheduleSearchResult.getOwner());
        }

        //======== QueryScheduleDialog ========
        {
            QueryScheduleDialog.setTitle("\u6392\u73ed\u67e5\u8be2");
            QueryScheduleDialog.setAlwaysOnTop(true);
            QueryScheduleDialog.setModal(true);
            var QueryScheduleDialogContentPane = QueryScheduleDialog.getContentPane();
            QueryScheduleDialogContentPane.setLayout(null);

            //---- DID ----
            DID.setText("\u53f8\u673a:");
            DID.setFont(DID.getFont().deriveFont(DID.getFont().getStyle() | Font.BOLD, DID.getFont().getSize() + 5f));
            QueryScheduleDialogContentPane.add(DID);
            DID.setBounds(35, 60, DID.getPreferredSize().width, 20);
            QueryScheduleDialogContentPane.add(SelectDID);
            SelectDID.setBounds(90, 60, 120, 20);

            //---- SearchScheduleButton ----
            SearchScheduleButton.setText("\u641c\u7d22");
            SearchScheduleButton.setFocusPainted(false);
            SearchScheduleButton.setFont(SearchScheduleButton.getFont().deriveFont(SearchScheduleButton.getFont().getStyle() | Font.BOLD, SearchScheduleButton.getFont().getSize() + 3f));
            SearchScheduleButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseReleased(MouseEvent e) {
                    SearchScheduleButtonMouseReleased(e);
                }
            });
            QueryScheduleDialogContentPane.add(SearchScheduleButton);
            SearchScheduleButton.setBounds(90, 100, SearchScheduleButton.getPreferredSize().width, 24);

            //---- Time ----
            Time.setText("\u65f6\u95f4:");
            Time.setFont(Time.getFont().deriveFont(Time.getFont().getStyle() | Font.BOLD, Time.getFont().getSize() + 5f));
            QueryScheduleDialogContentPane.add(Time);
            Time.setBounds(35, 30, Time.getPreferredSize().width, 20);
            QueryScheduleDialogContentPane.add(SelectTime);
            SelectTime.setBounds(90, 30, 120, 20);

            QueryScheduleDialogContentPane.setPreferredSize(new Dimension(255, 180));
            QueryScheduleDialog.setSize(255, 180);
            QueryScheduleDialog.setLocationRelativeTo(QueryScheduleDialog.getOwner());
        }

        //======== AddNewScheduleDialog ========
        {
            AddNewScheduleDialog.setTitle("\u6392\u73ed\u65b0\u589e");
            AddNewScheduleDialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            AddNewScheduleDialog.setAlwaysOnTop(true);
            AddNewScheduleDialog.setModal(true);
            var AddNewScheduleDialogContentPane = AddNewScheduleDialog.getContentPane();
            AddNewScheduleDialogContentPane.setLayout(null);

            //---- AddScheduleDID ----
            AddScheduleDID.setText("\u53f8\u673a:");
            AddScheduleDID.setFont(AddScheduleDID.getFont().deriveFont(AddScheduleDID.getFont().getStyle() | Font.BOLD, AddScheduleDID.getFont().getSize() + 5f));
            AddNewScheduleDialogContentPane.add(AddScheduleDID);
            AddScheduleDID.setBounds(new Rectangle(new Point(60, 60), AddScheduleDID.getPreferredSize()));

            //---- AddScheduleLicenseNum ----
            AddScheduleLicenseNum.setText("\u8f66\u724c\u53f7:");
            AddScheduleLicenseNum.setFont(AddScheduleLicenseNum.getFont().deriveFont(AddScheduleLicenseNum.getFont().getStyle() | Font.BOLD, AddScheduleLicenseNum.getFont().getSize() + 5f));
            AddNewScheduleDialogContentPane.add(AddScheduleLicenseNum);
            AddScheduleLicenseNum.setBounds(new Rectangle(new Point(60, 90), AddScheduleLicenseNum.getPreferredSize()));

            //---- AddScheduleTime ----
            AddScheduleTime.setText("\u65f6\u95f4:");
            AddScheduleTime.setFont(AddScheduleTime.getFont().deriveFont(AddScheduleTime.getFont().getStyle() | Font.BOLD, AddScheduleTime.getFont().getSize() + 5f));
            AddNewScheduleDialogContentPane.add(AddScheduleTime);
            AddScheduleTime.setBounds(new Rectangle(new Point(60, 30), AddScheduleTime.getPreferredSize()));

            //---- SelectScheduleLicenseNum ----
            SelectScheduleLicenseNum.setFont(SelectScheduleLicenseNum.getFont().deriveFont(SelectScheduleLicenseNum.getFont().getSize() + 3f));
            AddNewScheduleDialogContentPane.add(SelectScheduleLicenseNum);
            SelectScheduleLicenseNum.setBounds(130, 90, 105, SelectScheduleLicenseNum.getPreferredSize().height);

            //---- AddScheduleButton ----
            AddScheduleButton.setText("\u65b0\u589e");
            AddScheduleButton.setFocusPainted(false);
            AddScheduleButton.setFont(AddScheduleButton.getFont().deriveFont(AddScheduleButton.getFont().getStyle() | Font.BOLD, AddScheduleButton.getFont().getSize() + 3f));
            AddScheduleButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseReleased(MouseEvent e) {
                    AddScheduleButtonMouseReleased(e);
                }
            });
            AddNewScheduleDialogContentPane.add(AddScheduleButton);
            AddScheduleButton.setBounds(new Rectangle(new Point(105, 130), AddScheduleButton.getPreferredSize()));

            //---- SelectAddScheduleDID ----
            SelectAddScheduleDID.setFont(SelectAddScheduleDID.getFont().deriveFont(SelectAddScheduleDID.getFont().getSize() + 3f));
            AddNewScheduleDialogContentPane.add(SelectAddScheduleDID);
            SelectAddScheduleDID.setBounds(115, 60, 105, SelectAddScheduleDID.getPreferredSize().height);

            //---- SelectAddScheduleTime ----
            SelectAddScheduleTime.setFont(SelectAddScheduleTime.getFont().deriveFont(SelectAddScheduleTime.getFont().getSize() + 3f));
            AddNewScheduleDialogContentPane.add(SelectAddScheduleTime);
            SelectAddScheduleTime.setBounds(115, 30, 105, SelectAddScheduleTime.getPreferredSize().height);

            AddNewScheduleDialogContentPane.setPreferredSize(new Dimension(290, 210));
            AddNewScheduleDialog.setSize(290, 210);
            AddNewScheduleDialog.setLocationRelativeTo(AddNewScheduleDialog.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JMenuBar TopMenu;
    private JMenu Me;
    private JMenuItem LoginOut;
    private JMenu ServiceMenu;
    private JMenuItem RefreshHomePage;
    private JMenu AboutBus;
    private JMenuItem QueryBus;
    private JMenuItem AddBus;
    private JMenu AboutSchedule;
    private JMenuItem QuerySchedule;
    private JMenuItem AddSchedule;
    private JLabel Title;
    private JScrollPane TablePane;
    private JTable AllWorkArrange;
    private JLabel ExportToExcel;
    private JDialog QueryBusDialog;
    private JLabel BusLicenseNum;
    private JComboBox BusSelectBusLicenseNum;
    private JButton SearchBusButton;
    private JDialog BusSearchResult;
    private JLabel BusResultLicenseNum;
    private JLabel BusResultLicenseNumText;
    private JLabel BusStatus;
    private JLabel BelongRoute;
    private JLabel BelongRouteIdText;
    private JButton BusInformationModifyButton;
    private JCheckBox SelectBusStatus;
    private JButton DeleteBusButton;
    private JDialog Pass;
    private JLabel PassMessage;
    private JDialog BusAddDialog;
    private JLabel NewBusLicenseNum;
    private JLabel NewBusStatus;
    private JLabel NewBelongRoute;
    private JCheckBox NewSelectBusStatus;
    private JTextField NewBusLicenseNumberInput;
    private JComboBox NewSelectRouteId;
    private JButton AddBusButton;
    private JDialog LicenseNumberWrong;
    private JLabel PassMessage2;
    private JDialog BusExistDialog;
    private JLabel PassMessage3;
    private JDialog ScheduleSearchResult;
    private JLabel ScheduleResultDIID;
    private JLabel ScheduleResultLicenseNum;
    private JLabel ScheduleResultTime;
    private JComboBox ScheduleSelectBusLicenseNum;
    private JLabel ScheduleResultDIDText;
    private JLabel ScheduleResultTimeText;
    private JButton DeleteScheduleButton;
    private JButton ScheduleInformationModifyButton;
    private JDialog QueryScheduleDialog;
    private JLabel DID;
    private JComboBox SelectDID;
    private JButton SearchScheduleButton;
    private JLabel Time;
    private JComboBox SelectTime;
    private JDialog AddNewScheduleDialog;
    private JLabel AddScheduleDID;
    private JLabel AddScheduleLicenseNum;
    private JLabel AddScheduleTime;
    private JComboBox SelectScheduleLicenseNum;
    private JButton AddScheduleButton;
    private JComboBox SelectAddScheduleDID;
    private JComboBox SelectAddScheduleTime;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

    // 初始化工作安排表 BEGIN
    private void initAllWorkArrange() {
        DefaultTableModel model = (DefaultTableModel) AllWorkArrange.getModel();

        List<WorkArrangeRow> allWorkArranges = AdminHomePage.getAllWorkArrange();
        for (WorkArrangeRow allWorkArrange : allWorkArranges) {
            String time = allWorkArrange.getDayOfWeek();
            String driverId = allWorkArrange.getDriver().getID();
            String licenseNum = allWorkArrange.getBus().getLicenseNumber();
            String routeIdAndName = "[" + allWorkArrange.getRoute().getID() + "]" + allWorkArrange.getRoute().getName();
            String workTime = allWorkArrange.getRoute().getStartTime() + "->" + allWorkArrange.getRoute().getEndTime();

            model.addRow(new Object[]{time, driverId, licenseNum, routeIdAndName, workTime});
        }
    }
    // 初始化工作安排表 END

    // 车辆查询 BEGIN
    private void showAllBusLicenseNum() {
        BusSelectBusLicenseNum.removeAllItems();
        List<String> busLicenseNumbers = AdminEditBus.listBus2listBusLicenseNumber(AdminEditBus.queryAllBus());
        for (String busLicenseNumber : busLicenseNumbers) {
            BusSelectBusLicenseNum.addItem(busLicenseNumber);
        }
    }

    private void initBusSearchResult() {    // 初始化查询结果
        String licenseNum = (String) BusSelectBusLicenseNum.getSelectedItem();
        Bus bus = AdminEditBus.queryBusById(licenseNum);

        BusResultLicenseNumText.setText(bus.getLicenseNumber());
        BelongRouteIdText.setText(bus.getRID());
        SelectBusStatus.setSelected(bus.getStatus() == 1);
    }
    // 车辆查询 END

    // 车辆新增 BEGIN
    private void showAllRouteId() {
        List<String> routeIds = AdminEditBus.listRoute2listRouteId(AdminEditBus.queryRouteStatusIsOne());
        for (String routeId : routeIds) {
            NewSelectRouteId.addItem(routeId);
        }
    }
    // 车辆新增 END

    // 排班查询 BEGIN
    private void initScheduleQueryDialog() {
        SelectTime.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String time = (String) SelectTime.getSelectedItem();
                showDriverIsArrangedOnTheDay(time);
            }
        });
    }

    private void showDriverIsArrangedOnTheDay(String time) {
        SelectDID.removeAllItems();

        List<String> driverIds = AdminEditSchedule.listDriver2listDriverId(AdminEditSchedule.queryDriverIsArrangedOnTheDay(time));
        for (String driverId : driverIds) {
            SelectDID.addItem(driverId);
        }
    }

    private void showAllTime(JComboBox jComboBox) {
        jComboBox.removeAllItems();

        for (String day : AdminHomePage.dayOfWeek) {
            jComboBox.addItem(day);
        }
    }

    private void showAllBusAvailable(String time, JComboBox jComboBox) {
        jComboBox.removeAllItems();

        List<String> busLicenseNumbers = AdminEditSchedule.listBus2listBusLicenseNumber(AdminEditSchedule.queryBusAvailable(time));
        for (String busLicenseNumber : busLicenseNumbers) {
            jComboBox.addItem(busLicenseNumber);
        }
    }

    private void initQueryScheduleResult() {
        String DID = (String) SelectDID.getSelectedItem();
        String time = (String) SelectTime.getSelectedItem();

        Schedule schedule = new Schedule();
        schedule.setDID(DID);
        schedule.setTime(time);

        Schedule scheduleResult = AdminEditSchedule.queryScheduleById(schedule);

        ScheduleResultDIDText.setText(scheduleResult.getDID());
        ScheduleResultTimeText.setText(scheduleResult.getTime());

        showAllBusAvailable(time, ScheduleSelectBusLicenseNum);
        ScheduleSelectBusLicenseNum.addItem(scheduleResult.getLicenseNumber());
        ScheduleSelectBusLicenseNum.setSelectedItem(scheduleResult.getLicenseNumber());
    }
    // 排班查询 END

    // 排班新增 BEGIN
    private void initAddNewScheduleDialog() {
        SelectAddScheduleTime.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String time = (String) SelectAddScheduleTime.getSelectedItem();
                showDriverAvailable(time);
                showAllBusAvailable(time, SelectScheduleLicenseNum);
            }
        });
    }

    private void showDriverAvailable(String time) {
        List<String> driverIds = AdminEditSchedule.listDriver2listDriverId(AdminEditSchedule.queryDriverAvailable(time));

        SelectAddScheduleDID.removeAllItems();

        for (String driverId : driverIds) {
            SelectAddScheduleDID.addItem(driverId);
        }
    }
    // 排班新增 END
}
