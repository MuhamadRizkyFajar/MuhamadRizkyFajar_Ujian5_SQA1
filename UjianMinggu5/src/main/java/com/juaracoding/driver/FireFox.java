package com.juaracoding.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FireFox implements DriverStrategy {

	public WebDriver setStrategy() {
		System.setProperty("webdriver.gecko.driver", "D:/DriverFirefox/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		return driver;
	}
	
	

}
