package com.juaracoding.main;

import java.io.File;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;

import com.juaracoding.addtocart.AddTocart;
import com.juaracoding.checkout.Checkout;
import com.juaracoding.createacount.CreateAccount;
import com.juaracoding.driver.DriverSingleton;

public class MainApp {
	
	public static void main(String[] args) {
		DriverSingleton driverSingleton = DriverSingleton.getInstance();
		WebDriver driver = DriverSingleton.getDriver();
		
		driver.get("http://automationpractice.com/");
		
		CreateAccount create = new CreateAccount();
		create.signIn();
		create.Create("test@newtestlast.com");
		create.DetailAccount(0, "First Test Name", "Last Test Name", "Fj2831", "28", 
				"june", "1998", "test st.", "test city",2, "15414", "081111111111");
		
		AddTocart add = new AddTocart();
		add.menuDress(2,2);
		add.nextStep(0);
		add.menuTshirt(0);
		add.nextStep(0);
		
		Checkout out = new Checkout();
		out.toCheckOut();
		out.nextStep2(0);
		out.newAddres("test2 st.", "test2 city", 4, "17453", "082222222222", "My Second Address");
		out.changeAddresDelivery();
		out.nextStep3();
		out.Aggre();
		out.nextStep4();
		out.payment(0);
	}

}
