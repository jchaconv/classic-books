package expert.springframework.classicbooks.services.map;

import expert.springframework.classicbooks.model.Book;
import expert.springframework.classicbooks.services.CrudService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class BookServiceMap extends AbstractMapService<Book, Long> implements CrudService<Book, Long> {

    @Override
    public Set<Book> findAll() {
        return super.findAll();
    }

    @Override
    public Book findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Book save(Book object) {
        return super.save(object);
    }

    @Override
    public void delete(Book object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
