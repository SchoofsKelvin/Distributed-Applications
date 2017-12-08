package app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.net.URLEncoder;
import java.util.ArrayList;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import openweather.WeatherData;

@Component
public class ScheduledTasks {
	
	private ArrayList<String> locations = new ArrayList<>();
	
	public ScheduledTasks() {
		try {
			try (BufferedReader reader = new BufferedReader(new FileReader("locations.txt"))) {
				reader.lines().forEach(locations::add);
			}
		} catch (Exception e) {
			System.err.println("Couldn't read locations");;
			e.printStackTrace();
		}
	}

	@Scheduled(fixedRate = 600000)
	public void fetchData() {
		for (String loc : locations) {
			try {
				WeatherData data = Application.getData(
					"http://api.openweathermap.org/data/2.5/weather?q=" + URLEncoder.encode(loc,"UTF-8"), WeatherData.class);
				Weather weather = new Weather();
				weather.setName(data.getName());
				weather.setWindDirection(data.getWind().getDeg());
				weather.setWindSpeed(data.getWind().getSpeed());
				weather.setWeatherDescription(data.getWeather()[0].getDescription());
				weather.setSunrise(data.getSys().getSunrise());
				weather.setSunset(data.getSys().getSunset());
				Application.postData("http://localhost:8080/add", weather, Weather.class);
				Thread.sleep(1000);
			} catch (Exception e) {
				
			}
		}
	}
}
