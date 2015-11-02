package ss.java.course.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "COMMENTS")
public class Comment {
	
	@Id
	@Column(name = "COMMENT_ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer comment_id;
	
	@Size(min = 3, max = 1000)
	@Column(name = "COMMENT", nullable = false)
	private String comment;
	
	@ManyToOne
	@JoinColumn(name = "BOOK_ID")
	private Book book;

	public Integer getComment_id() {
		return comment_id;
	}

	public void setComment_id(Integer comment_id) {
		this.comment_id = comment_id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
}
	