package jack.brundage.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/omikuji")
public class HomeController {
	@RequestMapping("")
	public String index() {
		return "login.jsp";
	}
	@RequestMapping("/confirm")
	public String verify(@RequestParam(value="num") Integer num,
			@RequestParam(value="city") String city,
			@RequestParam(value="person") String person, 
			@RequestParam(value="hobby") String hobby,
			@RequestParam(value="mammal") String mammal,
			@RequestParam(value="happy") String happy,
			HttpSession session,
			RedirectAttributes redirectAttributes) {
		
		if(num.intValue() < 5 || num.intValue() > 25 || num.intValue() == 0) {
			redirectAttributes.addFlashAttribute("numError", "The value must be inbetween 5 - 25!");
			return "redirect:/omikuji";
		}
		if(city.length() < 3 || city.length() == 0) {
			redirectAttributes.addFlashAttribute("cityError", "Enter a City name!");
			return "redirect:/omikuji";
		}
		if(person.length() < 2 || person.length() == 0) {
			redirectAttributes.addFlashAttribute("personError", "Enter someone's name!");
			return "redirect:/omikuji";
		}
		if(hobby.length() < 3 || hobby.length() == 	0) {
			redirectAttributes.addFlashAttribute("hobbyError", "What do you like to do?");
			return "redirect:/omikuji";
		}
		if(mammal.length() < 3 || mammal.length() == 0) {
			redirectAttributes.addFlashAttribute("mammalError", "Enter in a living thing!");
			return "redirect:/omikuji";
		}
		if(happy.length() < 3 || happy.length() == 0) {
			redirectAttributes.addFlashAttribute("happyError", "What makes you happy?");
			return "redirect:/omikuji";
		}
		
		session.setAttribute("num", num);
		session.setAttribute("city", city);
		session.setAttribute("person", person);
		session.setAttribute("hobby", hobby);
		session.setAttribute("mammal", mammal);
		session.setAttribute("happy", happy);
		return "redirect:/omikuji/fortune";
	}
	@RequestMapping("/fortune")
	public String fortune() {
		return "fortune.jsp";
	}
}
