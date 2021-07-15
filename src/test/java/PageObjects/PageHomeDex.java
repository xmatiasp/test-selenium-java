package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageHomeDex {
	
	private WebDriver driver;
	private By botonZapatillas;
	
	public PageHomeDex(WebDriver driver) {
		this.driver = driver;
		botonZapatillas = By.id("zapatillas");
		
	}
	
	public void clickZapatillas() {
		driver.findElement(botonZapatillas).click();
	}
}
