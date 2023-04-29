package com.example.Counter;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import jakarta.servlet.http.HttpSession;

@Controller 

public class counter {
	@RequestMapping("/your_server/counter")
	public String index(HttpSession session) {
		
//		if (session.getAttribute("count") == null) {
//			// Use setAttribute to initialize the count in session
//			session.setAttribute("count",1);
//			}
//			else {
//				session.setAttribute("count",(Integer)session.getAttribute("count")+1);
//			}
		session.getAttribute("count");
	        return "counter.jsp";
	        
}
	@RequestMapping("/your_server")
	public String counter(HttpSession session) {
		
		if (session.getAttribute("count") == null) {
			// Use setAttribute to initialize the count in session
			session.setAttribute("count",1);
			}
			else {
				session.setAttribute("count",(Integer)session.getAttribute("count")+1);
			}
			
	        return "welcome.jsp";
	        
}
	
	@RequestMapping("/your_server/counter_plus_two")
	public String counterplus(HttpSession session) {
		
		if (session.getAttribute("count") == null) {
			// Use setAttribute to initialize the count in session
			session.setAttribute("count",1);
			}
			else {
				session.setAttribute("count",(Integer)session.getAttribute("count")+2);
			}
			
	        return "welcomeplus.jsp";
	        
}
	
	@RequestMapping("/reset")
	public String reset(HttpSession session) {
		session.setAttribute("count",1);
		
		
		 return "counter.jsp";
	}
	

}
