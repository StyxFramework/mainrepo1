package athn.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\nprabakaran\\Documents\\GitHub\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://styxframework.github.io/mainrepo1/");
		//driver.findElement(By.name("loginUsername")).sendKeys("admin");
	}
	@Test
	public void test_fill_login(){
		objlogin = new LoginSignup(driver);
		objlogin.signin("admin", "admin");
	}

}
