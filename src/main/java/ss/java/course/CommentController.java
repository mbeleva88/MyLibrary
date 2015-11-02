package ss.java.course;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ss.java.course.model.Author;
import ss.java.course.model.Book;
import ss.java.course.model.Comment;
import ss.java.course.service.AuthorService;
import ss.java.course.service.BooksServices;
import ss.java.course.service.CommentService;

@Controller
@RequestMapping(value = { "/authors/{author_id}/books/{book_id}"})
public class CommentController {

	@Autowired
	AuthorService authorService;
	
	@Autowired
	BooksServices booksService;
	
	@Autowired
	CommentService commentService;

	@Autowired
	MessageSource messageSource;

	/*
	 * Show all comments by book
	 */
	@RequestMapping(value = { "/comments" }, method = RequestMethod.GET)
	public String listAllComments(@PathVariable Integer book_id, @PathVariable Integer author_id, ModelMap model) {
		
		Author author = authorService.findById(author_id);
		Book book = booksService.findById(book_id);
		List<Comment> comment = book.getComment();
		model.addAttribute("isEmpty", false);
		
		if (comment.isEmpty()) {
			model.addAttribute("isEmpty", true);
		} 
		
		model.addAttribute("comments", comment);
		model.addAttribute("author", author.getName());
		model.addAttribute("book", book.getTitle());
		return "allComments";
	}
	
	/*
	 *  Add new comment
	 */
	@RequestMapping(value = { "/comments/new" }, method = RequestMethod.GET)
	public String addNewComment(ModelMap model) {
		Comment comment = new Comment();
		model.addAttribute("comments", comment);
		model.addAttribute("edit", false);
		return "addNewComment";
	}

	/*
	 *  Save comment
	 */
	@RequestMapping(value = { "/comments/new" }, method = RequestMethod.POST)
	public String saveComment(@Valid Comment comment, BindingResult result, ModelMap model, @PathVariable Integer book_id) {

		if (result.hasErrors()) {
			return "addNewComment";
		}

		Book book = booksService.findById(book_id);
		book.getComment().add(comment);
		comment.setBook(book);
		commentService.saveComment(comment);
		return "redirect:/authors/{author_id}/books/{book_id}/comments";
	}
	
	/*
	 *  Edit comment
	 */
	@RequestMapping(value = { "/comments/{comment_id}" }, method = RequestMethod.GET)
	public String editComment(@PathVariable Integer comment_id, ModelMap model) {
		Comment comment = commentService.findById(comment_id);
		model.addAttribute("comments", comment);
		model.addAttribute("edit", true);
		return "addNewComment";
	}

	/*
	 *  Update comment
	 */
	@RequestMapping(value = { "/comments/{comment_id}" }, method = RequestMethod.PUT)
	public String updateComment(@Valid Comment formComment, BindingResult result, ModelMap model,
			@PathVariable Integer book_id, @PathVariable Integer comment_id) {

		if (result.hasErrors()) {
			return "addNewComment";
		}

		Book book = booksService.findById(book_id);
		Comment dbComment = commentService.findById(comment_id);

		dbComment = formComment;

		commentService.updateComment(dbComment);
		book.getComment().add(dbComment);
		return "redirect:/authors/{author_id}/books/{book_id}/comments";
	}

	/*
	 *  Delete comment
	 */
	@RequestMapping(value = { "/comments/{comment_id}" }, method = RequestMethod.DELETE)
	public String deleteComment(@PathVariable Integer book_id, @PathVariable Integer comment_id) {
		Comment comment = commentService.findById(comment_id);
		Book book = booksService.findById(book_id);

		book.getComment().remove(comment);
		commentService.deleteCommentById(comment_id);
		return "redirect:/authors/{author_id}/books/{book_id}/comments";
	}
	
}
	