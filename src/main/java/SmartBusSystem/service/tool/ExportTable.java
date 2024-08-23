package SmartBusSystem.service.tool;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.filechooser.FileSystemView;
import javax.swing.table.TableModel;
import java.awt.*;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExportTable {
    private final static Workbook workbook = new XSSFWorkbook();
    private final static Sheet sheet = workbook.createSheet();

    public static void JTable2Excel(TableModel tableModel, String excelName, Frame frame) throws IOException {
        // 创建表头行
        Row headRow = sheet.createRow(0);
        for (int col = 0; col < tableModel.getColumnCount(); col++) {
            Cell cell = headRow.createCell(col);
            cell.setCellValue(tableModel.getColumnName(col));
        }

        // 填充表格数据
        for (int row = 0; row < tableModel.getRowCount(); row++) {
            Row dataRow = sheet.createRow(row + 1);
            for (int col = 0; col < tableModel.getColumnCount(); col++) {
                Cell cell = dataRow.createCell(col);
                Object value = tableModel.getValueAt(row, col);

                if (value instanceof Number) {
                    cell.setCellValue(((Number) value).doubleValue());
                } else {
                    cell.setCellValue(value.toString());
                }
            }
        }

        // 调整列宽
        for (int col = 0; col < tableModel.getColumnCount(); col++) {
            sheet.autoSizeColumn(col);
        }

        FileOutputStream excelExport = new FileOutputStream(FileSystemView.getFileSystemView().getHomeDirectory() + "/" + excelName + ".xlsx");
        workbook.write(excelExport);
    }
}
