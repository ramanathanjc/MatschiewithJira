package hooks;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.RestAssured;

import java.io.File;

public class SetUp {
	
	@Before
	public void setup() throws FileNotFoundException, IOException {
		
		Properties prop = new Properties();
		prop.load(new FileInputStream(new File("./src/test/resources/config.properties")));

		RestAssured.baseURI=prop.getProperty("baseURI");
		RestAssured.authentication=RestAssured.preemptive().basic(prop.getProperty("username"), prop.getProperty("Password"));
		
	}
	
	@After
	public void down() {
		
		
		
	}

}