package com.spring.example.service;

import com.spring.example.model.Product;

import java.util.Collection;

public interface ProductService {
    public Collection<Product> listProduct();
    public Product getProduct(String id);
    public void createProduct(Product product);
    public void updateProduct(String id, Product product);
    public void deleteProduct(String id);
}
