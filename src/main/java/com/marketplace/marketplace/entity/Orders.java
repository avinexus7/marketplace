package com.marketplace.marketplace.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Orders {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
	
	private String orderPlacedTime;
	/**
	 * mapping order with both the product and the inventory
	 */
	@ManyToOne
	private Product product; 
	
	@ManyToOne
	private Inventory inventory;
	
    
	public String getOrderPlacedTime() {
		return orderPlacedTime;
	}
	public void setOrderPlacedTime(String orderPlacedTime) {
		this.orderPlacedTime = orderPlacedTime;
	}
	

}
