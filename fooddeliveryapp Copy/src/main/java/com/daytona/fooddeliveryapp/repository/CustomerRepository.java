package com.daytona.fooddeliveryapp.repository;

import com.daytona.fooddeliveryapp.entity.CustomerDAO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerDAO,Long> {
}
