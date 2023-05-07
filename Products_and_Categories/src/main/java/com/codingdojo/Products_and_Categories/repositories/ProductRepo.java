package com.codingdojo.Products_and_Categories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.Products_and_Categories.models.Category;
import com.codingdojo.Products_and_Categories.models.Product;

@Repository
public interface ProductRepo extends CrudRepository<Product, Long>  {
	List<Product> findAll();
	
	List<Product> findByCategoriesNotContains(Category c);
	
}
