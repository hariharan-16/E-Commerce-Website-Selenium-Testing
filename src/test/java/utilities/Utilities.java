package utilities;

import base.BaseClass;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.util.Date;

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

    public static String getScreenshot(WebDriver driver, String name) throws IOException {
        TakesScreenshot ss =  (TakesScreenshot)driver;
        File temp = ss.getScreenshotAs(OutputType.FILE);
        File perm = new File("screenshots/"+name+"_"+System.currentTimeMillis()+".png");
        FileHandler.copy(temp, perm);

        return "screenshots/"+name+"_"+System.currentTimeMillis()+".png";
    }

    public static String invalidEmail(){
        Date date = new Date();
        return "harioz1515@"+date.toString().replace(" ", "").replace(":", "");
    }

    public static String invalidPassword() {
        Date date = new Date();
        return date.toString().replace(" ", "_").replace(":", "_");
    }
}
