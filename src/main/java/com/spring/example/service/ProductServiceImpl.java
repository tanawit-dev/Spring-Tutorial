package com.spring.example.service;

import com.spring.example.exception.ProductNotFoundException;
import com.spring.example.model.Product;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {
    private static Map<String, Product> productRepo = new HashMap<>();

    static {
        Product honey = new Product();
        honey.setId("1");
        honey.setName("Honey");
        productRepo.put(honey.getId(), honey);

        Product almond = new Product();
        almond.setId("2");
        almond.setName("Almond");
        productRepo.put(almond.getId(), almond);
    }

    @Override
    public Collection<Product> listProduct() {
        return productRepo.values();
    }

    @Override
    public Product getProduct(String id) {
        return productRepo.get(id);
    }

    @Override
    public void createProduct(Product product) {
        productRepo.put(product.getId(), product);
    }

    @Override
    public void updateProduct(String id, Product product) {
        if (!productRepo.containsKey(id)) throw new ProductNotFoundException();
        productRepo.remove(id);
        productRepo.put(id, product);
    }

    @Override
    public void deleteProduct(String id) {
        if (!productRepo.containsKey(id)) throw new ProductNotFoundException();
        productRepo.remove(id);
    }
}
