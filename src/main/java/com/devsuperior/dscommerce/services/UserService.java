package com.devsuperior.dscommerce.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dscommerce.DTO.UserDTO;
import com.devsuperior.dscommerce.entities.User;
import com.devsuperior.dscommerce.repositories.UserRepository;
import com.devsuperior.dscommerce.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	@Transactional(readOnly = true)
	public UserDTO findById(Long id) {
		User user = repository.findById(id).
				orElseThrow(()-> new ResourceNotFoundException("Recurso não encontrado"));
		return new UserDTO(user);
	}
	
	/*@Transactional(readOnly = true)
	public Page<UserDTO> findAll(Pageable pageable) {
		Page<User> result = repository.findAll(pageable);
		return result.map(x -> new UserDTO(x));
	}*/
	
	/*@Transactional(readOnly = true)
	public List<UserDTO> findAll() {
		List<User> result = repository.findAll(Sort.by("name"));
		return result.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());

	}*/

	@Transactional(readOnly = true)
	public List<UserDTO> findAll() {
		List<User> result = repository.findUsersWithOrders();
		return result.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());

	}
}
