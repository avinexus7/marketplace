package com.marketplace.marketplace.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marketplace.marketplace.entity.Product;
import com.marketplace.marketplace.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
    @Autowired
    ProductRepository productRepository;
	
    @Override
    public synchronized List<Product> getAllProducts() {
    	/**
    	 * get all the products
    	 */
        List<Product> inventoryList = productRepository.findAll();
        return inventoryList;
    }

}
