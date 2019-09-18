package com.marketplace.marketplace.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.marketplace.marketplace.entity.Product;

@Service
public interface ProductService {
	
	public List<Product> getAllProducts();

}
