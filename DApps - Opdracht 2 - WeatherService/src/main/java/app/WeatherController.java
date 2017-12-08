package app;


import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import travel.model.Weather;

@CrossOrigin
@RestController
public class WeatherController {

	private WeatherService service;

	@Autowired
	public WeatherController(WeatherService service) {
		this.service = service;
	}

    @RequestMapping("/add")
    public void add(@RequestBody Weather weather) {
        service.addWeather(weather);
    }
    
    @RequestMapping("/get")
    public Weather get(@RequestParam(value="name", defaultValue="Leuven") String name) {
    	return service.get(name);
    }
    
    @RequestMapping("/getall")
    public Collection<List<Weather>> getAll() {
    	return service.getAll();
    }
    
    @RequestMapping("/avgwindspeed")
    public double windspeed(@RequestParam(value="name", defaultValue="Leuven") String name) {
    	return service.getAverageWindspeed(name);
    }
}