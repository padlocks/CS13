package com.padlocks;

// This class will handle making an HTTP GET request to the NWS API and retrieving the JSON response.

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class WeatherForecastApiClient {
	private String API_STRING;

	public WeatherForecastApiClient(String api) {
		API_STRING = api;
	}

	public String getApiString() {
		return API_STRING;
	}

	public void setApiString(String api) {
		API_STRING = api;
	}

	public String getWeatherForecast() {
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