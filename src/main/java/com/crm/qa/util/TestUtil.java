package com.crm.qa.util;

import com.crm.qa.base.TestBase;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestUtil extends TestBase {
   public static long PAGE_LOAD_TIMEOUT=20;
  public   static long IMPLICIT_WAIT=20;

    public static String testDataPath="C:\\Users\\Lenovo\\Desktop\\New folder (2)\\RestAssured\\freecrmtestautomation\\src\\main\\java\\com\\crm\\qa\\testdata\\Login.xlsx";

    static Workbook book;
    static org.apache.poi.ss.usermodel.Sheet sheet;
    public static Object[][] getTestData(String SheetName){
        FileInputStream file = null;
        try{
            file = new FileInputStream(testDataPath);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        try{
            book = WorkbookFactory.create(file);
        }catch(IOException | EncryptedDocumentException e){
            e.printStackTrace();
        }
        sheet = book.getSheet(SheetName);

        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

        for(int i=0;i<sheet.getLastRowNum();i++) {
            for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
                data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
            }
        }
        return data;
    }
}