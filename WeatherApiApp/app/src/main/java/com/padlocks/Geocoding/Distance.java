package com.padlocks.Geocoding;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Distance {
	@JsonProperty("unitCode")
	private String unitCode;
	private double value;

	public Distance() {
	}

	public Distance(String unitCode, double value) {
		this.unitCode = unitCode;
		this.value = value;
	}

	public String getUnitCode() {
		return unitCode;
	}

	public void setUnitCode(String unitCode) {
		this.unitCode = unitCode;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}
}
