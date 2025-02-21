package com.enchirier.enchirier.repositories;

import com.enchirier.enchirier.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
 
}
    