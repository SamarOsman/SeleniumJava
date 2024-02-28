import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import POM_mainPages.Categories_Computers;
import POM_mainPages.CheckoutPage;
import POM_mainPages.Desktops_AddToCart;
import POM_mainPages.LoginPage;
import POM_mainPages.OrderProcessedPage;
import POM_mainPages.ProductSpecsPage;
import POM_mainPages.RegisterationPage;
import POM_mainPages.ShoppingCartPage;

import java.time.Duration;

public class DemoWebShop {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\11392\\Downloads\\eclipse\\Selenium\\chromedriver_win32/chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		String email ="samar.osman@example1.test";
		String pass ="Tosca123!";
		String addTocartProdukt ="Simple Computer";
		String discountCode ="AutomationDiscount2";
		String countryAdd ="Egypt";
		String city ="Cairo";
		int address = 123;
		int zip =1234;
		int mob =01456;
		String creditCard=" Visa";
		String CardholderName =" Barbara Gordon";
		//int cardNumber= 4485564059489345;
		int expirationDateMonth= 04;
		int expirationDateYear= 2023;
		int cardCode= 123;

		driver.get("http://demowebshop.tricentis.com");
		driver.manage().window().maximize();
		


		//Login
	

	    /*
		 LoginPage LoginPage = new LoginPage(driver);
		   LoginPage.ToLoginPage(email, pass);
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
		   ShoppingCartPage.EnterCoupon(discountCode);
		   
		   System.out.println("5. Add Discount");
		   
		//   System.out.println("totalBefore = " +PriceInfo.gettotal());
		   
				   ShoppingCartPage.Checkout();
				   ShoppingCartPage.TermsOfServiceAppear();
				   ShoppingCartPage.Checkout();
				   System.out.println(" TermsOfService");
				   
				   CheckoutPage CheckoutPage = new CheckoutPage(driver);
				   CheckoutPage.AddBillingAddress(countryAdd, city, "123", "123", "123");
				   System.out.println(" AddedBillingAddress");
				   
				   CheckoutPage.SelectShippingAddress();
				   System.out.println("AddedShippingAddress");
			
				   
				   CheckoutPage.SelectShippingMethod();
				   System.out.println("AddedShippingMethod");
				   
				   CheckoutPage.SelectPaymentMethod();
				   System.out.println("AddedPaymentMethod");
				   
				   CheckoutPage.AddPaymentInfo(CardholderName, "4485564059489345", "123");
				   System.out.println("AddedPaymentinfo");
				   
				   CheckoutPage.ConfirmOrder();
				   System.out.println("ConfirmedOrder");
				   
				   OrderProcessedPage OrderProcessedPage = new OrderProcessedPage(driver);
				   OrderProcessedPage.OrderProcessed();
				   System.out.println("OrderProcessed");
					  
				   OrderProcessedPage.ToLogoutPage();
				   */
		
		 String emailAddress = "";
		 String alphabet = "abcdef";
		 while (emailAddress.length() < 5) 
			{
			    int character = (int) (Math.random() * 6);
			    emailAddress += alphabet.substring(character, character + 1);
			    emailAddress += Integer.valueOf((int) (Math.random() * 99)).toString();
			    emailAddress += "@" + "domain" + ".com";
			}
			
		/*   WebElement waitRegister = driver.findElement(By.xpath("//a[@href='/register']"));
		   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		   wait.until(ExpectedConditions.visibilityOf(waitRegister));
		   waitRegister.click();
		   
			driver.findElement(By.id("gender-female")).click();
			driver.findElement(By.id("FirstName")).sendKeys(firstName);
			driver.findElement(By.id("LastName")).sendKeys(lastName);
			driver.findElement(By.id("Email")).sendKeys(emailAddress);
			driver.findElement(By.id("Password")).sendKeys(newpass);
			driver.findElement(By.id("ConfirmPassword")).sendKeys(newpass);
			driver.findElement(By.id("register-button")).click();
			System.out.println("emailAddress " + emailAddress);*/
		   
		
	}

}
