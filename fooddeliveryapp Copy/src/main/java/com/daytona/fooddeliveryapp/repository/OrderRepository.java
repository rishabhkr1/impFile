package com.daytona.fooddeliveryapp.repository;

import com.daytona.fooddeliveryapp.entity.OrderDAO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderDAO,Long> {
}
