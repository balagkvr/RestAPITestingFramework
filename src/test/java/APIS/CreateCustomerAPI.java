package APIS;

import static io.restassured.RestAssured.given;

import java.util.Hashtable;

import io.restassured.response.Response;
import setup.Base;

public class CreateCustomerAPI extends Base {
	
	//change
	public static Response validsecretkey(Hashtable<String, String> data)
	{
		return given().auth().basic(prop.getProperty("validsecretkey"), "")
		.formParam("email", data.get("email")).formParam("name", data.get("name")).log().all()
		.post(prop.getProperty("endpoint"));
	}
	
	public static Response invalidsecretkey(Hashtable<String, String> data)
	{
		return given().auth().basic(prop.getProperty("invalidsecretkey"), "")
				.formParam("email", data.get("email")).formParam("name", data.get("name")).log().all()
				.post(prop.getProperty("endpoint"));
	}


}
