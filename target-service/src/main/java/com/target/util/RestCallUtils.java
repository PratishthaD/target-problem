package com.target.util;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * 
 * @author Pratishtha Dwivedi
 *
 */
public class RestCallUtils {

	/**
	 * 
	 * @param url
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static String getResponseFromAPI(String url) {
		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity(requestHeaders);
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
		return response.getBody();
	}
}
