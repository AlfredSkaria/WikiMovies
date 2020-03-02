package com.thinkanalytics.wikimovies.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.thinkanalytics.wikimovies.dto.MovieDataDTO;

/**
 * 
 * @author Alfred Skaria
 *
 */
@RequestMapping("/api")
public interface MovieDetailsApi {
	
	@GetMapping(value = "/movie", produces = {"application/json"})
	ResponseEntity<MovieDataDTO> getMovieDetails(@RequestParam("topic") String topic);
	
	@GetMapping(value = "/movie/titles", produces = {"application/json"})
	ResponseEntity<List<String>> getAllMovieTitles();

}
