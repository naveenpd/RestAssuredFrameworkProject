package com.employee.testcases;

import io.restassured.http.ContentType;
import io.restassured.http.Cookies;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;

import org.hamcrest.core.CombinableMatcher;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employee.base.TestBase;

import apitesting.com.org.Info;
import apitesting.com.org.Posts2;

public class GetEmployeeAllDetails extends TestBase {
	
	@Test
	
	public void getEmployeeDetails() throws InterruptedException {
		
		Response response = given().
							when().
							get("http://dummy.restapiexample.com/api/v1/employees");
							
		Thread.sleep(5000);
		logger.info("Check the Response displayed");

		System.out.println(response.asString());
		Assert.assertTrue(response!=null);
		
		int responseStatusCode = response.then().extract().statusCode();
		
		logger.info("Status Code");
		
		System.out.println(responseStatusCode);
		Assert.assertEquals(responseStatusCode, 200);
		
		String responseStatusLine = response.then().extract().statusLine();
		
		logger.info("Status Line");
		
		System.out.println(responseStatusLine);
		Assert.assertEquals(responseStatusLine, "HTTP/1.1 200 OK");
		
		long responseTime = response.then().extract().time();
		
		System.out.println(responseTime);
		if(responseTime>2000)
			logger.warn("responsetime greater than 3000");
	
		Assert.assertTrue(responseTime<3000);
		
		String responseContentType = response.then().extract().contentType();
		
		System.out.println(responseContentType);
		Assert.assertEquals(responseContentType, "application/json");
		
		String responseServerType = response.then().extract().header("server");
		
		System.out.println(responseServerType);
		Assert.assertEquals(responseServerType, "nginx");
		
		String responseContentLength = response.then().extract().header("content-length");
		
		System.out.println(responseContentLength);
		Assert.assertEquals(responseContentLength, "631");
		
		Cookies responseCookies = response.then().extract().detailedCookies();
		
		logger.info("Cookies");
		System.out.println(responseCookies);
		
	}
	
	@Test
	
	public void singleEmployeeData() {
		
		Response response = 
				given().
				when().
				get("http://dummy.restapiexample.com/api/v1/employee/1");
		
		System.out.println(response.asString());
		
		logger.info("Status Code");
		
		int reponseStatusCode = response.then().extract().statusCode();
		
		System.out.println(reponseStatusCode);
		
		Assert.assertEquals(reponseStatusCode, 200);
		
		String reponseContentLength = response.then().extract().header("content-length");
		
		System.out.println(reponseContentLength);
		
		Assert.assertTrue(Integer.parseInt(reponseContentLength)<200);
	}
	
	//@Test
	
	public void test_Post() {
		
		baseURI = "http://localhost:3000";
		
		JSONObject request = new JSONObject();
		
		request.put("id", "3");
		request.put("title", "book1");
		request.put("author", "New");
		request.put("email", "email@gmail.com");
		request.put("phone", "Bangalore");
		request.put("address", "Harohalli");
		
	
		Response response =
				given().
				body(request.toJSONString()).
				when().
				contentType(ContentType.JSON).
				post("/posts");
		
		System.out.println(response.asString());
	}
	
	
	
}
