package athn.framework;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
		objlogin = new LoginSignup(driver);
		String outputMessage = objlogin.signin(loginUsername, loginPassword);
		Assert.assertEquals(outputMessage, "Succssfully Logged in!", "Login Failed");
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
