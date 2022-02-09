package com.PizzaOrder.PizzaOrderingSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.PizzaOrder.PizzaOrderingSystem.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
