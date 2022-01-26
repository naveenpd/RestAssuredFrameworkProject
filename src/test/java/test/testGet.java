package test;

import static io.restassured.RestAssured.*;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;


public class testGet {
	
	@Test
	public void test3() {
		
		baseURI = "http://dummy.restapiexample.com/api/v1";
		
		JSONObject response = new JSONObject();
		System.out.println(response.toJSONString());
		
		given().
			get("/employees").
			
		then().
			statusCode(200);
		
		
	}
	//@Test
	public void testPost() {
		
//		Map<String, Object> map = new HashMap<String, Object>();
//		
//		map.put("name", "Naveen");
//		map.put("Job", "Manager");
		JSONObject request = new JSONObject();
		request.put("name", "Naveen");
		request.put("Job", "Manager");
		
		baseURI = "https://reqres.in/api";
		
		given().
			header("Content-Type","application/json").
			
		when().
			post("/users").
		then().
			
			statusCode(201).
			log().all();
	}
	//@Test
	public void test5() {
		
		baseURI = "http://restapi.demoqa.com/utilities/weather/city";

		
		given().
			get("/delhi").
			
		then().
			statusCode(200).
			
			body("data[1].id", equalTo(8)).
			body("data[1].first_name", equalTo("Lindsay"));
		
		
	}

}
