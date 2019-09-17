package com.marketplace.marketplace.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marketplace.marketplace.entity.Inventory;
import com.marketplace.marketplace.repository.InventoryRepository;

@RestController
@RequestMapping(path="/order")
public class OrdersController {
	
	@Autowired
	InventoryRepository inventoryRepository; 
	
    @GetMapping
    public String check() {
    	
    	Inventory inventory = inventoryRepository.findProductItem("screw",1);
    	
    	if ( inventory != null ) {
    		// create order
    	}
    	
    	
        return "hellor orders";
    }
    
    @PostMapping(path="/place")
    public String placeOrder() {
    	return "order placed";
    }

}
