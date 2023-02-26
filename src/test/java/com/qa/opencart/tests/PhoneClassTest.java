package com.qa.opencart.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PhoneClassTest extends BaseTest{
	
	@BeforeClass
	public void doPhoneClassSetup() throws InterruptedException {
	accountPage	= loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	Thread.sleep(5000);
	phonePage = accountPage.clickPhoneLink();
	
	}
	
	@Test(priority=1)
	public void phoneListCountTest() {
		Assert.assertTrue(phonePage.getPhoneListCount()>0);
		}

	@DataProvider
	public Object [][] selectPhone() {
		return new Object [][] {
			{"iPhone"},
			//{"HTC Touch HD"}
		};
	}
	@Test(priority=2, dataProvider = "selectPhone")
	public void selectPhoneTest(String phoneName) {
		productInfoPage = phonePage.selectPhone(phoneName);
		Assert.assertEquals(productInfoPage.getProductHeader(),phoneName);
		Map<String,String> productMap = productInfoPage.getProductInfo();
		productMap.forEach((k,v) -> System.out.println(k +":"+ v));
		softAssert.assertEquals(productMap.get("Brand"), "Apple1");
		softAssert.assertEquals(productMap.get("Availability"), "In stock");
		softAssert.assertAll();
		
		}
	
	public void productInfoTest() {
		
	}
	
}
