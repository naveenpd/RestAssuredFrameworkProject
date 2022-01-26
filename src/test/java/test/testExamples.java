package test;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class testExamples extends DataforTest {
	
	//@Test
	public void test_Get() {
		
		baseURI = "http://localhost:3000";
		given().
				param("Subject","Automation").
				get("/Subjects").		
		then().
		statusCode(200).
		log().all();
	}
	
	
	@Test(dataProvider ="Dataforpost")
	public void test_Post(String FirstName, String LastName, int subjectId ) {
		
			
		JSONObject request = new JSONObject();
		request.put("Firstname",FirstName);
		request.put("Lastname",LastName);
		request.put("SubjectId",subjectId);
		
		baseURI = "http://localhost:3000";
		
		System.out.println(request.toJSONString());
		
		given().
			body(request.toJSONString()).
		when().
			post("/users").
		then().
			statusCode(201).
			log().all();
	}

}
