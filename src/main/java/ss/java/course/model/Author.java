package ss.java.course.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;


@Entity
@Table(name = "AUTHORS")
public class Author {

	@Id
	@Column(name = "AUTHOR_ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer author_id;

	@Size(min = 3, max = 50)
	@Column(name = "NAME", nullable = false)
	private String name;

	@Size(min = 3, max = 50)
	@Column(name = "COUNTRY", nullable = false)
	private String country;

	@OneToMany(mappedBy = "author", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Book> book;

	public Author(Integer author_id, String name, String country) {
		this.author_id = author_id;
		this.name = name;
		this.country = country;
	}

	public Author() {
	}

	public Set<Book> getBook() {
		return book;
	}

	public void setBook(Set<Book> book) {
		this.book = book;
	}

	public Integer getAuthor_id() {
		return author_id;
	}

	public void setAuthor_id(Integer author_id) {
		this.author_id = author_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	@Override
	public String toString() {
		return "Author [author_id=" + author_id + ", name=" + name + ", country=" + country + ", book=" + book + "]";
	}
}
