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
        return "hello worl 0998765";
    }

    @GetMapping(path="/all")
    public List<Inventory> getAllInventory() {
        List<Inventory> inventoryList = inventoryService.getAllInventory();
        return inventoryList;
    }

    @GetMapping(path="/one")
    public Inventory getOneInventory() {
        Inventory inventoryList = inventoryService.getInventoryByName("avinash");
        return inventoryList;
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<Inventory> addInventory(@RequestBody Inventory inventory) {
        Inventory saveResponse = inventoryService.addInventory(inventory);
        return new ResponseEntity<Inventory>(saveResponse, HttpStatus.CREATED);
    }


}
