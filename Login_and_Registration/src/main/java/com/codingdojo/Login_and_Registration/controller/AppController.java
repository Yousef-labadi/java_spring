package com.codingdojo.Login_and_Registration.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.codingdojo.Login_and_Registration.Services.UserService;
import com.codingdojo.Login_and_Registration.models.User;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

import com.codingdojo.Login_and_Registration.models.LoginUser;
@Controller
public class AppController {
	private final UserService userservices;
	public AppController(UserService userservices) {
		this.userservices=userservices;
	}
	
	@GetMapping("/")
    public String index(Model model) {
		model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
        return "userform.jsp";
    }
	
	@PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser,BindingResult result, Model model, HttpSession session) {
		
            // Be sure to send in the empty LoginUser before 
            // re-rendering the page.
			userservices.register(newUser, result);
			if(result.hasErrors()) {
            model.addAttribute("newLogin", new LoginUser());
            return "userform.jsp";
        }
        
        // No errors! 
        // TO-DO Later: Store their ID from the DB in session, 
        // in other words, log them in.
			session.setAttribute("user_id", newUser.getId());
        return "redirect:/home";
	}
	  @PostMapping("/login")
	    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
	            BindingResult result, Model model, HttpSession session) {
	        
	        // Add once service is implemented:
	        // User user = userServ.login(newLogin, result);
		  
		 User user= userservices.login(newLogin, result);
	        if(result.hasErrors()) {
	            model.addAttribute("newUser", new User());
	            return "userform.jsp";
	        }
	    
	        // No errors! 
	        // TO-DO Later: Store their ID from the DB in session, 
	        // in other words, log them in.
	        session.setAttribute("user_id", user.getId());
	        return "redirect:/home";
	    }
	  @GetMapping("/home")
	  public String home(Model model,HttpSession session) {
		  Long user_id = (Long) session.getAttribute("user_id");
		  if (user_id == null) {
			  return "redirect:/";
		  }
		  else {
			  User this_user=userservices.findUserById(user_id);
			  model.addAttribute("this_user",this_user);
			  return "home.jsp";
		  }}
	  @GetMapping("/logout")
	  public String logout(HttpSession session) {
		  session.invalidate();
		  return "redirect:/";
		  
	  }
}
