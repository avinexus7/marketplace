package com.marketplace.marketplace.repository;

import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.marketplace.marketplace.entity.Inventory;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {
	
	Inventory findByName(String name);
	
	@Query("select i from Inventory i, Product p where "
			+ " p.name=:name and "
			+ " i.remainingQuantity >= :remainingQuantity")
	Inventory findProductItem(@Param("name") String name, @Param("remainingQuantity") Integer remainingQuantity);
	
	
}
