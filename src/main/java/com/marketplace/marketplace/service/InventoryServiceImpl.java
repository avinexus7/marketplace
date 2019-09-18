package com.marketplace.marketplace.service;

import com.marketplace.marketplace.entity.Inventory;
import com.marketplace.marketplace.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManagerFactory;
import java.util.List;

@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    InventoryRepository inventoryRepository;

    @Autowired
    EntityManagerFactory emf;

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


}
