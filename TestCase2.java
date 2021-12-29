package pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase2 {
	static Login_Page login;
	static WebDriver driver;
	
  @Test
  public static void swagLogin() throws InterruptedException {
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
			login.type_UserName("gfdsg");
			login.type_Password("gsfdg");
			login.click_Login();
			
			//Verify ErrMsg
			String ActErrmsg=login.captureErr();
			System.out.println(ActErrmsg);
			String ExpErrmsg="Epic sadface: Username and password do not match any user in this service";
		   Assert.assertEquals(ActErrmsg, ExpErrmsg);
			driver.close();
			
  }
}
