package com.example.DisplayDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Display {
	
	
		@RequestMapping("/")
	    public String index(Model model) {
			
	        
	        return "index.jsp";
	    }
		@GetMapping("/date")
	    public String date(Model model) {
			SimpleDateFormat sd = new SimpleDateFormat("EEEE, MMM dd, yyyy");
			Date d=new Date();
			model.addAttribute("d",sd.format(d));
	        
	        
	        return "date.jsp";
	    }
		@GetMapping("/time")
	    public String time(Model model) {
			SimpleDateFormat sd = new SimpleDateFormat("h:mm a");
			Date t=new Date();
			model.addAttribute("t",sd.format(t));
			
	        
	        return "time.jsp";
	    }




}
