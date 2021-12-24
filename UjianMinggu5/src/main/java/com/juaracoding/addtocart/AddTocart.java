package com.juaracoding.addtocart;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.juaracoding.driver.DriverSingleton;

public class AddTocart {
	
	private WebDriver driver;
	
	public AddTocart () {
		
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css = "#block_top_menu > ul > li:nth-child(2) > a")
	private WebElement btndress;
	
	@FindBy(css = "#subcategories > ul > li")
	private List<WebElement> btncategorydress;
	
	@FindBy(css = "#center_column > ul > li > div")
	private List<WebElement> btnselectitem;

	@FindBy(css = "#add_to_cart > button")
	private WebElement btnadd;
	
	public void menuDress(int selectcategorydress, int selectitem) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		lstdress(selectcategorydress);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500);");
		btnselectitem.get(selectitem).click();
		wait.until(ExpectedConditions.elementToBeClickable(btnadd));
		btnadd.click();
	}
	
	public void lstdress (int selection) {
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(btndress));
		
		btndress.click();
		btncategorydress.get(selection).click();
		
		
	}
	
	@FindBy(css = "#block_top_menu > ul > li:nth-child(3) > a")
	private WebElement btntshirt;
	
	public void menuTshirt( int selectitem) {
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(btntshirt));
		btntshirt.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500);");
		btnselectitem.get(selectitem).click();
		wait.until(ExpectedConditions.elementToBeClickable(btnadd));
		btnadd.click();
		
		
	}
	
	@FindBy(xpath = "//*[@class='button-container']/*")
	private List<WebElement> btnoption;
	
	public void nextStep(int selectnext) {
		
		btnoption.get(selectnext).click();
		
	}
	
}


//int size = btnoption.size();
//
//System.out.println(size);
//System.out.println();
//
//for (int i = 0; i < size; i++) {
//	System.out.println(btnoption.get(i).getText());
//}


