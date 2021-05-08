package testCases;

import java.io.IOException;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import org.junit.Assert;
import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;
import utilities.BaseClass;

public class TC_AddCustomerTest_003 extends BaseClass {
	
 
	@Test
	public void AddCustomer() throws IOException, InterruptedException
	{   
	    driver = setup();
		LoginPage login = new LoginPage(driver);
		logger.info("Login page opened");
		login.getUserId().sendKeys("mngr324202");
		logger.info("Now details are filling on add customer form");
		login.getPassword().sendKeys("zEjUbEh");
		login.getSubmitButton().click();
		AddCustomerPage cust = new AddCustomerPage(driver);
	    cust.getAddCustomerLink().click();
		cust.getCutomerNameField().sendKeys("Test One");
		cust.getGenderRadioButton().click();
		WebElement DOB = cust.getDateOfBirth();
        DOB.sendKeys("0102");
        DOB.sendKeys(Keys.ARROW_RIGHT);
        DOB.sendKeys("1994");
        cust.getAddressField().sendKeys("Noida UP");
        cust.getCityField().sendKeys("Noida");
        cust.getstateField().sendKeys("UttarPradesh");
        cust.getPinField().sendKeys("201301");
        String mobileno = randomNumbers()+"123456";
        cust.getMobileNoField().sendKeys(mobileno);
        String email = randomString()+"@gmail.com";
        cust.getEmailidField().sendKeys(email);
        cust.getPasswordField().sendKeys("Test@123");
        logger.info("Details are filled on form");
        cust.getSubmitButton().click();
        logger.info("Details are submitted successfully");
        //cust.getcontineLink().click();
        
        Boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");
        if(res==true)
        {   logger.info("Customer registered successfully");
        	Assert.assertTrue(true);
        }
        else
        {   logger.info("Customer registration failed");
        	Assert.assertTrue(false);
        }
        driver = teardown();
	}
	
	
}


