package POM_mainPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import POM_main.AbstarctComponents.AbstarctComponents;

public class Desktops_AddToCart extends AbstarctComponents {
	WebDriver driver;
	String addTocartProdukt = "";

	 
	public Desktops_AddToCart(WebDriver driver)
	{
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this );
	}

	@FindBy(xpath="//a[contains(.,'Simple Computer')]/parent::h2/following-sibling::div[@class='add-info']/descendant::input[@value='Add to cart']")
	WebElement addToCart;
	
	@FindBy(xpath="//label[contains(.,'Qty:')]")
	WebElement produktAddedToCart;
	By produktSpecs = By.xpath("//label[contains(.,'Qty:')]");
	
	
	
	public void AddToCart ()
	{
		addToCart.click();
	}
	
	public void produktSpecs ()
	{
		waitvisibilityOf(produktSpecs);
	}

}

