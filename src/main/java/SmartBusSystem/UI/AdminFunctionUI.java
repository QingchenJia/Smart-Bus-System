/*
 * Created by JFormDesigner on Thu Jul 11 14:44:36 CST 2024
 */

package SmartBusSystem.UI;

import SmartBusSystem.service.TableRow.WorkArrangeRow;
import SmartBusSystem.service.function.AdminHomePage;

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
        AllWorkArrange = new JTable();

        //======== this ========
        setTitle("\u7ba1\u7406\u5458");
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
                Me.add(TotalView);

                //---- InformationModify ----
                InformationModify.setText("\u4fe1\u606f\u4fee\u6539");
                InformationModify.setBorderPainted(true);
                InformationModify.setIconTextGap(0);
                InformationModify.setFont(InformationModify.getFont().deriveFont(InformationModify.getFont().getSize() + 1f));
                Me.add(InformationModify);

                //---- LoginOut ----
                LoginOut.setText("\u8d26\u53f7\u9000\u51fa");
                LoginOut.setBorderPainted(true);
                LoginOut.setIconTextGap(0);
                LoginOut.setFont(LoginOut.getFont().deriveFont(LoginOut.getFont().getSize() + 1f));
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

            //---- AllWorkArrange ----
            AllWorkArrange.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                    "\u65e5\u671f", "\u53f8\u673a", "\u8f66\u8f86", "\u7ebf\u8def", "\u8fd0\u8425\u65f6\u95f4"
                }
            ) {
                boolean[] columnEditable = new boolean[] {
                    false, true, true, true, true
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
    private JTable AllWorkArrange;
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
}
