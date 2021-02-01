package expert.springframework.classicbooks.repositories;

import expert.springframework.classicbooks.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
