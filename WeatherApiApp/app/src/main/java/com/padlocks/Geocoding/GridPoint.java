package com.padlocks.Geocoding;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.padlocks.Geometry;

public class GridPoint {
	@JsonProperty("@context")
  	private List<Object> context;
  	private String id;
  	private String type;
	private Geometry geometry;
	private Properties properties;

	public GridPoint() {
	}

	public GridPoint(List<Object> context, String id, String type, Geometry geometry, Properties properties) {
		this.context = context;
		this.id = id;
		this.type = type;
		this.geometry = geometry;
		this.properties = properties;
	}

	public List<Object> getContext() {
		return context;
	}

	public void setContext(List<Object> context) {
		this.context = context;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Geometry getGeometry() {
		return geometry;
	}

	public void setGeometry(Geometry geometry) {
		this.geometry = geometry;
	}

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	public static GridPoint getGridPoint(Location location) {
		GridPointApiClient gridPointApiClient = GridPointApiClient.getGridPointClient(location);
		GridPoint gridPoint = gridPointApiClient.getGridPoint(location, 0);
		return gridPoint;
	}

	public String getGridId() {
		if (properties != null) {
			return properties.getGridId();
		}
   		return null;
	}

	public int getGridX() {
		if (properties != null) {
			return properties.getGridX();
		}
		return -1; // Return a default value if properties are not set
	}

	public int getGridY() {
		if (properties != null) {
			return properties.getGridY();
		}
		return -1; // Return a default value if properties are not set
	}

	@Override
	public String toString() {
		return getGridId() + "/" + getGridX() + "," + getGridY();
	}
}