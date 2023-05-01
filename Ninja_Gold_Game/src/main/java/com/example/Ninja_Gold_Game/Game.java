package com.example.Ninja_Gold_Game;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.lang.Math;
import java.util.ArrayList;


import jakarta.servlet.http.HttpSession;

@Controller
public class Game {
	@RequestMapping("/form")
	public String showform(HttpSession session) {
		if(session.getAttribute("sum")==null) {
		 session.setAttribute("sum",0);
		}
		return "ninja.jsp";
	}
	
	@PostMapping("/gold_handel")
	public String gold_handel(@RequestParam(value="which_form",required=false) String farm,HttpSession session) {
		int rand=0;
		String acti=" ";
		ArrayList<String> activity = new ArrayList<String>();
		int s = (int) session.getAttribute("sum");
        switch (farm) {                                   //will be selected what form it will come
        case "farm":
        	 rand =(int)(Math.random() * (20-10) + 10);
        	 session.setAttribute("rand1",rand);
        	 session.setAttribute("sum",(int)session.getAttribute("sum")+rand);
        	 acti="you enter farm and eran : "+rand;
        	 activity.add(acti);
        	 session.setAttribute("myactivity", activity);
        	 System.out.println(s);//to check sum 
        	 System.out.println(rand);//to check rand  
        	 return "redirect:/backtoform";    
        case "cave":
        	 rand =(int)(Math.random() * (10-5) + 5);
        	 session.setAttribute("sum",(int)session.getAttribute("sum")+rand);
        	 acti="you enter cave and eran : "+rand;
        	 activity.add(acti);
        	 session.setAttribute("myactivity", activity);
        	 System.out.println(s);
        	 System.out.println(rand);
        	 return "redirect:/backtoform";
        case "house":  
        	 rand =(int)(Math.random() * (5-2) + 2);
        	 session.setAttribute("sum",(int)session.getAttribute("sum")+rand);
        	 acti="you enter house and eran : "+rand;
        	 activity.add(acti);
        	 session.setAttribute("myactivity", activity);
        	 System.out.println(s);
        	 System.out.println(rand);
        	 return "redirect:/backtoform";
        case "quest":
            	 rand =(int)(Math.random() * (-50-50)-50);
            	 int min=-50;
            	 int max=50;
            	 int range=max-min+1;
            	 rand =(int) (Math.random() * range) + min;
            	 session.setAttribute("sum",(int)session.getAttribute("sum")+rand);
            	 if(rand > 0) {
            	 acti="you enter quest and eran : "+rand;
            	 activity.add(acti);
            	 session.setAttribute("myactivity", activity);
            	 }
            	 else {
            		 acti="you enter quest and lost : "+rand;
                	 activity.add(acti);
                	 session.setAttribute("myactivity", activity);
            	 }
        case "noting":
        	break;
        	}
    	System.out.println(rand);
    	System.out.println(s);
    	
        	
        	 return "redirect:/backtoform";
		
	}
	@RequestMapping("/backtoform")
	public String backtoform() {
		return "ninja.jsp";
	}
	@RequestMapping("/reset")
	public String reset(HttpSession session) {
		session.setAttribute("sum",0);
		session.setAttribute("myactivity", " ");
		return "ninja.jsp";
		
	}

}
