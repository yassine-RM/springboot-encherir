package com.enchirier.enchirier.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.enchirier.enchirier.entities.Client;
import com.enchirier.enchirier.repositories.ClientRepository;

@Component
public class ClientService {
    

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Client getClient(long client_id) {
        return clientRepository.findById(client_id)
                    .orElseThrow(() -> new NoSuchElementException("Client with ID " + client_id + " not found"));
    }

    public Client addNewClient(Client client) {
        return clientRepository.save(client);
    }


}
