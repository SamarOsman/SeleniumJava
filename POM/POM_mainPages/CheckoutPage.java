package POM_mainPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import POM_main.AbstarctComponents.AbstarctComponents;

public class CheckoutPage extends AbstarctComponents {
	WebDriver driver;
	String addTocartProdukt = "";

	 
	public CheckoutPage(WebDriver driver)
	{
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this );
	}


	@FindBy(id="BillingNewAddress_CountryId")
	WebElement country;
	Select theCountry = new Select(country);
	
	@FindBy(id="BillingNewAddress_City")
	WebElement city;
	
	@FindBy(id="BillingNewAddress_Address1")
	WebElement address1;
	
	@FindBy(id="BillingNewAddress_ZipPostalCode")
	WebElement zipPostalCode;
	
	@FindBy(id="BillingNewAddress_PhoneNumber")
	WebElement phoneNumber;
	
	@FindBy(xpath="//span[contains(.,'Country is required')]")
	WebElement countryMandatory;
	
	@FindBy(xpath="//span[contains(.,'City is required')]")
	WebElement cityMandatory;
	
	@FindBy(xpath="//span[contains(.,' Street address is required')]")
	WebElement streetMandatory;
	
	@FindBy(xpath="//span[contains(.,'Zip / postal code is required')]")
	WebElement zipMandatory;
	@FindBy(xpath="//span[contains(.,'Phone is required')]")
	WebElement PhoneMandatory;
	
	@FindBy(xpath="//input[@onclick='Billing.save()']")
	WebElement billingAddressContinue;
	By billingAddress = By.xpath("//input[@onclick='Billing.save()']");
	
	@FindBy(xpath="//input[@onclick='Shipping.save()']")
	WebElement shippingAddressContinue;
	By shippingAddress = By.xpath("//input[@onclick='Shipping.save()']");
		
	@FindBy(xpath="//input[@onclick='ShippingMethod.save()']")
	WebElement shippingMethodContinue;
	By shippingMethod = By.xpath("//input[@onclick='ShippingMethod.save()']");
		
	@FindBy(xpath="//label[contains(.,'Credit Card')]/preceding-sibling::input")
	WebElement paymentMethodSelect;
	
	@FindBy(xpath="//input[@onclick='PaymentMethod.save()']")
	WebElement paymentMethodContinue;
	By paymentMethod = By.xpath("//input[@onclick='PaymentMethod.save()']");
	
	/*@FindBy(id="CreditCardType")
	WebElement visaType;
	Select theCreditCard = new Select(visaType);*/
	
	@FindBy(id="CardholderName")
	WebElement cardholderName;
	
	@FindBy(id="CardNumber")
	WebElement cardNumber;
		
	/*@FindBy(id="ExpireMonth")
	WebElement expireMonth;
	Select theExpireMonth = new Select(expireMonth);*/
	
	/*@FindBy(id="ExpireYear")
	WebElement expireYear;
	Select theExpireYear = new Select(expireYear);*/
	
	@FindBy(id="CardCode")
	WebElement cardCode;
	
	@FindBy(xpath="//input[@onclick='PaymentInfo.save()']")
	WebElement paymentInfoContinue;
	By paymentInfo = By.xpath("//input[@onclick='PaymentInfo.save()']");
	 
	@FindBy(xpath="//input[@onclick='ConfirmOrder.save()']")
	WebElement confirmOrderContinue;
	By confirmOrder = By.xpath("//input[@onclick='ConfirmOrder.save()']");
	
	
	
	public void BillingAddressMandatory ()
	{
		 waitvisibilityOf(billingAddress);
		 billingAddressContinue.click();
		 countryMandatory.isDisplayed();
		 streetMandatory.isDisplayed();
		 zipMandatory.isDisplayed();
		 PhoneMandatory.isDisplayed();
	}
	
	
	public void AddBillingAddress (String countryAdd, String cityAdd, String address1Add, String zipAdd, String phoneNumberAdd)
	{
		 waitvisibilityOf(billingAddress);
		 theCountry.selectByVisibleText(countryAdd);
		 city.sendKeys(cityAdd);
		 address1.sendKeys(address1Add);
		 zipPostalCode.sendKeys(zipAdd);
		 phoneNumber.sendKeys(phoneNumberAdd);
		 billingAddressContinue.click();
	}
	
	public void SelectShippingAddress ()
	{
		 waitvisibilityOf(shippingAddress);
		 shippingAddressContinue.click();
	}
	
	public void SelectShippingMethod ()
	{
		 waitvisibilityOf(shippingMethod);
		 shippingMethodContinue.click();
	}
	
	public void SelectPaymentMethod ()
	{
		 waitvisibilityOf(paymentMethod);
		 paymentMethodSelect.click();
		 paymentMethodContinue.click();
	}
	
	public void AddPaymentInfo (String cardholderNameAdd, String cardNumberAdd,
			  String cardCodeAdd)
	{
		 waitvisibilityOf(paymentInfo);
	//	 theCreditCard.selectByVisibleText(visaTypeAdd);
		 cardholderName.sendKeys(cardholderNameAdd);
		 cardNumber.sendKeys(cardNumberAdd);
	//	 theExpireMonth.selectByValue(expireMonthAdd);
	//	 theExpireYear.selectByValue(expireYearAdd);
		 cardCode.sendKeys(cardCodeAdd);
		 paymentInfoContinue.click();
	}
	
	public void ConfirmOrder ()
	{
		 waitvisibilityOf(confirmOrder);
		 confirmOrderContinue.click();
	}
}

