package app;

import java.net.URLEncoder;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import travel.model.Composed;
import travel.model.Destination;
import travel.model.Review;
import travel.model.Weather;

@Component
public class CompositionService {

	@Autowired
	@LoadBalanced
	private RestTemplate loadBalanced;

	public Destination getDestination(String name) {
		try {
			return loadBalanced.getForObject(
				"http://destination-service/get?name=" + URLEncoder.encode(name, "UTF-8"),
				Destination.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Destination[] getDestinations() {
		return loadBalanced.getForObject("http://destination-service/getall",
			Destination[].class);
	}

	public Review[] getReviews(Destination dest) {
		try {
			return loadBalanced.getForObject(
				"http://review-service/get?name=" + URLEncoder.encode(dest.getName(), "UTF-8"),
				Review[].class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Review[0];
	}

	public Weather getWeather(Destination dest) {
		try {
			return loadBalanced.getForObject("http://weather-service/get?name="
				+ URLEncoder.encode(dest.getName(), "UTF-8"), Weather.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Composed createComposed(Destination dest) {
		Weather weather = getWeather(dest);
		Review[] reviews = getReviews(dest);
		return new Composed(dest, reviews, weather);
	}

	public Composed get(String name) {
		Destination dest = getDestination(name);
		if (dest == null) return null;
		return createComposed(dest);
	}

	public List<Composed> getAll() {
		return Arrays.stream(getDestinations()).map(this::createComposed)
			.collect(Collectors.toList());
	}
}
