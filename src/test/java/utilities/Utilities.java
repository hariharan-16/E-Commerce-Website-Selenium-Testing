package utilities;

import base.BaseClass;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;

public class Utilities extends BaseClass {

    public Utilities() throws Exception {
        super();
    }

    public static final int IMPLICIT_WAIT = 10;

    public static String getExcelData(String sheetName, int rowNum, int cellNum) {

        XSSFSheet sheet = wb.getSheet(sheetName);
        XSSFRow row = sheet.getRow(rowNum);
        XSSFCell cell = row.getCell(cellNum);
        CellType cellType = cell.getCellType();
        String data = "";

        switch (cellType) {
            case STRING:
                data = cell.getStringCellValue();
                break;
            case NUMERIC:
                data = Integer.toString((int)cell.getNumericCellValue());
                break;
        }

        return data;
    }
}
