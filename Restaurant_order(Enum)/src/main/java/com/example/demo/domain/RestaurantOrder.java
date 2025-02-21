package com.example.demo.domain;

import javax.persistence.*;

import lombok.Data;

@Table
@Entity
@Data
public class RestaurantOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Enumerated(EnumType.STRING )
	private OrderStatus status;

	private String dish;

	public RestaurantOrder(){}
	public RestaurantOrder(long id, OrderStatus status, String dish) {
		this.id = id;
		this.status = status;
		this.dish = dish;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public String getDish() {
		return dish;
	}

	public void setDish(String dish) {
		this.dish = dish;
	}

	@Override
	public String toString() {
		return "RestaurantOrder{" +
				"id=" + id +
				", status=" + status +
				", dish='" + dish + '\'' +
				'}';
	}
}


