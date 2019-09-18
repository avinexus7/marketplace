package com.marketplace.marketplace.controller;

import com.marketplace.marketplace.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.marketplace.marketplace.entity.Inventory;
import com.marketplace.marketplace.repository.InventoryRepository;

@RestController
@RequestMapping(path="/order")
public class OrdersController {
	
	@Autowired
	InventoryRepository inventoryRepository;

    @Autowired
    OrdersService ordersService;

    @GetMapping
    public String check() {
    	
    	Inventory inventory = inventoryRepository.findProductItem("screw",1);
    	
    	if ( inventory != null ) {
    		// create order
    	}
    	
    	
        return "hello orders";
    }
    
//    @PostMapping(path="/place")
//    public String placeOrder() {
//    	return "order placed";
//    }

    @PostMapping(path="/new")
    public ResponseEntity<String> placeOrder(@RequestParam String name, @RequestParam Integer quantity) {

        String newOrder = ordersService.placeNewOrder(name, quantity);

        return new ResponseEntity<String>(newOrder, HttpStatus.CREATED);
    }

}
