package com.enchirier.enchirier.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enchirier.enchirier.dto.EncherirDto;
import com.enchirier.enchirier.entities.Client;
import com.enchirier.enchirier.entities.Encherir;
import com.enchirier.enchirier.entities.Product;
import com.enchirier.enchirier.services.ClientService;
import com.enchirier.enchirier.services.EncherirService;
import com.enchirier.enchirier.services.ProductService;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/v1/encherirs")
public class EncherirController {

    @Autowired
    private EncherirService encherirService;
    @Autowired
    private ClientService clientService;
    @Autowired
    private ProductService productService;


    @GetMapping
    public List<Encherir> listOfEncherirs() {
        return encherirService.getAllEncherirs();
    }

    @PostMapping
    public ResponseEntity<Encherir> addNewEncherir(@RequestBody EncherirDto encherirDto) {

        Client client = clientService.getClient(encherirDto.getClientId());
        Product product = productService.getProduct(encherirDto.getProductId());

        // Get the last price, ensure it is not null
        Float lastPrice = encherirService.findMaxPriceByProductId(encherirDto.getProductId());
        
        // If lastPrice is null, set it to the product price as the starting point
        if (lastPrice == null) {
            lastPrice = product.getPrice();
        }


        double newPrice = lastPrice + (product.getPrice() * 0.1);

        Encherir encherir = new Encherir();
        encherir.setClient(client);
        encherir.setProduct(product);
        encherir.setPrice(newPrice);
        encherir.setDate(new Date().toString());

        // Save the new bid and return the result
        Encherir savedEncherir = encherirService.addNewEncherir(encherir);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEncherir);
    }

    
}
