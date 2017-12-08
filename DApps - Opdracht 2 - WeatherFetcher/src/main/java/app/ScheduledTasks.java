package app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.net.URLEncoder;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import openweather.WeatherData;

@Component
public class ScheduledTasks {

	private ArrayList<String>	locations	= new ArrayList<>();

	@Autowired
	@LoadBalanced
	private RestTemplate		loadBalanced;
	private RestTemplate		notBalanced	= new RestTemplate();

	private final static String	key			= "89a5cee78aa73389e0661c7c4c9fb790";

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
				WeatherData data = notBalanced.getForObject(
					"http://api.openweathermap.org/data/2.5/weather?q="
						+ URLEncoder.encode(loc, "UTF-8") + "&APPID=" + key,
					WeatherData.class);
				Weather weather = new Weather();
				weather.setName(data.getName());
				weather.setWindDirection(data.getWind().getDeg());
				weather.setWindSpeed(data.getWind().getSpeed());
				weather.setWeatherDescription(data.getWeather()[0].getDescription());
				weather.setSunrise(data.getSys().getSunrise());
				weather.setSunset(data.getSys().getSunset());
				// Application.postData("http://localhost:8080/add", weather,
				// Weather.class);
				loadBalanced.postForObject("http://weather-service/add", weather,
					Weather.class);
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
