package SmartBusSystem.UI;

import javax.swing.*;

public class CenterWindow extends JFrame {
    protected void setCenterOfFrame(JDialog jDialog) {
        // 会话框以当前窗体为参照居中展示
        jDialog.setLocationRelativeTo(this);
    }

    protected void showInCenterOfFrame(JDialog jDialog) {
        setCenterOfFrame(jDialog);
        jDialog.setVisible(true);
    }
}
