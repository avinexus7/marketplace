package com.marketplace.marketplace.service;

import org.springframework.stereotype.Service;

@Service
public interface OrdersService {
	
	public String placeNewOrder(String name, Integer quantity) throws Exception;

}
