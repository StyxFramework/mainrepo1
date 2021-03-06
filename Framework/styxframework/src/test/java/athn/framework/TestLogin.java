package athn.framework;

import java.io.IOException;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import athn.styxframework.pages.LoginSignup;
import excelOps.readFromExcel;

public class TestLogin {
	WebDriver driver;
	LoginSignup objlogin;

	/**
	 * @param args
	 */
	@BeforeTest
	public void startChrome(){
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://styxframework.github.io/mainrepo1/");
	}
	@Test(dataProvider = "TestCases")
	public void test_fill_login(String[] TestCase) throws IOException {
    	readFromExcel objExcelFile = new readFromExcel();
        String filePath = System.getProperty("user.dir")+"\\src\\main\\java\\excelOps";
        Sheet getSheet = objExcelFile.getSheet(filePath,"Styx.xlsx","Data");
        String loginUsername = objExcelFile.getValueFromSheet(getSheet,TestCase[0],"login_username");
        String loginPassword = objExcelFile.getValueFromSheet(getSheet,TestCase[0],"login_password");
        String loginMessage = objExcelFile.getValueFromSheet(getSheet,TestCase[0],"login_message");
		objlogin = new LoginSignup(driver);
		String outputMessage = objlogin.signin(loginUsername, loginPassword);
		Assert.assertEquals(outputMessage, loginMessage, "Success");
		driver.switchTo().alert().accept();
	}
	
	@Test(dataProvider = "TestCases")
	public void test_fill_signup(String[] TestCase) throws IOException {
    	readFromExcel objExcelFile = new readFromExcel();
        String filePath = System.getProperty("user.dir")+"\\src\\main\\java\\excelOps";
        Sheet getSheet = objExcelFile.getSheet(filePath,"Styx.xlsx","Data");
        String signupFirstName = objExcelFile.getValueFromSheet(getSheet,TestCase[0],"signup_firstname");
        String signupLastName = objExcelFile.getValueFromSheet(getSheet,TestCase[0],"signup_lastname");
        String signupDOB = objExcelFile.getValueFromSheet(getSheet,TestCase[0],"signup_dob");
        String signupEmail = objExcelFile.getValueFromSheet(getSheet,TestCase[0],"signup_email");
        String signupPhone = objExcelFile.getValueFromSheet(getSheet,TestCase[0],"signup_phone");
        String signupUserName = objExcelFile.getValueFromSheet(getSheet,TestCase[0],"signup_username");
        String signupPassWord = objExcelFile.getValueFromSheet(getSheet,TestCase[0],"signup_password");
        String signupMessage = objExcelFile.getValueFromSheet(getSheet,TestCase[0],"signup_message");
		objlogin = new LoginSignup(driver);
		String outputMessage = objlogin.signup(signupFirstName, signupLastName, signupDOB, signupEmail, signupPhone, signupUserName, signupPassWord);
		Assert.assertEquals(outputMessage, signupMessage, "Success");
		driver.switchTo().alert().accept();		
	}
	
	@AfterTest
	public void closeChrome(){
	driver.quit();
	}

	@DataProvider
	public Object[] TestCases() throws Exception{
		readFromExcel getTestCases = new readFromExcel();
		String filePath = System.getProperty("user.dir")+"\\src\\main\\java\\excelOps";
		Sheet getSheet = getTestCases.getSheet(filePath,"Styx.xlsx","Data");
		String[] runnableTests = getTestCases.getRunnableTestCases(getSheet);
		return runnableTests;
	}
}
