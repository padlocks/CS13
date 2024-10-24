package com.padlocks.Geocoding;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Benchmark {
	@JsonProperty("isDefault")
  	private boolean defaultValue;
  	private String benchmarkDescription;
  	private String id;
  	private String benchmarkName;

	public Benchmark() {
	}

	public Benchmark(boolean defaultValue, String benchmarkDescription, String id, String benchmarkName) {
		this.defaultValue = defaultValue;
		this.benchmarkDescription = benchmarkDescription;
		this.id = id;
		this.benchmarkName = benchmarkName;
	}

	public boolean getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(boolean defaultValue) {
		this.defaultValue = defaultValue;
	}

	public String getBenchmarkDescription() {
		return benchmarkDescription;
	}

	public void setBenchmarkDescription(String benchmarkDescription) {
		this.benchmarkDescription = benchmarkDescription;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBenchmarkName() {
		return benchmarkName;
	}

	public void setBenchmarkName(String benchmarkName) {
		this.benchmarkName = benchmarkName;
	}
}
