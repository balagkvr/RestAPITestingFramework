package APIS;

import static io.restassured.RestAssured.given;

import java.util.Hashtable;

import io.restassured.response.Response;
import setup.Base;

public class DeleteCustomerAPI extends Base {
	
	public static Response validCustId(Hashtable<String, String> data)
	{
		return given().auth().basic(prop.getProperty("validsecretkey"), "")
		.delete(prop.getProperty("endpoint")+"/"+data.get("id"));
	}

}
