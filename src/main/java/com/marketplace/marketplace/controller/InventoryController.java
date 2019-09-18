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
        return "hello world inventory";
    }

    // get all the products' inventory
    @GetMapping(path="/all")
    public ResponseEntity<List<Inventory>> getAllInventory() {
        List<Inventory> inventoryList = inventoryService.getAllInventory();
        return new ResponseEntity<List<Inventory>>(inventoryList, HttpStatus.OK);
    }

    // create a new inventory with product
    @PostMapping(path="/new")
    @ResponseBody
    public ResponseEntity<Inventory> addInventory(@RequestBody Inventory inventory) {
        /**
         * add conditions here to validate the incoming inventory fields
         */
        Inventory saveResponse = inventoryService.addInventory(inventory);
        return new ResponseEntity<Inventory>(saveResponse, HttpStatus.CREATED);
    }


}
