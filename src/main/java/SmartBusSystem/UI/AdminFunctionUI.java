/*
 * Created by JFormDesigner on Thu Jul 11 14:44:36 CST 2024
 */

package SmartBusSystem.UI;

import SmartBusSystem.pojo.Bus;
import SmartBusSystem.service.TableRow.WorkArrangeRow;
import SmartBusSystem.service.function.AdminHomePage;
import SmartBusSystem.service.function.AdminSearchBus;

import java.awt.*;
import java.awt.event.*;
import java.util.List;
import javax.swing.*;
import javax.swing.table.*;

/**
 * @author 87948
 */
public class AdminFunctionUI extends JFrame {
    public AdminFunctionUI() {
        initComponents();
        initAllWorkArrange();

        this.setVisible(true);
    }

    private void QueryBusMouseReleased(MouseEvent e) {
        // TODO add your code here
        showAllBusLicenseNum();
        QueryBusDialog.setVisible(true);
    }

    private void SearchBusButtonMouseReleased(MouseEvent e) {
        // TODO add your code here
        initBusSearchResult();
        BusSearchResult.setVisible(true);
    }

    private void BusInformationModifyButtonMouseReleased(MouseEvent e) {
        // TODO add your code here
        Bus bus = new Bus();
        bus.setLicenseNumber(BusResultLicenseNumText.getText());
        bus.setStatus(SelectBusStatus.isSelected() ? 1 : 0);
        AdminSearchBus.updateBusStatus(bus);

        Pass.setVisible(true);
        BusSearchResult.dispose();
    }

    private void LoginOutMouseReleased(MouseEvent e) {
        // TODO add your code here
        this.dispose();
        new LoginUI();
    }

    private void RefreshHomePageMouseReleased(MouseEvent e) {
        // TODO add your code here
        this.dispose();
        new AdminFunctionUI();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        TopMenu = new JMenuBar();
        Me = new JMenu();
        LoginOut = new JMenuItem();
        ServiceMenu = new JMenu();
        RefreshHomePage = new JMenuItem();
        QueryBus = new JMenuItem();
        Title = new JLabel();
        TablePane = new JScrollPane();
        AllWorkArrange = new JTable();
        QueryBusDialog = new JDialog();
        BusLicenseNum = new JLabel();
        SelectBusLicenseNum = new JComboBox();
        SearchBusButton = new JButton();
        BusSearchResult = new JDialog();
        BusResultLicenseNum = new JLabel();
        BusResultLicenseNumText = new JLabel();
        BusStatus = new JLabel();
        BelongRoute = new JLabel();
        BelongRouteIdText = new JLabel();
        BusInformationModifyButton = new JButton();
        SelectBusStatus = new JCheckBox();
        Pass = new JDialog();
        PassMessage = new JLabel();

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

                //---- QueryBus ----
                QueryBus.setText("\u8f66\u8f86\u67e5\u8be2");
                QueryBus.setFont(QueryBus.getFont().deriveFont(QueryBus.getFont().getSize() + 1f));
                QueryBus.setIconTextGap(0);
                QueryBus.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseReleased(MouseEvent e) {
                        QueryBusMouseReleased(e);
                    }
                });
                ServiceMenu.add(QueryBus);
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
            QueryBusDialogContentPane.add(SelectBusLicenseNum);
            SelectBusLicenseNum.setBounds(105, 30, 120, 20);

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
            BusInformationModifyButton.setBounds(100, 130, BusInformationModifyButton.getPreferredSize().width, 24);

            //---- SelectBusStatus ----
            SelectBusStatus.setText("\u6b63\u5e38");
            SelectBusStatus.setFont(SelectBusStatus.getFont().deriveFont(SelectBusStatus.getFont().getStyle() | Font.BOLD, SelectBusStatus.getFont().getSize() + 3f));
            SelectBusStatus.setFocusPainted(false);
            BusSearchResultContentPane.add(SelectBusStatus);
            SelectBusStatus.setBounds(new Rectangle(new Point(110, 90), SelectBusStatus.getPreferredSize()));

            BusSearchResultContentPane.setPreferredSize(new Dimension(290, 204));
            BusSearchResult.setSize(290, 204);
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
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JMenuBar TopMenu;
    private JMenu Me;
    private JMenuItem LoginOut;
    private JMenu ServiceMenu;
    private JMenuItem RefreshHomePage;
    private JMenuItem QueryBus;
    private JLabel Title;
    private JScrollPane TablePane;
    private JTable AllWorkArrange;
    private JDialog QueryBusDialog;
    private JLabel BusLicenseNum;
    private JComboBox SelectBusLicenseNum;
    private JButton SearchBusButton;
    private JDialog BusSearchResult;
    private JLabel BusResultLicenseNum;
    private JLabel BusResultLicenseNumText;
    private JLabel BusStatus;
    private JLabel BelongRoute;
    private JLabel BelongRouteIdText;
    private JButton BusInformationModifyButton;
    private JCheckBox SelectBusStatus;
    private JDialog Pass;
    private JLabel PassMessage;
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
        List<String> busLicenseNumbers = AdminSearchBus.listBus2listBusLicenseNumber(AdminSearchBus.queryAllBus());
        for (String busLicenseNumber : busLicenseNumbers) {
            SelectBusLicenseNum.addItem(busLicenseNumber);
        }
    }

    private void initBusSearchResult() {    // 初始化查询结果
        String licenseNum = (String) SelectBusLicenseNum.getSelectedItem();
        Bus bus = AdminSearchBus.queryBusById(licenseNum);

        BusResultLicenseNumText.setText(bus.getLicenseNumber());
        BelongRouteIdText.setText(bus.getRID());
        SelectBusStatus.setSelected(bus.getStatus() == 1);
    }
    // 车辆查询 END
}
