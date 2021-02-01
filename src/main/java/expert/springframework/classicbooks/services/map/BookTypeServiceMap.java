package expert.springframework.classicbooks.services.map;

import expert.springframework.classicbooks.model.BookType;
import expert.springframework.classicbooks.services.BookTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class BookTypeServiceMap extends AbstractMapService<BookType, Long> implements BookTypeService {

    @Override
    public Set<BookType> findAll() {
        return super.findAll();
    }

    @Override
    public BookType findById(Long id) {
        return super.findById(id);
    }

    @Override
    public BookType save(BookType object) {
        return super.save(object);
    }

    @Override
    public void delete(BookType object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
