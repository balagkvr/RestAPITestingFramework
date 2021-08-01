package setup;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.restassured.RestAssured;
import utilities.ExcelReader;

public class Base {
	
	public static Properties prop = new Properties();
	public FileInputStream fis;
	public static ExcelReader excel = new ExcelReader(System.getProperty("user.dir")+ "\\src\\test\\resources\\Excel\\TestData.xlsx");
	
	@BeforeSuite
	public void setUpMethod() throws IOException {
		fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\Files\\config.properties");
		prop.load(fis);
		RestAssured.baseURI= prop.getProperty("baseuri");
		RestAssured.basePath=prop.getProperty("basePath");
	}
	
	@AfterSuite
	public void tearDown() {
		
		

	}

}
