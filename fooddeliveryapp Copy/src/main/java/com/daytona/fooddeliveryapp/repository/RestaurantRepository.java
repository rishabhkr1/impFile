package com.daytona.fooddeliveryapp.repository;

import com.daytona.fooddeliveryapp.entity.RestaurantDAO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<RestaurantDAO,Long> {
}
