package com.example.Omikuji_Form;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class Form {
	
	    @RequestMapping("/")
	    public String index() {
	       
	        return "form.jsp";
	    }
	    @PostMapping("/handel")
	    public String handelform(@RequestParam(value="num") Integer num,
	        	@RequestParam(value="city") String city ,
	    @RequestParam(value="person") String person,
	    @RequestParam(value="hobby") String hobby,
	    @RequestParam(value="living") String living,
	    @RequestParam(value="comm") String comm,HttpSession session){
	    	
	    	session.setAttribute("num", num);
	    	session.setAttribute("person", person);
	    	session.setAttribute("hobby", hobby);
	    	session.setAttribute("living", living);
	    	session.setAttribute("comm", comm);
	    	
	    	return "redirect:/showform";
	    	
	    }
	    @RequestMapping("/showform")
	    public String show(HttpSession session) {
	       
	        return "showform.jsp";
	    }
	    
	    
	

}
