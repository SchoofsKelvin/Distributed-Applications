package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient
@SpringBootApplication
@EnableScheduling
public class Application {

	private final static String key = "89a5cee78aa73389e0661c7c4c9fb790";

	public static void main(String[] args) throws Exception {
		SpringApplication app = new SpringApplication(Application.class);
		// app.setWebEnvironment(false);
		app.run(args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	private final static RestTemplate template = new RestTemplate();

	public static <T> T getData(String url, Class<T> t) {
		return template.getForObject(url + "&APPID=" + key, t);
	}

	public static <T> T postData(String url, Object data, Class<T> t) {
		return template.postForObject(url, data, t);
	}

}

@RestController
class ApplicationInfoController {

    @RequestMapping("/info")
    public String serviceInstancesByApplicationName() {
        return "Weather service data gatherer running";
    }
}
