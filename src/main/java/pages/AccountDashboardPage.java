package pages;

import java.time.Duration;

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
		 wait= new WebDriverWait(driver,Duration.ofSeconds(20));
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//div[@class='nf-response-msg']/p")
public	WebElement submittedSuccessfully;


	
	
	public boolean WaitsToDashboardElementsShown()
	
	{
		boolean submittingSuccessfull=false;
		try {
		wait.until(ExpectedConditions.visibilityOf(submittedSuccessfully));
		submittingSuccessfull=true;
		}catch(Exception ex) {
			
			
		}
		return submittingSuccessfull;
	}
	/*
	public void userlogout()
	{

		clickButton(selectlogoutoraccount);
		clickButton(logout);

	}*/

}
