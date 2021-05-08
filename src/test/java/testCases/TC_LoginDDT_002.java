package testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import org.junit.Assert;
import pageObjects.LoginPage;
import utilities.BaseClass;
import utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass {
    
	
	@Test(dataProvider ="LoginData")
	public void loginDDT(String userID, String Password) throws IOException, InterruptedException
    {
    driver = setup();
	LoginPage login = new LoginPage(driver);
	login.getUserId().sendKeys(userID);
    logger.info("User name provided");
    login.getPassword().sendKeys(Password);
    logger.info("User name provided");
    login.getSubmitButton().click();
    logger.info("Clicked on submit button"); 
    Thread.sleep(3000);
    
    if(isAlertPresent()==true)
      {
    	driver.switchTo().alert().accept();
    	logger.warn("Login Failed");
    	driver.switchTo().defaultContent();
    	
    	Assert.assertTrue(false);
    	
      }
    else
    {   Assert.assertTrue(true);
    	login.getLogoutButton().click();
    	logger.info("Login Passed");
    	driver.switchTo().alert().accept();
    	Thread.sleep(3000);
    	driver.switchTo().defaultContent();
    	
    }
     driver  = teardown();
    }  
    
    
    public boolean isAlertPresent()
    {
    	try
    	{
    		driver.switchTo().alert();
    		return true;
    	}
    	catch(NoAlertPresentException e)
    	{
    		return false;
    	}
    	
    }
	
	
	@DataProvider(name="LoginData")
	String [][] getData() throws IOException
	{
		String path="C:\\Users\\Neera\\NeerajEclipseProjects\\inetBanking\\src\\test\\java\\testData\\LoginData.xlsx";
		
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path,"Sheet1",1);
		
		String logindata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j);//1 0
			}
				
		}
	return logindata;
	}
	
	
}
