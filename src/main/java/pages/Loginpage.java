package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Loginpage extends PageBase{
	WebDriverWait wait ;
	public Loginpage(WebDriver driver) {
		super(driver);
		wait=new WebDriverWait(driver,10);
	}
	
	@FindBy(name="username")
	WebElement usernametxtbox;
	
	@FindBy(name="password")
	WebElement passwordtxtbox;
	
	@FindBy(xpath="//button[@type='submit']")
   public WebElement loginbutton;
	
	
	public void WaitingAfterLogout()
	{
		wait.until(ExpectedConditions.visibilityOfAllElements(usernametxtbox,passwordtxtbox,loginbutton));
		
	}
	public void userlogin(String email, String password)
	{
		setTextElementText(usernametxtbox, email);
		setTextElementText(passwordtxtbox, password);
		clickButton(loginbutton);
	}

	

}
