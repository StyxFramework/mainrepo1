package athn.styxframework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginSignup {
 WebDriver driver;
 By loginUsername = By.name("loginUsername");
 By loginPassword = By.name("loginPassword");
 By firstname = By.name("firstname");
 By lastname = By.name("lastname");
 By signupbtn = By.name("signup");
 By loginBtn = By.name("signin");
 
 public LoginSignup(WebDriver driver) {
	 this.driver=driver;
 }
 public String signin(String username, String password)
 {	
	 driver.findElement(loginUsername).clear();
	 driver.findElement(loginPassword).clear();
	 driver.findElement(loginUsername).sendKeys(username);
	 driver.findElement(loginPassword).sendKeys(password);
	 driver.findElement(loginBtn).click();
	 String alertMessage = driver.switchTo().alert().getText();
	 return alertMessage;
 }
 
 public String signup(String firstname, String lastname)
 {
	 driver.findElement(this.firstname).sendKeys(firstname);
	 driver.findElement(this.lastname).sendKeys(lastname);
	 driver.findElement(signupbtn).click();
	 String alertMessage = driver.switchTo().alert().getText();
	 return alertMessage;
 }

}
