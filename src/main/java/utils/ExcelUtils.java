package utils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private DataFormatter formatter;

    public ExcelUtils(String path, String sheetName){
        try {
            workbook = new XSSFWorkbook(path);
            sheet = workbook.getSheet(sheetName);
            formatter = new DataFormatter();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Object getCellData(int rowNum, int colNum){
            Object value = formatter.formatCellValue(sheet.getRow(rowNum).getCell(colNum));
            return value;

    }

    public int getRowCount() {
            return sheet.getPhysicalNumberOfRows();
    }

    public int getColumnCount() {
        return sheet.getRow(0).getPhysicalNumberOfCells();
    }

}
