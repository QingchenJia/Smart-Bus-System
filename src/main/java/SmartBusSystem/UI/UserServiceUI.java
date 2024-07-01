/*
 * Created by JFormDesigner on Mon Jul 01 20:22:42 CST 2024
 */

package SmartBusSystem.UI;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author 87948
 */
public class UserServiceUI extends JFrame {
    public UserServiceUI() {
        initComponents();
        this.setVisible(true);
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
        ReturnHomePage = new JMenuItem();
        Direction = new JMenuItem();
        StopQuery = new JMenuItem();
        RouteQuery = new JMenuItem();

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
                TotalView.setBorder(new MatteBorder(1, 1, 1, 1, Color.black));
                TotalView.setIconTextGap(0);
                TotalView.setFont(TotalView.getFont().deriveFont(TotalView.getFont().getSize() + 1f));
                Me.add(TotalView);

                //---- InformationModify ----
                InformationModify.setText("\u4fe1\u606f\u4fee\u6539");
                InformationModify.setBorderPainted(true);
                InformationModify.setBorder(new MatteBorder(1, 1, 1, 1, Color.black));
                InformationModify.setIconTextGap(0);
                InformationModify.setFont(InformationModify.getFont().deriveFont(InformationModify.getFont().getSize() + 1f));
                Me.add(InformationModify);

                //---- LoginOut ----
                LoginOut.setText("\u8d26\u53f7\u9000\u51fa");
                LoginOut.setBorderPainted(true);
                LoginOut.setBorder(new MatteBorder(1, 1, 1, 1, Color.black));
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
                ReturnHomePage.setBorder(new MatteBorder(1, 1, 1, 1, Color.black));
                ReturnHomePage.setIconTextGap(0);
                ReturnHomePage.setFont(ReturnHomePage.getFont().deriveFont(ReturnHomePage.getFont().getSize() + 1f));
                ServiceMenu.add(ReturnHomePage);

                //---- Direction ----
                Direction.setText("\u8def\u5f84\u5bfc\u822a");
                Direction.setBorderPainted(true);
                Direction.setBorder(new MatteBorder(1, 1, 1, 1, Color.black));
                Direction.setIconTextGap(0);
                Direction.setFont(Direction.getFont().deriveFont(Direction.getFont().getSize() + 1f));
                ServiceMenu.add(Direction);

                //---- StopQuery ----
                StopQuery.setText("\u7ad9\u70b9\u67e5\u8be2");
                StopQuery.setBorderPainted(true);
                StopQuery.setBorder(new MatteBorder(1, 1, 1, 1, Color.black));
                StopQuery.setIconTextGap(0);
                StopQuery.setFont(StopQuery.getFont().deriveFont(StopQuery.getFont().getSize() + 1f));
                ServiceMenu.add(StopQuery);

                //---- RouteQuery ----
                RouteQuery.setText("\u7ebf\u8def\u67e5\u8be2");
                RouteQuery.setFont(RouteQuery.getFont().deriveFont(RouteQuery.getFont().getSize() + 1f));
                RouteQuery.setIconTextGap(0);
                RouteQuery.setBorderPainted(true);
                RouteQuery.setBorder(new MatteBorder(1, 1, 1, 1, Color.black));
                ServiceMenu.add(RouteQuery);
            }
            TopMenu.add(ServiceMenu);
        }
        setJMenuBar(TopMenu);

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
    private JMenuItem ReturnHomePage;
    private JMenuItem Direction;
    private JMenuItem StopQuery;
    private JMenuItem RouteQuery;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
