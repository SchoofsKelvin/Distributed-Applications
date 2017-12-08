package openweather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Clouds {

	private int all;

	public int getAll() {
		return all;
	}

	@Override
	public String toString() {
		return all + "%";
	}
}
