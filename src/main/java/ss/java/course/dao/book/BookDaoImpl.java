package ss.java.course.dao.book;

import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import ss.java.course.dao.AbstractDao;
import ss.java.course.model.Book;


@Repository("bookDao")
public class BookDaoImpl extends AbstractDao<Integer, Book> implements BookDao {

	/*
	 * Find book by book_id
	 */
	public Book findById(Integer book_id) {
		Book book = getByKey(book_id);
		if (book != null) {
			Hibernate.initialize(book.getAuthor());
		}
		return book;
	}

	/*
	 * Save book
	 */
	public void saveBook(Book book) {
		persist(book);
	}

	/*
	 * Delete book
	 */
	public void deleteBookById(Integer book_id) {
		Query query = getSession().createSQLQuery("delete from books where book_id = :book_id");
		query.setInteger("book_id" , book_id);
		query.executeUpdate();
	}

	/*
	 * Show all books
	 */
	@SuppressWarnings("unchecked")
	public Set<Book> findAllBooks() {
		
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("title"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        Set<Book> books = (Set<Book>) criteria.list();     
        return books;
	}
}
