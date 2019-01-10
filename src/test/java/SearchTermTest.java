package test.java;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import helpers.ResponseValidator;
import helpers.SearchUrlHelper;
import io.restassured.response.Response;

public class SearchTermTest {
	
  @Test
  public void searchTermLotsOfResults() {
	  String searchUrl = SearchUrlHelper.createSearchUrlWithQueryParameter("apollo 11");
	  Response response = given().when().get(searchUrl);
	  ResponseValidator.validateStandadardResponse(response, searchUrl);
	  ResponseValidator.collectionLinksPresent(response);
	  ResponseValidator.collectionMetadataTotalHitsGreaterThanZero(response);
  }
  @Test
  public void searchTermNoResults() {
	  String searchUrl = SearchUrlHelper.createSearchUrlWithQueryParameter("blahblahblah");
	  Response response = given().when().get(searchUrl);
	  ResponseValidator.validateStandadardResponse(response, searchUrl);
	  ResponseValidator.collectionLinksNotPresent(response);
	  ResponseValidator.collectionMetadataTotalHitsZero(response);
  }
  
  @Test
  public void searchLessThanOneHundredResults() {
	  String searchUrl = SearchUrlHelper.createSearchUrlWithQueryParameter("solar eclipse japan");
	  Response response = given().when().get(searchUrl);
	  ResponseValidator.validateStandadardResponse(response, searchUrl);
	  ResponseValidator.collectionLinksNotPresent(response);
	  ResponseValidator.collectionMetadataTotalHitsGreaterThanZero(response);
  }

}
