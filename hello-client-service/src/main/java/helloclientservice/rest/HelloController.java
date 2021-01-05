package helloclientservice.rest;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author Georgi Trendafilov
 */
@RestController
@RequestMapping("/rest/hello/client")
public class HelloController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    @HystrixCommand(fallbackMethod = "fallback", commandKey = "fallback")
    public String hello() {
        final String url = "http://hello-kur-server/rest/hello/server";
        return restTemplate.getForObject(url, String.class);
    }

    public String fallback(Throwable exception) {
        return "Hello from Kur fallback!";
    }
}
