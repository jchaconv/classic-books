package expert.springframework.classicbooks.controllers;

import expert.springframework.classicbooks.model.Author;
import expert.springframework.classicbooks.model.Book;
import expert.springframework.classicbooks.model.BookType;
import expert.springframework.classicbooks.services.AuthorService;
import expert.springframework.classicbooks.services.BookService;
import expert.springframework.classicbooks.services.BookTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
@RequestMapping("authors/{authorId}")
public class BookController {


    private static final String VIEWS_BOOKS_CREATE_OR_UPDATE_FORM = "books/createOrUpdateBookForm";

    private final BookService bookService;
    private final AuthorService authorService;
    private final BookTypeService bookTypeService;

    public BookController(BookService bookService, AuthorService authorService, BookTypeService bookTypeService) {
        this.bookService = bookService;
        this.authorService = authorService;
        this.bookTypeService = bookTypeService;
    }

    @ModelAttribute("types")
    public Collection<BookType> populateBookTypes() {
        return bookTypeService.findAll();
    }

    @ModelAttribute("author")
    public Author findAuthor(@PathVariable("authorId") Long authorId) {
        return authorService.findById(authorId);
    }

    @InitBinder("author")
    public void initAuthorBinder(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    @GetMapping("/books/new")
    public String initCreationForm(Author author, Model model) {
        Book book = new Book();
        author.getBooks().add(book);
        book.setAuthor(author);
        model.addAttribute("book", book);
        return VIEWS_BOOKS_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/books/new")
    public String processCreationForm(Author author, @Validated Book book, BindingResult result, ModelMap model) {
        if (StringUtils.hasLength(book.getName()) && book.isNew() && author.getBook(book.getName(), true) != null) {
            result.rejectValue("name", "duplicate", "already exists");
        }
        author.getBooks().add(book);
        if (result.hasErrors()) {
            model.put("book", book);
            return VIEWS_BOOKS_CREATE_OR_UPDATE_FORM;
        } else {
            bookService.save(book);

            return "redirect:/authors/" + author.getId();
        }
    }

    @GetMapping("/books/{bookId}/edit")
    public String initUpdateForm(@PathVariable Long bookId, Model model) {
        model.addAttribute("book", bookService.findById(bookId));
        return VIEWS_BOOKS_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/books/{bookId}/edit")
    public String processUpdateForm(@Validated Book book, BindingResult result, Author author, Model model) {
        if (result.hasErrors()) {
            book.setAuthor(author);
            model.addAttribute("book", book);
            return VIEWS_BOOKS_CREATE_OR_UPDATE_FORM;
        } else {
            author.getBooks().add(book);
            bookService.save(book);
            return "redirect:/authors/" + author.getId();
        }
    }

}
