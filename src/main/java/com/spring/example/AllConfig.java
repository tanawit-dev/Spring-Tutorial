package com.spring.example;

import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 *
 * @author Tanawit Aeabsakul
 */
@Component
@PropertySource({"classpath:config.properties"})
public class AllConfig {

}
