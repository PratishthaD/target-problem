package com.target.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * 
 * @author Pratishtha Dwivedi
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class NextTripDto {
	
	@JsonProperty("Actual")
	private boolean actual;
	@JsonProperty("BlockNumber")
	private Integer blockNumber;
	@JsonProperty("DepartureText")
	private String departureText;
	@JsonProperty("DepartureTime")
	private String departureTime;
	@JsonProperty("Description")
	private String description;
	@JsonProperty("Gate")
	private String gate;
	@JsonProperty("Route")
	private String route;
	@JsonProperty("RouteDirection")
	private String direction;
	@JsonProperty("Terminal")
	private String terminal;
	@JsonProperty("VehicleHeading")
	private Integer vehicleHeading;
	@JsonProperty("VehicleLatitude")
	private Integer vehicleLatitude;
	@JsonProperty("VehicleLongitude")
	private Integer vehicleLongitude;
	
	public boolean isActual() {
		return actual;
	}
	public void setActual(boolean actual) {
		this.actual = actual;
	}
	public Integer getBlockNumber() {
		return blockNumber;
	}
	public void setBlockNumber(Integer blockNumber) {
		this.blockNumber = blockNumber;
	}
	public String getDepartureText() {
		return departureText;
	}
	public void setDepartureText(String departureText) {
		this.departureText = departureText;
	}
	public String getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getGate() {
		return gate;
	}
	public void setGate(String gate) {
		this.gate = gate;
	}
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
	public String getTerminal() {
		return terminal;
	}
	public void setTerminal(String terminal) {
		this.terminal = terminal;
	}
	public Integer getVehicleHeading() {
		return vehicleHeading;
	}
	public void setVehicleHeading(Integer vehicleHeading) {
		this.vehicleHeading = vehicleHeading;
	}
	public Integer getVehicleLatitude() {
		return vehicleLatitude;
	}
	public void setVehicleLatitude(Integer vehicleLatitude) {
		this.vehicleLatitude = vehicleLatitude;
	}
	public Integer getVehicleLongitude() {
		return vehicleLongitude;
	}
	public void setVehicleLongitude(Integer vehicleLongitude) {
		this.vehicleLongitude = vehicleLongitude;
	}
	
	
}
