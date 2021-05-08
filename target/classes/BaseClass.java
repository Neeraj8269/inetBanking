package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class BaseClass {

	public static WebDriver driver;
	public Properties prop;
	public Logger logger;
	
	

   public WebDriver setup() throws IOException 
     {
	   logger =LogManager.getLogger(BaseClass.class.getName());

       prop= new Properties();
       FileInputStream fis=new FileInputStream("./"+"\\src\\test\\java\\utilities\\data.properties");

       prop.load(fis);
       String browserName=prop.getProperty("browser");
       System.out.println(browserName);

if(browserName.contains("chrome"))
   {   
    System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
	ChromeOptions options = new ChromeOptions();
	  if(browserName.contains("headless"))
	  {
	  options.addArguments("headless");
	  }
		//execute in chrome driver
   driver= new ChromeDriver(options);
   }
else if (browserName.equals("firefox"))
   {    
	System.setProperty("webdriver.firefox.driver", System.getProperty("user.dir")+"\\Drivers\\geckodriver.exe");
	 driver= new FirefoxDriver();
	//firefox code
   }
else if (browserName.equals("IE"))
     {
//	IE code
     }
    driver.get(prop.getProperty("url"));
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    return driver;	
    }


public WebDriver teardown()
{
	driver.quit();
	return driver;
}
  
public void getScreenshot(String result) throws IOException
   {
	File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(src, new File("./Screenshots//"+result+"screenshot.png"));
    }

public String randomString()
   {
	String generateString = RandomStringUtils.randomAlphabetic(8);
	return(generateString);
   }
public static String randomNumbers()
   {
    String generateNo = RandomStringUtils.randomNumeric(4);
    return(generateNo);
   }
}
