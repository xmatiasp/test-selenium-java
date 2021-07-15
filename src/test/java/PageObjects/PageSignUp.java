package PageObjects;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageSignUp {
	
	private WebDriver driver;
	private By selectDay;
	private By selectMonth;
	private By selectYear;
	private By checkBox;
	
	public PageSignUp(WebDriver driver) {
		this.driver = driver;
		selectDay = By.id("days");
		selectMonth = By.id("months");
		selectYear = By.id("years");
		checkBox = By.id("uniform-newsletter");
	}
	
	public void SelectDateOfBirth(int valueDay, int valueMonth, int valueYear) {
		Select day = new Select(driver.findElement(selectDay));
		Select month = new Select(driver.findElement(selectMonth));
		Select year = new Select(driver.findElement(selectYear));
		
		day.selectByValue(Integer.toString(valueDay));;
		month.selectByValue(Integer.toString(valueMonth));
		year.selectByValue(Integer.toString(valueYear));
		
		File myScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(myScreenshot, new File
					("CreateAcc " + System.currentTimeMillis() + " .png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void selectCheckBoxNewsLetter() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement checkboxNews = wait.until(ExpectedConditions.elementToBeClickable(checkBox));
		checkboxNews.click();
	}
}
