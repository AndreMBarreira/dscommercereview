package com.devsuperior.dscommerce.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_order_item")
public class OrderItem {
	
	@EmbeddedId
	private OrderItemPK id = new OrderItemPK();
	
	private Integer quantity;
	private double price;
	
	public OrderItem() {
		super();
	}

	public OrderItem(Order order, Product product, Integer quantity, double price) {
		super();
		//diferencial quando se tem chave estrangeira tipo PK do OrderItemPK
		id.setOrder(order);
		id.setProduct(product);
		this.quantity = quantity;
		this.price = price;
	}

	//diferencial quando se tem chave estrangeira tipo PK do OrderItemPK
	public Order getOrder() {
		return id.getOrder();
	}
	
	//diferencial quando se tem chave estrangeira tipo PK do OrderItemPK
	public void setOrder(Order order) {
		id.setOrder(order);
	}
	
	//diferencial quando se tem chave estrangeira tipo PK do OrderItemPK
	public Product getProduct() {
		return id.getProduct();
	}
	
	//diferencial quando se tem chave estrangeira tipo PK do OrderItemPK
	public void setProduct(Product product) {
		id.setProduct(product);
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	

}
