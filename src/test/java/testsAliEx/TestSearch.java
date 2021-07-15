package testsAliEx;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PageObjects.PageHomeDex;
import PageObjects.PageShoesLIst;

public class TestSearch {
	private WebDriver driver;
	@BeforeMethod
	public void SetUp() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.dexter.com.ar/");
		
	}
	
	@Test
	public void SortByLanzamiento() {
		PageHomeDex HomeDex = new PageHomeDex(driver);
		PageShoesLIst shoesList = new PageShoesLIst(driver);
		HomeDex.clickZapatillas();
		shoesList.selectOrder(2);
	}	
	
	@AfterMethod
	public void TearDown() {
		driver.close();
	}
}
