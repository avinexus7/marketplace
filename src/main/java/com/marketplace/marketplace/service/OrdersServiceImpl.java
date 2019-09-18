package com.marketplace.marketplace.service;

import com.marketplace.marketplace.repository.InventoryRepository;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marketplace.marketplace.entity.Inventory;
import com.marketplace.marketplace.entity.Orders;
import com.marketplace.marketplace.entity.Product;
import com.marketplace.marketplace.repository.OrdersRepository;
import com.marketplace.marketplace.repository.ProductRepository;

@Service
public class OrdersServiceImpl implements OrdersService {

	@Autowired
	OrdersRepository ordersRepository;

	@Autowired
	InventoryRepository inventoryRepository;
	
	@Autowired
	ProductRepository productRepository;

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
		
		Product doesProductExist = productRepository.findByName(name);
		
		
		if (doesProductExist != null) {
			
		} else {
			// if the product is not found, then halt and inform the user
			throw new Exception("no product found");
		}

		Inventory inventory = inventoryRepository.findProductItem(name, quantity);
		
		if(inventory!= null) {
			/**
			 *  if the product is found and inventory exists: continue
			 */
			
			// save the new order with the required fields
			ordersRepository.save(new Orders(null, new Date().toString(), quantity, inventory.getProduct(), inventory));
			
			// decrement the quantity from the inventory
			Integer inventorySize = inventory.getRemainingQuantity() - quantity;
			
			/**
			 * building the updated inventory to save to database
			 */
			Inventory updatedInventory = new Inventory();
			updatedInventory.setId(inventory.getId());
			updatedInventory.setRemainingQuantity(inventorySize);
			updatedInventory.setProduct(inventory.getProduct());
			
			// save the updated inventory
			inventoryRepository.save(updatedInventory);
			
			response = "order placed";
		} else {
			// inform user if the requested quantity is not available
			throw new Exception(doesProductExist.getName() + " items out of stock!");
		}
		return response;
	}


}
