package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.utils.Constants;


public class LoginPageTest extends BaseTest{
	@Test(priority=1)
	public void loginPageTitleTest() {
		String actTitle=loginPage.getLoginPageTitle();
		System.out.println("Page title is:" + actTitle);
		Assert.assertEquals(actTitle, Constants.LOGIN_PAGE_TITLE);
		
	}
	@Test(priority=2)
	public void loginPageUrlTest() {
		String actUrl = loginPage.getLoginPageUrl();
		System.out.println("Page url is:" + actUrl);
		Assert.assertTrue(actUrl.contains(Constants.LOGIN_URL_PAGE_FRACTION));
		
	}
	@Test(priority=3)
	public void forgotPwdLinkTest() {
		Assert.assertTrue(loginPage.isForgotPwdLinkExist());
	}
	@Test(priority=4)
	public void registerLinkTest() {
		Assert.assertTrue(loginPage.isRegisterLinkExist());
	}
	
	@Test(priority=5)
	public void dologinTest() {
		loginPage.doLogin(prop.getProperty("username").trim(),prop.getProperty("password").trim());
	}

}

