package com.enchirier.enchirier.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enchirier.enchirier.dto.ProductDto;
import com.enchirier.enchirier.entities.Client;
import com.enchirier.enchirier.entities.Product;
import com.enchirier.enchirier.services.ClientService;
import com.enchirier.enchirier.services.ProductService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ClientService clientService;

    @GetMapping
    public List<Product> listOfProducts() {
        return productService.getAllProducts();
    }

    @PostMapping
    public Product addNewProduct(@RequestBody ProductDto productDto) {
        try {

            Client client = clientService.getClient(productDto.getClientId());
            Product product = new Product();
            product.setName(productDto.getName());
            product.setPrice(productDto.getPrice());
            product.setStatus(productDto.getStatus());
            product.setClient(client);
    
            return productService.addNewProduct(product);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Add new product error "+e.getMessage());
        }
    }
    
}
