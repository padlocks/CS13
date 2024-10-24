package com.padlocks.Geocoding;

public class TigerLine {
	private String side;
	private String tigerLineId;

	public TigerLine() {
	}

	public TigerLine(String side, String tigerLineId) {
		this.side = side;
		this.tigerLineId = tigerLineId;
	}

	public String getSide() {
		return side;
	}

	public void setSide(String side) {
		this.side = side;
	}

	public String getTigerLineId() {
		return tigerLineId;
	}

	public void setTigerLineId(String tigerLineId) {
		this.tigerLineId = tigerLineId;
	}
}
