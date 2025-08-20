package com.example.userService.listeners;


import com.example.userService.controller.UserController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Calendar;

@Component
public class TestListener {
    private static final Logger logger = LoggerFactory.getLogger(TestListener.class);

    @Scheduled(fixedRate = 60000)
    public void justDOSomething()
    {
        logger.info(" Just CHECKING ");
    }

}
