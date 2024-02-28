package POM_mainPages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import POM_main.AbstarctComponents.AbstarctComponents;

public class ShoppingCartPage extends AbstarctComponents {
	 WebDriver driver;
	String addTocartProdukt = "";

	 
	public ShoppingCartPage(WebDriver driver)
	{
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this );
	}
	
	static By total = By.xpath("//span[@class='product-price order-total']");
	@FindBy(xpath="//span[@class='product-price order-total']")
	WebElement totalF;
	
	@FindBy(name="discountcouponcode")
	WebElement addDiscountCode;
	
	@FindBy(xpath="//input[@value='Apply coupon']")
	WebElement applyCoupon;
	
	@FindBy(xpath="//div[@class='message'][contains(.,'The coupon code was applied')]")
	WebElement couponApplied;
	By msgcodcouponApplied = By.xpath("//div[@class='message'][contains(.,'The coupon code was applied')]");
	
	@FindBy(id="checkout")
	WebElement checkout;
	
	@FindBy(xpath="//p[contains(.,'Please accept the terms of service before the next step.')]")
	WebElement termsOfService;
	By msgTermsOfService = By.xpath("//div[@id='terms-of-service-warning-box'][contains(.,'Please accept the terms of service before the next step.')]");
	
	@FindBy(xpath="//button[@title='close']")
	WebElement closeTermsOfService;

	@FindBy(id="termsofservice")
	WebElement termsofservice;
	
	
	public void EnterCoupon  (String discountCode)
	{
		addDiscountCode.sendKeys(discountCode);
		applyCoupon.click();
	    waitvisibilityOf(msgcodcouponApplied);
	}
	
	public void Checkout  ()
	{
		termsofservice.click();
		checkout.click();
	}
	
	public void CheckoutWithoutTermsOfService ()
	{
		checkout.click();
	}
	
	public void TermsOfServiceAppear  ()
	{
		checkout.click();
	    waitvisibilityOf(msgTermsOfService);	
	   // moveToElement(closeTermsOfService);
	 //   closeTermsOfService.click();
	    
	}
	
	public void CloseTermsOfService  ()
	{
		   closeTermsOfService.click();
	    
	}
	
	public   String PriceInfo (String totalBefore)
	{
		//String totalBefore= 
				driver.findElement(total).getText();
		return totalBefore;
		
	}
	
	
	

}

