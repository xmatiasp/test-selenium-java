package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class PageShoesLIst {
	
	private WebDriver driver;
	private By sortButton;
	
	public PageShoesLIst(WebDriver driver) {
		this.driver = driver;
		sortButton = By.className("custom-select");
	}
	
	public void selectOrder(int index) {
		Select selectLanazmiento = new Select(driver.findElement(sortButton));
		selectLanazmiento.selectByIndex(index);;
	}

}
