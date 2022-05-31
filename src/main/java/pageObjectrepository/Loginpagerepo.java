package pageObjectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Loginpagerepo {

public WebDriver driver;
	
	By email=By.id("user_email");
	By password=By.id("user_password");
	By lgnbtn=By.cssSelector("input[value='Log In']");
	
	public Loginpagerepo(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebElement getemail() {
		return driver.findElement(email);
	}
	public WebElement getpassword() {
		return driver.findElement(password);
	}
	public WebElement loginbutton() {
		return driver.findElement(lgnbtn);
	}
}
