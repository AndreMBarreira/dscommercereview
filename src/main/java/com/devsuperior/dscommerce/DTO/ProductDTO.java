package com.devsuperior.dscommerce.DTO;

import com.devsuperior.dscommerce.entities.Product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class ProductDTO {

	private long id;
	@NotBlank(message = "Campo requerido")
	@Size(min = 3, max = 80, message = "Nome precisa de ter de 3 a 80 caracteres")
	private String name;
	@Size(min = 10, message = "A descrição precisa ter no mínimo 10 caracteres")
	private String description;
	@Positive(message = "O preço deve ser positivo")
	private double price;
	private String imgUrl;

	public ProductDTO(long id, String name, String description, double price, String imgUrl) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.imgUrl = imgUrl;
	}
	
	public ProductDTO(Product entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.description = entity.getDescription();
		this.price = entity.getPrice();
		this.imgUrl = entity.getImgUrl();
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public double getPrice() {
		return price;
	}

	public String getImgUrl() {
		return imgUrl;
	}
	
}
