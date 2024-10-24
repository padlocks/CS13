package com.padlocks.Geocoding;

public class AddressMatch {
	private TigerLine tigerLine;
	private Coordinates coordinates;
  	private AddressComponents addressComponents;
  	private String matchedAddress;

	public AddressMatch() {
	}

	public AddressMatch(TigerLine tigerLine, Coordinates coordinates, AddressComponents addressComponents, String matchedAddress) {
		this.tigerLine = tigerLine;
		this.coordinates = coordinates;
		this.addressComponents = addressComponents;
		this.matchedAddress = matchedAddress;
	}

	public TigerLine getTigerLine() {
		return tigerLine;
	}

	public void setTigerLine(TigerLine tigerLine) {
		this.tigerLine = tigerLine;
	}

	public Coordinates getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(Coordinates coordinates) {
		this.coordinates = coordinates;
	}

	public AddressComponents getAddressComponents() {
		return addressComponents;
	}

	public void setAddressComponents(AddressComponents addressComponents) {
		this.addressComponents = addressComponents;
	}

	public String getMatchedAddress() {
		return matchedAddress;
	}

	public void setMatchedAddress(String matchedAddress) {
		this.matchedAddress = matchedAddress;
	}
}
