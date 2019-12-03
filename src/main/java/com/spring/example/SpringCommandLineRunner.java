package com.spring.example;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SpringCommandLineRunner implements CommandLineRunner {

    private Log log = LogFactory.getLog(SpringCommandLineRunner.class);

    @Override
    public void run(String... args) throws Exception {
        log.info("Command line runner is running");
    }
}
