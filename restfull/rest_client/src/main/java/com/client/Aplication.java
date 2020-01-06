package com.client;

import com.client.service.RestService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Aplication {
    @Bean
    RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @Bean
    public RestService restService() {
        return new RestService();
    }

    public static void main(String[] args) {
        SpringApplication.run(Aplication.class, args);
    }

}