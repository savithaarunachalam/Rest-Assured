package Rest_testing;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
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
import io.restassured.response.Response;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class trello {
	
	public String url ="https://api.trello.com/";
	//public String key = "20d7919185d6adeb6acda3c48fd82dce";
	//public String token = "985b56a8d0a996de376c4a0fd4de6613ffb1c7fa3b282ac31dc674b8bf05507f";
	public String id;
	
	
	@Test
	public void test() {
		 Response res= RestAssured.get(url);
		 
	}
	 @Test(enabled = true)
	 
	 public void trello() {
		// JSONObject js = new JSONObject ();
		 //JsonPath sa = new JsonPath(js.toJSONString());
		  RestAssured.baseURI =url;
		  //js.put("name","savitha3");
		     Response response = given().queryParam("name","Thanigai1")
		    	  .queryParam("key","e546fca4fddd02ea053aa8d2839ecf4f")
		          .queryParam("token","0be449d70e005e897d585c0dc589b42a3333f6b7afea4d5c7a1f89a5593eb955")
		          .header("Content-Type","application/json")
		          .when()
		          .post("/1/boards/")
		          .then()
		          .assertThat().statusCode(200).contentType(ContentType.JSON)
		          .extract().response();
		            
		         String jsonresponse = response.asString();
			    JsonPath js= new JsonPath(jsonresponse);
			
			   id = js.get("id");
			   System.out.println(id);		
		}
		           
		  
	@Test(enabled= true)
	 public void delete() {
		 JSONObject js = new JSONObject ();
		 RestAssured.baseURI =url;
		 given().queryParam("name","Thanigai1").queryParam("key","e546fca4fddd02ea053aa8d2839ecf4f")
         .queryParam("token","0be449d70e005e897d585c0dc589b42a3333f6b7afea4d5c7a1f89a5593eb955")
         .when()
         .contentType(ContentType.JSON).accept(ContentType.JSON)
         .delete("/1/boards/"+id).then().log().all();
		 
	 }
	@Test(enabled=false)
	
	public void update() {
		JSONObject js = new JSONObject ();
		 RestAssured.baseURI =url;
		 given().queryParam("name","Thanigai").queryParam("key","e546fca4fddd02ea053aa8d2839ecf4f")
        .queryParam("token","0be449d70e005e897d585c0dc589b42a3333f6b7afea4d5c7a1f89a5593eb955")
        .when()
        .contentType(ContentType.JSON).accept(ContentType.JSON)
        .put("/1/boards/id").then().log().all();
		
	}
	
	@Test(enabled =false)
	
	public void boards() {
		JSONObject js = new JSONObject ();
		 RestAssured.baseURI =url;
		 given().queryParam("name","test1").queryParam("key","e546fca4fddd02ea053aa8d2839ecf4f")
       .queryParam("token","0be449d70e005e897d585c0dc589b42a3333f6b7afea4d5c7a1f89a5593eb955")
       .when()
       .contentType(ContentType.JSON).accept(ContentType.JSON)
       .put("/1/boards/").then().log().all();
		
	}
	}


