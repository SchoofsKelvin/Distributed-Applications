package openweather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherMain {

	private double	temp;
	private double	pressure;
	private double	humidity;
	private double	temp_min;
	private double	temp_max;

	public double getTemp() {
		return temp;
	}

	public double getPressure() {
		return pressure;
	}

	public double getHumidity() {
		return humidity;
	}

	public double getTemp_min() {
		return temp_min;
	}

	public double getTemp_max() {
		return temp_max;
	}

	@Override
	public String toString() {
		return "Temperature: " + temp + " Kelvin\nPressure: " + pressure + "\nHumidity: "
			+ humidity + "\nMinimum temperature: " + temp_min + "\nMaximum temperature: "
			+ temp_max;
	}
}
