package SmartBusSystem.UI;

import SmartBusSystem.service.tool.ExportTable;

import javax.swing.*;
import java.io.IOException;

public class GenerateExcel extends CenterWindow {
    protected void ExportTable(JTable jTable, String tableName, JDialog success, JDialog failure) {
        try {
            ExportTable.JTable2Excel(jTable.getModel(), tableName, this);
        } catch (IOException ex) {
            showInCenterOfFrame(failure);
            throw new RuntimeException(ex);
        }

        showInCenterOfFrame(success);
    }
}
