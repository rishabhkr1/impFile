package com.daytona.fooddeliveryapp.entity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "menu")
@Data
public class MenuDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  String name;
    private  int price;

    //many menu items belongs to one restaurant
    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private RestaurantDAO restaurantDAO;

    @ManyToMany(mappedBy = "menuDAO")
    private List<OrderDAO> orderDAO;
}
