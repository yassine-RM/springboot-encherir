package com.enchirier.enchirier.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="encherirs")
public class Encherir {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private long id;

    @ManyToOne
    private Client client;

    @ManyToOne
    private Product product;

    private double price;

    private String date;

    // Getters and Setters
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    

    @Override
    public String toString() {
        return "Encherir [client=" + client + ", date=" + date + ", id=" + id + ", price=" + price + ", product=" + product + "]";
    }
}
