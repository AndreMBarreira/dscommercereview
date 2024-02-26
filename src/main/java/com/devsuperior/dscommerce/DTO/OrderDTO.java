package com.devsuperior.dscommerce.DTO;

import java.time.Instant;

import com.devsuperior.dscommerce.entities.Order;
import com.devsuperior.dscommerce.entities.OrderStatus;

public class OrderDTO {
	
	private Long id;
	private Instant moment;
	private OrderStatus status;
	
	private Long clientId;

	public OrderDTO(Long id, Instant moment, OrderStatus status, Long clientId) {
		this.id = id;
		this.moment = Instant.now();
		this.status = status;
		this.clientId = clientId;
	}
	
	public OrderDTO(Order entity) {
		this.id = entity.getId();
		this.moment = entity.getMoment();
		this.status = entity.getStatus();
		this.clientId = entity.getClient().getId();
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

	public Long getClientId() {
		return clientId;
	}

}
