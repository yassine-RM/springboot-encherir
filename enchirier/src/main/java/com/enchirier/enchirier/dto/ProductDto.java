package com.enchirier.enchirier.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductDto {

    private String name;
    private float price;
    private boolean status;
    private int client_id;

    // Getters
    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public boolean getStatus() {
        return status;
    }

    public int getClientId() {
        return client_id;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @JsonProperty("client_id")
    public void setClientId(int client_id) {
        this.client_id = client_id;
    }
}