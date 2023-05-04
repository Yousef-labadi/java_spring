package com.codingdojo.DojoandNinjas.Controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.DojoandNinjas.Services.AppServices;
import com.codingdojo.DojoandNinjas.models.Dojo;
import com.codingdojo.DojoandNinjas.models.Ninja;

import jakarta.validation.Valid;
@Controller
public class HomeController{
	private final AppServices appService;
	public HomeController(AppServices appService){
        this.appService = appService;
    }
	@RequestMapping("/dojos/new")
	public String formdojo(@ModelAttribute("dojo") Dojo dojo) {
		return "index.jsp";
	}
	@PostMapping("/dojos/new")
	public String handelformdojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result,Model model) {
		if (result.hasErrors()) {
            return "index.jsp";
        } else {
        	Dojo dj=appService.createDojo(dojo);
        	model.addAttribute("alldojo", dj);
            return "redirect:/alldojo";
        }
    }
	@RequestMapping("/alldojo")
	public String alldojo(Model model) {
	List<Dojo> dj=appService.findall();
		model.addAttribute("alldojo",dj);
		return "alldojo.jsp";
	}
	@RequestMapping("/ninjas/new")
	public String formninja(@ModelAttribute("ninja") Ninja ninja,Model model) {
		List<Dojo> dj=appService.findall();
		model.addAttribute("alldojo",dj);
		
		return "ninja.jsp";
	}
	@PostMapping("/ninjas/new")
	public String handelformninja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result,Model model) {
		if (result.hasErrors()) {
			List<Dojo> dj=appService.findall();
			model.addAttribute("alldojo",dj);
            return "ninja.jsp";
        } else {
        	Ninja nj=appService.createninja(ninja);
        	model.addAttribute("alldojo", nj);
            return "redirect:/dashbord";
        }
    }
	
	@RequestMapping("/dashbord/{id}")
	public String dashbord(@PathVariable("id") long id,Model model) {
		Dojo d = appService.findDojo(id);
		model.addAttribute("dojo",d);
		return "dashbord.jsp";
	}
		
	}
	

