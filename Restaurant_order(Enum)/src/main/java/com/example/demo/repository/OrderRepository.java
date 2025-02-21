package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.RestaurantOrder;

public interface OrderRepository extends JpaRepository<RestaurantOrder, Long>{
}
