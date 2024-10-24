package com.padlocks;

import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.padlocks.Geocoding.GridPoint;
import com.padlocks.Geocoding.Location;

public class App {
    private static final Logger LOGGER = Logger.getLogger(WeatherForecastApiClient.class.getName());
    public static void main(String[] args) throws JsonProcessingException {
        // Street Address to Latitude and Longitude
        String address = "1600 Amphitheatre Parkway, Mountain View, CA";
        Optional<Location> location = Location.getLocation(address);
        GridPoint gridPoint = null;

        if (location.isPresent()) {
            gridPoint = GridPoint.getGridPoint(location.get());
        } else {
            LOGGER.log(Level.WARNING, "Location not available for the address.");
            System.exit(0);
        }

        WeatherForecastApiClient client = new WeatherForecastApiClient(gridPoint.toString());
        ObjectMapper objectMapper = new ObjectMapper();

        WeatherForecastApiResponse response = objectMapper.readValue(client.getWeatherForecast(), WeatherForecastApiResponse.class);
        response.getProperties().getPeriods().forEach(period -> {
            StringBuilder forecast = new StringBuilder();
            forecast.append(period.getName()).append("\n");
            forecast.append(period.getTemperature()).append(" ").append(period.getTemperatureUnit()).append("\n");
            forecast.append("Probability of precipitation: ").append(period.getProbabilityOfPrecipitation().getValue()).append("%\n");
            forecast.append("Wind: ").append(period.getWindSpeed()).append(" ").append(period.getWindDirection()).append("\n");
            forecast.append(period.getDetailedForecast()).append("\n\n");

            System.out.println(forecast.toString());
        });

        // try {
        //     JsonNode node = objectMapper.readTree(client.getWeatherForecast());
        //     JsonNode periods = node.get("properties").get("periods");

        //     for (JsonNode period : periods) {
        //         StringBuilder forecast = new StringBuilder();
        //         forecast.append(period.get("name").asText()).append("\n");
        //         forecast.append(period.get("temperature").asInt()).append(" ").append(period.get("temperatureUnit").asText()).append("\n");
        //         forecast.append("Probability of precipitation: ").append(period.get("probabilityOfPrecipitation").get("value").asInt()).append("%\n");
        //         forecast.append("Wind: ").append(period.get("windSpeed").asText()).append(" ").append(period.get("windDirection").asText()).append("\n");
        //         forecast.append(period.get("detailedForecast").asText()).append("\n\n");

        //         System.out.println(forecast.toString());
        //     }

        // } catch (Exception e) {
        //     e.printStackTrace();
        // }

        // System.out.println(client.getWeatherForecast());
    }
}
