package com.padlocks.Geocoding;

import com.padlocks.Geometry;

public class RelativeLocation {
	private String type;
	private Geometry geometry;
	private RelativeLocationProperties properties;

	public RelativeLocation() {
	}

	public RelativeLocation(String type, Geometry geometry, RelativeLocationProperties properties) {
		this.type = type;
		this.geometry = geometry;
		this.properties = properties;
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

	public RelativeLocationProperties getProperties() {
		return properties;
	}

	public void setProperties(RelativeLocationProperties properties) {
		this.properties = properties;
	}
}
