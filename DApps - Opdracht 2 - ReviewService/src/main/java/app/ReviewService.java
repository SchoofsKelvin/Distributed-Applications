package app;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Component;

import travel.model.Review;

@Component
public class ReviewService {

	private HashMap<String, List<Review>> reviews = new HashMap<>();
	
	
	public ReviewService() {
		addReview(new Review("Leuven","Nice city"));
		addReview(new Review("Leuven","Nice city indeed"));
		addReview(new Review("Tienen","Nice city too I guess"));
	}

	private List<Review> getList(String location) {
		List<Review> list = reviews.get(location.toLowerCase());
		if (list != null) return list;
		list = new ArrayList<>();
		reviews.put(location.toLowerCase(), list);
		return list;
	}

	public void addReview(Review review) {
		getList(review.getLocation()).add(review);
	}

	public Collection<List<Review>> getAll() {
		return reviews.values();
	}

	public Review[] getAll(String location) {
		List<Review> list = reviews.get(location.toLowerCase());
		if (list == null) return new Review[0];
		if (list.size() == 0) return new Review[0];
		return list.toArray(new Review[list.size()]);
	}

	public Review get(String location) {
		List<Review> list = reviews.get(location.toLowerCase());
		if (list == null) return null;
		if (list.size() == 0) return null;
		return list.get(list.size()-1);
	}
}
