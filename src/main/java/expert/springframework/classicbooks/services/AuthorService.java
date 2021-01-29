package expert.springframework.classicbooks.services;

import expert.springframework.classicbooks.model.Author;

public interface AuthorService extends CrudService<Author, Long> {

    Author findByLastName(String lastName);

}
