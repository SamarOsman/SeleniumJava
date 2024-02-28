package POM_mainPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import POM_main.AbstarctComponents.AbstarctComponents;

public class LoginPage extends AbstarctComponents {
	
	
	WebDriver driver;
	 
	public LoginPage(WebDriver driver)
	{
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this );
	}
	
	@FindBy(linkText="Log in")
	WebElement logInButtonHeader;
	
	@FindBy(id="Email")
	WebElement email;
	
	@FindBy(css="input.password")
	WebElement password;
	
	
	@FindBy(xpath="//input[@value='Log in']")
	WebElement loginButton;
	
	@FindBy(xpath="//a[contains(.,'Log out')]")
	WebElement logoutButton;
	By logout = By.xpath("//a[contains(.,'Log out')]");
	
	@FindBy(xpath="//li[contains(.,'The credentials provided are incorrect')]")
	WebElement incorrectCredentials;
	By incorrectCreden = By.xpath("//li[contains(.,'The credentials provided are incorrect')]");
	
	@FindBy(xpath="//span[contains(.,'Please enter a valid email address')]")
	WebElement invalidUser;
	By invalidUsername = By.xpath("//span[contains(.,'Please enter a valid email address')]");
	
	
	public void ToLoginPage ()
	{
		logInButtonHeader.click();
	}
	
	public void AddEmail (String emailAdd)
	{	
		email.sendKeys(emailAdd);	
	}
	public void AddPassword ( String passwordAdd)
	{
		password.sendKeys(passwordAdd);	
	}
	public void loginButton ( )
	{
		loginButton.click();
	}
	
	public void InCorrectPass ()
	{
	    waitvisibilityOf(incorrectCreden);
	    
	}
	
	public void InCorrectUser ()
	{
	    waitvisibilityOf(invalidUsername);
	    
	}
	

}