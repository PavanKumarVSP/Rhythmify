package org.example.userServices.listeners;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
public class TestListener {
    private static final Logger logger = LoggerFactory.getLogger(TestListener.class);

    @Scheduled(fixedRate = 60000)
    public void justDOSomething()
    {
        logger.info(" Just CHECKING ");
    }

}
