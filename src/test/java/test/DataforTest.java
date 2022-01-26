package test;

import org.testng.annotations.DataProvider;

public class DataforTest {
	
	@DataProvider(name="Dataforpost")
	public Object [][] dataforPost(){
		return new Object[][]{
				{"graham","bell",1},
				{"henry","ford", 2}
		};
	}

}
