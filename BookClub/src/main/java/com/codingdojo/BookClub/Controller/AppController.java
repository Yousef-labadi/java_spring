package com.codingdojo.BookClub.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.BookClub.Service.AppService;
import com.codingdojo.BookClub.models.Book;
import com.codingdojo.BookClub.models.LoginUser;
import com.codingdojo.BookClub.models.User;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class AppController {
	private final AppService appservices;
	public AppController(AppService appservices) {
		this.appservices=appservices;
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
		appservices.register(newUser, result);
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
		  
		 User user= appservices.login(newLogin, result);
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
			  User this_user=appservices.findUserById(user_id);
			  List<Book> allBooks = appservices.allBooks();
			  model.addAttribute("this_user",this_user);
			  model.addAttribute("allBooks",allBooks);
			  
			  return "home.jsp";
		  }
		  }
	  @GetMapping("/logout")
	  public String logout(HttpSession session) {
		  session.invalidate();
		  return "redirect:/";
		  
	  }
	  @GetMapping("/book/new/{id}")
	  public String addbook(HttpSession session,@ModelAttribute("book") Book book,Model model,@PathVariable Long id) {
		  
		  User this_user=appservices.findUserById(id);
		  model.addAttribute("this_user",this_user);
		  return "bookform.jsp";
	  }
	  @PostMapping("/add/book")
	  public String addbook(@Valid @ModelAttribute("book") Book book, 
	            BindingResult result, Model model, HttpSession session) {
		  Long user_id = (Long) session.getAttribute("user_id");
		  if (result.hasErrors()) {
	            return "bookform.jsp";
		  } else {
			  
			  appservices.Creatbook(book);
			 
		
		  return "redirect:/home";
	  }
	  }
	  @GetMapping("/book/{id}")
	  public String showbook(HttpSession session,@PathVariable Long id,Model model) {
		   Book bk =appservices.findBookById(id);
		  
		  model.addAttribute("this_user",appservices.findUserById((Long) session.getAttribute("user_id")));
		  model.addAttribute("onebk",bk);
		  return "showform.jsp";
	  }
	  
	  @GetMapping("/edit/{id}")
public String Edit(@ModelAttribute("bk") Book book,@PathVariable Long id,Model model) {
		  
		  Book bk =appservices.findBookById(id);  
		  model.addAttribute("bk",bk);
	return "edit.jsp";
	
}
	  @PutMapping("/edit/{id}")
	  public String editbook(@Valid @ModelAttribute("bk") Book book, 
	            BindingResult result, Model model,@PathVariable Long id) {
		  
		  if (result.hasErrors()) {
	            return "edit.jsp";
		  } else {
			  
			  appservices.editbook(book);
			 
		
		  return "redirect:/home";
	  }
	  
}
	  @RequestMapping("/delete/{id}")
		public String destroy(@PathVariable("id") Long id) {
		  appservices.deleteBook(id);
	        return "redirect:/home";
	    }
	  }


