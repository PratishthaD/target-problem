/**
 * 
 */
package com.target.util;

/**
 * 
 * @author Pratishtha Dwivedi
 *
 */
public class TimeUtils {

	/**
	 * This API calculates time difference from current time 
	 * 
	 * @param nextBusTime
	 * @return
	 */
	public static Double getTimeDiff(long nextBusTime) {
		long currentTimeinMiilis = System.currentTimeMillis();
		Double minutes = (double) ((nextBusTime - currentTimeinMiilis) / 60000);
		return minutes;
	}
	
}
