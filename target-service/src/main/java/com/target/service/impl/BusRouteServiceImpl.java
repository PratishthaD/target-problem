package com.target.service.impl;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.target.constants.Constants;
import com.target.dtos.BusStopDto;
import com.target.dtos.NextTripDto;
import com.target.dtos.RouteDto;
import com.target.enums.Directions;
import com.target.service.BusRouteService;
import com.target.util.RestCallUtils;
import com.target.util.TimeUtils;

/**
 * 
 * @author Pratishtha Dwivedi
 *
 */
public class BusRouteServiceImpl implements BusRouteService {

	/*
	 * 
	 * (non-Javadoc)
	 * @see com.target.service.BusRouteService#getRoute(java.lang.String)
	 */
	public String getRoute(String busRoute) throws JsonParseException, JsonMappingException, IOException {
		String url = Constants.API_END_POINT + "Routes?format=json";
		String response = RestCallUtils.getResponseFromAPI(url);

		ObjectMapper mapper = new ObjectMapper();
		RouteDto[] res = mapper.readValue(response, RouteDto[].class);

		String route = "";
		for (RouteDto routeDto : res) {
			if (busRoute.equalsIgnoreCase(routeDto.getDescription())) {
				route = routeDto.getRoute();
				break;
			}
		}
		if (route.isEmpty()) {
			System.out.println("No such Route found");
			System.exit(0);
		}
		return route;
	}

	/**
	 * 
	 */
	public String getDirection(String direction) {
		switch (direction.toUpperCase()) {
		case "NORTH":
			return Directions.NORTH.getDirectionId();
		case "SOUTH":
			return Directions.SOUTH.getDirectionId();
		case "EAST":
			return Directions.EAST.getDirectionId();
		case "WEST":
			return Directions.WEST.getDirectionId();
		}

		System.out.println("Please enter correct Direction.");
		System.exit(0);
		return null;
	}

	/**
	 * 
	 */
	public String getBusStop(String busStop, String dir, String route)
			throws JsonParseException, JsonMappingException, IOException {
		String busStopVal = "";
		String url = Constants.API_END_POINT + "Stops/" + route + "/" + dir + "?format=json";
		String response = RestCallUtils.getResponseFromAPI(url);

		ObjectMapper mapper = new ObjectMapper();
		BusStopDto[] res = mapper.readValue(response, BusStopDto[].class);
		for (BusStopDto busStopDto : res) {
			if (busStop.equalsIgnoreCase(busStopDto.getText())) {
				busStopVal = busStopDto.getValue();
				break;
			}
		}
		if (busStopVal.isEmpty()) {
			System.out.println("No such Bus Stop found");
			System.exit(0);
		}
		return busStopVal;
	}
	
	/**
	 * 
	 */
	public Double getNextTripTime(String route, String direction, String busStop)
			throws JsonParseException, JsonMappingException, IOException {
		NextTripDto nextTripDto = getNextTrip(route, direction, busStop);

		Pattern jsonDatePattern = Pattern.compile(Constants.SPECIFIED_DATE_FORMAT);
		String dateFromJson = nextTripDto.getDepartureTime();
		Matcher m = jsonDatePattern.matcher(dateFromJson);
		if (m.matches()) {
			return TimeUtils.getTimeDiff(Long.parseLong(m.group(1)));
		}
		return null;
	}


	/**
	 * 
	 */
	public NextTripDto getNextTrip(String route, String direction, String busStop)
			throws JsonParseException, JsonMappingException, IOException {
		
		if (null != route && null != direction && busStop != null) {

			String url = Constants.API_END_POINT + route + "/" + direction + "/" + busStop + "?format=json";
			String response = RestCallUtils.getResponseFromAPI(url);
			ObjectMapper mapper = new ObjectMapper();
			NextTripDto[] res = mapper.readValue(response, NextTripDto[].class);
			if (res.length > 0) {
				return res[0];
			} 
		}
		return null;
	}

	
}
