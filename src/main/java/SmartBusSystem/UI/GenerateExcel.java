package SmartBusSystem.UI;

import SmartBusSystem.Util.FileIOUtil;

import javax.swing.*;
import java.io.IOException;

public class GenerateExcel extends CenterWindow {
    protected void ExportTable(JTable jTable, String tableName, JDialog success, JDialog failure) {
        try {
            FileIOUtil.JTable2Excel(jTable.getModel(), tableName);
        } catch (IOException ex) {
            showInCenterOfFrame(failure);
            throw new RuntimeException(ex);
        }

        showInCenterOfFrame(success);
    }
}
