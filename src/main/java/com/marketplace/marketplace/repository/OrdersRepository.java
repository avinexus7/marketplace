package com.marketplace.marketplace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marketplace.marketplace.entity.Orders;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {

}
