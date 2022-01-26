package com.employee.utilities;

import java.util.Date;

import com.aventstack.extentreports.ExtentReports;

public class ExtentManager {
	
	public static ExtentReports extent;
	
	public static ExtentReports getInstance() {
		
		if (extent==null) {
			Date dt = new Date();
			String fileName = dt.toString().replace(":", "_").replace(" ", "_")+".html";
			extent = new ExtentReports(System.getProperty("user.dir")+"//HtmlReports//"+fileName);
			extent.
			
			extent = new ExtentReports(System.getProperty("user.dir")+"//HtmlReports//");
		}
	}

}
