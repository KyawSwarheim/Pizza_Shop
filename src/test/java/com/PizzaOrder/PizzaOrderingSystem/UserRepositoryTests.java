package com.PizzaOrder.PizzaOrderingSystem;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.PizzaOrder.PizzaOrderingSystem.Repository.UserRepository;
import com.PizzaOrder.PizzaOrderingSystem.entity.User;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void testCreateUser() {
		User user = new User();
		user.setEmail("kaung99@gmail.com");
		user.setName("Kyaw");
		user.setPassword("kyaw123");
		
		User savedUser = userRepository.save(user);
		
		User existUser = entityManager.find(User.class,savedUser.getId());
		
		assertThat(existUser.getEmail()).isEqualTo(user.getEmail());
	}
	
	@Test
	public void testFindUserByEmail() {
		String email = "kaung99@gmail.com";
		User user = userRepository.findByEmail(email);
		
		assertThat(user).isNotNull();
	}
	

}
