package com.padlocks.Geocoding;

import com.fasterxml.jackson.databind.ObjectMapper;

public class GridPointParser {
   private final ObjectMapper objectMapper;

  	public GridPointParser() {
    	objectMapper = new ObjectMapper();
  	}

  	public GridPoint toGridPointObject(String jsonString) {
      try {
         // Convert JSON string to Java Object
         return objectMapper.readValue(jsonString, GridPoint.class);
      } catch (Exception e) {
         e.printStackTrace();
         return null;
      }
   }
}