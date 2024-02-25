package com.devsuperior.dscommerce.DTO;

import com.devsuperior.dscommerce.entities.User;

public class UserDTO {
	
	private Long id;
	private String name;
	
	public UserDTO(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public UserDTO(User entity) {
		super();
		this.id = entity.getId();
		this.name = entity.getName();
	}

	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
}
