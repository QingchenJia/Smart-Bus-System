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
            NameText.setText("text");
            NameText.setFont(NameText.getFont().deriveFont(NameText.getFont().getSize() + 2f));
            TotalViewDialogContentPane.add(NameText);
            NameText.setBounds(105, 30, 120, 20);

            //---- IdText ----
            IdText.setText("text");
            IdText.setFont(IdText.getFont().deriveFont(IdText.getFont().getSize() + 2f));
            TotalViewDialogContentPane.add(IdText);
            IdText.setBounds(105, 55, 120, 20);

            //---- PhoneNumText ----
            PhoneNumText.setText("text");
            PhoneNumText.setFont(PhoneNumText.getFont().deriveFont(PhoneNumText.getFont().getSize() + 2f));
            TotalViewDialogContentPane.add(PhoneNumText);
            PhoneNumText.setBounds(125, 80, 125, 20);

            //---- AptitudeText ----
            AptitudeText.setText("text");
            AptitudeText.setFont(AptitudeText.getFont().deriveFont(AptitudeText.getFont().getSize() + 2f));
            TotalViewDialogContentPane.add(AptitudeText);
            AptitudeText.setBounds(105, 105, 55, 20);

            TotalViewDialogContentPane.setPreferredSize(new Dimension(280, 190));
            TotalViewDialog.pack();
            TotalViewDialog.setLocationRelativeTo(TotalViewDialog.getOwner());
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
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
    private String currentUserId;

    public String getCurrentUserId() {
        return currentUserId;
    }

    public void setCurrentUserId(String currentUserId) {
        this.currentUserId = currentUserId;
    }
}
