package expert.springframework.classicbooks.services;

import expert.springframework.classicbooks.model.Author;

import java.util.Set;

public interface AuthorService {

    Author findByLastName(String lastName);

    Author findById(Long id);

    Author save(Author author);

    Set<Author> findAll();

}
