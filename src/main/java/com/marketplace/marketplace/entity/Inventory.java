package com.marketplace.marketplace.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    
    private String name;
    
    private Integer remainingQuantity;
    
	/**
	 * mapping the inventory with product
	 */
	
	@OneToOne
    private Product product;

    @OneToMany(mappedBy = "product")
	List<Orders> inventoryList = new ArrayList<Orders>();
   

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public Integer getRemainingQuantity() {
		return remainingQuantity;
	}

	public void setRemainingQuantity(Integer remainingQuantity) {
		this.remainingQuantity = remainingQuantity;
	}

	@Override
	public String toString() {
		return "Inventory [id=" + id + ", name=" + name + ", remainingQuantity=" + remainingQuantity + ", product="
				+ product + ", inventoryList=" + inventoryList + "]";
	}

	
	
}
