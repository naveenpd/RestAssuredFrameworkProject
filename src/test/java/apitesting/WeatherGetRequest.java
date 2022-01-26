package apitesting;

import org.testng.annotations.Test;

import apitesting.com.org.Info;
import apitesting.com.org.Posts;
import apitesting.com.org.Posts1;
import apitesting.com.org.Posts2;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;

public class WeatherGetRequest {
	
	//Statuscode =200
	// @Test
	public void test_01() {

		Response response = when()
				.get("https://api.openweathermap.org/data/2.5/weather?q=London&appid=724fb939b93b38c41335185dbfec4a9d");
		System.out.println(response.body().asString());// get body of the response
		System.out.println(response.getStatusCode());// get status code
		Assert.assertEquals(response.getStatusCode(), 200);// compare the results
	}

	// status code = 401
	// @Test
	public void test_02() {

		Response response = when()
				.get("https://api.openweathermap.org/data/2.5/weather?q=London&appid=724fb939b93b38c41335185dbfec4a9e");

		System.out.println(response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(), 401);
	}

	// @Test
	public void test_03() {

		given().param("q", "London").param("appid", "724fb939b93b38c41335185dbfec4a9d").when()
				.get("https://api.openweathermap.org/data/2.5/weather").then().assertThat().statusCode(200);

		// System.out.println(response.getStatusCode());
		// Assert.assertEquals(response.getStatusCode(), 200);
	}

	//@Test
	public void test_04() {

		Response response = given().
				param("q", "London").
				param("appid", "724fb939b93b38c41335185dbfec4a9d")
				.when().
				get("https://api.openweathermap.org/data/2.5/weather");
				

		System.out.println(response.asString());

		// System.out.println(response.getStatusCode());
		// Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	//@Test
		public void test_05() {

			Response  response = given().
				param("id", "2172797").
				param("appid", "724fb939b93b38c41335185dbfec4a9d").
			when().
				get("https://api.openweathermap.org/data/2.5/weather");
			
			Assert.assertEquals(response.statusCode(), 200);
	
			System.out.println(response.asString());
	
			// System.out.println(response.getStatusCode());
			// Assert.assertEquals(response.getStatusCode(), 200);
		}
	
	//@Test
	public void test_06() {

		String  response = given().
			param("id", "2172797").
			param("appid", "724fb939b93b38c41335185dbfec4a9d").
		when().
			get("https://api.openweathermap.org/data/2.5/weather").
			then().
			statusCode(200).
			contentType(ContentType.JSON).
			extract().
			path("weather[0].description");
			
		Assert.assertEquals("overcast clouds", response);
		
		System.out.println(response);

		// System.out.println(response.getStatusCode());
		// Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	//@Test
	public void test_07() {
		
		Response response = 
						given().
						param("id", "2172797").
						param("appid","724fb939b93b38c41335185dbfec4a9d").
						when().
						get("https://api.openweathermap.org/data/2.5/weather");
		
		String ReportbyID = response.
				then().
				contentType(ContentType.JSON).
				extract().
				path("weather[0].description");
		
		System.out.println(" Weather desc :"+ReportbyID);
		
		String lon = String.valueOf(response.
						then().
						contentType(ContentType.JSON).
						extract().
						path("coord.lon"));
		
		System.out.println("lon:"+lon);
		
		String lat = String.valueOf(response.
				then().
				contentType(ContentType.JSON).
				extract().
				path("coord.lat"));
		
		System.out.println("lat:"+lat);
		
		Response responsebyCoordinates =
										given().
										param("lat", lat).
										param("lon", lon).
										param("appid","724fb939b93b38c41335185dbfec4a9d").
										when().
										get("https://api.openweathermap.org/data/2.5/weather");
		
		String reportbyCoordinates = responsebyCoordinates.
				then().
				contentType(ContentType.JSON).
				extract().
				path("weather[0].description");
		
		System.out.println("weather :"+reportbyCoordinates);
		Assert.assertEquals(ReportbyID,reportbyCoordinates);
				
	}
	
	//@Test
	public void test_08() {
		
		Response response = given().
					when().get("http://localhost:3000/comments");

		System.out.println(response.asString());
		
		String reportbyCoordinates = response.
				then().
				contentType(ContentType.JSON).
				extract().
				path("comments[0].body");
		
		System.out.println(reportbyCoordinates);
		
		
		Assert.assertEquals("some comment", reportbyCoordinates);
						
	}
	
	//@Test
	public void test_09() {
		
		Response res = given().
		body("{\"id\": 3,\"title\": \"dummytitle\",\"author\": \"typicode\"}").
		when().
		contentType(ContentType.JSON).
		post("http://localhost:3000/posts");
		
		System.out.println(res.asString());
	}
	
	//@Test
	
	public void test_10() {
		
		Posts posts = new Posts();
		posts.setId("7");
		posts.setAuthor("Naveen");
		posts.setTitle("Homeless");
		
		Response response = 
				given().
				body(posts).
				when().
				contentType(ContentType.JSON).
				post("http://localhost:3000/posts");
		
	
		
		System.out.println(response.asString());
		
		
	}
	
	//@Test
	public void test_11() {
		
		Response response = 
				given().
				when().
				get("http://localhost:3000/posts/1");
		
		System.out.println(response.asString());
	}
	
	//@Test
	public void test_12() {
		
	Posts posts = new Posts();
	posts.setAuthor("Vinay");
	//posts.setId("3");
	posts.setTitle("Tasty");
	
	Response response = 
			given().
			body(posts).
			when().
			contentType(ContentType.JSON).
			put("http://localhost:3000/posts/3");
	
	System.out.println(response.asString());
	}
	
	//@Test
		public void test_13() {
			
		Posts posts = new Posts();
		posts.setAuthor("Vinay");
		//posts.setId("3");
		posts.setTitle("Tasty");
		
		Response response = 
				given().
				body(posts).
				when().
				contentType(ContentType.JSON).
				patch("http://localhost:3000/posts/3");
		
		System.out.println(response.asString());
		}
		
		//@Test
				public void test_14() {
					
			
				Response response = 
						given().
						when().
						contentType(ContentType.JSON).
						delete("http://localhost:3000/posts/4");
				
				System.out.println(response.asString());
				}
		
		//@Test
		public void test_15() {
			
			Info info = new Info();
			info.setAddress("Mangalore");
			info.setEmail("priya@gmail.com");
			info.setPhone("12345678");
			
			Posts1 posts1 = new Posts1();
			posts1.setAuthor("Raju");
			posts1.setId("2");
			posts1.setTitle("New Title");
			posts1.setInfo(info);
			
			Response response = 
					given().
					body(posts1).
					when().
					contentType(ContentType.JSON).
					post("http://localhost:3000/posts");
			
			System.out.println(response.asString());
			
		
		}
		
		//@Test
		public void test_16() {
			
			Info info1 = new Info();
			info1.setAddress("info 1");
			info1.setEmail("email 1");
			info1.setPhone("phone1");
			
			Info info2 = new Info();
			info2.setAddress("info 2");
			info2.setEmail("email 2");
			info2.setPhone("phone2");
			
			Posts2 posts2 = new Posts2();
			posts2.setAuthor("post author");
			posts2.setId("post id");
			posts2.setTitle("post info");
			posts2.setInfo(new Info[] {info1, info2});
			
			Response response =
					given().
					body(posts2).
					when().
					contentType(ContentType.JSON).
					post("http://localhost:3000/posts");
			
			System.out.println(response.asString());
			
			
		}
		
		@Test
		public void test_17() {
			
			Response response =
					given().
					when().
					get("http://localhost:3000/posts");
			
			long responseTime = response.
									then().
									extract().
									time();
			
			System.out.println(responseTime);
		}
}
