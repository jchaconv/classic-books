package expert.springframework.classicbooks.repositories;

import expert.springframework.classicbooks.model.BookType;
import org.springframework.data.repository.CrudRepository;

public interface BookTypeRepository extends CrudRepository<BookType, Long> {
}
