package com.profit.qa.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.profit.qa.Base.Base;

public class ClientData extends Base {

	public ClientData(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}

	public static Page page = new Page(driver, wait);
	
	 By AssignedOKR = By.xpath("//body//apptivo-profit-left-menu//a[@baseurl=\"/app/ng/profit.jsp#/pr/okrs/assigned-okrs\"]"); 
	public  void clientSetup() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, IOException
	{
		page.getInstance(PageMenus.class).enableOkrMenu(); 
		click(AssignedOKR); 
		System.out.println(readExcel().toString());
	}
	
	
	

		public Object[][] readExcel()throws IOException
		{

			String filePath = System.getProperty(("user.dir")) + "/src/test/java/com/profit/qa/testpages";
			String fileName = "CheckClientData.xlsx";
			String sheetName = "sheet1";

			File file = new File(filePath + "/" + fileName);
			FileInputStream inputStream = new FileInputStream(file);
			Workbook pageURL = null;

			String fileExtensionName = fileName.substring(fileName.indexOf("."));
			if (fileExtensionName.equals(".xlsx")) {
				pageURL = new XSSFWorkbook(inputStream);
			} else if (fileExtensionName.equals(".xls")) {
				pageURL = new HSSFWorkbook(inputStream);
			}

			Sheet loadURLSheet = pageURL.getSheet(sheetName);
			XSSFRow row = (XSSFRow) loadURLSheet.getRow(0);

			int RowNum = loadURLSheet.getPhysicalNumberOfRows();
			int ColNum = row.getLastCellNum();

			int rowCount = loadURLSheet.getLastRowNum();

			System.out.println("the no of rows are : " + rowCount);

			Object Data[][] = new Object[RowNum - 1][ColNum];

			for (int i = 0; i < RowNum - 1; i++) {
				XSSFRow row1 = (XSSFRow) loadURLSheet.getRow(i + 1);
				for (int j = 0; j < ColNum; j++) {
					if (row1 == null)
						Data[i][j] = "";
					else {
						XSSFCell cell = row1.getCell(j);
						if (cell == null)
							Data[i][j] = "";
						else {
							String value = cell.toString();
							Data[i][j] = value;
						}
					}
				}
			}
			return Data;
		}
	}
	
	
	

