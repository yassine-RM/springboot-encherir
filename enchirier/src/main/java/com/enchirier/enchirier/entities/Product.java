package com.enchirier.enchirier.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="products")
public class Product {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;
    private String name;
    private float price;
    private boolean status;

    @ManyToOne
    private Client client;


    public String getName() {
        return name;
    }
    public float getPrice() {
        return price;
    }
    public boolean getStatus() {
        return status;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(float price) {
        this.price = price;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Client getClient() {
        return client;
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", price=" + price + ", status=" + status + "]";
    }



    
}
