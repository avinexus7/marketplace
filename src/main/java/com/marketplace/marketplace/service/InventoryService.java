package com.marketplace.marketplace.service;

import com.marketplace.marketplace.entity.Inventory;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface InventoryService {

    public List<Inventory> getAllInventory();

    public Inventory addInventory(Inventory new_inventory);
}