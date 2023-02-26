package com.qa.opencart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.ElementUtil;

public class PhoneClass {

	private WebDriver driver;
	private ElementUtil eleUtil;
	
	public PhoneClass(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}
	
	private By phoneList = By.cssSelector("div.description a");
	
	public int getPhoneListCount() {
		int phoneListCount = eleUtil.waitForElementsToBeVisible(phoneList, 5).size();
		System.out.println("The total count is:" + phoneListCount);
		return phoneListCount;
		
	}
	
	public ProductInfoPage selectPhone(String phoneName) {
		System.out.println("The phone name is :" + phoneName);
		List<WebElement> actPhoneList =  eleUtil.waitForElementsToBeVisible(phoneList, 5);
		for(WebElement e : actPhoneList) {
			String text = e.getText();
			if(text.equals(phoneName)) {
				e.click();
				break;
				}
		}
		return new ProductInfoPage(driver);
	}
	
	
}
