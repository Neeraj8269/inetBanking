package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.BaseClass;

public class AddCustomerPage extends BaseClass {
     
	public WebDriver driver;
	public AddCustomerPage(WebDriver driver)
	{
		this.driver = driver;
	}
	 
	By addCustomerLink = By.xpath("//a[contains(text(),'New Customer')]");
	By cutomerNameField = By.name("name");
	By genderRadioButton = By.name("rad1");
	By dateOfBirth = By.id("dob");
	By addressField = By.name("addr");
	By cityField = By.name("city");
	By stateField = By.name("state");
	By PinField = By.name("pinno");
	By mobileNoField = By.name("telephoneno");
	By emailidField =  By.name("emailid");
	By passwordField = By.name("password");
	By submitButton = By.name("sub");
	By contineLink = By.xpath("//a[continue(text(),'Continue')]");
	
	
	public WebElement getAddCustomerLink()
	{
		return driver.findElement(addCustomerLink);
	}
	public WebElement getCutomerNameField()
	{
		return driver.findElement(cutomerNameField);
	}
	public WebElement getGenderRadioButton()
	{
		return driver.findElement(genderRadioButton);
	}
	public WebElement getDateOfBirth()
	{
		return driver.findElement(dateOfBirth);
	}
	public WebElement getAddressField()
	{
		return driver.findElement(addressField);
	}
	public WebElement getCityField()
	{
		return driver.findElement(cityField);
	}
	public WebElement getstateField()
	{
		return driver.findElement(stateField);
	}
	public WebElement getPinField()
	{
		return driver.findElement(PinField);
	}
	public WebElement getMobileNoField()
	{
		return driver.findElement(mobileNoField);
	}
	public WebElement getEmailidField()
	{
		return driver.findElement(emailidField);
	}
	public WebElement getPasswordField()
	{
		return driver.findElement(passwordField);
	}
	public WebElement getSubmitButton()
	{
		return driver.findElement(submitButton);
	}
	public WebElement getcontineLink()
	{
		return driver.findElement(submitButton);
	}
}
