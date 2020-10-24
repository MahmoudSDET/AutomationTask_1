package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pages.PageBase;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;



public class TestBase  {

	public static WebDriver driver;
	public static Properties prop;
	static String chromepath =System.getProperty("user.dir")+"\\drivers\\chromedriver.exe";
	static String firefoxpath =System.getProperty("user.dir")+"\\drivers\\geckodriver.exe";
	static String InternetExplorerpath =System.getProperty("user.dir")+"\\drivers\\IEDriverServer.exe";
	static String configpath=System.getProperty("user.dir")+"\\src\\test\\java\\configuration\\config.properties";
	public  static ExtentReports extent;
	public  static ExtentTest extentTest;
	public TestBase() throws IOException
	{
		prop=new Properties();
		FileInputStream file=new FileInputStream(configpath);
		prop.load(file);
	}

	@Parameters({"browser"})
	@BeforeMethod
	public  static String startdriver(@Optional("chrome")String browsername)
	{
		if(browsername.equalsIgnoreCase("chrome"))
		{

			System.setProperty("webdriver.chrome.driver", chromepath);
			driver=new ChromeDriver();
		}
		else if(browsername.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", firefoxpath);
			driver=new FirefoxDriver();
		}
		else if(browsername.equalsIgnoreCase("internetexplorer"))
		{
			System.setProperty("webdriver.ie.driver", InternetExplorerpath);
			driver=new InternetExplorerDriver();
		}

		driver.get(prop.getProperty("URL"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //implicit wait to make page load and element
		driver.manage().window().maximize();    //to maximize window 
		
		return browsername;



	}
	
	
	@BeforeTest
	public void setExtent(){
		extent = new ExtentReports(System.getProperty("user.dir")+"//TestReportResults//ExtentReport.html", true);
		extent.addSystemInfo("Host Name", "Mahmoud Windows");
		extent.addSystemInfo("User Name", "Mahmoud");
		extent.addSystemInfo("Environment", "QA");
		
	}
	
	@AfterTest
	public void endReport(){
		extent.flush();
		extent.close();
	}
	
	
	
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException{
		
		if(result.getStatus()==ITestResult.FAILURE){
			extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS "+result.getName()); //to add name in extent report
			extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS "+result.getThrowable()); //to add error/exception in extent report
			
			String screenshotPath =getScreenshot(driver, result.getName());
			extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath));
			driver.close();
			
			//to add screenshot in extent report
			//extentTest.log(LogStatus.FAIL, extentTest.addScreencast(screenshotPath)); //to add screencast/video in extent report
		}
		else if(result.getStatus()==ITestResult.SKIP){
			extentTest.log(LogStatus.SKIP, "Test Case SKIPPED IS " + result.getName());
		}
		else if(result.getStatus()==ITestResult.SUCCESS){
			extentTest.log(LogStatus.PASS, "Test Case PASSED IS " + result.getName());
			//driver.close();

		}
		
		
		extent.endTest(extentTest); //ending test and ends the current test and prepare to create html report
	//	driver.quit();
	}
	@AfterSuite
	public void stopdriver()
	{
		driver.quit();
	}
	
	public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException{
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		// after execution, you could see a folder "FailedTestsScreenshots"
		// under src folder
		String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/" + screenshotName + dateName
				+ ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}


}
