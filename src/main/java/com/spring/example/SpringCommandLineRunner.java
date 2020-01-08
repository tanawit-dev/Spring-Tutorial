package com.spring.example;

import com.spring.example.service.StorageService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SpringCommandLineRunner implements CommandLineRunner {

    private Log log = LogFactory.getLog(SpringCommandLineRunner.class);
    
    private final StorageService storageService;
    
    public SpringCommandLineRunner(StorageService storageService) {
        this.storageService = storageService;
    }
    
    
    @Override
    public void run(String... args) throws Exception {
        storageService.deleteAll();
        storageService.init();
        log.info("Command line runner is running");
    }
}
