package fullFramework;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjectrepository.LandingHomepgrepo;
import pageObjectrepository.Loginpagerepo;
import resources.base;

public class Homepage extends base {
	WebDriver driver;
	public static Logger log=LogManager.getLogger(base.class.getName()); 
	LandingHomepgrepo lp=new LandingHomepgrepo(driver);
	
	@BeforeTest
	public void initialization() throws IOException {
		driver=initializeDriver();
		log.info("Successfully initialized the driver");
		
	}
	@Test(dataProvider="getData")
	public void home(String username,String password) throws IOException {
		driver.get(prop.getProperty("url"));
		//to dismiss the newsletter popup press ESCAPE key
		lp=new LandingHomepgrepo(driver);
		log.info("Checking whether popup is present");
		try {
			lp.getpop().click();
			log.info("popup is present");
		}
		catch(Exception e) {
			log.error("popup is absent");
		}
		lp.getloginoption().click();
		log.info("clicked on login link");
		Loginpagerepo lgp=new Loginpagerepo(driver);
		log.info("entering login credentials");
		lgp.getemail().sendKeys(username);
		lgp.getpassword().sendKeys(password);
		lgp.loginbutton().click();
		log.info("login sucessful");
	}
	@AfterTest
	public void teartown() {
		driver.close();
	}
	
	@DataProvider
	public Object[][] getData() {
		Object[][] data=new Object[2][2];
		data[0][0]="abc";
		data[0][1]="def";
		data[1][0]="cba";
		data[1][1]="fed";
		return data;
	}

}
