package expert.springframework.classicbooks.services.map;

import expert.springframework.classicbooks.model.Author;
import expert.springframework.classicbooks.services.AuthorService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class AuthorServiceMap extends AbstractMapService<Author, Long> implements AuthorService {

    @Override
    public Author findByLastName(String lastName) {
        return null;
    }

    @Override
    public Set<Author> findAll() {
        return super.findAll();
    }

    @Override
    public Author findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Author save(Author object) {
        return super.save(object.getId(), object);
    }

    @Override
    public void delete(Author object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
