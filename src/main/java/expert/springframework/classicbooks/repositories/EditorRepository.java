package expert.springframework.classicbooks.repositories;

import expert.springframework.classicbooks.model.Editor;
import org.springframework.data.repository.CrudRepository;

public interface EditorRepository extends CrudRepository<Editor, Long> {
}
