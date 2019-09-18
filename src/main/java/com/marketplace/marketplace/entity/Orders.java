package com.marketplace.marketplace.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Orders {
	
	public Orders(Long id, String orderPlacedTime, Integer orderQuantity, Product product, Inventory inventory) {
		super();
		this.id = id;
		this.orderPlacedTime = orderPlacedTime;
		this.orderQuantity = orderQuantity;
		this.product = product;
		this.inventory = inventory;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
	
	private String orderPlacedTime;
	private Integer orderQuantity;
	
	public Integer getOrderQuantity() {
		return orderQuantity;
	}

	public void setOrderQuantity(Integer orderQuantity) {
		this.orderQuantity = orderQuantity;
	}

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

	@Override
	public String toString() {
		return "Orders [id=" + id + ", orderPlacedTime=" + orderPlacedTime + ", orderQuantity=" + orderQuantity
				+ ", product=" + product + ", inventory=" + inventory + "]";
	}

}
