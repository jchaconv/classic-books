package expert.springframework.classicbooks.services.springdatajpa;

import expert.springframework.classicbooks.model.BookType;
import expert.springframework.classicbooks.repositories.BookTypeRepository;
import expert.springframework.classicbooks.services.BookTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class BookTypeServiceImpl implements BookTypeService {

    private final BookTypeRepository bookTypeRepository;

    public BookTypeServiceImpl(BookTypeRepository bookTypeRepository) {
        this.bookTypeRepository = bookTypeRepository;
    }

    @Override
    public Set<BookType> findAll() {
        Set<BookType> bookTypes = new HashSet<>();
        bookTypeRepository.findAll().forEach(bookTypes::add);
        return bookTypes;
    }

    @Override
    public BookType findById(Long id) {
        return bookTypeRepository.findById(id).orElse(null);
    }

    @Override
    public BookType save(BookType bookType) {
        return bookTypeRepository.save(bookType);
    }

    @Override
    public void delete(BookType bookType) {
        bookTypeRepository.delete(bookType);
    }

    @Override
    public void deleteById(Long id) {
        bookTypeRepository.deleteById(id);
    }
}
