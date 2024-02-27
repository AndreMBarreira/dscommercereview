package com.devsuperior.dscommerce.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.dscommerce.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	@Query("SELECT obj FROM User obj JOIN FETCH obj.orders")
	List<User> findUsersWithOrders();

}
