package com.spring.example.controller;

import com.spring.example.exception.ProductNotFoundException;
import com.spring.example.model.Product;
import com.spring.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ProductServiceController {
    @Autowired
    ProductService productService;

    @RequestMapping("products")
    @CrossOrigin("http://localhost:80801")
    public ResponseEntity<Object> listProduct() {
        return new ResponseEntity<>(productService.listProduct(), HttpStatus.OK);
    }

    @RequestMapping("products/{id}")
    public ResponseEntity<Object> getProduct(@PathVariable("id") String id) {
        Product product = productService.getProduct(id);
        if (product != null) return new ResponseEntity<>(product, HttpStatus.OK);
        else throw new ProductNotFoundException();
    }

    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public ResponseEntity<Object> createProduct(@RequestBody Product product) {
        productService.createProduct(product);
        return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
    }

    @RequestMapping(value = "products/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateProduct(@PathVariable("id") String id, @RequestBody Product product) {
        productService.updateProduct(id, product);
        return new ResponseEntity<>("Product is updated successfully", HttpStatus.OK);
    }

    @RequestMapping(value = "products/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteProduct(@PathVariable("id") String id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>("Product is deleted successfully", HttpStatus.OK);
    }
}
