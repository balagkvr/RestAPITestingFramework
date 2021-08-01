package utilities;

import org.json.JSONObject;

public class TestUtil {
	
	public static boolean jsonResponseHasKey(String json, String key)
	{
		JSONObject jsonObject = new JSONObject(json);
		return jsonObject.has(key);
	}
	
	public static String getJSONKeyValue(String json, String key)
	{
		JSONObject jsonObject = new JSONObject(json);
		return jsonObject.get(key).toString();
	}

}
