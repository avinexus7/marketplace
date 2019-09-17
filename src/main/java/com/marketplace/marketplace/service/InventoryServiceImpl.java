package com.marketplace.marketplace.service;

import com.marketplace.marketplace.entity.Inventory;
import com.marketplace.marketplace.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    InventoryRepository inventoryRepository;

    @Override
    public synchronized List<Inventory> getAllInventory() {
        List<Inventory> inventoryList = inventoryRepository.findAll();
        
        return inventoryList;
    }

    @Override
    public synchronized Inventory addInventory(Inventory new_inventory) {
        Inventory saveResponse = inventoryRepository.save(new_inventory);
        return saveResponse;
    }

    @Override
    public synchronized Inventory getOneInventory(Long invName) {
        Optional<Inventory> inventory= inventoryRepository.findById(invName);
        return inventory.get();
    }
    
    @Override
    public synchronized Inventory getInventoryByName(String invName) {
        Inventory inventory= inventoryRepository.findByName(invName);
        return inventory;
    }
}
