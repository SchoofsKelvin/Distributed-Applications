package app;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Component;

import travel.model.Weather;

@Component
public class WeatherService {

	private HashMap<String, List<Weather>> weathers = new HashMap<>();

	private List<Weather> getList(String name) {
		List<Weather> list = weathers.get(name.toLowerCase());
		if (list != null) return list;
		list = new ArrayList<>();
		weathers.put(name.toLowerCase(), list);
		return list;
	}

	public void addWeather(Weather weather) {
		getList(weather.getName()).add(weather);
	}

	public Collection<List<Weather>> getAll() {
		return weathers.values();
	}

	public double getAverageWindspeed(String name) {
		List<Weather> list = weathers.get(name.toLowerCase());
		double total = 0;
		for (Weather weather : list) {
			total += weather.getWindSpeed();
		}
		return total / weathers.size();
	}

	public Weather get(String name) {
		List<Weather> list = weathers.get(name.toLowerCase());
		if (list == null) return null;
		if (list.size() == 0) return null;
		return list.get(list.size()-1);
	}
}
