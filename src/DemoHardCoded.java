import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import POM_mainPages.LoginPage;

import java.time.Duration;

public class DemoHardCoded {

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
		


		//2 TC buying
		//Login
		
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.id("Email")).sendKeys(email);
		driver.findElement(By.cssSelector("input.password")).sendKeys(pass);
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		
		// add new product to cart and verify that it was added successfully
		driver.findElement(By.linkText("Computers")).click();
		driver.findElement(By.linkText("Desktops")).click();

		driver.findElement(By.xpath("//a[contains(.,'"+addTocartProdukt+"')]/parent::h2/following-sibling::div[@class='add-info']/descendant::input[@value='Add to cart']")).click();
		//driver.findElement(By.xpath("//a[contains(.,'Simple Computer')]/parent::h2/following-sibling::div[@class='add-info']/descendant::input[@value='Add to cart']")).click();
		driver.findElement(By.xpath("//label[contains(.,'Slow')]/preceding-sibling::input")).click();
		driver.findElement(By.xpath("//input[@value='Add to cart']")).click();
		
		WebElement successMSG = driver.findElement(By.xpath("//p[contains(.,'The product has been added to your ')]"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOf(successMSG));
		
		driver.findElement(By.id("topcartlink")).click();
		
		//Add discount code and verify that it gives 20% discount.

		String totalBefore = driver.findElement(By.xpath("//span[@class='product-price order-total']")).getText();
		System.out.println("totalBefore = " + totalBefore);

		driver.findElement(By.xpath("//input[@name='discountcouponcode']")).sendKeys(discountCode);
		driver.findElement(By.xpath("//input[@value='Apply coupon']")).click();
		
		WebElement couponApplied  = driver.findElement(By.xpath("//div[@class='message'][contains(.,'The coupon code was applied')]"));
		wait.until(ExpectedConditions.textToBePresentInElement(couponApplied, "The coupon code was applied"));
		
		String totalAfter = driver.findElement(By.xpath("//span[@class='product-price order-total']")).getText();
		System.out.println("totalAfter = " + totalAfter);
		
		String totalDiscount  = driver.findElement(By.xpath("//span[contains(.,'Discount')]/ancestor::td/following-sibling::td/descendant::span[@class='product-price']")).getText();
		System.out.println("totalDiscount  = " + totalDiscount);
		
		double discount = Double.valueOf(totalBefore);
		double percentage = (discount * 20/ 100 );
		System.out.println("percentage = " + percentage);
		
		//double discountAfter = percentage + totalAfter;
		//double discountAfter = Double.valueOf(percentage + totalAfter);

		/* 
		 
		 
		 
		  >>>>  >>>> >>>> >>>>                  to check this
		              Assert.assertEquals(percentage, totalDiscount );  
		              
		              */
		
		
		//verify that “Terms of service” is mandatory
		driver.findElement(By.id("checkout")).click();
		
		WebElement TermsOfService  = driver.findElement(By.xpath("//p[contains(.,'Please accept the terms of service before the next step.')]"));
		wait.until(ExpectedConditions.textToBePresentInElement(TermsOfService, "Please accept the terms of service before the next step."));

		driver.findElement(By.xpath("//button[@title='close']")).click();
		
		//click on T&C and check out
		driver.findElement(By.id("termsofservice")).click();
		driver.findElement(By.id("checkout")).click();
		
		//not possible to proceed without filling the mandatory data in the Billing Address
		
		driver.findElement(By.xpath("//li[@id='opc-confirm_order'][@class='tab-section']"));
		
		//adding address
		WebElement country = driver.findElement(By.id("BillingNewAddress_CountryId"));
		Select theCountry = new Select(country);
		theCountry.selectByVisibleText(countryAdd);
		
		driver.findElement(By.id("BillingNewAddress_City")).sendKeys(city);
		driver.findElement(By.id("BillingNewAddress_Address1")).sendKeys("123");
		driver.findElement(By.id("BillingNewAddress_ZipPostalCode")).sendKeys("123");
		driver.findElement(By.id("BillingNewAddress_PhoneNumber")).sendKeys("123456");
		
		driver.findElement(By.xpath("//input[@onclick='Billing.save()']")).click();
		driver.findElement(By.xpath("//input[@onclick='Shipping.save()']")).click();
		driver.findElement(By.xpath("//input[@onclick='ShippingMethod.save()']")).click();
		driver.findElement(By.xpath("//label[contains(.,'Credit Card')]/preceding-sibling::input")).click();
		driver.findElement(By.xpath("//input[@onclick='PaymentMethod.save()']")).click();
		
		
		//SelectCreidtcardInfo
		WebElement creditCardtype = driver.findElement(By.id("CreditCardType"));
		Select theCreditCard = new Select(creditCardtype);
		theCreditCard.selectByVisibleText(creditCard);
		driver.findElement(By.id("CardholderName")).sendKeys(CardholderName);
		driver.findElement(By.id("CardNumber")).sendKeys("4485564059489345");
		
		/*WebElement dateMonth = driver.findElement(By.id("ExpireMonth"));
		Select thedateMonth = new Select(dateMonth);
		thedateMonth.selectByValue(expirationDateMonth);
		
		WebElement dateYear = driver.findElement(By.id("ExpireYear"));
		Select thedateYear = new Select(dateYear);
		thedateYear.selectByValue(expirationDateYear);
	

		//            to ask >>>>   expirationDateMonth
		
	 /*   boolean month = (expirationDateMonth == 04);
		WebElement action = driver.findElement(By.xpath("//select[@id='ExpireMonth']/child::option"));

		while (!month)
		{ 		driver.findElement(By.linkText("04"));
	         //   action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		         action.click();
                 action.sendKeys(Keys.ARROW_DOWN).build().perform();
                 action.sendKeys(Keys.ENTER).perform(); 
		}
		*/
		
		
		
		 driver.findElement(By.xpath("//select[@id='ExpireMonth']")).click();
		 driver.findElement(By.xpath("//option[contains(.,'"+expirationDateMonth+"')]")).click();
		 driver.findElement(By.xpath("//select[@id='ExpireYear']")).click();
		 driver.findElement(By.xpath("//option[contains(.,'"+expirationDateYear+"')]")).click();
		//>> to check why cant  accept int
		 //driver.findElement(By.id("CardCode")).sendKeys(cardCode);
		 driver.findElement(By.id("CardCode")).sendKeys("123");
		 driver.findElement(By.xpath("//input[@onclick='PaymentInfo.save()']")).click();
		 driver.findElement(By.xpath("//input[@onclick='ConfirmOrder.save()']")).click();
		 
		 
		 WebElement  orderProcessed = driver.findElement(By.xpath("//strong[contains(.,'Your order has been successfully processed!')]"));
		 wait.until(ExpectedConditions.visibilityOf(orderProcessed));


         
		
		
		driver.close();

	}

}
