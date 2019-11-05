package com.target.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author Pratishtha Dwivedi
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BusStopDto {

	@JsonProperty("Text")
	private String text;
	@JsonProperty("Value")
	private String value;
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}

	

}
