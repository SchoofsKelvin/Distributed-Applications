package openweather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherData {

	private Coord		coord;
	private Weather[]	weather;
	private String		base;
	private WeatherMain	main;
	private int			visibility;
	private Wind		wind;
	private Clouds		clouds;
	private int			dt;
	private Sys			sys;
	private int			id;
	private String		name;
	private int			cod;

	public WeatherData() {}

	public Coord getCoord() {
		return coord;
	}

	public Weather[] getWeather() {
		return weather;
	}

	public String getBase() {
		return base;
	}

	public WeatherMain getMain() {
		return main;
	}

	public int getVisibility() {
		return visibility;
	}

	public Wind getWind() {
		return wind;
	}

	public Clouds getClouds() {
		return clouds;
	}

	public int getDt() {
		return dt;
	}

	public Sys getSys() {
		return sys;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getCod() {
		return cod;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder("Weather");
		result.append("Coords: " + coord + "\n");
		result.append("Weathers (" + weather.length + ")\n");
		for (Weather w : weather) {
			result.append("- " + w + "\n");
		}
		result.append("Base: " + base + "\n");
		result.append("Main: " + main + "\n");
		result.append("Visibility: " + visibility + "\n");
		result.append("Wind: " + wind + "\n");
		result.append("Clouds: " + clouds + "\n");
		result.append("Dt: " + dt + "\n");
		result.append("Sys: " + sys + "\n");
		result.append("Id: " + id + "\n");
		result.append("Name: " + name + "\n");
		result.append("Cod: " + cod + "\n");
		return result.toString();
	}
}
