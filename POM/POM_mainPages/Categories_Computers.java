package POM_mainPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import POM_main.AbstarctComponents.AbstarctComponents;

public class Categories_Computers extends AbstarctComponents{
	WebDriver driver;

	 
	public Categories_Computers(WebDriver driver)
	{
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this );
	}
	
	@FindBy(linkText="Computers")
	WebElement selectComputer;
	
	@FindBy(linkText="Desktops")
	WebElement selectDesktop;
	
	public void ToCategories_Computers ()
	{
		
		selectComputer.click();
		selectDesktop.click();

		
	}

}

