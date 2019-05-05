package TestScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGTestCase {
	WebDriver driver;
		
	
@BeforeMethod
public void Setup() {
	
    System.setProperty("webdriver.chrome.driver"  , "C:\\Drivers\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.manage().window().maximize();
    driver.manage().deleteAllCookies();
    
    driver.get("http://www.westpac.co.nz/");
    
}

@Test
public void NavigationToIconMessage() {
	driver.findElement(By.linkText("KiwiSaver calculator")).click();
	driver.findElement(By.linkText("Click here to get started.")).click();  
	
	  driver.switchTo().frame(0);
	  
	 WebElement icon =  driver.findElement(By.className("icon"));
	  System.out.println(icon.isDisplayed());
	  System.out.println(icon.isEnabled());
			  icon.click();

					
			  WebElement  msg=driver.findElement(By.cssSelector(".field-message.message-info.ng-binding"));
				System.out.println(msg.getText());
				
				String  Expmsg="This calculator has an age limit of 64 years old ";
				if(msg.getText().contains(Expmsg))
				{
					
					Assert.assertTrue(true, "Test case is passed");
				}
				else
				{
					
					Assert.assertFalse(false,"Test case is  false");
				}
			  
	
	
}
	
}
	







	

	
	
	
	
	
   

	
	
	
  
    
    
    
    
    
    

	

