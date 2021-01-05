package helloclientserver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author Georgi Trendafilov
 */
@Configuration
public class ServerConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
