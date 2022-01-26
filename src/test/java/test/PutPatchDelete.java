package test;


import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class PutPatchDelete {
	
	//@Test
	public void testPut() {
		

		JSONObject request = new JSONObject();
		request.put("name", "Naveen");
		request.put("Job", "Manager");
		
		baseURI = "https://reqres.in/api";
		
		given().
			header("Content-Type","application/json").
			body(request.toJSONString()).
		when().
			put("/users/2").
		then().
			statusCode(200).
			log().all();
	}
	
	//@Test
	public void testPatch() {
		

		JSONObject request = new JSONObject();
		request.put("name", "Naveen");
		request.put("Job", "Manager");
		
		baseURI = "https://reqres.in/api";
		
		given().
			header("Content-Type","application/json").
			body(request.toJSONString()).
		when().
			patch("/users/2").
		then().
			statusCode(200).
			log().all();
	}
	
	@Test
	public void testDelete() {
		

//		JSONObject request = new JSONObject();
//		request.put("name", "Naveen");
//		request.put("Job", "Manager");
		
		baseURI = "https://reqres.in/api";
		
//		given().
//			header("Content-Type","application/json").
//			body(request.toJSONString()).
		when().
			delete("/users/2").
		then().
			statusCode(204).
			log().all();
	}

}
