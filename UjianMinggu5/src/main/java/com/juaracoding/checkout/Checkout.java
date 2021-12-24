package com.juaracoding.checkout;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.juaracoding.driver.DriverSingleton;

public class Checkout {
	
	private WebDriver driver;
	
	public Checkout() {
		
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css = "#header > div:nth-child(3) > div > div > div:nth-child(3) > div")
	private WebElement shoppingcart;
	
	@FindBy(css = "#button_order_cart")
	private WebElement btntocheckout;
	
	@FindBy(css ="#center_column > p.cart_navigation.clearfix > a")
	private List<WebElement> btnstep;
	
	public void toCheckOut() {
		shoppingcart.click();
	}
	
	public void nextStep2(int select) {
		
		btnstep.get(select).click();
		
	}
	
	@FindBy(css = "#center_column > form > div > p > a")
	private WebElement btnaddnewaddress;
	
	@FindBy( css = "#address1")
	private WebElement inputaddress;
	
	@FindBy(css = "#city")
	private WebElement inputcity;
	
	@FindBy(css = "#id_state")
	private WebElement inputstate;
	
	@FindBy(css = "#postcode")
	private WebElement inputpostcode;
	
	@FindBy(css = "#phone_mobile")
	private WebElement inputphonenumber;
	
	@FindBy(css = "#alias")
	private WebElement inputaliasaddress;
	
	@FindBy(css = "#submitAddress")
	private WebElement btnsubmitaddress;
	
	public void newAddres(String address, String city, 
			int selectstate, String postcode, String phonenumber, String alias) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", btnaddnewaddress);
		btnaddnewaddress.click();
		inputaddress.sendKeys(address);
		inputcity.sendKeys(city);
		lstState(selectstate);
		inputpostcode.sendKeys(postcode);
		inputphonenumber.sendKeys(phonenumber);
		inputaliasaddress.sendKeys(alias);
		btnsubmitaddress.click();
	}
	
	public void lstState (int selection) {
//		WebDriverWait wait = new WebDriverWait(driver,30);
//		wait.until(ExpectedConditions.elementToBeClickable(inputstate));
		
		inputstate.click();
		
		
		this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		List<Keys> lstSequence = new ArrayList<Keys>();
		for (int i = 0; i < selection; i++) {
			 lstSequence.add(Keys.DOWN);
		}
		lstSequence.add(Keys.ENTER);
		CharSequence[] cs = lstSequence.toArray(new CharSequence[lstSequence.size()]);
		Actions keyDown = new Actions(driver); keyDown.sendKeys(Keys.chord(cs)).perform();
	}
	
	@FindBy(css = "#id_address_delivery")
	private WebElement changeaddresdelivery;
	
	public void changeAddresDelivery() {
		Select s = new Select(changeaddresdelivery);
		s.selectByIndex(1);
	}
	
	@FindBy(css = "#center_column > form > p > button")
	private WebElement btnstep2;
	
	public void nextStep3() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,50);");
		btnstep2.click();
	}
	
	@FindBy(css = "#cgv")
	private WebElement btnagree;
	
	public void Aggre() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,50);");
		btnagree.click();
	}
	
	@FindBy(css = "#form > p > button")
	private WebElement btnstep3;
	
	public void nextStep4() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,50);");
		btnstep3.click();
	}
	
	@FindBy(css= "#HOOK_PAYMENT > div > div > p > a")
	private List<WebElement> btnpayment;
	
	@FindBy(css = "#cart_navigation > button")
	private WebElement btnconfirm;
	
	public void payment(int select) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500);");
		btnpayment.get(select).click();
		js.executeScript("window.scrollBy(0,50);");
		btnconfirm.click();
	}
	
}
