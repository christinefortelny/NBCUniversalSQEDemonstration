package test.java;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import helpers.SearchRequestParameters;
import helpers.SearchResponseValidator;
import helpers.SearchUrlCreator;
import io.restassured.response.Response;

public class DescriptionParameterTest {
	
	  @Test
	  public void descriptionLotsOfResults() {
		  String queryString = "moon walk";
		  String searchUrl = SearchUrlCreator.createSearchUrl(new SearchRequestParameters().setDescription(queryString));
		  Response response = given().when().get(searchUrl);
		  SearchResponseValidator.validateStandadardResponse(response, searchUrl);
		  SearchResponseValidator.collectionLinksPresent(response);
		  SearchResponseValidator.collectionMetadataTotalHitsGreaterThanZero(response);
		  SearchResponseValidator.resultCollectionItemDataDescriptionContainsQueryParam(response, queryString);
	  }
	  
	  @Test
	  public void descriptionNoResults() {
		  String searchUrl = SearchUrlCreator.createSearchUrl(new SearchRequestParameters().setDescription("kitten"));
		  Response response = given().when().get(searchUrl);
		  SearchResponseValidator.validateStandadardResponse(response, searchUrl);
		  SearchResponseValidator.collectionLinksNotPresent(response);
		  SearchResponseValidator.collectionMetadataTotalHitsZero(response);
	  }
	  
	  @Test
	  public void descriptionLessThanOneHundredResults() {
		  String queryString = "solar eclipse japan";
		  String searchUrl = SearchUrlCreator.createSearchUrl(new SearchRequestParameters().setDescription(queryString));
		  Response response = given().when().get(searchUrl);
		  SearchResponseValidator.validateStandadardResponse(response, searchUrl);
		  SearchResponseValidator.collectionLinksNotPresent(response);
		  SearchResponseValidator.collectionMetadataTotalHitsGreaterThanZero(response);
		  SearchResponseValidator.resultCollectionItemDataDescriptionContainsQueryParam(response, queryString);
	  }
}
