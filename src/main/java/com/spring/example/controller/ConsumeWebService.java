package com.spring.example.controller;

import com.spring.example.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@RestController
public class ConsumeWebService {
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/template/products")
    public String getProductList() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        return restTemplate.exchange("http://localhost:8081/products", HttpMethod.GET, entity, String.class).getBody();
    }

    @RequestMapping(value = "/template/products", method = RequestMethod.POST)
    public String createProduct(@RequestBody Product product) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<Product> entity = new HttpEntity<>(product, headers);
        return restTemplate.exchange("http://localhost:8081/products", HttpMethod.POST, entity, String.class).getBody();
    }

    @RequestMapping(value = "/template/products/{id}", method = RequestMethod.PUT)
    public String updateProduct(@PathVariable("id") String id, @RequestBody Product product) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<Product> entity = new HttpEntity<>(product, headers);
        return restTemplate.exchange("http://localhost:8081/products/" + id, HttpMethod.PUT, entity, String.class).getBody();
    }

    @RequestMapping(value = "/template/products/{id}", method = RequestMethod.DELETE)
    public String deleteProduct(@PathVariable("id") String id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<Product> entity = new HttpEntity<>(headers);
        return restTemplate.exchange("http://localhost:8081/products/" + id, HttpMethod.DELETE, entity, String.class).getBody();
    }
}
