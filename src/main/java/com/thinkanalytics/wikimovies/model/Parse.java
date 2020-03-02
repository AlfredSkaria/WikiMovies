package com.thinkanalytics.wikimovies.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "title", "pageid", "text","categories"})
public class Parse {

	@JsonProperty("title")
	private String title;
	@JsonProperty("pageid")
	private Integer pageid;
	@JsonProperty("text")
	private Text text;
	@JsonProperty("categories")
	private List<Category> categories;
	
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public Parse() {
	}

	/**
	 *
	 * @param text
	 * @param title
	 * @param pageid
	 */
	public Parse(String title, Integer pageid, Text text, List<Category> categories,
			Map<String, Object> additionalProperties) {
		super();
		this.title = title;
		this.pageid = pageid;
		this.text = text;
		this.categories = categories;
		this.additionalProperties = additionalProperties;
	}

	@JsonProperty("title")
	public String getTitle() {
		return title;
	}



	@JsonProperty("title")
	public void setTitle(String title) {
		this.title = title;
	}

	@JsonProperty("pageid")
	public Integer getPageid() {
		return pageid;
	}

	@JsonProperty("pageid")
	public void setPageid(Integer pageid) {
		this.pageid = pageid;
	}

	@JsonProperty("text")
	public Text getText() {
		return text;
	}

	@JsonProperty("text")
	public void setText(Text text) {
		this.text = text;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	
	

}