package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Tests {
	private WebDriver driver;
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://automationpractice.com/index.php");
	}
	
	@Test
	public void searchSummerDresses() {
		driver.findElement(By.id("search_query_top")).sendKeys("summer dresses");
		driver.findElement(By.name("submit_search")).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"center_column\"]/h1/span[1]")).getText().contains("SUMMER DRESSES"));
	}
	
	@Test
	public void sortDressesBySize() {
		driver.findElement(By.className("sf-with-ul")).click();
		driver.findElement(By.className("checkbox")).click();
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
