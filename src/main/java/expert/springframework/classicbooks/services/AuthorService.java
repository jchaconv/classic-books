package expert.springframework.classicbooks.services;

import expert.springframework.classicbooks.model.Author;

import java.util.List;

public interface AuthorService extends CrudService<Author, Long> {

    Author findByLastName(String lastName);

    List<Author> findAllByLastNameLike(String lastName);

}
