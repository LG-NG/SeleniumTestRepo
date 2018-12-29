package testNG;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Amazon {
	public WebDriver driver;
	private static final Logger log = LogManager.getLogger(Amazon.class);
	
	static
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
		
	}
	@BeforeTest
	
	public void openURL ()
	{
		 log.info("Entering openURL method");
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		 driver.get("https://www.amazon.in");
	}

	
	@Test
	public void iphone6()
	{
		log.info("Entering iphone6 method");
		 WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		 
		 WebDriverWait wait = new WebDriverWait(driver,15);
		 wait.until(ExpectedConditions.elementToBeClickable(searchBox));
		
		 searchBox.sendKeys("iphone6");
		 driver.findElement(By.xpath("(//input[@type='submit'])[1]")).click();
		 List<WebElement> iphoneList = driver.findElements(By.xpath("//h2[starts-with(@data-attribute,'Apple iPhone 6 (')]"));
		 for(WebElement list:iphoneList)
		 {
			 System.out.println(list.getText());
		 }
		 log.info("Exiting iphone6 method");
		 
	}
	@AfterTest
	
	public void closeBrowser()
	{
		driver.close();
	}
		
		
	}

