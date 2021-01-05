package helloclientservice.rest;

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
    public String hello() {
        final String url = "http://hello-kur-server/rest/hello/server";
        return restTemplate.getForObject(url, String.class);
    }
}
