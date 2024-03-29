package com.devsuperior.dscommerce.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.dscommerce.entities.User;
import com.devsuperior.dscommerce.projections.UserDetailsProjection;

public interface UserRepository extends JpaRepository<User, Long>{
	
	@Query("SELECT obj FROM User obj JOIN FETCH obj.orders")
	List<User> findUsersWithOrders();
	
	@Query(nativeQuery = true, value = "SELECT tb_user.email AS username, "
			+ "tb_user.password, tb_role.id AS roleId, tb_role.authority "
			+ "FROM tb_user INNER JOIN tb_user_role ON tb_user.id = tb_user_role_id "
			+ "INNER JOIN tb_role ON tb_role.id = tb_user_role_id "
			+ "WHERE tb_user.email = :email")
	List<UserDetailsProjection> searchUserAndRolesByEmail(String email);

}
