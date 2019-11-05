package com.target.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author Pratishtha Dwivedi
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RouteDto {

	@JsonProperty("Description")
	private String description;

	@JsonProperty("ProviderID")
	private String providerID;

	@JsonProperty("Route")
	private String route;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getProviderID() {
		return providerID;
	}

	public void setProviderID(String providerID) {
		this.providerID = providerID;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

}
