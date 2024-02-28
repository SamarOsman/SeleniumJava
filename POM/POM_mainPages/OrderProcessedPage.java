package POM_mainPages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import POM_main.AbstarctComponents.AbstarctComponents;

public class OrderProcessedPage extends AbstarctComponents {
	WebDriver driver;
	String addTocartProdukt = "";

	 
	public OrderProcessedPage(WebDriver driver)
	{
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this );
	}

	@FindBy(xpath="//strong[contains(.,'Your order has been successfully processed!')]")
	WebElement orderProcessed;
	By orderProcessedMsg = By.xpath("//strong[contains(.,'Your order has been successfully processed!')]");
	

	public void OrderProcessed ()
	{
		waitvisibilityOf(orderProcessedMsg);
		
	}
	

	

}

