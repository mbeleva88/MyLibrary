package ss.java.course.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;


@Entity
@Table(name = "BOOKS")
public class Book {

	@Id
	@Column(name = "BOOK_ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer book_id;

	@Size(min = 3, max = 100)
	@Column(name = "TITLE", nullable = false)
	private String title;

	@Size(min = 3, max = 50)
	@Column(name = "STATUS", nullable = false)
	private String status;

	@ManyToOne
	@JoinColumn(name = "AUTHOR_ID")
	private Author author;

	@OneToMany(mappedBy = "book")
	private List<Comment> comment;
	
	public Integer getBook_id() {
		return book_id;
	}

	public List<Comment> getComment() {
		return comment;
	}

	public void setComment(List<Comment> comment) {
		this.comment = comment;
	}

	public void setBook_id(Integer book_id) {
		this.book_id = book_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}
	
	@Override
	public String toString() {
		return "Books [book_id=" + book_id + ", author_id=" + ", title=" + title + ", status=" + status + ", author="
				+ author + "]";
	}
}
