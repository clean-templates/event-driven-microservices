package com.rolandsall.twitter.to.kafka.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.rolandsall")
public class TwitterToKafkaService {
    public static void main(String[] args) {
        SpringApplication.run(TwitterToKafkaService.class, args);
    }
}
