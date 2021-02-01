package expert.springframework.classicbooks.services.map;

import expert.springframework.classicbooks.model.Author;
import expert.springframework.classicbooks.model.Book;
import expert.springframework.classicbooks.services.AuthorService;
import expert.springframework.classicbooks.services.BookService;
import expert.springframework.classicbooks.services.BookTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class AuthorServiceMap extends AbstractMapService<Author, Long> implements AuthorService {

    private final BookTypeService bookTypeService;
    private final BookService bookService;

    public AuthorServiceMap(BookTypeService bookTypeService, BookService bookService) {
        this.bookTypeService = bookTypeService;
        this.bookService = bookService;
    }

    @Override
    public Author findByLastName(String lastName) {
        return null;
    }

    @Override
    public Set<Author> findAll() {
        return super.findAll();
    }

    @Override
    public Author findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Author save(Author object) {
        if (object != null) {
            if (object.getBooks() != null) {
                object.getBooks().forEach(book -> {
                    if (book.getBookType() != null) {
                        if (book.getBookType().getId() == null) {
                            book.setBookType(bookTypeService.save(book.getBookType()));
                        }
                    } else {
                        throw new RuntimeException("Book Type is required");
                    }

                    if (book.getId() == null) {
                        Book savedBook = bookService.save(book);
                        book.setId(savedBook.getId());
                    }
                });
            }

            return super.save(object);

        } else {
            return null;
        }

    }

    @Override
    public void delete(Author object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
