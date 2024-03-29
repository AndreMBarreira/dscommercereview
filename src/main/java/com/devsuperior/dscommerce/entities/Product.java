package com.devsuperior.dscommerce.entities;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_product")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	@Column(columnDefinition = "TEXT")
	private String description;
	private double price;
	private String imgUrl;
	
	@ManyToMany
	@JoinTable(name= "tb_product_category",
				joinColumns = @JoinColumn(name = "product_id"),
				inverseJoinColumns = @JoinColumn(name = "category_id"))
	private Set<Category> categories = new HashSet<>();
	
	//diferencial quando se tem chave estrangeira tipo PK do OrderItemPK
	@OneToMany(mappedBy = "id.product")
	private Set<OrderItem> items = new HashSet<>();
	
	public List<Order> getOrder(){
		return items.stream().map(x -> x.getOrder()).toList();
	}
	
	public Set<OrderItem> getItems() {
		return items;
	}
	
	public Product() {
		super();
	}

	public Product(long id, String name, String description, double price, String imgUrl) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.imgUrl = imgUrl;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public Set<Category> getCategories() {
		return categories;
	}

}
