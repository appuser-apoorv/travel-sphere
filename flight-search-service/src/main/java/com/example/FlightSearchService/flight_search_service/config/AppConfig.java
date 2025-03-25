package com.example.FlightSearchService.flight_search_service.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @Bean
    @LoadBalanced  // Enables Eureka Service Discovery
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
