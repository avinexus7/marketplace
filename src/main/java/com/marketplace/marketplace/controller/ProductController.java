package com.marketplace.marketplace.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marketplace.marketplace.entity.Product;
import com.marketplace.marketplace.service.ProductService;

@RestController
@RequestMapping(path="/product")
public class ProductController {
	
    @Autowired
    ProductService productService;
	
    @GetMapping
    public String check() {
        return "hello world product";
    }
    
    // get all products
    @GetMapping(path="/all")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> productList = productService.getAllProducts();
        return new ResponseEntity<List<Product>>(productList, HttpStatus.OK);
    }

}
