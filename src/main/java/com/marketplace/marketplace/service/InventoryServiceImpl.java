package com.marketplace.marketplace.service;

import com.marketplace.marketplace.entity.Inventory;
import com.marketplace.marketplace.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    InventoryRepository inventoryRepository;

    @Override
    public List<Inventory> getAllInventory() {
        List<Inventory> inventoryList = inventoryRepository.findAll();
        return inventoryList;
    }

    @Override
    public Inventory addInventory(Inventory new_inventory) {
        Inventory saveResponse = inventoryRepository.save(new_inventory);
        return saveResponse;
    }

    @Override
    public Inventory getOneInventory(Integer invName) {
        Boolean getOneResponse = inventoryRepository.findById(invName);
        return getOneResponse;
    }
}
