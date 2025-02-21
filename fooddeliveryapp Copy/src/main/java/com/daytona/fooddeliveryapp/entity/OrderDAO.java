package com.daytona.fooddeliveryapp.entity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "orders")
@Data
public class OrderDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  String status;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private RestaurantDAO restaurantDAO;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerDAO customerDAO;

    @ManyToMany
    @JoinTable(
            name = "order_menu",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "menu_id"))
    private List<MenuDAO> menuDAO;


}
