package com.enchirier.enchirier.repositories;

import com.enchirier.enchirier.entities.Encherir;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EncherirRepository extends JpaRepository<Encherir, Long> {
 
    @Query("SELECT MAX(e.price) FROM Encherir e WHERE e.product.id = :productId")
    Float findMaxPriceByProductId(@Param("productId") Long productId);
    
}
    