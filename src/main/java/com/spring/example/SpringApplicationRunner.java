package com.spring.example;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class SpringApplicationRunner implements ApplicationRunner {

    private Log log = LogFactory.getLog(SpringApplicationRunner.class);

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("Application runner is running...");
    }
}
