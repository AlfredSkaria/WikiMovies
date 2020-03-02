package com.thinkanalytics.wikimovies.service;

import java.util.List;

import com.thinkanalytics.wikimovies.dto.MovieDataDTO;

public interface MovieDetailsService {
	
	public MovieDataDTO getMovieDetailsByName(String movieName);
	
	public List<String> getMovieTitles();

}
