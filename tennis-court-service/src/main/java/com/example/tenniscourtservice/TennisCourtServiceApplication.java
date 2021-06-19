package com.example.tenniscourtservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.example.tenniscourtservice.tennis")
@SpringBootApplication
//@EnableFeignClients
public class TennisCourtServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TennisCourtServiceApplication.class, args);
    }

}
