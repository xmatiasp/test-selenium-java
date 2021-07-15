package Tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PageObjects.PageHome;
import PageObjects.PageSignIn;
import PageObjects.PageSignUp;

public class TestsCreateAccount {
	private WebDriver driver;
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://automationpractice.com/index.php");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@Test
	public void createAccount() {
		PageHome homePage = new PageHome(driver);
		homePage.clickSignIn();
		PageSignIn signPage = new PageSignIn(driver);
		signPage.createAccount("prueba01@falsemail.com");
		PageSignUp signUpPage = new PageSignUp(driver);
		signUpPage.SelectDateOfBirth(19, 5, 1992);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
