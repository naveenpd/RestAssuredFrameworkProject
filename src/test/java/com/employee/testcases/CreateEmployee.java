package com.employee.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.employee.base.PostCreateEmp;
import com.employee.base.TestBase;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class CreateEmployee extends TestBase{
	
	@Test
	
	public void createEmployeeDetails() {
		
		PostCreateEmp postce = new PostCreateEmp();
		
		postce.setAge("25");
		postce.setName("Naveen1as242");
		postce.setSalary("12345441512dd332");
		
		Response response = 
				given().
				body(postce).
				when().
				contentType(ContentType.JSON).
				put("http://dummy.restapiexample.com/api/v1/update/2857");
		
		System.out.println(response.asString());
		
		String responsename = response.then().extract().path("data.name");
		Assert.assertEquals(responsename, "Naveen1242");
					
		
		
	}
	
	
	

}
