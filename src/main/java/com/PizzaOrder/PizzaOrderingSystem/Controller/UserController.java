package com.PizzaOrder.PizzaOrderingSystem.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.PizzaOrder.PizzaOrderingSystem.Repository.UserRepository;
import com.PizzaOrder.PizzaOrderingSystem.entity.User;

@Controller
public class UserController {
	
	@Autowired
	private UserRepository repo;
	
	@GetMapping("/")
	public String  viewHomePage() {
		return "home";	
	}
	
	@GetMapping("/page")
	public String  viewPage() {
		return "page";		
	}
	
	@GetMapping("/register")
	public String showSignUpForm(Model model) {
		model.addAttribute("user",new User());
		return "register";
	}
	
	@PostMapping("/process_register")
	public String processRegistration(User user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodePassword = encoder.encode(user.getPassword());
		user.setPassword(encodePassword);
		repo.save(user);
		return "home";
	}
	
	@GetMapping("/list_users")
	public String  viewUserPage(Model model) {
		List<User> listUsers = repo.findAll();
		model.addAttribute("listUsers",listUsers);
		return "userlist";		
	}

}
