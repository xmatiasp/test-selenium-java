package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageCasualDressesList {
	private WebDriver driver;
	private By categoryNameBanner;
	
	public PageCasualDressesList(WebDriver driver) {
		this.driver = driver;
		categoryNameBanner = By.className("cat-name");
		
	}
	
	public String returnCategoryName() {
		return driver.findElement(categoryNameBanner).getText();
	}
}
