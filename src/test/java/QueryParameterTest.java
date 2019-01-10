package test.java;
import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static io.restassured.module.jsv.JsonSchemaValidator.*;

import helpers.SearchUrlHelper;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class QueryParameterTest {
	
  @Test
  public void responseWithPaging() {
	  Response response = given().when().get(SearchUrlHelper.createSearchUrlWithQueryParameter("apollo 11"));
	  response.then().body(matchesJsonSchemaInClasspath("searchResultSchema.json"));
	  response.then().body("collection.version", equalTo("1.0"));
	  response.then().body("collection", hasKey("links"));
	  response.then().body("collection.links[0]", hasKey("href"));
	  
	  
	  
//	  
//      get("/greeter").
//      then().
//              body(matchesJsonSchemaInClasspath("greeter-schema.json")). // (1)
//              body("greeting.firstName", equalTo("John")). // (2)
//              body("greeting.lastName", equalTo("Doe"));   // (3)
  }

}
