package com.target;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.target.dtos.InputDto;

public class NextBusTest {

	@Test
	public void getNextBusTest() throws JsonParseException, JsonMappingException, IOException {

		InputDto input = setInput();
		Double timeDIff = NextBus.getNextBus(input);
		assertTrue(timeDIff > 0.00);

	}

	private InputDto setInput() {
		InputDto dto = new InputDto();
		dto.setRoute("METRO Green Line");
		dto.setDirection("EAST");
		dto.setBusStop("Union Depot ");
		return dto;
	}

}
