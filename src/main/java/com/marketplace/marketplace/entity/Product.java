package com.marketplace.marketplace.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Product {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
	
	private String name;
	
	private String type;
	
	/**
	 * mapping each product with each inventory available
	 */
	@OneToOne(mappedBy = "product")
	@JsonIgnore
	private Inventory inventory;
	
	/**
	 * mapping a product with many orders which may be placed
	 */
	@OneToMany(mappedBy = "product")
	@JsonIgnore
	List<Orders> inventoryList = new ArrayList<Orders>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public List<Orders> getInventoryList() {
		return inventoryList;
	}

	public void setInventoryList(List<Orders> inventoryList) {
		this.inventoryList = inventoryList;
	}
	

}
