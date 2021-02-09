package expert.springframework.classicbooks.controllers;

import expert.springframework.classicbooks.model.Book;
import expert.springframework.classicbooks.model.Publication;
import expert.springframework.classicbooks.services.BookService;
import expert.springframework.classicbooks.services.PublicationService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.beans.PropertyEditorSupport;
import java.time.LocalDate;
import java.util.Map;

@Controller
public class PublicationController {

    private final PublicationService publicationService;
    private final BookService bookService;

    public PublicationController(PublicationService publicationService, BookService bookService) {
        this.publicationService = publicationService;
        this.bookService = bookService;
    }

    @InitBinder
    public void dataBinder(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");

        dataBinder.registerCustomEditor(LocalDate.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) throws IllegalArgumentException {
                setValue(LocalDate.parse(text));
            }
        });
    }

    /**
     * Called before each and every @RequestMapping annotated method.
     * 2 goals:
     * - Make sure we always have fresh data
     * - Since we do not use the session scope, make sure that Book object always has an id
     * (Even though id is not part of the form fields)
     *
     * @param bookId
     * @return Pet
     */
    @ModelAttribute("publication")
    public Publication loadPetWithVisit(@PathVariable("bookId") Long bookId, Map<String, Object> model) {
        Book book = bookService.findById(bookId);
        model.put("book", book);
        Publication publication = new Publication();
        book.getPublications().add(publication);
        publication.setBook(book);
        return publication;
    }

    // Spring MVC calls method loadBookWithPublication(...) before initNewVisitForm is called
    @GetMapping("/authors/*/books/{bookId}/publications/new")
    public String initNewPublicationForm(@PathVariable("bookId") Long bookId, Map<String, Object> model) {
        return "books/createOrUpdatePublicationForm";
    }

    // Spring MVC calls method loadBookWithPublication(...) before processNewPublicationForm is called
    @PostMapping("/authors/{authorId}/books/{bookId}/publications/new")
    public String processNewVisitForm(@Validated Publication publication, BindingResult result) {
        if (result.hasErrors()) {
            return "books/createOrUpdatePublicationForm";
        } else {
            publicationService.save(publication);

            return "redirect:/authors/{authorId}";
        }
    }
}
