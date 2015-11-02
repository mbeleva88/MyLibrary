package ss.java.course.dao.author;

import java.util.List;

import ss.java.course.model.Author;

public interface AuthorDao {
	
	Author findById(Integer author_id);
	
	void saveAuthor(Author author);
	
	void deleteAuthorById(Integer author_id);
	
	List<Author> findAllAuthors();
	
}
