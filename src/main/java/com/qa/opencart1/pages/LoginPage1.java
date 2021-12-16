package com.qa.opencart1.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage1 {
	
	private WebDriver driver;
	
	public LoginPage1(WebDriver driver) {
		this.driver = driver;
	}

	private By emailid = By.id("input-email");
	private By password = By.id("input-password");
	private By registerLink = By.linkText("Register");
	private By forgotPwdLink = By.linkText("Forgotten Password");
	private By loginBtn = By.xpath("//input[@type='submit']");
	
	public boolean isRegisterLinkExist() {
		return driver.findElement(registerLink).isDisplayed();
	}
	
	public boolean isForgotPwdLinkExist() {
		return driver.findElement(forgotPwdLink).isDisplayed();
	}

	public String verifyPageTitle() {
		return driver.getTitle();
	}
	
	public String verifyPageUrl() {
		return driver.getCurrentUrl();
	}
	
	public void doLogin(String un, String pwd) {
		driver.findElement(emailid).sendKeys(un);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(loginBtn).click();
	}
}
