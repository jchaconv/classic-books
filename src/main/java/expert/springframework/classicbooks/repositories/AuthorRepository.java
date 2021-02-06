package expert.springframework.classicbooks.repositories;

import expert.springframework.classicbooks.model.Author;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AuthorRepository extends CrudRepository<Author, Long> {

    Author findByLastName(String lastName);

    List<Author> findAllByLastNameLike(String lastName);

}
