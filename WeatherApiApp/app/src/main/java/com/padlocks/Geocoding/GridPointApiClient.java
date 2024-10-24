package com.padlocks.Geocoding;

public class GridPointApiClient {
	private final String BASE_URL = "https://api.weather.gov/points/";

	private Location location;
	private double latitude;
	private double longitude;
	private String url = "";

	public GridPointApiClient() {
	}

	public GridPointApiClient(Location location) {
		this.location = location;
		this.latitude = location.getLatitude(0);
		this.longitude = location.getLongitude(0);

		this.url = BASE_URL + this.latitude + "," + this.longitude;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public GridPoint getGridPoint(Location location1, int par) {
		GridPointParser gridPointParser = new GridPointParser();
		return gridPointParser.toGridPointObject(this.url);
	}

	public static GridPointApiClient getGridPointClient(Location location) {
		return new GridPointApiClient();
	}

	
}