package com.example.ProjectManager.Controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.example.ProjectManager.Models.LoginUser;
import com.example.ProjectManager.Models.Project;
import com.example.ProjectManager.Models.User;
import com.example.ProjectManager.Services.AppServices;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class HomeController {
	private final AppServices appService;
	
	public HomeController(AppServices appService) {
		this.appService=appService;
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
		appService.register(newUser, result);
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
		  
		 User user= appService.login(newLogin, result);
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
			 List <Project> p=appService.findAll();
			 User this_user=appService.findUserById(user_id);
			 List<Project> notcontain=appService.notcontain(this_user);
			 List<Project>contain=appService.contain(this_user);
			  model.addAttribute("notcontain",notcontain);
			  model.addAttribute("contain",contain);
			  model.addAttribute("p",p);
			 
			  model.addAttribute("this_user",this_user);
			  return "home.jsp";
		  }}
	  @GetMapping("/logout")
	  public String logout(HttpSession session) {
		  session.invalidate();
		  return "redirect:/";
		  
	  }
	  @GetMapping("/projects/new")
	  public String gotocreateproject(@ModelAttribute("proj") Project proj,Model model,HttpSession session)
	  {
		  Long user_id = (Long) session.getAttribute("user_id");
		  if(user_id==null) {
			  return "redirect:/";
		  }
		  else {
			  User this_user=appService.findUserById(user_id);
			  model.addAttribute("user",this_user);
			  return "projectform.jsp";
		  }}
	  @PostMapping("/projects/new")
	  public String createproject(@Valid @ModelAttribute("proj") Project proj,
			  BindingResult result, Model model, HttpSession session ) {
		  if(result.hasErrors()) {
			  return "projectform.jsp"; 
		  }else {
			  appService.createproject(proj);
			  return "redirect:/home";
		  }
	  }
	  @GetMapping("/join/{p_id}")
	  public String join (@PathVariable("p_id") Long project_id, HttpSession session ) {
		  Long user_id = (Long) session.getAttribute("user_id");
		  User this_user=appService.findUserById(user_id);
		  Project this_project=appService.findProjectById(project_id);
		  this_project.getUsers().add(this_user);
		  appService.join(this_project);
		  return "redirect:/home";
		  
	  }
	  @GetMapping("/leave/{p_id}")
	  public String leave (@PathVariable("p_id") Long project_id, HttpSession session ) {
		  Long user_id = (Long) session.getAttribute("user_id");
		  User this_user=appService.findUserById(user_id);
		  Project this_project=appService.findProjectById(project_id);
		  this_project.getUsers().remove(this_user);
		  appService.leave(this_project);
		  return "redirect:/home";
		  
	  }
	  @GetMapping("/edit/{id}")
	  public String gotoeditproject(@ModelAttribute("editproj") Project editprojs,Model model,HttpSession session,
			  @PathVariable Long id)
	  {
		  Long user_id = (Long) session.getAttribute("user_id");
		  if(user_id==null) {
			  return "redirect:/";
		  }
		  else {
			  User this_user=appService.findUserById(user_id);
			  Project this_project=appService.findProjectById(id);
			  model.addAttribute("user",this_user);
			  model.addAttribute("editproj",this_project);
			  
			  return "editform.jsp";
		  }}
	  @PutMapping("/edit/{id}")
	  public String editproject(@Valid @ModelAttribute("editproj") Project editprojs,
			  BindingResult result, Model model,@PathVariable Long id) {
		  if(result.hasErrors()) {
			  return "editform.jsp"; 
		  }else {
			  appService.editproject(editprojs);
			  return "redirect:/home";
		  }
	  }
	  @GetMapping("/delete/{id}")
	  public String delete(@PathVariable Long id) {
		  appService.delete(id);
		  return "redirect:/home";
	  }
	  @GetMapping("/show/{id}")
	  public String show(@PathVariable Long id,Model model) {
		  
		  Project p=appService.findProjectById(id);
		  model.addAttribute("p",p);
		  return "show.jsp";
	  }
}
