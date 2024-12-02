package com.ssafy.mvc.model.dto;

public class Marker {

	private String title;
	private double lat;
	private double lng;

	public Marker() {
	}

	public String getWhat() {
		return title;
	}

	public void setWhat(String title) {
		this.title = title;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}

	@Override
	public String toString() {
		return "{" +
				"what=" + title +
				", lat=" + lat +
				", lng=" + lng +
				'}';
	}
}
