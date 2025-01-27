package com.enchirier.enchirier.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.enchirier.enchirier.entities.Product;
import com.enchirier.enchirier.repositories.ProductRepository;

@Component
public class ProductService {
    

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProduct(long product_id) {
        return productRepository.findById(product_id)
                    .orElseThrow(() -> new NoSuchElementException("Product with ID " + product_id + " not found"));
    }

    public Product addNewProduct(Product product) {
        return productRepository.save(product);
    }


}
