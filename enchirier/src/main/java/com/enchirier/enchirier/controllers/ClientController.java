package com.enchirier.enchirier.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enchirier.enchirier.entities.Client;
import com.enchirier.enchirier.services.ClientService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/v1/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;


    @GetMapping
    public List<Client> listOfClients() {
        return clientService.getAllClients();
    }

    @PostMapping
    public Client addNewClient(@RequestBody Client client) {
        return clientService.addNewClient(client);
    }
    
}
