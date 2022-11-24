package jack.brundage.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String index(Model model, HttpSession session) {
		String firstName = "Jack";
		String lastName = "Brundage";
		String email = "Jbrundage@email.com";
		Integer age = 19;
		
		model.addAttribute("fruit", "strawberry");
		model.addAttribute("FName", firstName);
		model.addAttribute("LName", lastName);
		model.addAttribute("Email", email);
		model.addAttribute("Age", age);
		
		ArrayList<String> dojos = new ArrayList<String>();
		dojos.add("Burbank");
		dojos.add("Chicago");
		dojos.add("Bellevue");
		model.addAttribute("dojosFromMyController", dojos);
		
//		session.setAttribute("Count", 0);
		if (session.getAttribute("Count") == null) {
			session.setAttribute("Count", 110);
		}
		else {
			Integer currentCount = (Integer) session.getAttribute("Count");
			session.setAttribute("Count", currentCount + 1);	
		}
		return "demo.jsp";
	}
	@RequestMapping("/reset")
	public String indexReset(HttpSession session) {
		session.setAttribute("Count", 0);
		return ("redirect:/");
	}
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@RequestParam(value="email") String email, @RequestParam(value="password") String password) {
		return "login.jsp";
	}
}
