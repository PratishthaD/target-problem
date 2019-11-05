package com.target.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @author Pratishtha Dwivedi
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class InputDto {

	private String route;
	private String direction;
	private String busStop;
	
	public String getRoute() {
		return route;
	}
	public void setRoute(String route) {
		this.route = route;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public String getBusStop() {
		return busStop;
	}
	public void setBusStop(String busStop) {
		this.busStop = busStop;
	}
	
}
