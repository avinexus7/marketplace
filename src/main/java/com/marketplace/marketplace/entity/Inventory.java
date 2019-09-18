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

    private Integer remainingQuantity;
    
	/**
	 * mapping the inventory with product
	 */
	
	@OneToOne(cascade = CascadeType.PERSIST)
    private Product product;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Orders> getInventoryList() {
        return inventoryList;
    }

    public void setInventoryList(List<Orders> inventoryList) {
        this.inventoryList = inventoryList;
    }

    @OneToMany(mappedBy = "product")
	List<Orders> inventoryList = new ArrayList<Orders>();


    public Integer getRemainingQuantity() {
		return remainingQuantity;
	}

	public void setRemainingQuantity(Integer remainingQuantity) {
		this.remainingQuantity = remainingQuantity;
	}

	@Override
	public String toString() {
		return "Inventory [id=" + id + ", remainingQuantity=" + remainingQuantity + ", product="
				+ product + ", inventoryList=" + inventoryList + "]";
	}

	
	
}
