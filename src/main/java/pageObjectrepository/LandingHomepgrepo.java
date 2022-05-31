package pageObjectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingHomepgrepo {

	public WebDriver driver;
	
	By login=By.cssSelector("a[href*='sign_in']");
	By message=By.xpath("//button[text()='NO THANKS']");
	By title=By.xpath("//section[@id='content']/div/div/h2");
	By nav=By.xpath("//nav[@class='navbar-collapse collapse']/ul");
	By pop=By.xpath("//button[text()='NO THANKS']");
	
	public LandingHomepgrepo(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebElement getloginoption() {
		return driver.findElement(login);
	}
	public WebElement dismissmsg() {
		return driver.findElement(message);
	}
	public WebElement getTitle() {
		return driver.findElement(title);
	}
	public WebElement getnav() {
		return driver.findElement(nav);
	}
	public WebElement getpop() {
		return driver.findElement(pop);
	}
//	public int getPopUpSize()
//
//	{
//
//	return driver.findElements(pop).size();
}
