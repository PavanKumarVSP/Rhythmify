package org.example.userServices.service.startup;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class StartupLogger implements ApplicationRunner {
    private static final Logger log = LoggerFactory.getLogger(StartupLogger.class);

    @Override
    public void run(ApplicationArguments args) {
        log.info(">>> Application started with options: {}", args.getOptionNames());
    }

}
