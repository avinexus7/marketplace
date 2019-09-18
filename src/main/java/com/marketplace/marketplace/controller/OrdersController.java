package com.marketplace.marketplace.controller;

import com.marketplace.marketplace.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
        return "hello orders";
    }

    @PostMapping(path="/new")
    public ResponseEntity<String> placeOrder(@RequestParam String name, @RequestParam Integer quantity) throws Exception {

        String newOrder = ordersService.placeNewOrder(name, quantity);

        return new ResponseEntity<String>(newOrder, HttpStatus.CREATED);
    }

}
