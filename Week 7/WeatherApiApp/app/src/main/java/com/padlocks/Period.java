package com.padlocks;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Period {
	private int number;
	private String name;
	private String startTime;
	private String endTime;
	@JsonProperty("isDaytime")
	private boolean daytime;
	private int temperature;
	private String temperatureUnit;
	private String temperatureTrend;
	private ProbabilityOfPrecipitation probabilityOfPrecipitation;
	private String windSpeed;
	private String windDirection;
	private String icon;
	private String shortForecast;
	private String detailedForecast;

	public Period() {
	}

	public Period(int number, String name, String startTime, String endTime, boolean daytime, int temperature, String temperatureUnit, String temperatureTrend, ProbabilityOfPrecipitation probabilityOfPrecipitation, String windSpeed, String windDirection, String icon, String shortForecast, String detailedForecast) {
		this.number = number;
		this.name = name;
		this.startTime = startTime;
		this.endTime = endTime;
		this.daytime = daytime;
		this.temperature = temperature;
		this.temperatureUnit = temperatureUnit;
		this.temperatureTrend = temperatureTrend;
		this.probabilityOfPrecipitation = probabilityOfPrecipitation;
		this.windSpeed = windSpeed;
		this.windDirection = windDirection;
		this.icon = icon;
		this.shortForecast = shortForecast;
		this.detailedForecast = detailedForecast;
	}

	public int getNumber() {
		return number;
	}

	public String getName() {
		return name;
	}

	public String getStartTime() {
		return startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public boolean isDaytime() {
		return daytime;
	}

	public int getTemperature() {
		return temperature;
	}

	public String getTemperatureUnit() {
		return temperatureUnit;
	}

	public String getTemperatureTrend() {
		return temperatureTrend;
	}

	public ProbabilityOfPrecipitation getProbabilityOfPrecipitation() {
		return probabilityOfPrecipitation;
	}

	public String getWindSpeed() {
		return windSpeed;
	}

	public String getWindDirection() {
		return windDirection;
	}

	public String getIcon() {
		return icon;
	}

	public String getShortForecast() {
		return shortForecast;
	}

	public String getDetailedForecast() {
		return detailedForecast;
	}
}