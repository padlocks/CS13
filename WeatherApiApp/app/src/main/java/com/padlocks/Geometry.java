package com.padlocks;
import java.util.List;

public class Geometry {
	private String type;
	private List<List<List<Double>>> coordinates;

	public Geometry() {
	}

	public Geometry(String type, List<List<List<Double>>> coordinates) {
		this.type = type;
		this.coordinates = coordinates;
	}

	public String getType() {
		return type;
	}

	public List<List<List<Double>>> getCoordinates() {
		return coordinates;
	}
}