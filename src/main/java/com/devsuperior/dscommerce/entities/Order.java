package com.devsuperior.dscommerce.entities;

import java.time.Instant;
import java.util.Objects;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_order")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long id;
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	public Instant moment;
	public OrderStatus status;
	
	@ManyToOne
	@JoinColumn(name = "client_id")
	private User client;
	
	public Order() {}

	public Order(long id, Instant moment, OrderStatus status, User client) {
		this.id = id;
		this.moment = moment;
		this.status = status;
		this.client = client;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return id == other.id;
	}
	
	
	

}
