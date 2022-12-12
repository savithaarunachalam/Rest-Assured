package Rest_testing;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.*;
import static io.restassured.RestAssured.*;
import io.restassured.path.json.JsonPath;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;



public class Demo1 {
	public String url = "https://reqres.in/api/users?page=2";
	
	@Test
	 public void get_tc1() {
		Response rep = RestAssured.get(url);
		rep.statusCode();
		rep.body();
		rep.asString();
		System.out.println(rep.statusCode());
		System.out.println(rep.body());
		System.out.println(rep.asString());
		int actual = rep.statusCode();
		Assert.assertEquals(actual, 200);
		
	}

	@Test
	public void get_tc2() {
		given().get(url).then().statusCode(200).log().all(); // I WANT EVERYTHING IN CONSOLE
		//given().get(url).then().statusCode(200).body("data.first_name",hasItems()); //BODY
		given().get(url).then().statusCode(200).body("data.Id[5]",equalTo(7)).log().all();
	
	}
   @Test
   public void post_tc3() {
	  JSONObject js = new JSONObject ();
	   js.put("name", "savi");
	   js.put("job", "tester");
	   given().body(js.toJSONString()).when().post("https://reqres.in/api/users/2").then().statusCode(200).log().all();
	   given().delete("https://reqres.in/api/users/2").then().statusCode(204).log().all();
	   
	   
   }
   @Test
   public void put_tc4() {
	   JSONObject js = new JSONObject ();
	   js.put("name", "savitha");
	   js.put("job", "tester1");
	   given().body(js.toJSONString()).when().post("https://reqres.in/api/users/2").then().statusCode(200).log().all();
	   //given().delete("https://reqres.in/api/users/2").then().statusCode(204).log().all();
   }
   @Test
   public void patch() {
	   JSONObject js = new JSONObject ();
	   js.put("name", "savitha");
	   js.put("job", "tester2");
	   given().body(js.toJSONString()).when().patch("https://reqres.in/api/users/2").then().statusCode(200).log().all();
	   
   }
   @Test
   public void delete() {
	   JSONObject js = new JSONObject ();
	   js.put("name", "savitha");
	   js.put("job", "developer");
	   given().delete("https://reqres.in/api/users/2").then().statusCode(204).log().all();
	  // given().body(js.toJSONString()).when().delete("https://reqres.in/api/users/2").then().statusCode(200).log().all();
   }
   @Test
   public void register () {
	   JSONObject js = new JSONObject ();
	   js.put("email","eve.holt@reqres.in");
	   js.put("password","pistol");
	    Response resp= given().contentType(ContentType.JSON).log().all().body(js).post("https://reqres.in/api/register");
	    resp.prettyPrint();
	
		 
	   
   }
 	
	
}
