package com.example.tenniserservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.tenniserservice.tenniser")
public class TenniserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TenniserServiceApplication.class, args);
    }

}
