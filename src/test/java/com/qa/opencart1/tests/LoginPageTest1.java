package com.qa.opencart1.tests;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart1.utils.Constants;

public class LoginPageTest1 extends BaseTest1{

	@Test
	public void registerLiskTest() {
		Assert.assertTrue(lp.isRegisterLinkExist());
	}
	
	@Test
	public void forgotPwdLinkTest() {
		Assert.assertTrue(lp.isForgotPwdLinkExist());
	}
	
	@Test
	public void loginPageTitleTest() {
		String actUrl = lp.verifyPageTitle();
		System.out.println(actUrl);
		Assert.assertEquals(actUrl, Constants.LOGIN_PAGE_TITLE);
	}
	@Test
	public void loginPageUrlFractionTest() {
		String actUrl = lp.verifyPageUrl();
		System.out.println(actUrl);
		Assert.assertTrue(actUrl.contains(Constants.LOGIN_PAGE_URL_FRACTION));
	}
	@Test
	public void loginTest() {
		lp.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
}
