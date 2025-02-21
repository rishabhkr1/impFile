package com.daytona.fooddeliveryapp.service;

import com.daytona.fooddeliveryapp.repository.OrderRepository;
import com.daytona.fooddeliveryapp.entity.OrderDAO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<OrderDAO> getAllOrders() {
        return orderRepository.findAll();
    }

    public OrderDAO getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Transactional
    public OrderDAO placeOrder(OrderDAO orderDAO) {
        return orderRepository.save(orderDAO);
}
}
