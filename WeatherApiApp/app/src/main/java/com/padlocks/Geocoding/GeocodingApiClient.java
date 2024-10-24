package com.padlocks.Geocoding;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class GeocodingApiClient {
	private static final String BASE_URL = "https://geocoding.geo.census.gov/geocoder/locations/onelineaddress?benchmark=4&format=json&address=";
	private String address;

	GeocodingApiClient(String address) {
		this.address = address;
		this.address = URLEncoder.encode(address, StandardCharsets.UTF_8);
	}

	public String getApiString() {
		return BASE_URL + this.address;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLocation() {
		HttpResponse response = sendGetRequest();
		return response.body().toString();
	}

	private HttpResponse sendGetRequest() {
        try {
			HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(this.getApiString()))
				.header("Content-Type", "application/json")
                .GET()
                .build();

			HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofString());	
			return response;
        } catch (URISyntaxException | 
				IOException | 
				InterruptedException e) {
			System.out.println(e.toString());
        }
		return null;
	}
}