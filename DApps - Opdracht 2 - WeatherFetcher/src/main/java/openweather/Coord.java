package openweather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Coord {

	private double lon;
	private double lat;
	
	
	public double getLon() {
		return lon;
	}
	
	public double getLat() {
		return lat;
	}
	
	@Override
	public String toString() {
		return "N" + lat + " " + lon + "S";
	}
}
