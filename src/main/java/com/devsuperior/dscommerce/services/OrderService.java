package com.devsuperior.dscommerce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dscommerce.DTO.OrderDTO;
import com.devsuperior.dscommerce.DTO.OrdersUserDTO;
import com.devsuperior.dscommerce.entities.Order;
import com.devsuperior.dscommerce.entities.User;
import com.devsuperior.dscommerce.repositories.OrderRepository;
import com.devsuperior.dscommerce.repositories.UserRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository repository;
	
	@Autowired
	private UserRepository userRepository;
	
	public OrdersUserDTO insert(OrdersUserDTO dto) {
		Order entity = new Order();
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new OrdersUserDTO(entity);
	}
	
	//Pode-se manter metodos com mesmo nome(sobrecarga), mas com parametros diferentes 
	public OrderDTO insert(OrderDTO dto) {
		Order entity = new Order();
		
		entity.setMoment(dto.getMoment());
		entity.setStatus(dto.getStatus());
		
		//User client = userRepository.getReferenceById(dto.getClientId());
		User client = new User();
		client.setId(dto.getClientId());
		entity.setClient(client);
		entity = repository.save(entity);
		return new OrderDTO(entity);
	}
	
	private void copyDtoToEntity(OrdersUserDTO dto, Order entity) {

		entity.setMoment(dto.getMoment());
		entity.setStatus(dto.getStatus());
		
		User client = userRepository.getReferenceById(dto.getClient().getId());
		//User client = new User();
		//client.setId(dto.getClient().getId());
		
		entity.setClient(client);
		}


}
