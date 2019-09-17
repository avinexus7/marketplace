package com.marketplace.marketplace.service;

import com.marketplace.marketplace.entity.Orders;

import org.springframework.stereotype.Service;

@Service
public interface OrdersService {
	
	public Orders placeNewOrder(Orders new_inventory);

}
