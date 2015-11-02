package ss.java.course.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ss.java.course.dao.author.AuthorDao;
import ss.java.course.model.Author;


@Service("authorService")
@Transactional
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	private AuthorDao dao;
	
	/*
	 * Find author by author_id
	 */
	public Author findById(Integer author_id) {
		return dao.findById(author_id);
	}

	/*
	 * Save author
	 */
	public void saveAuthor(Author author) {
		dao.saveAuthor(author);
	}

	/*
	 * Edit/Update author
	 */
	public void updateAuthor(Author author) {
		Author entity = dao.findById(author.getAuthor_id());
		
		if (entity != null) {
			entity.setName(author.getName());
			entity.setCountry(author.getCountry());
			entity.setBook(author.getBook());
		}
	}

	/*
	 * Show all authors
	 */
	public List<Author> findAllAuthors() {
		return dao.findAllAuthors();
	}

	/*
	 * Delete author
	 */
	public void deleteAuthor(int author_id) {
		dao.deleteAuthorById(author_id);
	}
}
