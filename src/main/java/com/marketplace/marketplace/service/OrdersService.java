package com.marketplace.marketplace.service;

import com.marketplace.marketplace.entity.Orders;

import org.springframework.stereotype.Service;

@Service
public interface OrdersService {
	
	public String placeNewOrder(String name, Integer quantity);

}
