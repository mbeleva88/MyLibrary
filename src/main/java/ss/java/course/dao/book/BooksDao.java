package ss.java.course.dao.book;

import java.util.Set;

import ss.java.course.model.Book;

public interface BooksDao {

	Book findById(Integer book_id);
	
	void saveBook(Book book);
	
	void deleteBookById(Integer book_id);
	
	Set<Book> findAllBooks();
	
}
