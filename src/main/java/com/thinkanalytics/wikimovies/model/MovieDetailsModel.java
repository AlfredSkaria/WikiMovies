package com.thinkanalytics.wikimovies.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "parse" })
public class MovieDetailsModel {

	@JsonProperty("parse")
	private Parse parse;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public MovieDetailsModel() {
	}

	/**
	 *
	 * @param parse
	 */
	public MovieDetailsModel(Parse parse) {
		super();
		this.parse = parse;
	}

	@JsonProperty("parse")
	public Parse getParse() {
		return parse;
	}

	@JsonProperty("parse")
	public void setParse(Parse parse) {
		this.parse = parse;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}