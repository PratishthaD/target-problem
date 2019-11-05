package com.target;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.target.dtos.InputDto;
import com.target.service.BusRouteService;
import com.target.service.impl.BusRouteServiceImpl;

/**
 * 
 * @author Pratishtha Dwivedi
 *
 */
public class NextBus {

	/**
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		InputDto inputDto = takeInput();
		getNextBus(inputDto);

	}
	
	/**
	 * This method takes input from console
	 * 
	 * @return
	 * @throws IOException
	 */
	private static InputDto takeInput() throws IOException {
		InputDto inputDto = new InputDto();

		System.out.println("To get next bus on the route from your stop. Please enter : ");
		System.out.println("1. The bus route in 1st line");
		System.out.println("2. The direction in 2nd line. (Expected input must be one of east, west, north, south)");
		System.out.println("3. Your bus stop in 3rd line.");

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String route = reader.readLine();
		String direction = reader.readLine();
		String busStop = reader.readLine();

		inputDto.setRoute(route);
		inputDto.setDirection(direction);
		inputDto.setBusStop(busStop);

		return inputDto;
	}

	/**
	 * 
	 * @param inputDto
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public static Double getNextBus(InputDto inputDto) throws JsonParseException, JsonMappingException, IOException {
		BusRouteService service = new BusRouteServiceImpl();

		String route = service.getRoute(inputDto.getRoute());
		String direction = service.getDirection(inputDto.getDirection());
		String busStop = service.getBusStop(inputDto.getBusStop(), direction, route);

		if (null != route && null != direction && null != busStop) {
			Double minutesToNextBus = service.getNextTripTime(route, direction, busStop);

			System.out.println("Next bus on route : " + inputDto.getRoute() + " going in " + inputDto.getDirection()
					+ " direction, from the stop : " + inputDto.getBusStop() + " will be arriving in approximately "
					+ minutesToNextBus + " minutes ");
			return minutesToNextBus;
		} else {
			System.out.println("Incorrect input provided .Please provide correct input. ");
			System.exit(0);
		}
		return null;
	}

	

}
