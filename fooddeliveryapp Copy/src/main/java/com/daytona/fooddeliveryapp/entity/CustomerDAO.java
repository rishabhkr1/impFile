package com.daytona.fooddeliveryapp.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "customer")
@Data
public class CustomerDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private long phoneNumber;

    @OneToMany(mappedBy = "customerDAO",cascade = CascadeType.ALL)
    private List<OrderDAO> orderDAOS;
}
