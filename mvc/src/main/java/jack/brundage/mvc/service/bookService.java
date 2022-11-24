package jack.brundage.mvc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import jack.brundage.mvc.models.books;
import jack.brundage.mvc.repositories.bookRepository;

@Service
public class bookService {
	private final bookRepository bookRepository;
	
	public bookService(bookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	public List<books> allBooks() {
        return bookRepository.findAll();
    }
    // creates a book
    public books createBook(books b) {
        return bookRepository.save(b);
    }
    // update a book
    public books updateBook(books b) {
    	return bookRepository.save(b);
    }
    // delete a book
    public void deleteBook(long id) {
    	bookRepository.deleteById(id);
    }
    // retrieves a book
    public books findBook(Long id) {
        Optional<books> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
}
