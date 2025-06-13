package com.freezefootball.frzftball;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    //Codigo un poco redundante que nos deja usar un restTemplate con Autowired 
    //porque ahora esta definido como Bean
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate(); 
    }
}
