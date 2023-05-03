package com.codingdojo.Burgar_tracker_1.HomeController;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.Burgar_tracker_1.BurgerService.BurgerService;
import com.codingdojo.Burgar_tracker_1.models.Burger;

import jakarta.validation.Valid;

@Controller
public class BurgerController {
	private final BurgerService burgerService;
	public BurgerController(BurgerService burgerService) {
		this.burgerService = burgerService;
		
	}
	@RequestMapping("/")
	public String index(@ModelAttribute("burger") Burger burger,Model model) {
		 List<Burger> br=this.burgerService.allBurgers();
		 model.addAttribute("br", br);
		return "index.jsp";	
	}
	@RequestMapping("/burger")
	public String handelform(@Valid @ModelAttribute("burger") Burger burger,BindingResult result) {
		if(result.hasErrors()) {
			return "index.jsp";
		}
		else {
			this.burgerService.createBurger(burger);
			return "redirect:/";
		}	
	}
}
