package com.employee.base;


import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;
import static io.restassured.RestAssured.*;

public class TestBase {
	
	public Logger logger;
	
	@BeforeClass
	
	public void setup() {
		
		logger = Logger.getLogger("EmployeeRestAPI");
		PropertyConfigurator.configure("log4j.properties");
		logger.setLevel(Level.DEBUG);
		
	}
	

}
