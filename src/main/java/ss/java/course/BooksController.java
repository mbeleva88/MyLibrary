package ss.java.course;

import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ss.java.course.model.Author;
import ss.java.course.model.Book;
import ss.java.course.service.AuthorService;
import ss.java.course.service.BooksServices;


@Controller
@RequestMapping(value = "/authors/{author_id}/")
public class BooksController {

	@Autowired
	BooksServices booksService;

	@Autowired
	AuthorService authorService;

	@Autowired
	MessageSource messageSource;

	/*
	 * Show all books by an author
	 */
	@RequestMapping(value = { "/books" }, method = RequestMethod.GET)
	public String listAllBooks(@PathVariable Integer author_id, ModelMap model) {
		Author author = authorService.findById(author_id);
		Set<Book> book = author.getBook();
		model.addAttribute("isEmpty", false);
		
		if (book.isEmpty()) {
			model.addAttribute("isEmpty", true);
		}
		
		model.addAttribute("books", book);
		model.addAttribute("author", author.getName());
		return "books/all";
	}
	
	/*
	 * Add new book by an author
	 */
	@RequestMapping(value = { "/books/new" }, method = RequestMethod.GET)
	public String addNewBook(ModelMap model) {
		Book book = new Book();
		model.addAttribute("book", book);
		model.addAttribute("edit", false);
		return "books/addNewBook";
	}

	/*
	 * Save book
	 */
	@RequestMapping(value = { "/books/new" }, method = RequestMethod.POST)
	public String saveBook(@Valid Book book, BindingResult result, ModelMap model, @PathVariable Integer author_id) {

		if (result.hasErrors()) {
			return "books/addNewBook";
		}

		Author author = authorService.findById(author_id);
		author.getBook().add(book);
		book.setAuthor(author);
		booksService.saveBook(book);
		return "redirect:/authors/{author_id}/books";
	}

	/*
	 * Edit book
	 */
	@RequestMapping(value = { "/books/{book_id}" }, method = RequestMethod.GET)
	public String editBook(@PathVariable Integer book_id, ModelMap model) {
		Book book = booksService.findById(book_id);
		Author author = book.getAuthor();
		model.addAttribute("book", book);
		model.addAttribute("author", author);
		model.addAttribute("edit", true);
		return "books/addNewBook";
	}

	/*
	 * Update book 
	 */
	@RequestMapping(value = { "/books/{book_id}" }, method = RequestMethod.PUT)
	public String updateBook(@Valid Book formBook, BindingResult result, ModelMap model,
			@PathVariable Integer author_id, @PathVariable Integer book_id) {

		if (result.hasErrors()) {
			return "books/addNewBook";
		}

		Author author = authorService.findById(author_id);
		Book dbBook = booksService.findById(book_id);

		dbBook = formBook;

		booksService.updateBook(dbBook);
		author.getBook().add(dbBook);
		return "redirect:/authors/{author_id}/books";
	}

	/*
	 * Delete book 
	 */
	@RequestMapping(value = { "/books/{book_id}" }, method = RequestMethod.DELETE)
	public String deleteBook(@PathVariable Integer author_id, @PathVariable Integer book_id) {
		Book book = booksService.findById(book_id);
		Author author = authorService.findById(author_id);

		author.getBook().remove(book);
		booksService.deleteBooks(book);
		return "redirect:/authors/{author_id}/books/";
	}
}
