package com.ssafy.mvc.model.dto;

public class LatLng {
    private int key;
	private double lat;
    private double lng;

    public LatLng() {
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
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
                "key=" + key +
                ", lat=" + lat +
                ", lng=" + lng +
                '}';
    }
}
