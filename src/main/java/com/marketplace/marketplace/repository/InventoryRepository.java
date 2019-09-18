package com.marketplace.marketplace.repository;

import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.marketplace.marketplace.entity.Inventory;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {

    /**
     * defining a custom query to get a product with given name and remaining quantity
     * @param name
     * @param remainingQuantity
     * @return
     */
	@Query("select i from Inventory i join  i.product p where "
			+ " p.name=:name and "
			+ " i.remainingQuantity >= :remainingQuantity and "
			+ " i.remainingQuantity > 0")
	Inventory findProductItem(@Param("name") String name, @Param("remainingQuantity") Integer remainingQuantity);
	
}
