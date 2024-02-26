package com.devsuperior.dscommerce.DTO;

import com.devsuperior.dscommerce.entities.Category;

public class CategoryDTO {

	private long id;
	private String name;
	
	public CategoryDTO(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public CategoryDTO(Category entity) {
		super();
		this.id = entity.getId();
		this.name = entity.getName();
	}
	
	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	
}
