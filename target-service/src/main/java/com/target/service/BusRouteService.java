package com.target.service;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.target.dtos.NextTripDto;

/**
 * 
 * @author Pratishtha Dwivedi
 *
 */
public interface BusRouteService {

	String getRoute(String string) throws JsonParseException, JsonMappingException, IOException;

	String getDirection(String string);

	String getBusStop(String busStop, String dir, String route)
			throws JsonParseException, JsonMappingException, IOException;

	NextTripDto getNextTrip(String route, String direction, String busStop)
			throws JsonParseException, JsonMappingException, IOException;

	Double getNextTripTime(String route, String direction, String busStop)
			throws JsonParseException, JsonMappingException, IOException;

}
