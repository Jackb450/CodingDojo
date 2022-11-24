package jack.brundage.mvc.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jack.brundage.mvc.models.books;
import jack.brundage.mvc.service.bookService;

@RestController
public class booksAPI {
    private final bookService bookService;
    public booksAPI(bookService bookService){
        this.bookService = bookService;
    }
    @RequestMapping("/api/books")
    public List<books> index() {
        return bookService.allBooks();
    }
    
    @RequestMapping(value="/api/books", method=RequestMethod.POST)
    public books create(@RequestParam(value="title") String title, @RequestParam(value="description") String desc, @RequestParam(value="language") String lang, @RequestParam(value="pages") Integer numOfPages) {
        books book = new books(title, desc, lang, numOfPages);
        return bookService.createBook(book);
    }
    
    @RequestMapping("/api/books/{id}")
    public books show(@PathVariable("id") Long id) {
        books book = bookService.findBook(id);
        return book;
    }
//    @RequestMapping(value="/api/books/{id}", method=RequestMethod.PUT)
//    public books update(
//    		@PathVariable("id") Long id, 
//    		@RequestParam(value="title") String title, 
//    		@RequestParam(value="description") String desc, 
//    		@RequestParam(value="language") String lang,
//    		@RequestParam(value="pages") Integer numOfPages) {
//        books book = bookService.updateBook(id, title, desc, lang, numOfPages);
//        return book;
//    }   
//    @RequestMapping(value="/api/books/{id}", method=RequestMethod.DELETE)
//    public void destroy(@PathVariable("id") Long id) {
//        bookService.deleteBook(id);
//    }
}
