package com.marketplace.marketplace.service;

import com.marketplace.marketplace.repository.InventoryRepository;
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
    InventoryRepository inventoryRepository;

    @Autowired
    InventoryService inventoryService;
	
    @Override
    public synchronized String placeNewOrder(String name, Integer quantity) {

        String response = "";

        Inventory inventory = inventoryRepository.findProductItem(name, quantity);

        if (inventory != null) {
            response = "order placed";
        }

        return response;


//        Orders saveResponse = ordersRepository.save({});
//        return saveResponse;
    }




}
