package helloclientserver.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author Georgi Trendafilov
 */
@RestController
@RequestMapping("/rest/hello/server")
public class HelloController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    @ResponseBody
    public String hello() {
        return "Hello from the Kur server side!";
    }
}
