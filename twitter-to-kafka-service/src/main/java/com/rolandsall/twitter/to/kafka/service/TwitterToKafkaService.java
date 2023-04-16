package com.rolandsall.twitter.to.kafka.service;

import com.rolandsall.twitter.to.kafka.service.external.init.StreamInitializer;
import com.rolandsall.twitter.to.kafka.service.external.runner.StreamRunner;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.rolandsall")
@Slf4j
@RequiredArgsConstructor
public class TwitterToKafkaService implements CommandLineRunner {

    private final StreamRunner streamRunner;
    private final StreamInitializer streamInitializer;

    public static void main(String[] args) {
        SpringApplication.run(TwitterToKafkaService.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Starting application initializer");
        streamInitializer.init();
        streamRunner.start();
    }
}
