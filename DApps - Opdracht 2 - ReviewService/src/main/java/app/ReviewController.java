package app;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import travel.model.Review;

@CrossOrigin
@RestController
public class ReviewController {

	private ReviewService service;

	@Autowired
	public ReviewController(ReviewService service) {
		this.service = service;
	}

	@RequestMapping("/add")
	public void add(@RequestBody Review review) {
		service.addReview(review);
	}

	@RequestMapping("/get")
	public Review[] get(@RequestParam(value = "name", defaultValue = "Leuven") String name) {
		return service.getAll(name);
	}

	@RequestMapping("/getall")
	public Collection<List<Review>> getAll() {
		return service.getAll();
	}

}
