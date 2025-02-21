package com.daytona.fooddeliveryapp.entity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "restaurant")
@Data
public class RestaurantDAO {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private  String name;
    private  String address;

    @OneToMany(mappedBy = "restaurantDAO",cascade = CascadeType.ALL)
    private List<OrderDAO> orderDAO;

    @OneToMany(mappedBy = "restaurantDAO",cascade = CascadeType.ALL)
    private  List<MenuDAO> menuDAO;
}
