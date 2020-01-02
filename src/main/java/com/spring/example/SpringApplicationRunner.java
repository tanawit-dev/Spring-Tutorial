package com.spring.example;

import com.spring.example.properties.ConfigProperties;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class SpringApplicationRunner implements ApplicationRunner {

    private final Log log = LogFactory.getLog(SpringApplicationRunner.class);
    
    @Autowired
    private ConfigProperties configProperties;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("Application runner is running...");
        log.info(configProperties.toString());
    }
}
