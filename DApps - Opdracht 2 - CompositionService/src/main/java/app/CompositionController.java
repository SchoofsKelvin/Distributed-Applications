package app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import travel.model.Composed;

@CrossOrigin
@RestController
public class CompositionController {

	private CompositionService service;

	@Autowired
	public CompositionController(CompositionService service) {
		this.service = service;
	}

	@RequestMapping("/get")
	public Composed get(@RequestParam(value = "name", defaultValue = "Leuven") String name) {
		return service.get(name);
	}

	@RequestMapping("/getall")
	public List<Composed> getAll() {
		return service.getAll();
	}

}
