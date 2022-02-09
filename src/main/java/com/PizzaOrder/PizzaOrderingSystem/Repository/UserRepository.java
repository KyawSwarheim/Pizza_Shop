package com.PizzaOrder.PizzaOrderingSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.PizzaOrder.PizzaOrderingSystem.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	@Query(value = "Select * from User u where u.email = ?1",nativeQuery = true)
	User findByEmail(@Param("email") String email);
}
