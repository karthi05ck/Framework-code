package com.qa.opencart.utils;

import java.util.ArrayList;
import java.util.List;

public class Constants {
	
	public static final String LOGIN_PAGE_TITLE = "Account Login";
	public static final String LOGIN_URL_PAGE_FRACTION = "route=account/login";
	public static final String ACC_PAGE_HEADER = "Your Store";
	
	public static List<String> expectedAccountSecList() {
		List<String> expList = new ArrayList<String>();
		expList.add("My Account");
		expList.add("My Orders");
		expList.add("My Affiliate Account");
		expList.add("Newsletter");
		return expList;
	}

}
