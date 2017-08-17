package athn.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import athn.styxframework.pages.LoginSignup;

public class TestLogin {
	LoginSignup objlogin = new LoginSignup();
	//WebElement objUsername = objlogin.loginUsername;

	/**
	 * @param args
	 */
	@BeforeTest
	public void startChrome(){
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ssrivatsan\\Desktop\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://styxframework.github.io/mainrepo/");
		
	}
	@Test
	public void test_fill_login(){
		
	}

}
