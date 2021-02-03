package expert.springframework.classicbooks.services.springdatajpa;

import expert.springframework.classicbooks.model.Author;
import expert.springframework.classicbooks.repositories.AuthorRepository;
import expert.springframework.classicbooks.repositories.BookRepository;
import expert.springframework.classicbooks.repositories.BookTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AuthorServiceImplTest {

    public static final String LAST_NAME = "Vallejo";

    @Mock
    AuthorRepository authorRepository;

    @Mock
    BookRepository bookRepository;

    @Mock
    BookTypeRepository bookTypeRepository;

    @InjectMocks
    AuthorServiceImpl service;


    Author returnAuthor;

    @BeforeEach
    void setUp() {

        returnAuthor = Author.builder().id(1L).lastName(LAST_NAME).build();

    }

    @Test
    void findByLastName() {


        when(authorRepository.findByLastName(any())).thenReturn(returnAuthor);

        Author vallejo = service.findByLastName(LAST_NAME);

        assertEquals(LAST_NAME, vallejo.getLastName());

        verify(authorRepository).findByLastName(any());

    }

    @Test
    void findAll() {

        Set<Author> returnAuthorsSet = new HashSet<>();
        returnAuthorsSet.add(Author.builder().id(1L).build());
        returnAuthorsSet.add(Author.builder().id(2L).build());

        when(authorRepository.findAll()).thenReturn(returnAuthorsSet);

        Set<Author> authors = service.findAll();

        assertNotNull(authors);
        assertEquals(2, authors.size());

    }

    @Test
    void findById() {

        when(authorRepository.findById(anyLong())).thenReturn(Optional.of(returnAuthor));

        Author author = service.findById(1L);

        assertNotNull(author);

    }

    @Test
    void findByIdNotFound() {

        when(authorRepository.findById(anyLong())).thenReturn(Optional.empty());

        Author author = service.findById(1L);

        assertNull(author);

    }

    @Test
    void save() {

        Author authorToSave = Author.builder().id(1L).build();

        when(authorRepository.save(any())).thenReturn(returnAuthor);

        Author savedAuthor = service.save(authorToSave);

        assertNotNull(savedAuthor);


    }

    @Test
    void delete() {

        service.delete(returnAuthor);

        verify(authorRepository, times(1)).delete(any());

    }

    @Test
    void deleteById() {

        service.deleteById(anyLong());

        verify(authorRepository, times(1)).deleteById(anyLong());


    }
}