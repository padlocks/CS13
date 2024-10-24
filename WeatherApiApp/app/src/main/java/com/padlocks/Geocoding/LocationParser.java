package com.padlocks.Geocoding;

import com.fasterxml.jackson.databind.ObjectMapper;

public class LocationParser {
	private final ObjectMapper objectMapper;

  	public LocationParser() {
    	objectMapper = new ObjectMapper();
	}

	public Location toLocationObject(String jsonString) {
		try {
			// Convert JSON string to Java Object
			return objectMapper.readValue(jsonString, Location.class);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
  }
}