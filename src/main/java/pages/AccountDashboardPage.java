package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountDashboardPage  extends PageBase{
	WebDriverWait wait ;
	public AccountDashboardPage(WebDriver driver) {
		super(driver);
		 wait= new WebDriverWait(driver,10);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//li[@class='d-none d-md-block fl']/div/a[@id='dropdownCurrency']")
public	WebElement selectlogoutoraccount;


	@FindBy(linkText="Logout")
public	WebElement logout;
	
	
	
	public void WaitsToDashboardElementsShown()
	
	{
		
		wait.until(ExpectedConditions.visibilityOf(selectlogoutoraccount));
	}
	
	public void userlogout()
	{

		clickButton(selectlogoutoraccount);
		clickButton(logout);

	}

}
