package SmartBusSystem.UI;

import SmartBusSystem.Util.FileIOUtil;
import lombok.extern.slf4j.Slf4j;

import javax.swing.*;
import java.io.IOException;

@Slf4j
public class GenerateExcel extends CenterWindow {
    protected void ExportTable(JTable jTable, String tableName, JDialog success, JDialog failure) {
        try {
            FileIOUtil.JTable2Excel(jTable.getModel(), tableName);

            log.info("Excel导出成功");
            showInCenterOfFrame(success);
        } catch (IOException e) {
            log.warn("Excel导出失败");

            e.printStackTrace();
            showInCenterOfFrame(failure);
        }
    }
}
