package jack.brundage.mvc.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import jack.brundage.mvc.models.Dojos;
import jack.brundage.mvc.models.Ninjas;
import jack.brundage.mvc.service.DojoService;

@Controller
public class HomeController {
	@Autowired
	private DojoService dojoService;
	@RequestMapping("/")
	public String home() {
		return "redirect:/dojos";
	}
	@RequestMapping("/dojos")
	public String dashboard(Model model) {
		List<Dojos> dojo = dojoService.allDojos();
		model.addAttribute("dojos", dojo);
		return "Dashboard.jsp";
	}
	@RequestMapping("/dojos/new")
	public String newDojo(@ModelAttribute("newDojo") Dojos dojo) {
		return "NewDojo.jsp";
	}
	@PostMapping("/dojos/new")
	public String verifyDojo(@Valid @ModelAttribute("newDojo") Dojos dojo, BindingResult result) {
		if(result.hasErrors()) {
			return "NewDojo.jsp";
		}
		else {
			dojoService.createDojo(dojo);
			return "redirect:/dojos";
		}
	}
	@RequestMapping("/dojos/new/ninja")
	public String newNinja(@ModelAttribute("newNinja") Ninjas ninja, Model model) {
		List<Dojos> dojo = dojoService.allDojos();
		model.addAttribute("dojos", dojo);
		return "NewNinja.jsp";
	}
	@PostMapping("/dojos/new/ninja")
	public String verifyNinja(@Valid @ModelAttribute("newNinja") Ninjas ninja, BindingResult result, Model model) {
		if(result.hasErrors()) {
			List<Dojos> dojo = dojoService.allDojos();
			model.addAttribute("dojos", dojo);
			return "NewNinja.jsp";
		}
		else {
			dojoService.createNinja(ninja);
			return "redirect:/dojos";
		}
	}
	@RequestMapping("/dojos/{id}")
	public String dojo(Model model, @PathVariable("id") long id) {
		Dojos name = dojoService.findDojo(id);
		List<Ninjas> ninja = dojoService.allNinjas();
		model.addAttribute("dojo", name);
		model.addAttribute("ninjas", ninja);
		return "Dojo.jsp";
	}
}
