package POM_mainPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import POM_main.AbstarctComponents.AbstarctComponents;

public class ProductSpecsPage extends AbstarctComponents {
	WebDriver driver;
	String addTocartProdukt = "";

	 
	public ProductSpecsPage(WebDriver driver)
	{
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this );
	}

	@FindBy(xpath="//label[contains(.,'Slow')]/preceding-sibling::input")
	WebElement processorSelect;
	
	@FindBy(xpath="//input[@value='Add to cart']")
	WebElement addToCart;
	
	@FindBy(xpath="//p[contains(.,'The product has been added to your')]")
	WebElement produktAddedToCart;
	By productAdded = By.linkText("The product has been added to your");
	
	@FindBy(id="topcartlink")
	WebElement shoppingCart;
		

	public void SelectProcessor ()
	{
		processorSelect.click();
	}
	
	public void AddToCart ()
	{
		addToCart.click();
	}
	
	public void productAdded ()
	{
		waitInvisibilityOf(productAdded);
		
	}
	
	public void ToShoppingCart ()
	{
		shoppingCart.click();
	}
	
	

}

