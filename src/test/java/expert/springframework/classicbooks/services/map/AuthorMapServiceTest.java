package expert.springframework.classicbooks.services.map;

import expert.springframework.classicbooks.model.Author;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class AuthorMapServiceTest {

    AuthorMapService authorMapService;

    final Long authorId = 1L;
    final String lastName = "Vallejo";

    @BeforeEach
    void setUp() {

        authorMapService = new AuthorMapService(new BookTypeMapService(), new BookMapService());

        authorMapService.save(Author.builder().id(authorId).lastName(lastName).build());

    }

    @Test
    void findByLastName() {

        Author vallejo = authorMapService.findByLastName(lastName);

        assertNotNull(vallejo);

        assertEquals(authorId, vallejo.getId());


    }

    @Test
    void findAll() {

        Set<Author> authorSet = authorMapService.findAll();

        assertEquals(1, authorSet.size());

    }

    @Test
    void findById() {

        Author author = authorMapService.findById(authorId);

        assertEquals(authorId, author.getId());
    }

    @Test
    void saveExistingId() {

        long id = 2L;

        Author author2 = Author.builder().id(id).build();

        Author savedAuthor = authorMapService.save(author2);

        assertEquals(id, savedAuthor.getId());

    }

    @Test
    void saveNoId() {

        Author savedAuthor = authorMapService.save(Author.builder().build());

        assertNotNull(savedAuthor);
        assertNotNull(savedAuthor.getId());

    }

    @Test
    void delete() {

        authorMapService.delete(authorMapService.findById(authorId));

        assertEquals(0, authorMapService.findAll().size());

    }

    @Test
    void deleteById() {

        authorMapService.deleteById(authorId);

        assertEquals(0, authorMapService.findAll().size());

    }
}