package com.daytona.fooddeliveryapp.repository;

import com.daytona.fooddeliveryapp.entity.MenuDAO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<MenuDAO,Long> {
}
