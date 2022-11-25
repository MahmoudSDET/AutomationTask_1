package pages;


import java.time.Duration;
import java.util.List;

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
		 
		 wait= new WebDriverWait(driver,Duration.ofSeconds(20));

	}
	
	@FindBy(name="fname")
	WebElement firstnametxtbox;

	@FindBy(name="lname")
	WebElement lastnametxtbox;

	@FindBy(xpath="//label[text()='Phone  ']/parent::div/following-sibling::div/input")
	WebElement phonenumbertxtbox;

	@FindBy(name="email")
	WebElement emailtxtbox;

	@FindBy(name="password")
	WebElement passwordtxtbox;

	@FindBy(name="confirmpassword")
	WebElement confirmpasswordtxtbox;
	
   // @FindBy(xpath="//*[@id=\"headersignupform\"]/div[8]/button")
	@FindBy(xpath= "//input[@value='Register']")
	public WebElement signupbutton;
	


	@FindBy(xpath= "//div[@class='nf-form-errors']/nf-errors/nf-section/div")
	public WebElement validationAlert;


	@FindBy(xpath= "//div[@class='nf-error-wrap nf-error']/div")
	public  List<WebElement> fieldAlert;

	public void userregistration(String fname, String lname,String phone, String email,String herafrom ) throws InterruptedException 
	{
		setTextElementText(firstnametxtbox, fname);
		setTextElementText(lastnametxtbox, lname);
		setTextElementText(phonenumbertxtbox, phone);
		setTextElementText(emailtxtbox, email);
		
		
		WebElement  HereFrom= driver.findElement(By.xpath("//label[text()='"+herafrom+"']/preceding-sibling::input"));
		js.executeScript("arguments[0].scrollIntoView();",HereFrom);
		Thread.sleep(5000);
		//wait.until(ExpectedConditions.elementToBeClickable(HereFrom)).click();
		
		js.executeScript("arguments[0].click();",HereFrom);
		//setTextElementText(passwordtxtbox, password);
		//setTextElementText(confirmpasswordtxtbox, confirmpassword);
		//clickonbutton(signupbutton);
		signupbutton.click();
		//js.executeScript("arguments[0].click();",signupbutton);
		
		
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
