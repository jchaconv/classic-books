package expert.springframework.classicbooks.repositories;

import expert.springframework.classicbooks.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {

    Author findByLastName(String lastName);

}
