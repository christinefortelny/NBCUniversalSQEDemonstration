package test.java;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import helpers.SearchRequestParameters;
import helpers.SearchResponseValidator;
import helpers.SearchUrlCreator;
import io.restassured.response.Response;

public class CenterParameterTest {
	
  @Test
  public void centerLotsOfResults() {
	  String queryString = "HQ";
	  String searchUrl = SearchUrlCreator.createSearchUrl(new SearchRequestParameters().setCenter(queryString));
	  Response response = given().when().get(searchUrl);
	  SearchResponseValidator.validateStandadardResponse(response, searchUrl);
	  SearchResponseValidator.collectionLinksPresent(response);
	  SearchResponseValidator.collectionMetadataTotalHitsGreaterThanZero(response);
	  SearchResponseValidator.resultCollectionItemDataKeywordContainsQueryParam(response, queryString);
  }
  @Test
  public void centerNoResults() {
	  String searchUrl = SearchUrlCreator.createSearchUrl(new SearchRequestParameters().setCenter("texas"));
	  Response response = given().when().get(searchUrl);
	  SearchResponseValidator.validateStandadardResponse(response, searchUrl);
	  SearchResponseValidator.collectionLinksNotPresent(response);
	  SearchResponseValidator.collectionMetadataTotalHitsZero(response);
  }


}
