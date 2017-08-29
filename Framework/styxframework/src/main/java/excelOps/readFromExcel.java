package excelOps;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class readFromExcel {

    public Sheet getSheet(String filePath,String fileName,String sheetName) throws IOException {

    File file = new File(filePath+"\\"+fileName);
    FileInputStream inputStream = new FileInputStream(file);
    Workbook readWb = null;
    String fileExtensionName = fileName.substring(fileName.indexOf("."));
    if(fileExtensionName.equals(".xlsx")){
    	readWb = new XSSFWorkbook(inputStream);
    }
    else if(fileExtensionName.equals(".xls")){
    	readWb = new HSSFWorkbook(inputStream);
    }
    Sheet readSheet = readWb.getSheet(sheetName);
    return readSheet;
    }
    
    public String getValueFromSheet(Sheet readSheet, String columnName){
      String getValue;
      Row row = readSheet.getRow(1);
      int colNum = getColNum(readSheet, columnName);
      getValue = row.getCell(colNum).getStringCellValue();
      return getValue;
  }
    
    public int getColNum(Sheet readSheet, String colName){
    	int colCount = readSheet.getRow(0).getLastCellNum();
    	String colContent;
    	int i;
    	for(i = 0;i<colCount;i++) {
    		colContent = readSheet.getRow(0).getCell(i).getStringCellValue();
    		if (colContent.equals(colName)){
    			return i;
    		}
    	}
    	return 0;
    }
    
    public int getRowCount(Sheet readSheet){
        int rowCount = readSheet.getLastRowNum()-readSheet.getFirstRowNum();
        return rowCount;
    }
    
    public ArrayList<Integer> getRunnableTestCases(Sheet readSheet){
    	int rowTotal = getRowCount(readSheet);
    	ArrayList<Integer> arrRunnable = new ArrayList<Integer>();
    	for(int i=1;i<rowTotal;i++){
    		String runTest = readSheet.getRow(i).getCell(1).getStringCellValue();
    		if(runTest.contentEquals("Yes")){
    			arrRunnable.add(i);
    		}
    	}
		return arrRunnable;
    }
}
