package com.marketplace.marketplace.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marketplace.marketplace.entity.Inventory;
import com.marketplace.marketplace.entity.Orders;
import com.marketplace.marketplace.repository.OrdersRepository;

@Service
public class OrdersServiceImpl implements OrdersService {
	
    @Autowired
    OrdersRepository ordersRepository;
    
    @Autowired
    InventoryService inventoryService;
	
    @Override
    public synchronized Orders placeNewOrder(Orders new_inventory) {
    	
    	Inventory foundInventory = inventoryService.getInventoryByName("avinash");
    	Orders saveResponse = ordersRepository.save(new_inventory);
        return saveResponse;
    }

}
