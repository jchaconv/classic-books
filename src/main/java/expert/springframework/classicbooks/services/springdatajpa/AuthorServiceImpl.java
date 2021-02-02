package expert.springframework.classicbooks.services.springdatajpa;

import expert.springframework.classicbooks.model.Author;
import expert.springframework.classicbooks.repositories.AuthorRepository;
import expert.springframework.classicbooks.repositories.BookRepository;
import expert.springframework.classicbooks.repositories.BookTypeRepository;
import expert.springframework.classicbooks.services.AuthorService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final BookTypeRepository bookTypeRepository;


    public AuthorServiceImpl(AuthorRepository authorRepository, BookRepository bookRepository, BookTypeRepository bookTypeRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.bookTypeRepository = bookTypeRepository;
    }

    @Override
    public Author findByLastName(String lastName) {
        return authorRepository.findByLastName(lastName);
    }

    @Override
    public Set<Author> findAll() {

        Set<Author> authors = new HashSet<>();
        authorRepository.findAll().forEach(authors::add);

        return authors;
    }

    @Override
    public Author findById(Long id) {
        /*Optional<Author> optionalAuthor = authorRepository.findById(id);
        if (optionalAuthor.isPresent()) {
            return optionalAuthor.get();
        } else {
            return null;
        }*/
        return authorRepository.findById(id).orElse(null);
    }

    @Override
    public Author save(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public void delete(Author author) {
        authorRepository.delete(author);
    }

    @Override
    public void deleteById(Long id) {
        authorRepository.deleteById(id);
    }
}
