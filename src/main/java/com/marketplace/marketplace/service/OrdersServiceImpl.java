package com.marketplace.marketplace.service;

import com.marketplace.marketplace.repository.InventoryRepository;

import java.util.Date;

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
	public synchronized String placeNewOrder(String name, Integer quantity) throws Exception {
		/**
		 * step 1: check if the given product name exists and if the requested quantity exists
		 * 2: if yes, fetch the available product inventory
		 * 3. Decrement the inventory by the requested quantity
		 * 4. Add a new order to the orders table
		 */

		String response = "order not placed";

		Inventory inventory = inventoryRepository.findProductItem(name, quantity);
		
		if(inventory!= null) {
			ordersRepository.save(new Orders(null, new Date().toString(), quantity, inventory.getProduct(), inventory));
			Integer inventorySize = inventory.getRemainingQuantity() - quantity;
			inventoryRepository.updateRemainingQuantityById(inventorySize, inventory.getId());
			response = "order placed";
		} else {
			throw new Exception("Items out of stock!");
		}
		return response;
	}


}
