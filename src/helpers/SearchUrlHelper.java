package helpers;

import java.net.URLEncoder;

public class SearchUrlHelper {
	public static String searchUrl = "https://images-api.nasa.gov/search";
	
	public static String createSearchUrlWithQueryParameter(String query) {
		return String.format("%s?q=%s", searchUrl,  query);
	}
	public static String createSearchUrlWithQueryParameterEncoded(String query) {
		return String.format("%s?q=%s", searchUrl,  encodeParameter(query));
	}
	
	private static String encodeParameter(String parameter) {
		try { 
			parameter = URLEncoder.encode(parameter, "UTF-8");
		} 
		catch (Exception e) { }
		return parameter;
	}
}
