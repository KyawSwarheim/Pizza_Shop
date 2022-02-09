package com.PizzaOrder.PizzaOrderingSystem.Controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.PizzaOrder.PizzaOrderingSystem.entity.Product;
import com.PizzaOrder.PizzaOrderingSystem.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService productservice;
	
	@RequestMapping("/product")
	public String  viewHomePage(Model model) {
		List<Product> listProducts = productservice.listAllProduct();
		model.addAttribute("listProducts", listProducts);
		
//		List<String> typelist = Arrays.asList("Margarita","Hawaiian","Meat Lovers","Supreme","Vegetarian");
//		model.addAttribute("typelist", typelist);
		return "myorder";		
	}
	
	@RequestMapping("/menu")
	public String  viewMenuPage() {
		return "menu";
	}
	
	@RequestMapping("/new")
	public String  showNewproductForm(Model model) {
		model.addAttribute("product", new Product());
		return "customOrder";		
	}
	
	@RequestMapping(value= "/save", method = RequestMethod.POST)
	public String saveNewProduct(@ModelAttribute("product")Product product) {
		productservice.saveProduct(product);
		return "redirect:/product";		
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView  editProduct(@PathVariable(name="id")Long id) {
		ModelAndView mav = new ModelAndView("editOrder");
		Product product = productservice.getProduct(id);
		mav.addObject("product",product);
		return mav;		
	}
	
	@RequestMapping("/delete/{id}")
	public String  deleteProduct(@PathVariable(name="id")Long id) {
		productservice.deleteProduct(id);
		return "redirect:/product";
	}

	@RequestMapping("/about")
	public String  viewAboutUs() {
		return "aboutUs";
		
	}
	@GetMapping("/checkout")
	public String  viewCheckout(Model model) {
		List<Product> listProducts = productservice.listAllProduct();
		model.addAttribute("listProducts", listProducts);
		return "checkout";		
	}
}
