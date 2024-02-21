package com.devsuperior.dscommerce.entities;

import java.time.Instant;

import jakarta.persistence.*;
@Entity
@Table(name = "tb_payment")
public class Payment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long id;
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	public Instant moment;
	
	@OneToOne
	@MapsId
	private Order order;

	public Payment() {
		super();
	}

	public Payment(long id, Instant moment, Order order) {
		super();
		this.id = id;
		this.moment = moment;
		this.order = order;
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

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	

}
