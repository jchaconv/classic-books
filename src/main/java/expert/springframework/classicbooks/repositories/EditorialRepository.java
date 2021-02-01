package expert.springframework.classicbooks.repositories;

import expert.springframework.classicbooks.model.Editorial;
import org.springframework.data.repository.CrudRepository;

public interface EditorialRepository extends CrudRepository<Editorial, Long> {
}
