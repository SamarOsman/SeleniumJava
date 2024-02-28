import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import POM_mainPages.Categories_Computers;
import POM_mainPages.CheckoutPage;
import POM_mainPages.Desktops_AddToCart;
import POM_mainPages.LoginPage;
import POM_mainPages.ProductSpecsPage;
import POM_mainPages.ShoppingCartPage;

public class ValidationMsgs {
	WebDriver driver;
	
	
	@Parameters({"URL" ,"Browser"})
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
		
		//driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        System.out.println("Open Browser & URL ");

    }
	
	 @Parameters({"email", "pass"})
	   @Test(groups = {"Smoke"})
	
	public void AddToCart (String email, String pass)

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
		   System.out.println("4.AddToCart MSG");
		   
		   ProductSpecsPage.ToLogoutPage();
		   System.out.println("5. LogOut");

}
	 
	   @Parameters({"email", "pass"})
	   @Test(groups = {"Regression"})
	
	public void TermsOfServiceMandatory (String email, String pass)

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
		   ShoppingCartPage.CheckoutWithoutTermsOfService();
		   ShoppingCartPage.TermsOfServiceAppear();
		   ShoppingCartPage.CloseTermsOfService();
		   ShoppingCartPage.Checkout();
		   System.out.println("5. TermsOfService");
		   		   		   
		   ShoppingCartPage.ToLogoutPage();
		   System.out.println("6. LogOut");
		   
}
	   
	   @Parameters({"email", "pass"})
	   @Test(groups = {"Regression"})
	
	public void BillingAddressMandatory (String email, String pass)

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
		   ShoppingCartPage.Checkout();		  
		   System.out.println("TermsOfService");
		   
		   CheckoutPage CheckoutPage = new CheckoutPage(driver);
		   CheckoutPage.BillingAddressMandatory();
		   System.out.println("BillingAddress is Mandatory");
		   
		   CheckoutPage.ToLogoutPage();
		   System.out.println("5. LogOut");

}
	 
	   
	   @Parameters({"email", "pass", "discountCode"})
	   @Test(groups = {"Regression"})
	   public void AddDiscountCode (String email, String pass, String discountCode)

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
	 		   
	 		    String totalBefore = driver.findElement(By.xpath("//span[@class='product-price order-total']")).getText();			
				double doubleTotalBefore = Double.valueOf(totalBefore);			

	 		    ShoppingCartPage.EnterCoupon(discountCode);
	 		   
	 		    String totalAfter = driver.findElement(By.xpath("//span[@class='product-price order-total']")).getText();
				double doubTotalAfter = Double.valueOf(totalAfter);			
							
				double percentage = (doubleTotalBefore * 20/ 100 );
				int IntPercentage = (int) Math.round(percentage);
		        System.out.println(" percentage = " + IntPercentage);
		        		        
		        int IntTotalAfter = (int) Math.round(doubTotalAfter);
		        System.out.println("TotalAfter = " + IntTotalAfter);
						   
		        int IntTotalBefore = (int) Math.round(doubleTotalBefore);
				System.out.println("TotalBefore = " + IntTotalBefore);
					
			     int sum = IntPercentage + IntTotalAfter;
				System.out.println("sum = " + sum);
					
				Assert.assertEquals(IntTotalBefore, sum);
	 		   
	 		     ShoppingCartPage.ToLogoutPage();
	 		     System.out.println("6. LogOut");
 		   
	 }
	   
	 @AfterMethod
	    
public void postCondition()
	    {        	        
	       driver.quit(); 
	        System.out.println("Close Browser");
	    }
	 
}
