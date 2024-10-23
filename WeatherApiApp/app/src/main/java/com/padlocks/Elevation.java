package com.padlocks;

public class Elevation {
	private String unitCode;
	private Integer value;

	public Elevation() {
	}

	public Elevation(String unitCode, Integer value) {
		this.unitCode = unitCode;
		this.value = value;
	}

	public String getUnitCode() {
		return unitCode;
	}

	public Integer getValue() {
		return value;
	}
}