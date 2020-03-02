package com.thinkanalytics.wikimovies.dto;

import java.util.List;
import java.util.Map;

public class MovieDataDTO {
	
	private String summary;
	private Map<String, String[]> movieCrew;
	private List<String> categories;
	
	public MovieDataDTO() {}

	public MovieDataDTO(String summary, Map<String, String[]> movieCrew, List<String> categories) {
		super();
		this.summary = summary;
		this.movieCrew = movieCrew;
		this.categories = categories;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public Map<String, String[]> getMovieCrew() {
		return movieCrew;
	}

	public void setMovieCrew(Map<String, String[]> movieCrew) {
		this.movieCrew = movieCrew;
	}

	public List<String> getCategories() {
		return categories;
	}

	public void setCategories(List<String> categories) {
		this.categories = categories;
	}
}
