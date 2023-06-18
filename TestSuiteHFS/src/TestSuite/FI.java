package TestSuite;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class FI {
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
	public void login() throws InterruptedException {
		driver.findElement(By.id("username")).sendKeys("V01470");
		driver.findElement(By.id("password")).sendKeys("hfs@123");
		Select dropd = new Select(driver.findElement(By.name("client_id")));
		dropd.selectByVisibleText("HFS_SBL");
		driver.findElement(By.xpath("//button[@id=\"loginbutton\"]")).click();
		Thread.sleep(3000);
		driver.findElement(By.partialLinkText("501235")).click();
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		((JavascriptExecutor)driver).executeScript("Scroll(0,400)");
		
		}

}
