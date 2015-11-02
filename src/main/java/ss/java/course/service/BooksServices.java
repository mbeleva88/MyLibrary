package ss.java.course.service;

import java.util.Set;

import ss.java.course.model.Book;

public interface BooksServices {

	Book findById(Integer book_id);
	
	void saveBook(Book book);
	
	void updateBook(Book book);
	
	Set<Book> findAllBooks();
	
	void deleteBooks(Book book);
	
}
