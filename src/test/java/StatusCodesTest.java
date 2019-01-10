package test.java;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import helpers.SearchUrlHelper;

public class StatusCodesTest {
	
  @Test
  public void successfulCallReturns200() {
	  given().when().get(SearchUrlHelper.createSearchUrlWithQueryParameter("apollo 11")).then().assertThat().statusCode(200);
  }
  
  @Test
  public void callUnknownResourceReturns404() {
	  given().when().get(SearchUrlHelper.searchUrl+"/assets").then().assertThat().statusCode(404);
  }
  
  @Test
  public void callNoParametersReturns400() {
	  given().when().get(SearchUrlHelper.searchUrl).then().assertThat().statusCode(400);
  }
 
}
