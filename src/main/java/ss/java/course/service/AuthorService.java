package ss.java.course.service;

import java.util.List;

import ss.java.course.model.Author;

public interface AuthorService {
	
	Author findById(Integer author_id);
	
	void saveAuthor(Author author);
	
	void updateAuthor(Author author);
	
	List<Author> findAllAuthors();
	
	void deleteAuthor(int author_id);

}
