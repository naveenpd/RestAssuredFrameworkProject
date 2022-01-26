package com.employee.testcases;

import io.restassured.response.Response;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;


public class deleteEmp {
	
	@Test
	public void test_delete() {
	
	Response response =
			given().
			when().
			contentType(ContentType.JSON).
			delete("http://dummy.restapiexample.com/api/v1/delete/24");
	
	System.out.println(response.asString());
	
	int responseStatus = response.then().extract().statusCode();
	
	Assert.assertEquals(responseStatus, 204);
	
	}			

}
