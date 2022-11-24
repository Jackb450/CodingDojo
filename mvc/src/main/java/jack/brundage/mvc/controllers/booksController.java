package jack.brundage.mvc.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jack.brundage.mvc.models.books;
import jack.brundage.mvc.service.bookService;

@Controller
public class booksController {
	@Autowired
	bookService bookService;
    @RequestMapping("/books")
    public String index(Model model) {
        model.addAttribute("books", bookService.allBooks());
        return "book.jsp";
    }
    @RequestMapping("/book/{bookId}")
    public String book(Model model, @PathVariable("bookId") long bookId) {
    	books book = bookService.findBook(bookId);
    	model.addAttribute("book", book);
    	return "book.jsp";
    }
    @RequestMapping("/book/new")
    public String newBook(@ModelAttribute("book") books book) {
    	return "new.jsp";
    }
    @RequestMapping("/book/new/verify")
    public String create(@RequestParam("title") String title,
    		@RequestParam("description") String description,
    	    @RequestParam("language") String language,
    	    @RequestParam("pages") Integer pages, 
    	    RedirectAttributes redirectAttributes) {
    	if (title.length() < 3) {
        	redirectAttributes.addFlashAttribute("titleError", "Enter the books's title!");
        	return "redirect:/book/new";
    	}
    	if (description.length() < 5) {
        	redirectAttributes.addFlashAttribute("descError", "Enter the book's description!");
        	return "redirect:/book/new";
    	}
    	if (language.length() < 3 ) {
        	redirectAttributes.addFlashAttribute("languageError", "What language was it written in?");
        	return "redirect:/book/new";
    	}
    	if (pages.intValue() < 100) {
        	redirectAttributes.addFlashAttribute("numError", "more than 100 pages");
            return "redirect:/book/new";
    	}
	   	books book = new books(title, description, language, pages);
	   	bookService.createBook(book);
	   	return "redirect:/books";
    }
    @RequestMapping("/book/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        books book = bookService.findBook(id);
        model.addAttribute("book", book);
        return "edit.jsp";
    }
    
    @RequestMapping("/book/edit/{id}/verify")
    public String update(@Valid @ModelAttribute("book") books book, BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
        	redirectAttributes.addFlashAttribute("titleError", "Enter the books's title!");
        	redirectAttributes.addFlashAttribute("descError", "Enter the book's description!");
        	redirectAttributes.addFlashAttribute("languageError", "What language was it written in?");
        	redirectAttributes.addFlashAttribute("numError", "more than 100 pages");
            return "redirect:/book/{id}/edit";
        } 
        else {
            bookService.updateBook(book);
            return "redirect:/books";
        }
    }
    @RequestMapping("book/delete/{id}")
    public String delete(@PathVariable("id") long id) {
    	bookService.deleteBook(id);
    	return "redirect:/books";
    }
}
