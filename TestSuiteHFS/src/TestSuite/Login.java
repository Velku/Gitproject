package TestSuite;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


public class Login {
	
	WebDriver driver;
	
	@BeforeSuite
	public void setup() {
		System.setProperty ("webdriver.driver.chrome", "C:\\Users\\VelkumarPalanisamy\\Sele Web Server.exe");
		}
	@BeforeClass
	public void browserlaunch() throws InterruptedException {
		org.openqa.selenium.chrome.ChromeOptions options = new org.openqa.selenium.chrome.ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.get("https://uatrapid.hfs.in/security/login");
		driver.manage().window().maximize();
		Thread.sleep(1000);
		}
	
	@Test
	public void login() {
		driver.findElement(By.id("username")).sendKeys("hfs005");
		driver.findElement(By.id("password")).sendKeys("hfs@123");
		Select dropd = new Select(driver.findElement(By.name("client_id")));
		dropd.selectByVisibleText("HFS_SBL");
		driver.findElement(By.xpath("//button[@id=\"loginbutton\"]")).click();
		}
	@Test(groups= {"mytask"})
	public void mytask() throws InterruptedException{
    driver.findElement(By.xpath("//span[contains(text(),'Credit')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//a[contains(text(),'Tray')]")).click();
	Thread.sleep(1000);
	WebElement my = driver.findElement(By.xpath("//a[contains(text(),'MY TASK')]"));
	my.click();
	Thread.sleep(4000);
	Actions act = new Actions(driver);
    act.sendKeys(Keys.PAGE_DOWN).build().perform();
    Thread.sleep(1000);
	driver.findElement(By.linkText("501265")).click();
	}
	
	
}
		
		
	
	
	
	
	


