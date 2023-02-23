package com.tests;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tc_Login 
{

	WebDriver driver=null;
	
	@Test(priority = 1)
	public void luanch_Browser()
	{
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.testyou.in/Login.aspx");
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
	}
	
	@Test(priority = 3)
	public void login_Test()
	{
		
		
		driver.findElement(By.name("ctl00$CPHContainer$txtUserLogin")).sendKeys("maruthiraja@gmail.com");
		driver.findElement(By.name("ctl00$CPHContainer$txtPassword")).sendKeys("12345");
		driver.findElement(By.name("ctl00$CPHContainer$btnLoginn")).click();
		takescreenshots();
		
		
	}
	
	
	@Test(priority = 2)
	public void signUp_Test()
	{
		
		driver.findElement(By.xpath("//*[@id=\"ctl00_CPHContainer_pnl_login\"]/div[2]/div[1]/div[5]/div[2]/a/span")).click();
		driver.findElement(By.name("ctl00$CPHContainer$txtFname")).sendKeys("maruthi");
		driver.findElement(By.name("ctl00$CPHContainer$txtEmail")).sendKeys("maruthi@gmail.com");
		driver.findElement(By.name("ctl00$CPHContainer$txtUserLogin1")).sendKeys("maruthi123");
		driver.findElement(By.name("ctl00$CPHContainer$txtpassword")).sendKeys("maruthi123");
		driver.findElement(By.name("ctl00$CPHContainer$txtReType")).sendKeys("maruthi123");
		WebElement ele=driver.findElement(By.xpath("//div[@id='ctl00_CPHContainer_dxCaptcha_IMGD']"));
		
		String capch=ele.getText();
		driver.findElement(By.name("ctl00$CPHContainer$txtVarificationCode")).sendKeys(capch);
		driver.findElement(By.name("ctl00$CPHContainer$btnRegistration")).click();
		takescreenshots();
		driver.navigate().back();
		
		
		
	}
	
	public void takescreenshots()
	{
		
		TakesScreenshot screen=(TakesScreenshot)driver;
		File scrfile=screen.getScreenshotAs(OutputType.FILE);
		File destfile=new File("G:\\MavenProjectDemo\\maruthiqa\\screenshots\\login.png");
		try {
			FileUtils.copyFile(scrfile, destfile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
