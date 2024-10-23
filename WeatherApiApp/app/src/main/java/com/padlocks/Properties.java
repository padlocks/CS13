package com.padlocks;

import java.util.List;

public class Properties {
	private String units;
	private String forecastGenerator;
	private String generatedAt;
	private String updateTime;
	private String validTimes;
	private Elevation elevation;
	private List<Period> periods;

	public Properties() {
	}

	public Properties(String units, String forecastGenerator, String generatedAt, String updateTime, String validTimes, Elevation elevation, List<Period> periods) {
		this.units = units;
		this.forecastGenerator = forecastGenerator;
		this.generatedAt = generatedAt;
		this.updateTime = updateTime;
		this.validTimes = validTimes;
		this.elevation = elevation;
		this.periods = periods;
	}

	public String getUnits() {
		return units;
	}

	public String getForecastGenerator() {
		return forecastGenerator;
	}

	public String getGeneratedAt() {
		return generatedAt;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public String getValidTimes() {
		return validTimes;
	}

	public Elevation getElevation() {
		return elevation;
	}

	public List<Period> getPeriods() {
		return periods;
	}

	@Override
	public String toString() {
		return "WeatherForecast{" +
				"generatedAt='" + generatedAt + '\'' +
				", updateTime='" + updateTime + '\'' +
				", validTimes='" + validTimes + '\'' +
				", elevation=" + elevation +
				", periods=" + periods +
				'}';
	}
}