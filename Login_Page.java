package pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login_Page {
	WebDriver driver;
	
	//Specify the Object/Element Locators Here
	
	By UserNameField=By.xpath("//input[@name='user-name']");
	By PasswdField=By.xpath("//input[@name='password']");
	By LoginBtn=By.xpath("//input[@name='login-button']");		
	By ErrMsg_login=By.xpath("//h3[contains(text(),'Username and password')]");
	
	

	
/*	Non- POM Model
	//Fill UserName Textbox with Input
			driver.findElement(By.xpath("//input[@name='user-name']")).sendKeys("standard_user");
			Thread.sleep(4000);
			//Fill Password Textbox with Input
			driver.findElement(By.xpath("//input[@name='password']")).sendKeys("secret_sauce");
			Thread.sleep(4000);
			//Click on Login
			driver.findElement(By.xpath("//input[@name='login-button']")).click();
			Thread.sleep(4000);*/
	
	
	public Login_Page(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	public void type_UserName(String uname) throws InterruptedException
	{
		//Fill UserName Textbox with Input
		driver.findElement(UserNameField).sendKeys(uname);
		Thread.sleep(4000);
	}
	
	
	public void type_Password(String pwd) throws InterruptedException
	{
		//Fill Password Textbox with Input
		driver.findElement(PasswdField).sendKeys(pwd);
		Thread.sleep(4000);
	}
	
	public void click_Login() throws InterruptedException
	{
		
		//Click on Login
		driver.findElement(LoginBtn).click();
		Thread.sleep(4000);
	}
	
	public String captureErr()
	{
		return driver.findElement(ErrMsg_login).getText();
	}
	
	
	
	
	

			
			
}
