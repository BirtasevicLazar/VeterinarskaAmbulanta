package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {

    private static final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);

    @Scheduled(initialDelay = 10000, fixedRate = Long.MAX_VALUE)
    public void checkPatientStatus() {
        logger.info("Provera statusa pacijenata i slanje podsetnika vlasnicima.");
    }
}