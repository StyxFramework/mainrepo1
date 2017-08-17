package athn.styxframework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginSignup {
 WebDriver driver;
 By loginUsername = By.name("loginUsername");
 By loginPassword = By.name("loginPassword");
 By loginBtn = By.name("signin");
 
 public void signin(String username, String password)
 {
	 driver.findElement(loginUsername).sendKeys(username);
	 driver.findElement(loginPassword).sendKeys(password);
 }
}
