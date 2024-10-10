package com.padlocks;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherForecastApiResponse {
    @JsonProperty("@context")
    private List<Object> context;
    private String type;
    private Geometry geometry;
    private Properties properties;

    public WeatherForecastApiResponse() {
    }

    public WeatherForecastApiResponse(List<Object> context, String type, Geometry geometry, Properties properties) {
        this.context = context;
        this.type = type;
        this.geometry = geometry;
        this.properties = properties;
    }

    public List<Object> getContext() {
        return context;
    }

    public String getType() {
        return type;
    }

    public Geometry getGeometry() {
        return geometry;
    }

    public Properties getProperties() {
        return properties;
    }
}