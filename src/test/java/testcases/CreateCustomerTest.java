package testcases;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.Test;

import APIS.CreateCustomerAPI;
import io.restassured.response.Response;
import listeners.ExtentListeners;
import setup.Base;
import utilities.DataUtils;
import utilities.TestUtil;

public class CreateCustomerTest extends Base{
	
	@Test(dataProviderClass=DataUtils.class,dataProvider="getdata")
	public void CreateValidSecretKey(Hashtable<String, String> data)
	{		
		Response response = CreateCustomerAPI.validsecretkey(data);
		
		ExtentListeners.testReport.get().info("data received is "+data.toString());
		
		response.prettyPrint();
		
		Assert.assertTrue(TestUtil.jsonResponseHasKey(response.asString(), "id"),"ID key not present in output");
		
		System.out.println("id key value extracted from output screen is " + TestUtil.getJSONKeyValue(response.asString(), "id"));
		
		ExtentListeners.testReport.get().info("id key value extracted from output screen is" + TestUtil.getJSONKeyValue(response.asString(), "id"));
		
		System.out.println("created key value extracted from output screen is " + TestUtil.getJSONKeyValue(response.asString(), "created"));
		
		ExtentListeners.testReport.get().info("created key value extracted from output screen is" + TestUtil.getJSONKeyValue(response.asString(), "created"));
		
		Assert.assertEquals(response.statusCode(), 200,"invalid status code received");
		
	}

	@Test(dataProviderClass=DataUtils.class,dataProvider="getdata")
	public void CreateInvalidSecretKey(Hashtable<String, String> data)
	{		
		Response response = CreateCustomerAPI.invalidsecretkey(data);
			
		ExtentListeners.testReport.get().info("data received is "+data.toString());
		
		response.prettyPrint();
		
		Assert.assertEquals(response.statusCode(), 401,"invalid status code received");
		
	}
	
}
