package travel.model;

public class Composed {

	private Destination	destination;
	private Review[]	reviews;
	private Weather		weather;

	public Composed() {}

	public Composed(Destination dest, Review[] revs, Weather weath) {
		destination = dest;
		reviews = revs;
		weather = weath;
	}

	public Destination getDestination() {
		return destination;
	}

	public Review[] getReviews() {
		return reviews;
	}

	public Weather getWeather() {
		return weather;
	}

	public void setDestination(Destination destination) {
		this.destination = destination;
	}

	public void setReviews(Review[] reviews) {
		this.reviews = reviews;
	}

	public void setWeather(Weather weather) {
		this.weather = weather;
	}
}
