package pageobjectmodel;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class TestCase1 {
	static Login_Page login;
	static WebDriver driver;
	
	@Test(dataProvider="testData")
  public static void swagLogin(String uname,String pwd) throws InterruptedException {
	//TC-1 Launch Edge   Browser 
			System.setProperty("webdriver.edge.driver","D:\\Trainings_BhanuSai\\WeekendBatch_June13th_Selenium\\MyWorkspace\\Drivers\\edgedriver.exe");		
			 driver=new EdgeDriver();
			//Goto Test URL https://www.saucedemo.com/
			driver.get("https://www.saucedemo.com/");
			Thread.sleep(4000);
			/*Class obj=new Class();
			obj.meth1();
			obj.meth2();*/
			login=new Login_Page(driver);
			//Fill UserName Textbox
			login.type_UserName(uname);
			login.type_Password(pwd);
			login.click_Login();
			driver.close();
			
	
  }
  
  
  @DataProvider(name="testData")
	public Object[][] readExcel() throws BiffException, IOException
	{
		
		//Open the Excel for read and write ,which is available under same package
		File f=new File("D:\\Trainings_BhanuSai\\WeekendBatch_June13th_Selenium\\MyWorkspace\\mySeleniumProject\\src\\topic_DataProvider\\TestData_SwagDemo.xls");
		
		Workbook w=Workbook.getWorkbook(f);
		Sheet s=w.getSheet(0);
		int noofRows=s.getRows();
		System.out.println(s.getRows());
		int noofColumns=s.getColumns();
		System.out.println(s.getColumns());
		//Creating an Array to store data of an excel sheet
		String inputDat[][]=new String[noofRows-1][noofColumns];
		
		int count=0;
		for(int i=1;i<noofRows;i++)
		{
			for (int j=0;j<noofColumns;j++)
			{
				
				Cell c=s.getCell(j,i);
				
				inputDat[count][j]=c.getContents();
			}
			count++;
		}
		return inputDat;
		
	}
	
}
