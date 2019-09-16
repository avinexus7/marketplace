package com.marketplace.marketplace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marketplace.marketplace.entity.Inventory;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Integer> {
	
	Inventory findByName(String name);
	
	
}
