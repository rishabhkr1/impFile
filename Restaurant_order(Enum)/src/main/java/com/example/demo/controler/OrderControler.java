package com.example.demo.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.RestaurantOrder;
import com.example.demo.repository.OrderRepository;

@RestController
public class OrderControler {

	@Autowired
	private OrderRepository orderRepository;
	
	@PostMapping("/order/create")
	public RestaurantOrder save(@RequestBody RestaurantOrder order) {
		return orderRepository.save(order);
	}
	
}
