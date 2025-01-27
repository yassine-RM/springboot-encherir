package com.enchirier.enchirier.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EncherirDto {
    
    private long client_id;
    private long product_id;

    @JsonProperty("client_id")
    public long getClientId() {
        return client_id;
    }

    @JsonProperty("product_id")
    public long getProductId() {
        return product_id;
    }

    public void setClientId(long client_id) {
        this.client_id = client_id;
    }
    public void setProductId(long product_id) {
        this.product_id = product_id;
    }
}
