import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import POM_mainPages.LoginPage;

public class Login {
	WebDriver driver;

	
	@Parameters({"URL","Browser"})
	 @BeforeMethod
     
     public void preCondition(String URL, String Browser)

     {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\11392\\Downloads\\eclipse\\Selenium\\chromedriver_win32/chromedriver.exe");

        
		if(Browser.equalsIgnoreCase("Chrome"))		 
		 { 
			  driver = new ChromeDriver();  
		  }
		else if (Browser.equalsIgnoreCase("Edge"))
		 { 
		  driver = new EdgeDriver();
		  }
		
         driver.get(URL);
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

         System.out.println("Open Browser & URL ");

     }
	 
	   @Parameters({"email", "pass"})
	   @Test(groups = {"Smoke"})

     public void loginsuccess (String email, String pass )

     {      
		   LoginPage LoginPage = new LoginPage(driver);
		   LoginPage.ToLoginPage();
		   LoginPage.AddEmail(email);
		   LoginPage.AddPassword(pass);
		   LoginPage.loginButton();
		   LoginPage.ToLogoutPage();
	
           System.out.println("1. loginsuccess");
     }
	 
	 
	   @Parameters({"email", "invalidPass"})
	  @Test(groups = {"Regression"}, dependsOnMethods = {"loginsuccess"})

     public void invalidPassword ( String email, String invalidPass )

     {        
		    LoginPage LoginPage = new LoginPage(driver);
		    LoginPage.ToLoginPage();
		    LoginPage.AddEmail(email);
			LoginPage.AddPassword(invalidPass);
			LoginPage.loginButton();
		    LoginPage.InCorrectPass();
		    LoginPage.ToLoginPage();
		    
            System.out.println("2. invalidPassword");
     }
	   
	   @Parameters({ "invalidemail"})
		  @Test(groups = {"Regression"})

	     public void invalidUser( String invalidemail )

	     {     
		        LoginPage LoginPage = new LoginPage(driver);
		        LoginPage.ToLoginPage();
		        LoginPage.AddEmail(invalidemail);
				LoginPage.AddPassword("0");
				LoginPage.loginButton();
			    LoginPage.InCorrectUser();

	           System.out.println("3. invalidUser");
	     }
	   
	 @AfterMethod

	    public void postCondition()

	    {        
	        
	       driver.quit(); 
	        
	        System.out.println("Close Browser");
	    }
	 
}
