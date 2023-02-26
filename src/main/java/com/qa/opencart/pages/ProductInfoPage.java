package com.qa.opencart.pages;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.ElementUtil;

public class ProductInfoPage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	public ProductInfoPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}
	
	private By header = By.cssSelector("div#content h1");
	private By images = By.cssSelector("div.image.magnific-popup img");
	private By productMetaData = By.cssSelector("div#content ul.list-unstyled:nth-of-type(1) li");
	private By productPriceData = By.cssSelector("div#content ul.list-unstyled:nth-of-type(2) li");
	private By quantity = By.name("quantity");
	private Map<String,String> productInfoMap;
	
	public String getProductHeader() {
		String name = eleUtil.doGetText(header);
		//driver.navigate().back();
		return name;
	}
	
	public int getImagesCount() {
		return eleUtil.waitForElementsToBeVisible(images, 10).size();
	}
	
	public Map<String, String> getProductInfo() {
		
		productInfoMap = new LinkedHashMap<String,String>();
		getProductMetaData();
		return productInfoMap;
		}
	
	public void getProductMetaData() {
		List<WebElement> metaDataList = eleUtil.getElements(productMetaData);
		
		for (WebElement e : metaDataList) {
			String text = e.getText();
			String[] meta = text.split(":");
			String metaKey = meta[0].trim();
			String metaValue = meta[1].trim();
			productInfoMap.put(metaKey, metaValue);
			}
		}

}
