package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Registerpage extends PageBase {

	
	JavascriptExecutor js;
	
	WebDriverWait wait ;
	public Registerpage(WebDriver driver) {
		super(driver);
		 js=((JavascriptExecutor)driver);
		 
		 wait= new WebDriverWait(driver,10);

	}
	
	@FindBy(name="firstname")
	WebElement firstnametxtbox;

	@FindBy(name="lastname")
	WebElement lastnametxtbox;

	@FindBy(name="phone")
	WebElement phonenumbertxtbox;

	@FindBy(name="email")
	WebElement emailtxtbox;

	@FindBy(name="password")
	WebElement passwordtxtbox;

	@FindBy(name="confirmpassword")
	WebElement confirmpasswordtxtbox;
	
   // @FindBy(xpath="//*[@id=\"headersignupform\"]/div[8]/button")
	@FindBy(xpath= "//*[@id='headersignupform']/div[8]/button")
	public WebElement signupbutton;
	


	@FindBy(xpath= "//*[@id='headersignupform']/div[8]/button")
	public WebElement validationAlert;




	public void userregistration(String fname, String lname,String phone, String email ,String password,String confirmpassword) 
	{
		setTextElementText(firstnametxtbox, fname);
		setTextElementText(lastnametxtbox, lname);
		setTextElementText(phonenumbertxtbox, phone);
		setTextElementText(emailtxtbox, email);
		setTextElementText(passwordtxtbox, password);
		setTextElementText(confirmpasswordtxtbox, confirmpassword);
		//clickonbutton(signupbutton);
		
		js.executeScript("arguments[0].click();",signupbutton);
		
		
		//Actions actions = new Actions(driver);
		//actions.moveToElement(signupbutton).click().build().perform();
		//WebDriverWait wait2 = new WebDriverWait(driver, 20);
		//wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\\\"headersignupform\\\"]/div[8]/button")));
	
	}
	
	

	
	/*clickonbutton(countrycodeclick);
	clickonbutton(choosecodecountryphone);
	setTextElementText(phonetxtbox, phone);
	setTextElementText(companynametxtbox,company);
	setTextElementText(address1txtbox, address);
	setTextElementText(citynametxtbox, city);
	setTextElementText(statenametxtbox, state);
	setTextElementText(postalcodetxtbox, postal);
	setTextElementText(countryname, country);
	setTextElementText(mobilewhatsappnumber, phone);
	setTextElementText(passwordtxtbox, password);
	setTextElementText(confrimpasswordtxtbox, password);
	clickonbutton(notrobotcheck);
	clickonbutton(registerbutton);*/



}
