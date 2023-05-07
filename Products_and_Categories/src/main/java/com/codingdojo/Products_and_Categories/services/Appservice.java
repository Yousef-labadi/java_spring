package com.codingdojo.Products_and_Categories.services;

import java.util.List;

import org.springframework.stereotype.Service;


import com.codingdojo.Products_and_Categories.models.Category;
import com.codingdojo.Products_and_Categories.models.Product;
import com.codingdojo.Products_and_Categories.repositories.CategoryRepo;
import com.codingdojo.Products_and_Categories.repositories.ProductRepo;

@Service
public class Appservice {
	private final ProductRepo prodRepo;
	private final CategoryRepo cateRepo;
	public  Appservice(ProductRepo prodRepo,CategoryRepo cateRepo) {
		this.prodRepo = prodRepo;
		this.cateRepo = cateRepo;
		
	}
	public Product  createProduct(Product b) {
        return prodRepo.save(b);
    }
	public Category createCategory(Category c) {
        return cateRepo.save(c);
    }
	public List<Product> allProducts() {
        return prodRepo.findAll();
    }
	public List<Category> allCategory() {
        return cateRepo.findAll();
    }
	public Product findProduct(long id){
	if (prodRepo.findById(id).isPresent()) {
		return prodRepo.findById(id).get();
}
	else {
		return null;
	}
}
	public Category findCategory(long id){
		if (cateRepo.findById(id).isPresent()) {
			return cateRepo.findById(id).get();
	}
		else {
			return null;
		}
	}
	public List<Category>  findallProduct() {
        return cateRepo.findAll();
    }
	public List<Product>  findallCategory() {
        return prodRepo.findAll();
    }
	public void add_ProductTo_Category(Long cat_id, Long product_id){
	      Category thisCategory =findCategory(cat_id);
	      Product thisProduct = findProduct(product_id);      
	      thisCategory.getProducts().add(thisProduct);
	      cateRepo.save(thisCategory);	
	    }
	public void add_CategoryTo_Product(Long pro_id, Long product_id){
	      Category  thisProduct =findCategory(pro_id);
	      Product thisCategory = findProduct(product_id);      
	      thisProduct.getProducts().add(thisCategory);
	      cateRepo.save(thisProduct);	
	    }
	
	public List<Category> findByProductsNotContains(Product P){
		return cateRepo.findByProductsNotContains( P);
	}
	
	
	public List<Product> findByCategorysNotContains(Category C){
		return prodRepo.findByCategoriesNotContains( C);
	}
}
