package SmartBusSystem.UI;

import javax.swing.*;

public class CenterWindow extends JFrame {
    protected void setCenterOfFrame(JDialog jDialog) {
        jDialog.setLocationRelativeTo(this);
    }

    protected void showInCenterOfFrame(JDialog jDialog) {
        setCenterOfFrame(jDialog);
        jDialog.setVisible(true);
    }
}
