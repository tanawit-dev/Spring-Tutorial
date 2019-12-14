/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.example.scheduler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 *
 * @author g
 */
@Component
public class Scheduler {

    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

    @Scheduled(cron = "0 * 15 * * ?")
    public void cronJobSch() {
        LocalDateTime now = LocalDateTime.now();
        String dateTimeStr = now.format(dateTimeFormatter);
        System.out.println("Java cron job expression: " + dateTimeStr);
    }

    @Scheduled(fixedRate = 1000)
    public void fixRateSch() {
        LocalDateTime now = LocalDateTime.now();
        String dateTimeStr = now.format(dateTimeFormatter);
        System.out.println("Fixed Rate Scheduler: " + dateTimeStr);
    }

    @Scheduled(fixedDelay = 1000, initialDelay = 3000)
    public void fixDelaySch() {
        LocalDateTime now = LocalDateTime.now();
        String dateTimeStr = now.format(dateTimeFormatter);
        System.out.println("Fixed Delay Scheduler: " + dateTimeStr);
    }
}
