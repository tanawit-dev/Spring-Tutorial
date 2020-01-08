package com.spring.example.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 *
 * @author Tanawit Aeabsakul
 */
@ConfigurationProperties("storage")
public class StorageProperties {
    private String location = "upload-dir";

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    
}
