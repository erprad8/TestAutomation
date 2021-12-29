package topic_ObjectRepository;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class ReadPropFiles {
static WebDriver driver;
  @Test
  public void swagPage() throws IOException, InterruptedException {
	  
	  Properties prop=new Properties();
	  FileInputStream ip=new FileInputStream("D:/Trainings_BhanuSai/WeekendBatch_June13th_Selenium/MyWorkspace/pageobjectmodel/src/test/resources/myresourceFiles/config.properties");
	  prop.load(ip);
	  System.out.println("name");
	  //Name
	  String Name=prop.getProperty("name");
	  System.out.println(Name);
	  
	  //Age
	  String Age=prop.getProperty("age");
	  System.out.println(Age);
	  //URL
	  String URL=prop.getProperty("url");
	  System.out.println(URL);
	  
	  //Browser
	  String Browser=prop.getProperty("browser");
	  System.out.println(Browser);
	  
	  
	  if(Browser.equalsIgnoreCase("chrome"))
		{
			//TC-1 Launch Chrome   Browser 
			System.setProperty("webdriver.chrome.driver","D:\\Trainings_BhanuSai\\WeekendBatch_June13th_Selenium\\MyWorkspace\\Drivers\\chromedriver.exe");		
		    driver=new ChromeDriver();
		
		}
		else if(Browser.equalsIgnoreCase("edge"))
		{
			//TC-1 Launch Edge   Browser 
			System.setProperty("webdriver.edge.driver","D:\\Trainings_BhanuSai\\WeekendBatch_June13th_Selenium\\MyWorkspace\\Drivers\\edgedriver.exe");		
			driver=new EdgeDriver();
		
		}
		else if(Browser.equalsIgnoreCase("ff"))
		{
			//TC-1 Launch FF   Browser 
			System.setProperty("webdriver.gecko.driver","D:\\Trainings_BhanuSai\\WeekendBatch_June13th_Selenium\\MyWorkspace\\Drivers\\geckodriver.exe");		
			 driver=new FirefoxDriver();
			
		}
		
	  driver.get(URL);
	  Thread.sleep(4000);
	  //Fill UserName Textbox
	  driver.findElement(By.xpath(prop.getProperty("UserNameField"))).sendKeys(prop.getProperty("username"));
	  Thread.sleep(4000);
	  
	  //Fill Password  Textbox
	  driver.findElement(By.name(prop.getProperty("PasswordField"))).sendKeys(prop.getProperty("password"));
	  Thread.sleep(4000);
	  //Click Login Button
	  driver.findElement(By.xpath(prop.getProperty("LoginBttn"))).click();
	  Thread.sleep(4000);
	  driver.close();
  }
}
