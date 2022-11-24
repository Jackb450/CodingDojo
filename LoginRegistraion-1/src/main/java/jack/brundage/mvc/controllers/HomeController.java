package jack.brundage.mvc.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jack.brundage.mvc.models.Login;
import jack.brundage.mvc.models.Users;
import jack.brundage.mvc.service.UserService;

@Controller
public class HomeController {
    @Autowired
    private UserService userServ;
    @GetMapping("/")
    public String index(Model model, HttpSession session) {
        // Bind empty User and LoginUser objects to the JSP to capture the form input
    	if (session.getAttribute("id") != null) {
    		return "redirect:/home";
    	}
        model.addAttribute("newUser", new Users());
        model.addAttribute("newLogin", new Login());
        return "index.jsp";
    }
    
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") Users newUser, 
            BindingResult result, Model model, HttpSession session) {
        
        userServ.createUser(newUser, result);
        if(result.hasErrors()) {
            model.addAttribute("newLogin", new Login());
            return "index.jsp";
        }
        session.setAttribute("id", newUser.getId());
        return "redirect:/home";
    }
    
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") Login newLogin, 
            BindingResult result, Model model, HttpSession session) {
        Users user = userServ.loginUser(newLogin, result);
        if(result.hasErrors()) {
            model.addAttribute("newUser", new Users());
            return "index.jsp";
        }
        session.setAttribute("id", user.getId());
        return "redirect:/home";
    }
    @GetMapping("/home")
    public String home(Model model, HttpSession session) {
    	if (session.isNew() || session.getAttribute("id") == null) {
    		return "redirect:/";
    	}
    	else {
    		Users Login = userServ.findUser((long) session.getAttribute("id"));
    		model.addAttribute("login", Login);
    		return "dashboard.jsp";
    	}
    }
    @GetMapping("/logout")
    public String logout(HttpSession session) {
    	session.invalidate();
    	return "redirect:/";
    }
}