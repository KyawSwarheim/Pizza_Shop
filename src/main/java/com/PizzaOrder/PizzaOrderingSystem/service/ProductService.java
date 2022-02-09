package com.PizzaOrder.PizzaOrderingSystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.PizzaOrder.PizzaOrderingSystem.entity.Product;

@Service
public interface ProductService {

	List<Product> listAllProduct();
	
	void saveProduct(Product product);
	
	Product getProduct(long id);
	
	void deleteProduct(long id);

}
