package com.codingdojo.Products_and_Categories.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.Products_and_Categories.models.Category;
import com.codingdojo.Products_and_Categories.models.Product;
import com.codingdojo.Products_and_Categories.services.Appservice;

import jakarta.validation.Valid;



@Controller
public class ApiController {
	private final Appservice appservice;
	public  ApiController(Appservice appservice) {
		this.appservice = appservice;	
	}
	@RequestMapping("/")
	public String index(Model model) {
		List <Product> p=appservice.allProducts();
		List <Category> c=appservice.allCategory();
		model.addAttribute("allproduct", p);
		model.addAttribute("allcategory", c);
		return "index.jsp";
	}
	@RequestMapping("/products/new")//this method to render a form of a product
	public String formproduct(@ModelAttribute("product") Product product) {
		
		return "productform.jsp";
	}
	@RequestMapping("/category/new")//this method to render a form of a category
	public String formcategory(@ModelAttribute("category") Category category) {
		
		return "categoryform.jsp";
	}
	@RequestMapping("/addproduct")//this method to create a new  product
	public String addproduct(@Valid @ModelAttribute("product") Product product,BindingResult result) {
		if (result.hasErrors()) {
            return "productform.jsp";
		} else {
			appservice.createProduct(product);
            return "redirect:/";
        }
	}
	@RequestMapping("/addcategory")//this method to create a new  category
	public String addcategory(@Valid @ModelAttribute("category") Category category,BindingResult result) {
		if (result.hasErrors()) {
            return "categoryform.jsp";
		} else {
			appservice.createCategory(category);
            return "redirect:/";
        }
	}
	@RequestMapping("/showp/{id}")
	public String prodpage(@PathVariable long id,@ModelAttribute("productc") Product pro,Model model) {
		Product onep= appservice.findProduct(id);
		 List<Category> allc= appservice.findByProductsNotContains(pro);
		model.addAttribute("oneproduct", onep);
		model.addAttribute("allcat", allc);
		return "information.jsp";
	}
	@RequestMapping("/showc/{id}")//this method to render a form of a product
	public String catogerypage(@PathVariable long id,@ModelAttribute("categoryp") Category categ,Model model) {
		Category onec= appservice.findCategory(id);
		 List<Product> allp= appservice.findByCategorysNotContains(categ);
		model.addAttribute("onecatogry", onec);
		model.addAttribute("allcat", allp);
		return "informationc.jsp";
	}
	
	@RequestMapping("/add_prod_to_category/{product_id}")
	public String add_product_to_catogery(@PathVariable long product_id,@RequestParam(value="name",required=false)long cat_id){
		
		appservice.add_ProductTo_Category(cat_id, product_id);
		return "redirect:/";
	}
	@RequestMapping("/add_category_to_product/{cato_id}")
	public String add_category_to_product(@PathVariable long cato_id,@RequestParam(value="name",required=false)long pro_id){
		
		appservice.add_ProductTo_Category(pro_id, cato_id);
		return "redirect:/";
	}
	
}
