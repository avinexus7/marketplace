package com.marketplace.marketplace.controller;

import com.marketplace.marketplace.entity.Inventory;
import com.marketplace.marketplace.service.InventoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/inventory")
public class InventoryController {

    @Autowired
    InventoryService inventoryService;

    @GetMapping
    public String check() {
        return "hello world 0998765";
    }

    @GetMapping(path="/all")
    public ResponseEntity<List<Inventory>> getAllInventory() {
        List<Inventory> inventoryList = inventoryService.getAllInventory();
        return new ResponseEntity<List<Inventory>>(inventoryList, HttpStatus.OK);
    }

    @GetMapping(path="/one")
    public ResponseEntity<Inventory> getOneInventory() {
    	Inventory inventoryList = inventoryService.getInventoryByName("avinash");
        return new ResponseEntity<Inventory>(inventoryList, HttpStatus.OK);
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<Inventory> addInventory(@RequestBody Inventory inventory) {
    	/**
    	 * add conditions here to validate the incoming inventory fields
    	 */
        Inventory saveResponse = inventoryService.addInventory(inventory);
        return new ResponseEntity<Inventory>(saveResponse, HttpStatus.CREATED);
    }


}
