package jack.brundage.mvc.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jack.brundage.mvc.models.Travels;
import jack.brundage.mvc.service.TravelsService;

@Controller
public class ExpenseController {
	@Autowired
	private TravelsService travelsService;
	@RequestMapping("/expenses")
	public String index(Model model) {
		//gets list from SQL called travel
		List<Travels> travel = travelsService.allExpense();
		//send travel to jsp
		model.addAttribute("listTravel", travel);
		//add empty new travel for form:form
		model.addAttribute("newTravel", new Travels());
		return "expense.jsp";
	}
	@RequestMapping("/expenses/{id}")
    public String book(Model model, @PathVariable("id") long id) {
    	Travels location = travelsService.findExpense(id);
    	model.addAttribute("location", location);
    	return "details.jsp";
    }
	@PostMapping("/expenses")
    public String create(@Valid @ModelAttribute("newTravel") Travels travel, BindingResult result) {
        if (result.hasErrors()) {
            return "expense.jsp";
        } 
        else {
            travelsService.createExpense(travel);
            return "redirect:/expenses";
        }
    }
	@RequestMapping("/expenses/edit/{id}")
	public String edit(@PathVariable("id") long id, Model model) {
		Travels eTravel = travelsService.findExpense(id);
		model.addAttribute("editTravel", eTravel);
		return "edit.jsp";
	}
	@PostMapping("/expenses/edit/{id}")
    public String update(@PathVariable("id") long id, @Valid @ModelAttribute("editTravel") Travels eTravel, BindingResult result) {
        if (result.hasErrors()) {
            return "edit.jsp";
        } 
        else {
            travelsService.updateExpense(eTravel);
            return "redirect:/expenses";
        }
    }
	
	@RequestMapping("/expenses/delete/{id}")
	public String delete (@PathVariable("id") long id) {
		travelsService.deleteExpense(id);
		return "redirect:/expenses";
	}
}