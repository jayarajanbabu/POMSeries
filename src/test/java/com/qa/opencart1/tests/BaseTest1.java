package com.qa.opencart1.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.opencart1.factory.DriverFactory;
import com.qa.opencart1.pages.LoginPage1;

public class BaseTest1 {

	WebDriver driver;
	DriverFactory df;
	Properties prop;
	LoginPage1 lp;
	
	@BeforeTest
	public void setUp() {
		df = new DriverFactory();
		prop = df.init_prop();
		driver = df.init_driver(prop);
		
		lp = new LoginPage1(driver);
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
