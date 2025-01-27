package com.enchirier.enchirier.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.enchirier.enchirier.entities.Encherir;
import com.enchirier.enchirier.repositories.EncherirRepository;

@Component
public class EncherirService {
    

    @Autowired
    private EncherirRepository encherirRepository;

    public List<Encherir> getAllEncherirs() {
        return encherirRepository.findAll();
    }

    public Float findMaxPriceByProductId(long productId) {
        return encherirRepository.findMaxPriceByProductId(productId);
    }

    public Encherir addNewEncherir(Encherir encherir) {
        return encherirRepository.save(encherir);
    }


}
