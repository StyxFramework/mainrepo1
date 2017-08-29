package athn.framework;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
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
	public void test_fill_login(List<Integer> TestCase) throws IOException {
    	readFromExcel objExcelFile = new readFromExcel();
        String filePath = System.getProperty("user.dir")+"\\src\\main\\java\\excelOps";
        Sheet getSheet = objExcelFile.getSheet(filePath,"Styx.xlsx","Data");
        String loginUsername = objExcelFile.getValueFromSheet(getSheet,"login_username");
        String loginPassword = objExcelFile.getValueFromSheet(getSheet,"login_password");
		objlogin = new LoginSignup(driver);
		String outputMessage = objlogin.signin(loginUsername, loginPassword);
		Assert.assertEquals(outputMessage, "Succssfully Logged in!", "Login Failed");
		
		String signupresult = objlogin.signup("", "");
		Assert.assertEquals(signupresult, "firstname and lastname are empty", "Signup alert passed");
		driver.switchTo().alert().accept();
	}

	@DataProvider
	public Object[] TestCases() throws Exception{
		String[] runnableTests = new String[8];
		readFromExcel getTestCases = new readFromExcel();
		String filePath = System.getProperty("user.dir")+"\\src\\main\\java\\excelOps";
		Sheet getTCSheet = getTestCases.getSheet(filePath,"Styx.xlsx","Test_Cases");
		runnableTests = getTestCases.getRunnableTestCases(getTCSheet);
		Sheet getSheet = getTestCases.getSheet(filePath,"Styx.xlsx","Data");
		int rowCount = getTestCases.getRowCount(getSheet);
		return runnableTests;
	}
}
