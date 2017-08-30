package athn.styxframework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginSignup {
 WebDriver driver;
 By loginUsername = By.name("loginUsername");
 By loginPassword = By.name("loginPassword");
 By loginBtn = By.name("signin");
 By signupFirstName = By.name("signupFirstName");
 By signupLastName = By.name("signupLastName");
 By signupDOB = By.name("signupDOB");
 By signupEmail = By.name("signupEmail");
 By signupPhone = By.name("signupPhone");
 By signupUserName = By.name("signupUserName");
 By signupPassword = By.name("signupPassword");
 By signupBtn = By.name("signup");
 
 public LoginSignup(WebDriver driver) {
	 this.driver=driver;
 }
 public String signin(String username, String password)
 {
	 driver.findElement(loginUsername).sendKeys(username);
	 driver.findElement(loginPassword).sendKeys(password);
	 driver.findElement(loginBtn).click();
	 String alertMessage = driver.switchTo().alert().getText();
	 return alertMessage;
 }
 
 public String signup(String firstname, String lastname, String dob, String email, String phone, String username, String password)
 {
	 driver.findElement(signupFirstName).sendKeys(firstname);
	 driver.findElement(signupLastName).sendKeys(lastname);
	 driver.findElement(signupDOB).sendKeys(dob);
	 driver.findElement(signupEmail).sendKeys(email);
	 driver.findElement(signupPhone).sendKeys(phone);
	 driver.findElement(signupUserName).sendKeys(username);
	 driver.findElement(signupPassword).sendKeys(password);
	 driver.findElement(signupBtn).click();
	 String alertMessage = driver.switchTo().alert().getText();
	 return alertMessage;
 }
}
