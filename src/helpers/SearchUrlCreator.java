package helpers;

public class SearchUrlCreator {
	public static String searchUrl = "https://images-api.nasa.gov/search";
	
	public static String createSearchUrl(SearchRequestParameters requestParameters) {
		String url = searchUrl;
		if(requestParameters.hasParametersSet()) {
			if(!requestParameters.getSearchTerm().isEmpty()) {
				url += seperator(url) + "q="+ requestParameters.getSearchTerm();
			}
			if(!requestParameters.getCenter().isEmpty()) {
				url += seperator(url) + "center="+ requestParameters.getCenter();
			}
			if(!requestParameters.getDescription().isEmpty()) {
				url += seperator(url) + "description="+ requestParameters.getDescription();
			}
			if(!requestParameters.getDescription508().isEmpty()) {
				url += seperator(url) + "description_508="+ requestParameters.getDescription508();
			}
			if(!requestParameters.getKeywords().isEmpty()) {
				url += seperator(url) + "keywords="+ requestParameters.getKeywords();
			}
			if(!requestParameters.getLocation().isEmpty()) {
				url += seperator(url) + "location="+ requestParameters.getLocation();
			}
			if(!requestParameters.getMediaType().isEmpty()) {
				url += seperator(url) + "media_type="+ requestParameters.getMediaType();
			}
			if(!requestParameters.getNasaId().isEmpty()) {
				url += seperator(url) + "nasa_id="+ requestParameters.getNasaId();
			}
			if(!requestParameters.getPhotographer().isEmpty()) {
				url += seperator(url) + "photographer="+ requestParameters.getPhotographer();
			}
			if(!requestParameters.getSecondaryCreator().isEmpty()) {
				url += seperator(url) + "secondary_creator="+ requestParameters.getSecondaryCreator();
			}
			if(!requestParameters.getTitle().isEmpty()) {
				url += seperator(url) + "title="+ requestParameters.getTitle();
			}
			if(!requestParameters.getYearStart().isEmpty()) {
				url += seperator(url) + "year_start="+ requestParameters.getYearStart();
			}
			if(!requestParameters.getYearEnd().isEmpty()) {
				url += seperator(url) + "year_end="+ requestParameters.getYearEnd();
			}
		}
		
		
		return url;
	}
	private static String seperator(String url) {
		return url.contains("?") ? "&" : "?";
	}

	

}
