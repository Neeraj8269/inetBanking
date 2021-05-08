package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	public WebDriver driver;
    
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
    
	By UserId = By.name("uid");
	By password = By.name("password");
	By submit_button = By.name("btnLogin");
	By LogoutButton = By.xpath("//a[contains(text(),'Log out')]");
	
	
	public WebElement getUserId()
	{
		return driver.findElement(UserId);
	}
	
	public WebElement getPassword()
	{
		return driver.findElement(password);
	}
	
	public WebElement getSubmitButton()
	{
		return driver.findElement(submit_button);
	}
	
	public WebElement getLogoutButton()
	{
		return driver.findElement(LogoutButton);
	}
}
