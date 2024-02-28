package POM_mainPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import POM_main.AbstarctComponents.AbstarctComponents;

public class RegisterationPage extends AbstarctComponents{
	
	
	WebDriver driver;
	
	public RegisterationPage(WebDriver driver)
	{
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this );
	}
	
	@FindBy(xpath="//a[@href='/register']")
	WebElement registerButtonHeader;
	
	@FindBy(xpath="//strong[contains(.,'Your Personal Details')]")
	WebElement personalDetails;
	By yourPersonalDetails = By.xpath("//strong[contains(.,'Your Personal Details')]");
	
	@FindBy(id="gender-female")
	WebElement gender;
	
	@FindBy(id="FirstName")
	WebElement firstName;
	
	@FindBy(id="LastName")
	WebElement lastName;
	
	@FindBy(id="Email")
	WebElement email;
	
	@FindBy(id="Password")
	WebElement password;
	
	@FindBy(id="ConfirmPassword")
	WebElement confirmPassword;
	
	@FindBy(id="register-button")
	WebElement registerButton;
	
	@FindBy(xpath="//a[contains(.,'Log out')]")
	WebElement logoutButton;
	By logout = By.xpath("//a[contains(.,'Log out')]");
	
	
	@FindBy(xpath="//div[contains(.,'Your registration completed')]")
	WebElement registerCompleted;
	By registerCompletedMsg = By.xpath("//div[contains(.,'Your registration completed')]");
	
	@FindBy(xpath="//div[contains(.,'The specified email already exists')]")
	WebElement emailExist;
	By emailExistdMsg = By.xpath("//div[contains(.,'The specified email already exists')]");
	

	
	
	public void ToRegisterationPage ()
	{
		registerButtonHeader.click();
	    waitvisibilityOf(yourPersonalDetails);
	}
	
	public void GenderFemale ()
	{
		gender.click();		
	}
	
	public void FirstName (String firstNameAdd)
	{		
		firstName.sendKeys(firstNameAdd);
	}
	
	public void LastName (String lastNameAdd)
	{				
		lastName.sendKeys(lastNameAdd);		
	}
	
	public void Email (String emailAdd)
	{				
		email.sendKeys(emailAdd);
	}
	
	public void Password (String passwordAdd)
	{						
		password.sendKeys(passwordAdd);
	}
	
	public void ConfirmPassword (String confirmpassAdd)
	{						
		confirmPassword.sendKeys(confirmpassAdd);
	}
	
	public void RegisterButtonClick ( )
	{						
		registerButton.click();
	}
	
	public void RegisterCompleted ()
	{
	    waitvisibilityOf(registerCompletedMsg);
	    
	}
	
	public void EmailExist ()
	{
	    waitvisibilityOf(emailExistdMsg);
	    
	}
	

}