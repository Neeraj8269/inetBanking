package testCases;
import java.io.IOException;

import org.testng.annotations.Test;

import pageObjects.LoginPage;
import utilities.BaseClass;

@Test
public class TC_LoginTest_001 extends BaseClass
  {
     public void login() throws IOException
     {   driver = setup();
    	 LoginPage login = new LoginPage(driver);
         logger.info("Logger is working fine");
         login.getUserId().sendKeys("mngr324202");
         login.getPassword().sendKeys("zEjUbEh");
         logger.info("Logger is working fine again");
         login.getSubmitButton().click();
         driver = teardown();
         
     }
    
       
}
