package Rest_testing;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;

public class Google_maps {
	public String url = "http://216.10.245.166/maps/api/place/add/json?key= qaclick123\r\n";
	public String str;
	
	@Test(enabled=true)
	
	public void tc1() {
		JSONObject js = new JSONObject ();
		str = js.toString();
		JsonPath jt = new JsonPath(str);
		jt.get("place_id");
		JSONArray ja= new JSONArray();
		JSONObject jy = new JSONObject();
		jy.put("lat", -38.383494);
		jy.put("lng", 33.427362);
		ja.add(jy);
		js.put("location", jy);
		js.put("accuracy", 50);
		js.put("name", "Frontline house");
		js.put("phone_number", "983 893 3937");
		js.put("address", "29, side layout, cohen 09");
		js.put("types", "shoe park");
		js.put("website", "http://google.com");
		js.put("language", "French-IN");
		given().queryParam("key","qaclick123")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(js)
		.when()
		.post("http://216.10.245.166/maps/api/place/add/json/")
        .then()
        .statusCode(200)
        .log()
        .all();
		System.out.println(js);	
	}
	@Test(enabled= true)
	 
	public void delete() {
		JSONObject js = new JSONObject ();
		js.put("place_id", "e7de663c709d20be91ccc9e9a1ffc3ef");
		
		given().queryParam("key","qaclick123")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(js)
		.when()
		.post("http://216.10.245.166/maps/api/place/delete/json/")
        .then()
        .statusCode(200)
        .log()
        .all();
		System.out.println(js);
	}
	
			

}
