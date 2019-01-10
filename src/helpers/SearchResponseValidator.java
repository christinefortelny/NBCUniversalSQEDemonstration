package helpers;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertTrue;

import java.util.List;

import ResponseStructure.SearchResponse;
import ResponseStructure.SearchResponseData;
import ResponseStructure.SearchResponseItem;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static io.restassured.module.jsv.JsonSchemaValidator.*;

public class SearchResponseValidator {
	
	private static String expectedVersion = "1.0";
	
	public static void validateStandadardResponse(Response response, String searchUrl) {
		
		response.then().assertThat().statusCode(200);
		response.then().body(matchesJsonSchemaInClasspath("searchResultSchema.json"));
		response.then().body("", hasKey("collection"));
		
		response.then().body("collection.version", equalTo(expectedVersion));
		response.then().body("collection", hasKey("items"));
		response.then().body("collection", hasKey("metadata"));
		response.then().body("collection.metadata", hasKey("total_hits"));

		response.then().body("collection", hasKey("href"));
		response.then().body("collection.href",equalTo(encodeUrl(searchUrl)));
	}
	
	public static void collectionMetadataTotalHitsGreaterThanZero(Response response) {
		response.then().body("collection.metadata.total_hits", greaterThan(0));
	}
	
	public static void collectionMetadataTotalHitsZero(Response response) {
		response.then().body("collection.metadata.total_hits", equalTo(0));
	}
	public static void collectionLinksPresent(Response response) {
		response.then().body("collection", hasKey("links"));
	}
	
	public static void collectionLinksNotPresent(Response response) {

		response.then().body("collection", not(hasKey("links")));
	}
	
	public static void resultCollectionItemDataKeywordContainsQueryParam(Response response, String centerQueryParameter) {
		SearchResponse searchResponse = response.getBody().as(SearchResponse.class);
		for (SearchResponseItem responseItem : searchResponse.collection.items) {
			for (SearchResponseData data : responseItem.data) {
				assertTrue(data.center.toLowerCase().equals(centerQueryParameter.toLowerCase()), "Incorrect ceneter value");
			}
		}
	}
	
	public static void resultCollectionItemDataDescriptionContainsQueryParam(Response response, String descriptionQueryParameter) {
		String[] expectedTerms = descriptionQueryParameter.toLowerCase().split("\\s+");
		SearchResponse searchResponse = response.getBody().as(SearchResponse.class);
		for (SearchResponseItem responseItem : searchResponse.collection.items) {
			for (SearchResponseData data : responseItem.data) {
				for (String expecterdTerm : expectedTerms) {
					assertTrue(data.description.toLowerCase().contains(expecterdTerm), "Description does not contain query param ");
				}
			}
		}
	}
	
	private static String encodeUrl(String url) {
		// Temporary replace spaces until url encoders can be investigated further
		try {
			url = url.replace(" ", "%20"); 
		} catch (Exception e) { }
		return url;
	}

}
