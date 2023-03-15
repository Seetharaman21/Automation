package com.profit.qa.testpages;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.gson.Gson;

public class ExcelToJson {
	
	
	    public static void main(String[] args) throws Exception {
			/*
			 * System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
			 * WebDriver driver = new ChromeDriver(); driver.get("https://example.com");
			 */

	        FileInputStream file = new FileInputStream("src/test/java/com/profit/qa/testpages/CheckClientData.xlsx");
	        XSSFWorkbook workbook = new XSSFWorkbook(file);
	        XSSFSheet sheet = workbook.getSheetAt(0);

	        // Create a map to store the column index for each column name
	        Map<String, Integer> columnMap = new HashMap<String, Integer>();
	        XSSFRow headerRow = sheet.getRow(0);
	        for (Cell cell : headerRow) {
	            columnMap.put(cell.getStringCellValue(), cell.getColumnIndex());
	        }

	        // Create a list to store the data from each row
	        List<Map<String, String>> dataList = new ArrayList<Map<String, String>>();

	        // Iterate through each row of the sheet
	        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
	            XSSFRow row = sheet.getRow(i);
	            Map<String, String> dataMap = new HashMap<String, String>();
	            // Iterate through each column of the row
	            for (String columnName : columnMap.keySet()) {
	                dataMap.put(columnName, row.getCell(columnMap.get(columnName)).getStringCellValue());
	            }
	            dataList.add(dataMap);
	        }

	        // Convert the data list to JSON format
	        Gson gson = new Gson();
	        String json = gson.toJson(dataList);
	        System.out.println(json);
	    }
}


