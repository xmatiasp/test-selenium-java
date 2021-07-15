package Tests;


import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PageObjects.PageCasualDressesList;
import PageObjects.PageHome;
import helpers.ScreenShooter;
import helpers.WebDriverManager;

public class Tests {
	private WebDriver driver;
	ArrayList<String> tabs;
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://automationpractice.com/index.php");
		/*JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		String googleWindow = "window.open('https://www.google.com')";
		javascriptExecutor.executeScript(googleWindow);
		tabs = new ArrayList<String>(driver.getWindowHandles());*/
	}
	
	@Test
	public void searchSummerDresses() {
		PageHome homePage = new PageHome(driver);
		homePage.search("SUMMER DRESSES");
		Assert.assertTrue(homePage.returnBannerText().contains("SUMMER "));
	}
	
	@Test(enabled = false)
	public void clickOnCasualDresses() {
		PageCasualDressesList catName = new PageCasualDressesList(driver);
		Actions action = new Actions(driver);
		WebElement element = driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/a"));
		action.moveToElement(element).build().perform();
		driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/ul/li[1]/a"))
		.click();
		Assert.assertEquals(catName.returnCategoryName(), "CASUAL DRESSES ");
		

		
	}
	
	@Test(enabled = false)
	public void sortDressesBySize() {
		driver.findElement(By.className("sf-with-ul")).click();
		driver.findElement(By.className("checkbox")).click();
		
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) {
		if (!result.isSuccess()) {
			ScreenShooter.takeScreenShot("error", driver);
		}
		
		
		driver.close();
	}
	
	//List<WebElement> nombreLista = driver.findElements(pasarle el By)
}
