package com.target.enums;

/**
 * 
 * @author Pratishtha Dwivedi
 *
 */
public enum Directions {
	SOUTH("1"),
	EAST("2"),
	WEST("3"),
	NORTH("4");
	private String directionId;

	private Directions(String directionId) {
		this.directionId = directionId;
	}

	public String getDirectionId() {
		return directionId;
	}

}
