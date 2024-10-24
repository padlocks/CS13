package com.padlocks.Geocoding;

import java.util.Optional;

public class Location {
	private Result result;

	public Location() {
	}

	public Location(Result result) {
		this.result = result;
	}

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}

	// Helper method to get the Longitude at the specified index
	public double getLongitude(int index) {
   		if (result != null && result.getAddressMatches() != null
      	&& index >= 0 && index < result.getAddressMatches().size()) {

			return result.getAddressMatches().get(index).getCoordinates().getX();

		} else {
      	throw new IndexOutOfBoundsException("Invalid index or no address matches available.");
   		}
	}

	// Helper method to get the Latitude at the specified index
	public double getLatitude(int index) {
		if (result != null && result.getAddressMatches() != null
			&& index >= 0 && index < result.getAddressMatches().size()) {

			return result.getAddressMatches().get(index).getCoordinates().getY();

		} else {
			throw new IndexOutOfBoundsException("Invalid index or no address matches available.");
		}
	}

	// Helper method to combine the API call and parse the JSON
	public static Optional<Location> getLocation(String addressString) {
		GeocodingApiClient geocodingApiClient = new GeocodingApiClient(addressString);
		String locationString = geocodingApiClient.getLocation();

		if (!locationString.isEmpty()) {
			LocationParser locationParser = new LocationParser();
			return Optional.of(locationParser.toLocationObject(locationString));
		} else {
			return Optional.empty();
		}
	}
}