package athn.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestLogin {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ssrivatsan\\Desktop\\chromedriver.exe");
		 WebDriver driver = new ChromeDriver();
		 driver.get("https://styxframework.github.io/mainrepo/");
	}

}
