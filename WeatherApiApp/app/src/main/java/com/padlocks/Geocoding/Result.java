package com.padlocks.Geocoding;

import java.util.List;

public class Result {
	private Input input;
	private List<AddressMatch> addressMatches;

	public Result() {
	}

	public Result(Input input, List<AddressMatch> addressMatches) {
		this.input = input;
		this.addressMatches = addressMatches;
	}

	public Input getInput() {
		return input;
	}

	public void setInput(Input input) {
		this.input = input;
	}

	public List<AddressMatch> getAddressMatches() {
		return addressMatches;
	}

	public void setAddressMatches(List<AddressMatch> addressMatches) {
		this.addressMatches = addressMatches;
	}
}
