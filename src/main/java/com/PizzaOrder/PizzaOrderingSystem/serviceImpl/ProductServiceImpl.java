package com.PizzaOrder.PizzaOrderingSystem.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PizzaOrder.PizzaOrderingSystem.Repository.ProductRepository;
import com.PizzaOrder.PizzaOrderingSystem.entity.Product;
import com.PizzaOrder.PizzaOrderingSystem.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	ProductRepository repo;

	@Override
	public List<Product> listAllProduct() {		
		return repo.findAll();
	}

	@Override
	public void saveProduct(Product product) {
		repo.save(product);
	}

	@Override
	public Product getProduct(long id) {
		return repo.findById(id).get();
	}

	@Override
	public void deleteProduct(long id) {
		repo.deleteById(id);
		
	}

}
