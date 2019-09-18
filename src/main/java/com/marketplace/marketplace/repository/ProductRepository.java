package com.marketplace.marketplace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marketplace.marketplace.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
	Product findByName(String name);

}
