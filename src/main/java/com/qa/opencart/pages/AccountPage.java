package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.ElementUtil;

public class AccountPage {

	private WebDriver driver;
	private ElementUtil eleUtil;
	
	private By header = By.cssSelector("div#logo a");
	private By accHeaders = By.cssSelector("div#content h2");
	private By searchfield = By.name("search");
	private By searchButton = By.cssSelector("div#search button");
	private By logoutLink =By.linkText("Logout");
	private By phoneLink = By.linkText("Phones & PDAs");
	
	public AccountPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	public String getAccountHeader() {
		return eleUtil.doGetText(header);
	}
	
	public boolean isLogoutLinkExist() {
		return eleUtil.doIsDisplayed(logoutLink);
	}
	
	public List<String> getAccountSecList() {
		List<WebElement> accList = eleUtil.waitForElementsToBeVisible(accHeaders, 500);
		List<String> accValList = new ArrayList<String>();
		for(WebElement e : accList) {
			String text = e.getText();
			accValList.add(text);
		}
		return accValList;
	}
	public boolean isSearchExist() {
		return eleUtil.doIsDisplayed(searchfield);
	}
	
	public SearchResultsPage doSearch(String productName) {
		System.out.println("searching product name is:" +productName);
		eleUtil.doSendKeys(searchfield, productName);
		eleUtil.doClick(searchButton);
		return new SearchResultsPage(driver);
	}

	public PhoneClass clickPhoneLink() {
		eleUtil.doClick(phoneLink);
		return new PhoneClass(driver);
	}

}

