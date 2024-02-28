import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import POM_mainPages.RegisterationPage;

public class Registration {
	WebDriver driver;
//	String emailAddress = null;
	// not calling 
	//String emailAddress = "";
	
	
	@Parameters({"URL","Browser"})
	 @BeforeMethod
     
     public void preCondition(String URL,String Browser)

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
	 
	   @Parameters({"firstName", "lastName", "newpass"})
	   @Test(groups = {"Smoke"})

     public void Register (String firstName, String lastName, String newpass )

     {      
		 String emailAddress = "";
		 String alphabet = "abcdef";
		 while (emailAddress.length() < 5) 
			{
			    int character = (int) (Math.random() * 6);
			    emailAddress += alphabet.substring(character, character + 1);
			    emailAddress += Integer.valueOf((int) (Math.random() * 99)).toString();
			    emailAddress += "@" + "domain" + ".com";
			    
			}
		   System.out.println("emailAddress " + emailAddress);
		   
		   RegisterationPage RegisterationPage = new RegisterationPage(driver);
		   RegisterationPage.ToRegisterationPage();
		   RegisterationPage.GenderFemale();
		   RegisterationPage.FirstName(firstName);
		   RegisterationPage.LastName(lastName);
		   RegisterationPage.Email(emailAddress);
		   RegisterationPage.Password(newpass);
		   RegisterationPage.ConfirmPassword(newpass);
		   RegisterationPage.RegisterButtonClick();
		   RegisterationPage.RegisterCompleted();
		   System.out.println("emailAddress " + emailAddress);
		   RegisterationPage.ToLogoutPage();
           System.out.println("2. Register completed");
     }
		

	   @Parameters({"firstName", "lastName","email", "newpass" })
	 @Test(groups = {"Regression"})

     public void registerExist ( String firstName,String lastName, String email, String newpass )

     {        		  
		   RegisterationPage RegisterationPage = new RegisterationPage(driver);
		   RegisterationPage.ToRegisterationPage();
		   RegisterationPage.GenderFemale();
		   RegisterationPage.FirstName(firstName);
		   RegisterationPage.LastName(lastName);
		   RegisterationPage.Email(email);
		   RegisterationPage.Password(newpass);
		   RegisterationPage.ConfirmPassword(newpass);
		   RegisterationPage.RegisterButtonClick();
		   RegisterationPage.EmailExist();
           System.out.println("3. Register exist ");
     }
     
	 @AfterMethod

	    public void postCondition ()

	    {        
	        driver.quit(); 
	        System.out.println(" close Browser");
	    }
		
		
	/*  @AfterTest

      public void tearDown ()

      {
          System.out.println("5. Close Chrome & Application");
          driver.quit();        
      }*/
	  
	  @DataProvider
	  public String getData ()

      {
			String emailAddress = "";
			String alphabet = "abcdef";
			
			while (emailAddress.length() < 5) 
			{
			    int character = (int) (Math.random() * 6);
			    emailAddress += alphabet.substring(character, character + 1);
			emailAddress += Integer.valueOf((int) (Math.random() * 99)).toString();
			emailAddress += "@" + "domain" + ".com";
		}      
			return emailAddress;
      }
}
