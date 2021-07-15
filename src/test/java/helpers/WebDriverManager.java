package helpers;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

public class WebDriverManager {
	
	public static void setWindowSize(WebDriver driver, String size) {
		if( size.toLowerCase() == "maximize") {
			driver.manage().window();}
		else if(size.toLowerCase() == "fullscreen") {
			driver.manage().window().fullscreen();
		}
	}
	
	public static void setWindowsSize(WebDriver driver, int x, int y) {
		driver.manage().window().setSize(new Dimension(x, y));
		
	}
	

}
