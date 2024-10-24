package com.padlocks.Geocoding;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Bearing {
	@JsonProperty("unitCode")
	private String unitCode;
	private int value;

	public Bearing() {
	}

	public Bearing(String unitCode, int value) {
		this.unitCode = unitCode;
		this.value = value;
	}

	public String getUnitCode() {
		return unitCode;
	}

	public void setUnitCode(String unitCode) {
		this.unitCode = unitCode;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
