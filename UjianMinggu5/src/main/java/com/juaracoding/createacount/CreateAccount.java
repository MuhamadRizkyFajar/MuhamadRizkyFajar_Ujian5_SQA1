package com.juaracoding.createacount;

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

public class CreateAccount {
	
	private WebDriver driver;
	
	public CreateAccount() {
		
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css = "#header > div.nav > div > div > nav > div.header_user_info > a")
	private WebElement btnsignin;
	
	public void signIn() {
		btnsignin.click();
	}
	
	@FindBy(css = "#email_create")
	private WebElement inputemail;
	
	@FindBy(css = "#SubmitCreate")
	private WebElement btncreate;
	
	public void Create(String email) {
		inputemail.sendKeys(email);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500);");
		btncreate.click();
	}
	
	@FindBy(xpath = "//*[@class='top']")
	private List<WebElement> btngender;
	
	@FindBy(xpath = "//*[@data-validate='isName']")
	private List<WebElement> inputname;
	
	@FindBy(id = "passwd")
	private WebElement inputpasswd;
	
	@FindBy(xpath = "//*[@class='form-control']")
	private List<WebElement> inputdob;
	
	@FindBy(xpath = "//*[@type='checkbox']")
	private List<WebElement> btnchecker;
	
	@FindBy(css = "#company")
	private WebElement inputcompany;
	
	@FindBy( css = "#address1")
	private WebElement inputaddress;
	
	@FindBy( css = "#address2")
	private WebElement inputaddress2;
	
	@FindBy(css = "#city")
	private WebElement inputcity;
	
	@FindBy(css = "#id_state")
	private WebElement inputstate;
	
	@FindBy(css = "#postcode")
	private WebElement inputpostcode;
	
	@FindBy(css = "#other")
	private WebElement inputadditional;
	
	@FindBy(css = "#phone")
	private WebElement inputhomephone;
	
	@FindBy(css = "#phone_mobile")
	private WebElement inputphonenumber;
	
	@FindBy(css = "#submitAccount")
	private WebElement btnsubmit;
	
	public void DetailAccount(int select, String firstname, String lastname, String password, 
			String day, String month, String year, String company, String address, String address2, String city,int selectstate, 
			String postcode, String additional, String homephone,String phonenumber) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		btngender.get(select).click();
		inputname.get(0).sendKeys(firstname);
		inputname.get(1).sendKeys(lastname);
		inputpasswd.sendKeys(password);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", inputpasswd);
		inputdob.get(0).click();
		inputdob.get(0).sendKeys(day);
		inputdob.get(0).sendKeys(Keys.ENTER);
		inputdob.get(1).sendKeys(month);
		inputdob.get(1).sendKeys(Keys.ENTER);
		inputdob.get(2).sendKeys(year);
		inputdob.get(2).sendKeys(Keys.ENTER);
		btnchecker.get(0).click();
		btnchecker.get(1).click();
		js.executeScript("window.scrollBy(0,500);");
		inputcompany.sendKeys(company);
		inputaddress.sendKeys(address);
		inputaddress2.sendKeys(address2);
		inputcity.sendKeys(city);
		lstState(selectstate);
		inputpostcode.sendKeys(postcode);
		inputadditional.sendKeys(additional);
		inputhomephone.sendKeys(homephone);
		inputphonenumber.sendKeys(phonenumber);
		btnsubmit.click();
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
	
}
