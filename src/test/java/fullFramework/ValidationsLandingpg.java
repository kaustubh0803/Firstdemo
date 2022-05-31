package fullFramework;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjectrepository.LandingHomepgrepo;
import resources.base;

public class ValidationsLandingpg extends base {
	WebDriver driver;
	public static Logger log=LogManager.getLogger(base.class.getName()); 
	LandingHomepgrepo lp=new LandingHomepgrepo(driver);
	
	@BeforeTest
	public void initializing() throws IOException {
		driver=initializeDriver();
		log.info("initializing driver");
		driver.get(prop.getProperty("url"));
		//to dismiss the newsletter popup press ESCAPE key
		lp=new LandingHomepgrepo(driver);
		try {
			lp.getpop().click();
			log.info("popup is present");
		}
		catch(Exception e) {
			log.error("popup is absent");
		}
		}
		
	
	
	@Test
	public void validTitle() {
		lp=new LandingHomepgrepo(driver);
		Assert.assertEquals(lp.getTitle().getText(),"FEATURED COURSES123");
		log.info("FEATURED COURSES title is present");
	}
	@Test
	public void validnav() {
		lp=new LandingHomepgrepo(driver);
		Assert.assertTrue(lp.getnav().isDisplayed());
		log.info("Navigation bar is present");
	}
	@AfterTest
	public void teartown() {
		driver.close();
	}
}
