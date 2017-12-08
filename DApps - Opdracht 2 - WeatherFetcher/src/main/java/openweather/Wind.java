package openweather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Wind {

	private double speed;
	private int deg;
	
	
	public double getSpeed() {
		return speed;
	}
	
	
	public int getDeg() {
		return deg;
	}
	
	@Override
	public String toString() {
		return speed + " knots at " + deg + "°";
	}
}
