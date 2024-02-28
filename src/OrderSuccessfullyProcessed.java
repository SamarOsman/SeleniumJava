import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import POM_mainPages.Categories_Computers;
import POM_mainPages.CheckoutPage;
import POM_mainPages.Desktops_AddToCart;
import POM_mainPages.LoginPage;
import POM_mainPages.OrderProcessedPage;
import POM_mainPages.ProductSpecsPage;
import POM_mainPages.ShoppingCartPage;

public class OrderSuccessfullyProcessed {
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
	 
	   @Parameters({"email", "pass", "discountCode","country", "city", "address","zip","mob",
		   "visaType","CardholderName", "cardNumber", "expirationDateMonth","expirationDateYear","cardCode" })
	   @Test(groups = {"Smoke"})

     public void endToEnd (String email, String pass, String discountCode, String country, String city, String address, String zip, String mob, String visaType, String CardholderName, String cardNumber, String expirationDateMonth, String expirationDateYear, String cardCode)

     {      
		   LoginPage LoginPage = new LoginPage(driver);
		   LoginPage.ToLoginPage();
		   LoginPage.AddEmail(email);
		   LoginPage.AddPassword(pass);
		   LoginPage.loginButton();
           System.out.println("1. LoginPage");
           
           Categories_Computers Categories_Computers = new Categories_Computers(driver);
   		   Categories_Computers.ToCategories_Computers();
   		   System.out.println("2. ToCategories_Computers");
   		   
   	       Desktops_AddToCart Desktops_AddToCart = new Desktops_AddToCart(driver);
   	       Desktops_AddToCart.AddToCart();
   	       Desktops_AddToCart.produktSpecs();
		   System.out.println("3. AddToCart");
		   
		   ProductSpecsPage ProductSpecsPage = new ProductSpecsPage(driver);
		   ProductSpecsPage.SelectProcessor();
		   ProductSpecsPage.AddToCart();
		   ProductSpecsPage.productAdded();
		   ProductSpecsPage.ToShoppingCart();
		   System.out.println("4.ToShoppingCart");
		   
		   ShoppingCartPage ShoppingCartPage = new ShoppingCartPage(driver);
	//	   ShoppingCartPage.EnterCoupon(discountCode);
	//	   System.out.println("5. Add Discount");
		   
		//   System.out.println("totalBefore = " +PriceInfo.gettotal());
		   
		   //ShoppingCartPage.Checkout();
		  // ShoppingCartPage.TermsOfServiceAppear();
		   ShoppingCartPage.Checkout();
		   System.out.println("TermsOfService");
		   
		   CheckoutPage CheckoutPage = new CheckoutPage(driver);
		   CheckoutPage.AddBillingAddress(country, city, address, zip, mob);
		   System.out.println("AddedBillingAddress");
		   		   
		   CheckoutPage.SelectShippingAddress();
		   System.out.println("AddedShippingAddress");
			   
		   CheckoutPage.SelectShippingMethod();
		   System.out.println("AddedShippingMethod");
		   
		   CheckoutPage.SelectPaymentMethod();
		   System.out.println("AddedPaymentMethod");
		   
		//  CheckoutPage.AddPaymentInfo(CardholderName, cardNumber, expirationDateMonth, expirationDateYear, cardCode);
		    CheckoutPage.AddPaymentInfo(CardholderName, cardNumber, cardCode);

		   System.out.println("AddedPaymentinfo");
		   
		   CheckoutPage.ConfirmOrder();
		   System.out.println("ConfirmedOrder");
		   
		   OrderProcessedPage OrderProcessedPage = new OrderProcessedPage(driver);
		   OrderProcessedPage.OrderProcessed();
		   System.out.println("OrderProcessed");
			  
		   OrderProcessedPage.ToLogoutPage();
     }
	   
	   @AfterMethod
	    public void postCondition()
	    {        	        
	       driver.quit(); 
	        System.out.println("Close Browser");
	    }

}
