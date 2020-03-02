package com.thinkanalytics.wikimovies.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.thinkanalytics.wikimovies.dto.MovieDataDTO;
import com.thinkanalytics.wikimovies.model.Category;
import com.thinkanalytics.wikimovies.model.MovieDetailsModel;
import com.thinkanalytics.wikimovies.service.MovieDetailsService;

@Service
public class MovieDetailsServiceImpl implements MovieDetailsService{
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}

	private static Logger logger = LoggerFactory.getLogger(MovieDetailsServiceImpl.class);
	
	@Override
	public MovieDataDTO getMovieDetailsByName(String movieName) {

		String url = "https://en.wikipedia.org/w/api.php?action=parse&section=0&prop=text&page="+movieName+"&format=json";
		MovieDetailsModel content = new MovieDetailsModel();
		try {
			content = restTemplate.getForObject(url, MovieDetailsModel.class);
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		List<String> movieCategories = getMovieCategories(movieName);
		String movieContent = content.getParse().getText().getContent();
		Document doc = Jsoup.parse(movieContent);
		MovieDataDTO movieDataDTO = new MovieDataDTO();
		//Elements tableContent = doc.select("table > tbody > tr > th ~ td > a");
		Elements summaryElement = doc.select("table ~ p");
		Elements tableContent = doc.select("table > tbody > tr");
		Map<String, String[]> movieData = createMovieData(tableContent);
		movieDataDTO.setSummary(summaryElement.text());
		movieDataDTO.setMovieCrew(movieData);
		movieDataDTO.setCategories(movieCategories);
		logger.info("Title: "+ content.getParse().getTitle());
		return movieDataDTO;
	}

	private List<String> getMovieCategories(String movieName) {
		String url = "https://en.wikipedia.org/w/api.php?action=parse&section=0&prop=categories&page="+movieName+"&format=json";
		MovieDetailsModel content = new MovieDetailsModel();
		try {
			content = restTemplate.getForObject(url, MovieDetailsModel.class);
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		List<Category> categories = content.getParse().getCategories();
		List<String> categoryList = new ArrayList<String>();
		for(Category category : categories) {
			if(category.getHidden()!=null ) {
				categoryList.add(category.getData());
			}
		}
		return categoryList;
	}

	private Map<String, String[]> createMovieData(Elements tableContent) {
		Map<String, String[]> movieData = new HashMap<String, String[]>();
		
		for(Element tr : tableContent) {
			Element th = tr.getElementsByTag("th").first();
			if(th != null) {
				Element td = tr.getElementsByTag("td").first();
				if(td != null ) {
					String[] movieCrew = td.text().split("\n");
					movieData.put(th.text(), movieCrew);
				}
				
			}
			
		}
		return movieData;
		
	}

	@Override
	public List<String> getMovieTitles() {
		List<String> movieTitles = new ArrayList<String>();
		movieTitles.addAll(Arrays.asList("Kumbalangi Nights,The Matrix, Avengers: Endgame,The Fate of the Furious, Furious 7, Fast & Furious 6"
				+ "Fast Five, Fast & Furious, The Fast and the Furious: Tokyo Drift, 2 Fast 2 Furious, Iron Man, Iron Man2, Iron Man3, Thor, Thor: Ragnork, Captain America: The First Avenger"
				+ "Titanic, Men in Black, Jurrassic Park, It, It Chapter Two, Fury, Die Hard, Die Hard 2, Die Hard with a Vengeance, Live Free or Die Hard"
				+ "Speed, Troy, Tron, Up, Tangled, Rush"));
		return movieTitles;
	}
	
	

}
