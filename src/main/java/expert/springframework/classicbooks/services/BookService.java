package expert.springframework.classicbooks.services;

import expert.springframework.classicbooks.model.Book;

import java.util.Set;

public interface BookService {

    Book findById(Long id);

    Book save(Book book);

    Set<Book> findAll();

}
