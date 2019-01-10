package test.java;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import helpers.SearchRequestParameters;
import helpers.SearchResponseValidator;
import helpers.SearchUrlCreator;
import io.restassured.response.Response;

public class SearchTermParameterTest {
	
	  @Test
	  public void searchTermLotsOfResults() {
		  String searchUrl = SearchUrlCreator.createSearchUrl(new SearchRequestParameters().setSearchTerm("apollo 11"));
		  Response response = given().when().get(searchUrl);
		  SearchResponseValidator.validateStandadardResponse(response, searchUrl);
		  SearchResponseValidator.collectionLinksPresent(response);
		  SearchResponseValidator.collectionMetadataTotalHitsGreaterThanZero(response);
	  }
	  @Test
	  public void searchTermNoResults() {
		  String searchUrl = SearchUrlCreator.createSearchUrl(new SearchRequestParameters().setSearchTerm("blahblahblah"));
		  Response response = given().when().get(searchUrl);
		  SearchResponseValidator.validateStandadardResponse(response, searchUrl);
		  SearchResponseValidator.collectionLinksNotPresent(response);
		  SearchResponseValidator.collectionMetadataTotalHitsZero(response);
	  }
	  
	  @Test
	  public void searchTermLessThanOneHundredResults() {
		  String searchUrl = SearchUrlCreator.createSearchUrl(new SearchRequestParameters().setSearchTerm("solar eclipse japan"));
		  Response response = given().when().get(searchUrl);
		  SearchResponseValidator.validateStandadardResponse(response, searchUrl);
		  SearchResponseValidator.collectionLinksNotPresent(response);
		  SearchResponseValidator.collectionMetadataTotalHitsGreaterThanZero(response);
	  }
}
