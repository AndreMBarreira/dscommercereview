package com.devsuperior.dscommerce.DTO;

import java.time.Instant;

import com.devsuperior.dscommerce.entities.Order;
import com.devsuperior.dscommerce.entities.OrderStatus;

public class OrdersUserDTO {
	
	//orders id
	private Long id;
	private Instant moment;
	private OrderStatus status;
	
	private UserDTO client;

	public OrdersUserDTO(Long id, Instant moment, OrderStatus status, UserDTO client) {
		super();
		this.id = id;
		this.moment = Instant.now();
		this.status = status;
		this.client = client;
	}

	public OrdersUserDTO(Order entity) {
		super();
		this.id = entity.getId();
		this.moment = entity.getMoment();
		this.status = entity.getStatus();
		this.client = new UserDTO(entity.getClient());
	}

	public Long getId() {
		return id;
	}

	public Instant getMoment() {
		return moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public UserDTO getClient() {
		return client;
	}

}
