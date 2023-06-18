package TestSuite;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Technical {
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
		driver.findElement(By.id("username")).sendKeys("Tech001");
		driver.findElement(By.id("password")).sendKeys("hfs@123");
		Select dropd = new Select(driver.findElement(By.name("client_id")));
		dropd.selectByVisibleText("HFS_SBL");
		driver.findElement(By.xpath("//button[@id=\"loginbutton\"]")).click();
		Thread.sleep(3000);
		driver.findElement(By.partialLinkText("501227")).click();
		}
	@Test(groups= {"techcapture"})
	public void techcapture() throws InterruptedException {
		Actions act = new Actions(driver);
	    act.sendKeys(Keys.PAGE_DOWN).build().perform();
	    Thread.sleep(3000);
	    }
	

}
