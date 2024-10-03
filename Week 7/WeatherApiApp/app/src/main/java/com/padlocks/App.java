package com.padlocks;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class App {
    public static void main(String[] args) {
        WeatherForecastApiClient client = new WeatherForecastApiClient("https://api.weather.gov/gridpoints/STO/53,76/forecast");
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            JsonNode node = objectMapper.readTree(client.getWeatherForecast());
            JsonNode periods = node.get("properties").get("periods");

            for (JsonNode period : periods) {
                StringBuilder forecast = new StringBuilder();
                forecast.append(period.get("name").asText()).append("\n");
                forecast.append(period.get("temperature").asInt()).append(" ").append(period.get("temperatureUnit").asText()).append("\n");
                forecast.append("Probability of precipitation: ").append(period.get("probabilityOfPrecipitation").get("value").asInt()).append("%\n");
                forecast.append("Wind: ").append(period.get("windSpeed").asText()).append(" ").append(period.get("windDirection").asText()).append("\n");
                forecast.append(period.get("detailedForecast").asText()).append("\n\n");

                System.out.println(forecast.toString());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        // System.out.println(client.getWeatherForecast());
    }
}
