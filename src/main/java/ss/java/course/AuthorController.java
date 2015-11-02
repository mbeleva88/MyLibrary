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
import ss.java.course.service.AuthorService;


@Controller
@RequestMapping({ "/authors" })
public class AuthorController {

	@Autowired
	AuthorService authorService;

	@Autowired
	MessageSource messageSource;
	
	/*
	 * Show all authors
	 */
	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String listAllAuthors(ModelMap model) {
		List<Author> authors = authorService.findAllAuthors();
		model.addAttribute("isEmpty", false);
		
		if (authors.isEmpty()) {
			model.addAttribute("isEmpty", true);
		}
		
		model.addAttribute("authors", authors);
		return "authors/all";
	}
	
	/*
     * Adds a new author
     */
	@RequestMapping(value = { "/new" }, method = RequestMethod.GET)
	public String addNewAuthor(ModelMap model) {
		Author author = new Author();
		String countryAuthor = new String();
		model.addAttribute("author", author);
		model.addAttribute("edit", false);
		model.addAttribute("country", countryAuthor);
		return "authors/addNewAuthor";
	}
	
	
	@RequestMapping(value = { "/new" }, method = RequestMethod.POST)
	public String saveAuthor(@Valid Author author, BindingResult result, ModelMap model) {

		if (result.hasErrors()) {
			return "authors/addNewAuthor";
		}

		authorService.saveAuthor(author);
		return "redirect:/authors/";
	}
	
	/*
     * Edit an author
     */
	@RequestMapping(value = { "/{author_id}" }, method = RequestMethod.GET)
	public String editAuthor(@PathVariable Integer author_id, ModelMap model) {
		Author author = authorService.findById(author_id);
		model.addAttribute("author", author);
		model.addAttribute("edit", true);
		return "authors/addNewAuthor";
	}
	
	@RequestMapping(value = { "/{author_id}" }, method = RequestMethod.PUT)
	public String updateAuthor(@Valid Author author, BindingResult result, ModelMap model, @PathVariable Integer author_id) {

		if (result.hasErrors()) {
			return "authors/addNewAuthor";
		}

		authorService.updateAuthor(author);
		return "redirect:/authors/";
	}
	
	/*
     * Delete an author
     */
	@RequestMapping(value = { "/{author_id}" }, method = RequestMethod.DELETE)
	public String deleteAuthor(@PathVariable Integer author_id) {
		authorService.deleteAuthor(author_id);
		return "redirect:/authors/";
	}
}
