package com.marketplace.marketplace.service;

import com.marketplace.marketplace.entity.Inventory;

import java.util.List;

public interface InventoryService {

    public List<Inventory> getAllInventory();

    public Inventory addInventory(Inventory new_inventory);

	Inventory getOneInventory(Integer invName);

	Inventory getInventoryByName(String invName);

//    public Boolean getOneInventory(Integer invName);

}