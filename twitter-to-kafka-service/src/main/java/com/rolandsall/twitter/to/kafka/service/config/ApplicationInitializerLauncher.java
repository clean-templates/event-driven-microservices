package com.rolandsall.twitter.to.kafka.service.config;

import com.rolandsall.twitter.to.kafka.service.external.runner.StreamRunner;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class ApplicationInitializerLauncher implements CommandLineRunner {

    private final StreamRunner streamRunner;

    @Override
    public void run(String... args) throws Exception {
      log.info("Starting application initializer");
      streamRunner.start();
    }
}
