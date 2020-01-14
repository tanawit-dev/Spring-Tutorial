package com.spring.example;

import com.spring.example.messaging.Receiver;
import com.spring.example.service.StorageService;
import java.util.concurrent.TimeUnit;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SpringCommandLineRunner implements CommandLineRunner {

    private final Log log = LogFactory.getLog(SpringCommandLineRunner.class);
    
    private final StorageService storageService;
    private final RabbitTemplate rabbitTemplate;
    private final Receiver receiver;
    
    public SpringCommandLineRunner(StorageService storageService, Receiver receiver, RabbitTemplate rabbitTemplate) {
        this.storageService = storageService;
        this.receiver = receiver;
        this.rabbitTemplate = rabbitTemplate;
    }
    
    
    @Override
    public void run(String... args) throws Exception {
        storageService.deleteAll();
        storageService.init();
        
        System.out.println("Sending message...");
        rabbitTemplate.convertAndSend(SpringTutorial.TOPIC_EXCHANGE_NAME, "foo.bar.baz", "Hello from RabbitMQ!");
        receiver.getLatch().await(100000, TimeUnit.MILLISECONDS);
        
        log.info("Command line runner is running");
    }
}
