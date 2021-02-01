package expert.springframework.classicbooks.repositories;

import expert.springframework.classicbooks.model.Publication;
import org.springframework.data.repository.CrudRepository;

public interface PublicationRepository extends CrudRepository<Publication, Long> {
}
