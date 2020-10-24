package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage extends PageBase {

	
	
	public Homepage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath="//div[@class='dropdown dropdown-login dropdown-tab']/a[@id='dropdownCurrency']")
	WebElement myaccountselect;
	
	@FindBy(linkText="Login")
	 WebElement selectlogin;
	
	@FindBy(linkText="Sign Up")
	WebElement selectsignup;
	
	public void selectLoginORSingup()
	{
		clickButton(myaccountselect);
	}
	
	public void clickonloginpage()
	{
		clickButton(selectlogin);
	}
	
	public void clickonsignuppage()
	{
		clickButton(selectsignup);
	}
	

}
