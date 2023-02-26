package com.qa.opencart.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.utils.Constants;

public class AccountPageTest extends BaseTest{
	
	@BeforeClass
	public void accPageSetup() {
		accountPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test
	public void getAccountHeaderTest() {
		String header = accountPage.getAccountHeader();
		Assert.assertEquals(header, Constants.ACC_PAGE_HEADER);
		
	}
	@Test
	public void logoutLinkTest() {
		//Assert.assertEquals(true, accountPage.isLogoutLinkExist());
		Assert.assertTrue(accountPage.isLogoutLinkExist());
		
		}
	@Test
	public void accountSecListTest() {
		List<String> actualSecList = accountPage.getAccountSecList();
		Assert.assertEquals(actualSecList, Constants.expectedAccountSecList());
	}

	@DataProvider
	public Object[][] productData() {
		return new Object [][] {
			{"Macbook"},
			{"Apple"},
			{"Samsung"}
		};
	}
	
	@Test(priority = 0, dataProvider = "productData")
	public void doSearchTest(String productName) {
		accountPage.doSearch(productName);
	}

}

