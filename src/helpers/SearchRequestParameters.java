package helpers;

public class SearchRequestParameters {
	
	private String searchTerm="";
	private String center="";
	private String description="";
	private String description508="";
	private String keywords="";
	private String location="";
	private String mediaType="";
	private String nasaId="";
	private String photographer="";
	private String secondaryCreator="";
	private String title="";
	private String yearStart="";
	private String yearEnd="";
	
	private boolean parametersSet = false;
	
	public SearchRequestParameters setSearchTerm(String searchTerm ) {
		this.searchTerm = searchTerm;
		parametersSet = true;
		return this;
	}
	public String getSearchTerm() {
		return searchTerm;
	}
	
	public SearchRequestParameters setCenter(String center ) {
		this.center = center;
		parametersSet = true;
		return this;
	}
	public String getCenter() {
		return center;
	}
	
	public SearchRequestParameters setDescription(String description ) {
		this.description = description;
		parametersSet = true;
		return this;
	}
	public String getDescription() {
		return description;
	}
	
	public SearchRequestParameters setDescription508(String description508) {
		this.description508 = description508;
		parametersSet = true;
		return this;
	}
	public String getDescription508() {
		return description508;
	}
	
	public SearchRequestParameters setKeywords(String keywords ) {
		this.keywords = keywords;
		parametersSet = true;
		return this;
	}
	public String getKeywords() {
		return keywords;
	}
	public SearchRequestParameters setLocation(String location ) {
		this.location = location;
		parametersSet = true;
		return this;
	}
	
	public String getLocation() {
		return location;
	}
	
	public SearchRequestParameters setMediaType(String mediaType ) {
		this.mediaType = mediaType;
		parametersSet = true;
		return this;
	}
	public String getMediaType() {
		return mediaType;
	}
	
	public SearchRequestParameters setNasaId(String nasaId ) {
		this.nasaId = nasaId;
		parametersSet = true;
		return this;
	}
	public String getNasaId() {
		return nasaId;
	}
	
	public SearchRequestParameters setPhotographer(String photographer ) {
		this.photographer = photographer;
		parametersSet = true;
		return this;
	}
	public String getPhotographer() {
		return photographer;
	}
	
	public SearchRequestParameters setSecondaryCreator(String secondaryCreator ) {
		this.secondaryCreator = secondaryCreator;
		parametersSet = true;
		return this;
	}
	public String getSecondaryCreator() {
		return secondaryCreator;
	}

	
	public SearchRequestParameters setTitle(String title ) {
		this.title = title;
		parametersSet = true;
		return this;
	}
	public String getTitle() {
		return title;
	}

	
	public SearchRequestParameters setYearStart(String yearStart ) {
		this.yearStart = yearStart;
		parametersSet = true;
		return this;
	}
	public String getYearStart() {
		return yearStart;
	}
	
	public SearchRequestParameters setYearEnd(String yearEnd ) {
		this.yearEnd = yearEnd;
		parametersSet = true;
		return this;
	}
	public String getYearEnd() {
		return yearEnd;
	}
	
	public boolean hasParametersSet() {
		return parametersSet;
	}
}
