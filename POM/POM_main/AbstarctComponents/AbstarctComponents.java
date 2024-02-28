package POM_main.AbstarctComponents;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstarctComponents {
	
	WebDriver driver;

	public AbstarctComponents(WebDriver driver) 
	{
		this.driver= driver;
		PageFactory.initElements(driver, this );

	}
	
	@FindBy(xpath="//a[contains(.,'Log out')]")
	WebElement logoutButton;
	By logout = By.xpath("//a[contains(.,'Log out')]");
	
	public void  waitvisibilityOf(By findBy) 
	{
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public void  waitInvisibilityOf(By findBy) 
	{
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	
	wait.until(ExpectedConditions.invisibilityOfElementLocated(findBy));
	}
	
	public void  moveToElement(WebElement WebElement ) 
	{
		   Actions actions = new Actions(driver);
		   actions.moveToElement(WebElement);
	
	}
	
	public void ToLogoutPage ()
	{
	    waitvisibilityOf(logout);
	    
		logoutButton.click();
	}
}
