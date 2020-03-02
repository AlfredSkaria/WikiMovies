package com.thinkanalytics.wikimovies.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.thinkanalytics.wikimovies.api.MovieDetailsApi;
import com.thinkanalytics.wikimovies.dto.MovieDataDTO;
import com.thinkanalytics.wikimovies.service.MovieDetailsService;

@RestController
@CrossOrigin
public class MovieDetailsController implements MovieDetailsApi {

	@Autowired
	MovieDetailsService movieDetailsServiceImpl;

	@Override
	public ResponseEntity<MovieDataDTO> getMovieDetails(String topic) {
		return new ResponseEntity<MovieDataDTO>(movieDetailsServiceImpl.getMovieDetailsByName(topic), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<String>> getAllMovieTitles() {
		return new ResponseEntity<List<String>>(movieDetailsServiceImpl.getMovieTitles(), HttpStatus.OK);
	}

}
