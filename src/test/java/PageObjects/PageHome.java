package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import helpers.Helpers;

public class PageHome {
	
	private WebDriver driver;
	private By bannerText; 
	private By dressesButton;
	private By casualDressesButton;
	
	public PageHome(WebDriver Driver) {
		this.driver = Driver;
		bannerText = By.xpath("//*[@id=\"center_column\"]/h1/span[1]");
	}
	
	public void search(String product) {
		driver.findElement(By.id("search_query_top")).sendKeys(product);
		driver.findElement(By.name("submit_search")).click();
		Helpers helper = new Helpers();
		helper.sleepSeconds(5);
	}
	
	public void clickSignIn() {
		driver.findElement(By.className("login")).click();
	}
	
	public String returnBannerText() {
		return driver.findElement(bannerText).getText();
	}

}
