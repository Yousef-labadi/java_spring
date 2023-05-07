package com.codingdojo.Products_and_Categories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.Products_and_Categories.models.Category;
import com.codingdojo.Products_and_Categories.models.Product;



@Repository
public interface CategoryRepo extends CrudRepository<Category, Long>{
	List<Category> findAll();
    // Retrieves a list of all categories for a particular product
    List<Category> findAllByProducts(Product product);
    
    // Retrieves a list of any categories a particular product
    // does not belong to.
    List<Category> findByProductsNotContains(Product product);

}
