package athn.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import athn.styxframework.pages.LoginSignup;

public class TestLogin {
	WebDriver driver;
	LoginSignup objlogin;

	/**
	 * @param args
	 */
	@BeforeTest
	public void startChrome(){
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\bkeerthana\\Documents\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://styxframework.github.io/mainrepo1/");
	}
	@Test
	public void test_fill_login(){
		objlogin = new LoginSignup(driver);
		String outputMessage = objlogin.signin("admin", "admin1");
		driver.switchTo().alert().accept();
		String resultmessage = objlogin.signin("admin", "admin");
		driver.switchTo().alert().accept();
		Assert.assertEquals(resultmessage, "Invalid username or password!", "Login passed");
		Assert.assertEquals(outputMessage, "Succssfully Logged in!", "Login Failed");
		
		String signupresult = objlogin.signup("", "");
		Assert.assertEquals(signupresult, "firstname and lastname are empty", "Signup alert passed");
		driver.switchTo().alert().accept();
	}
}
