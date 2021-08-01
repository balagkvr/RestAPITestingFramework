package testcases;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.Test;

import APIS.CreateCustomerAPI;
import APIS.DeleteCustomerAPI;
import io.restassured.response.Response;
import listeners.ExtentListeners;
import setup.Base;
import utilities.DataUtils;
import utilities.TestUtil;

public class DeleteCustomerTest extends Base{
	
	@Test(dataProviderClass=DataUtils.class,dataProvider="getdata")
	public void DeleteValidCustID(Hashtable<String, String> data)
	{		
		Response response = DeleteCustomerAPI.validCustId(data);
		
		ExtentListeners.testReport.get().info("data received is "+data.toString());
		
		response.prettyPrint();
		
		Assert.assertEquals(response.statusCode(), 200,"invalid status code received");
		
		System.out.println("id key value extracted from output screen is " + TestUtil.getJSONKeyValue(response.asString(), "id"));
		System.out.println("object key value extracted from output screen is " + TestUtil.getJSONKeyValue(response.asString(), "object"));
		System.out.println("deleted key value extracted from output screen is " + TestUtil.getJSONKeyValue(response.asString(), "deleted"));	
		
		ExtentListeners.testReport.get().info("id key value extracted from output screen is" + TestUtil.getJSONKeyValue(response.asString(), "id"));
		ExtentListeners.testReport.get().info("object key value extracted from output screen is" + TestUtil.getJSONKeyValue(response.asString(), "object"));
		ExtentListeners.testReport.get().info("deleted key value extracted from output screen is" + TestUtil.getJSONKeyValue(response.asString(), "deleted"));
		
		
	}
}
