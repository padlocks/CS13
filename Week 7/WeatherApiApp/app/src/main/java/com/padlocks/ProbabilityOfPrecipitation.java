package com.padlocks;

public class ProbabilityOfPrecipitation {
	private String unitCode;
	private Integer value;

	public ProbabilityOfPrecipitation() {
	}

	public ProbabilityOfPrecipitation(String unitCode, Integer value) {
		this.unitCode = unitCode;
		this.value = value;
	}

	public String getUnitCode() {
		return unitCode;
	}

	public Integer getValue() {
		if (value == null) {
			return 0;
		} else {
			return value;
		}
	}
}