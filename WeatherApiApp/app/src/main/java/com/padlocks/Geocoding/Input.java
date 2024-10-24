package com.padlocks.Geocoding;

public class Input {
	private Address address;
	private Benchmark benchmark;

	public Input() {
	}

	public Input(Address address, Benchmark benchmark) {
		this.address = address;
		this.benchmark = benchmark;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Benchmark getBenchmark() {
		return benchmark;
	}

	public void setBenchmark(Benchmark benchmark) {
		this.benchmark = benchmark;
	}
}
