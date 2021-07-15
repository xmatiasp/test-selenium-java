package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageSignIn {
	
	private WebDriver driver;
	private By mailField;
	private By createButton;
	
	public PageSignIn(WebDriver Driver) {
		this.driver = Driver;
		mailField = By.id("email_create");
		createButton = By.id("SubmitCreate");
	}
	
	public void createAccount(String mail) {
		driver.findElement(mailField).sendKeys(mail);
		driver.findElement(createButton).click();	
	}

}
