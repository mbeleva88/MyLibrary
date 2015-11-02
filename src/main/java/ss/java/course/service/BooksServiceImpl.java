package ss.java.course.service;

import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ss.java.course.dao.book.BooksDao;
import ss.java.course.model.Book;


@Service("booksService")
@Transactional
public class BooksServiceImpl implements BooksServices {

	@Autowired
	private BooksDao dao;

	/*
	 * Find book by book_id
	 */
	public Book findById(Integer book_id) {
		return dao.findById(book_id);
	}

	/*
	 * Save book
	 */
	public void saveBook(Book book) {
		dao.saveBook(book);
	}

	/*
	 * Update book
	 */
	public void updateBook(Book book) {
		Book entity = dao.findById(book.getBook_id());

		if (entity != null) {
			entity.setTitle(book.getTitle());
			entity.setStatus(book.getStatus());
		}
	}

	/*
	 * Show all books
	 */
	public Set<Book> findAllBooks() {
		return dao.findAllBooks();
	}

	/*
	 * Delete book
	 */
	public void deleteBooks(Book book) {
		dao.deleteBookById(book.getBook_id());
	}
}
