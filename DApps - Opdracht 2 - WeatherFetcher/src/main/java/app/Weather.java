package app;

public class Weather {

	private String	name;
	private double	windSpeed;
	private double	windDirection;
	private String	weatherDescription;
	private int		sunrise, sunset;
	
	private long timestamp = System.currentTimeMillis();

	public String getName() {
		return name;
	}

	public double getWindSpeed() {
		return windSpeed;
	}

	public double getWindDirection() {
		return windDirection;
	}

	public String getWeatherDescription() {
		return weatherDescription;
	}

	public int getSunrise() {
		return sunrise;
	}

	public int getSunset() {
		return sunset;
	}
	
	public long getTimestamp() {
		return timestamp;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setWindSpeed(double windSpeed) {
		this.windSpeed = windSpeed;
	}

	public void setWindDirection(double windDirection) {
		this.windDirection = windDirection;
	}

	public void setWeatherDescription(String weatherDescription) {
		this.weatherDescription = weatherDescription;
	}

	public void setSunrise(int sunrise) {
		this.sunrise = sunrise;
	}

	public void setSunset(int sunset) {
		this.sunset = sunset;
	}
	
	
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
}
