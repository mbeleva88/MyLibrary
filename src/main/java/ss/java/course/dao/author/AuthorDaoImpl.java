package ss.java.course.dao.author;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import ss.java.course.dao.AbstractDao;
import ss.java.course.model.Author;


@Repository("authorDao")
public class AuthorDaoImpl extends AbstractDao<Integer, Author> implements AuthorDao {

	/*
	 * Find author by author_id
	 */
	public Author findById(Integer author_id) {
		Author author = getByKey(author_id);
		return author;
	}

	/*
	 * Save author
	 */
	public void saveAuthor(Author author) {
		persist(author);
	}

	/*
	 * Delete author by author_id
	 */
	public void deleteAuthorById(Integer author_id) {
		Query query = getSession().createSQLQuery("delete from authors where author_id = :author_id");
		query.setInteger("author_id", author_id);
		query.executeUpdate();
	}

	/*
	 * Show all authors
	 */
	@SuppressWarnings("unchecked")
	public List<Author> findAllAuthors() {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("name"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);

		List<Author> authors = (List<Author>) criteria.list();
		return authors;
	}
}
