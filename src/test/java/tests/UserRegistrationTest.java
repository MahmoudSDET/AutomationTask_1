package tests;
import static org.testng.AssertJUnit.assertTrue;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.annotations.DataProvider;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.internal.annotations.ITest;

import com.github.javafaker.Faker;


import Data.ExcelReaderAndWriter;
import pages.AccountDashboardPage;

import pages.Registerpage;




@Test
public class UserRegistrationTest extends TestBase {
	
	public UserRegistrationTest() throws IOException {
		super();
		
	}
	Faker fakeData = new Faker();
	Registerpage registerobject;
	
	AccountDashboardPage DashboardPage;
	
	//1.Valid FirstName which must start with capital letter
	String Validfname = "M"+fakeData.name().firstName();
	//(Non-Valid) FirstName  start with small letter
	String NValidfname = "m"+fakeData.name().firstName();
	//2.1 Last Name which must start with capital letter 
	String Validlname = "M"+fakeData.name().lastName();
	//2.2 Last Name which  start with small letter
	String NValidlname_1 = "m"+fakeData.name().lastName();
	
	//2.3 Last Name which is equal to Valid first name
	String NValidlname_2=Validfname;
	//3. Valid mobile number
	String Vmobile = fakeData.phoneNumber().cellPhone();
	
	//4. NonValid Mobile Number
	
	String NVmobile ="trst456789";
	//5.1 Valid Unique Email
	String VEmail = fakeData.internet().emailAddress();
	// 5.2 Registerd Email
	 
	String email_Matched=VEmail ;
	 // 5.3
	 
	 String email_3="test@test";

	
	//6. Valid Password
	String password = fakeData.number().digits(8).toString()+"MN"+"on";
	//6.1. NON Valid Password
	String NVpassword = fakeData.number().digits(6).toString();
	//7.1 Valid Confirmed Password
	
	String confirmedPass_1=password;
	String Nvalidwithconfirmedpassword=NVpassword;
	// 7.2 Non Valid confirmed password (Non Matched with valid password)
	String confirmedPass_2=fakeData.number().digits(6).toString();
	
	
	// verify valid data and invalid data
	
	
	String Data_Specification="";
	// create instance to make Write Data
	ExcelReaderAndWriter ER = new ExcelReaderAndWriter();
	
	
	
	

@Test(priority=1)
	
	public void UserCanRegisterWithVaildData() throws IOException, InterruptedException 
	{
	
		TestBase.extentTest = TestBase.extent.startTest("User Can Register With Vaild Data");
		registerobject= new Registerpage(driver);
		
		DashboardPage=new AccountDashboardPage(driver);
		
		
		registerobject.userregistration(Validfname,Validlname, Vmobile, VEmail, prop.getProperty("HereFrom"));
	//	ER.copydatatofile(Validfname,Validlname,Vmobile, VEmail, password,Data_Specification);
		assertEquals(DashboardPage.WaitsToDashboardElementsShown(), true,"we can register with valid and happy scenarios");

		
		/*
		softAssertion.assertTrue(DashboardPage.selectlogoutoraccount.isDisplayed());
		softAssertion.assertTrue(DashboardPage.selectlogoutoraccount.isEnabled());
		softAssertion.assertAll();
		*/
		
		//registerobject.userlogout();
		//loginobject.userlogin(email, password);
	

	}
	
	
	
@Test (priority=2)
public void UserCannotRegisterWithFirstnNameStartsWithSmallLetter() throws IOException, InterruptedException 
	{
	
	   String VEmail_1 = fakeData.internet().emailAddress();
	   
	
		TestBase.extentTest = TestBase.extent.startTest("User Cannot Register With Firstname Starts With Small Letter");
		registerobject= new Registerpage(driver);
		DashboardPage=new AccountDashboardPage(driver);
		
		
		
       
		registerobject.userregistration(NValidfname,Validlname, Vmobile, VEmail_1,prop.getProperty("HereFrom"));
		assertEquals(DashboardPage.WaitsToDashboardElementsShown(), false,"we can register with small letters on last name");
	    
		Thread.sleep(3000);
	}



@Test(priority=3)
public void UserCannotRegisterWithLastNameStartsWithSmallLetter() throws IOException, InterruptedException 
{
	
	String VEmail_2 = fakeData.internet().emailAddress();
	 Data_Specification="INValid last name";
	
	TestBase.extentTest = TestBase.extent.startTest("User Cannot Register With LastName Starts WithSmallLetter");
	registerobject= new Registerpage(driver);
	
	DashboardPage=new AccountDashboardPage(driver);
	
	
	registerobject.userregistration(Validfname,NValidlname_1, Vmobile, VEmail_2,prop.getProperty("HereFrom"));
	
	assertEquals(DashboardPage.WaitsToDashboardElementsShown(), false,"we can register with small letters on last name");

	


}





@Test(priority=4)
public void UserCannotRegisterWithFirstnNameAndLastNameWhenMatched() throws IOException, InterruptedException 
{
	String VEmail_4 = fakeData.internet().emailAddress();
    
	TestBase.extentTest = TestBase.extent.startTest("User Cannot Register With FirstnName and LastName When Matched");
	registerobject= new Registerpage(driver);
	
	DashboardPage=new AccountDashboardPage(driver);
	
	
    
	registerobject.userregistration(Validfname,NValidlname_2, Vmobile, VEmail_4,prop.getProperty("HereFrom"));
	
	assertEquals(DashboardPage.WaitsToDashboardElementsShown(), false,"we can not register  in case firstName and LastName when are not matched");




}


@Test(priority=5)
public void UserCannotRegisterWithInvalidMobileNumber() throws IOException, InterruptedException 
{
	String VEmail_5 = fakeData.internet().emailAddress();
   
	TestBase.extentTest = TestBase.extent.startTest("User Cannot Register With Invalid Mobile Number");
	registerobject= new Registerpage(driver);
	
	DashboardPage=new AccountDashboardPage(driver);
	
	
    
	registerobject.userregistration(Validfname,Validlname,NVmobile , VEmail_5,prop.getProperty("HereFrom"));
	
	assertEquals(DashboardPage.WaitsToDashboardElementsShown(), false,"we can register With Invalid Mobile Number");

	 



}


@Test(priority=6)
public void UserCannotRegisterWithInvalidEmail() throws IOException, InterruptedException 
{
	
   

	TestBase.extentTest = TestBase.extent.startTest("User Cannot Register With Invalid Email");
	registerobject= new Registerpage(driver);
	
	DashboardPage=new AccountDashboardPage(driver);
	
	
   
	registerobject.userregistration(Validfname,Validlname, Vmobile,email_3,prop.getProperty("HereFrom"));
	
	assertEquals(DashboardPage.WaitsToDashboardElementsShown(), false,"we can register With Invalid Email");




}


@Test(priority=7)
public void UserCannotRegisterWithExistingEmail() throws IOException, InterruptedException 
{
   

	TestBase.extentTest = TestBase.extent.startTest("User Cannot Register With Existing Email");
	registerobject= new Registerpage(driver);
	
	DashboardPage=new AccountDashboardPage(driver);
	
	
    //homeobject.selectLoginORSingup();
	//homeobject.clickonsignuppage();
	registerobject.userregistration(Validfname,Validlname, Vmobile,email_Matched ,prop.getProperty("HereFrom"));
	
	
	assertEquals(DashboardPage.WaitsToDashboardElementsShown(), false,"we can register With Existing Email");

	



}
/*
@Test(priority=8)
public void UserCannotRegisterWithInvalidPassword() throws IOException, InterruptedException 
{
	String VEmail_6 = fakeData.internet().emailAddress();
    Data_Specification="INValid Password"+ ""+"Password Must be 8 characters not 6";
	SoftAssert softAssertion= new SoftAssert();

	TestBase.extentTest = TestBase.extent.startTest("Register Test");
	registerobject= new Registerpage(driver);
	homeobject=new Homepage(driver);
	loginobject=new Loginpage(driver);
	DashboardPage=new AccountDashboardPage(driver);
	
	
    //homeobject.selectLoginORSingup();
	//homeobject.clickonsignuppage();
	registerobject.userregistration(Validfname,Validlname, Vmobile,VEmail_6 );
	
	ER.copydatatofile(Validfname,Validlname,Vmobile,VEmail_6, NVpassword,Data_Specification);
     Thread.sleep(3000);
     softAssertion.assertFalse(DashboardPage.selectlogoutoraccount.isDisplayed());
 	softAssertion.assertFalse(DashboardPage.selectlogoutoraccount.isEnabled());
 	softAssertion.assertAll();
	softAssertion.assertAll();



}

@Test(priority=9)
public void UserCannotRegisterWithInvalidMatchedPassword() throws IOException, InterruptedException 
{
	String VEmail_6 = fakeData.internet().emailAddress();
    Data_Specification="INValid Password";
	SoftAssert softAssertion= new SoftAssert();

	TestBase.extentTest = TestBase.extent.startTest("Register Test");
	registerobject= new Registerpage(driver);
	homeobject=new Homepage(driver);
	loginobject=new Loginpage(driver);
	DashboardPage=new AccountDashboardPage(driver);
	
	
    //homeobject.selectLoginORSingup();
	//homeobject.clickonsignuppage();
	registerobject.userregistration(Validfname,Validlname, Vmobile,VEmail_6 , password,NVpassword);
	
	ER.copydatatofile(Validfname,Validlname,Vmobile,VEmail_6, NVpassword,Data_Specification);
     Thread.sleep(3000);
 	softAssertion.assertTrue(registerobject.validationAlert.isDisplayed());
	softAssertion.assertAll();



}
	

	
	
	
	@Test(priority=11)
	public void UserCannotRegisterWithExistingEmail() throws IOException, InterruptedException 
	{
	    Data_Specification="INValid"+" "+"ThisEmailExist";
		SoftAssert softAssertion= new SoftAssert();

		TestBase.extentTest = TestBase.extent.startTest("Register Test");
		registerobject= new Registerpage(driver);
		homeobject=new Homepage(driver);
		loginobject=new Loginpage(driver);
		DashboardPage=new AccountDashboardPage(driver);
		
		
	    //homeobject.selectLoginORSingup();
		//homeobject.clickonsignuppage();
		registerobject.userregistration(Validfname,Validlname, Vmobile,email_Matched , password,confirmedPass_1);
		
		
		ER.copydatatofile(Validfname,Validlname,Vmobile,email_Matched , password,Data_Specification);
          Thread.sleep(3000);
		softAssertion.assertTrue(registerobject.validationAlert.isDisplayed());
		
		



	}
	
@Test(priority=12)
	
	public void UserCanLoginAndLogoutAfterRegisterSuccessfully() throws IOException 
	{
	
	SoftAssert softAssertion= new SoftAssert();
	TestBase.extentTest = TestBase.extent.startTest("Login Test");
		homeobject=new Homepage(driver);
		loginobject=new Loginpage(driver);
		DashboardPage=new AccountDashboardPage(driver);
		homeobject.selectLoginORSingup();
		homeobject.clickonloginpage();
		
		String [] getdata=ER.getloginData();
		System.out.println(getdata[0]+ " "+ getdata[1]);
		loginobject.userlogin(getdata[0], getdata[1]);
		DashboardPage.WaitsToDashboardElementsShown();
		softAssertion.assertTrue(DashboardPage.selectlogoutoraccount.isDisplayed());
		softAssertion.assertTrue(DashboardPage.selectlogoutoraccount.isEnabled());
		softAssertion.assertAll();
		DashboardPage.userlogout();
		loginobject.WaitingAfterLogout();
	    Assert.assertTrue(loginobject.loginbutton.isDisplayed());
		
		

	}
	*/
	

}
