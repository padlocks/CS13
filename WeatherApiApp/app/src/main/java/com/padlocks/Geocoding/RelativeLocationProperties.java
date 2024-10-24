package com.padlocks.Geocoding;

public class RelativeLocationProperties {
	private String city;
	private String state;
	private Distance distance;
	private Bearing bearing;

	public RelativeLocationProperties() {
	}

	public RelativeLocationProperties(String city, String state, Distance distance, Bearing bearing) {
		this.city = city;
		this.state = state;
		this.distance = distance;
		this.bearing = bearing;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Distance getDistance() {
		return distance;
	}

	public void setDistance(Distance distance) {
		this.distance = distance;
	}

	public Bearing getBearing() {
		return bearing;
	}

	public void setBearing(Bearing bearing) {
		this.bearing = bearing;
	}
}
