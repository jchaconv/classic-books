package expert.springframework.classicbooks.controllers;

import expert.springframework.classicbooks.model.Author;
import expert.springframework.classicbooks.model.Book;
import expert.springframework.classicbooks.model.BookType;
import expert.springframework.classicbooks.services.AuthorService;
import expert.springframework.classicbooks.services.BookService;
import expert.springframework.classicbooks.services.BookTypeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


//Esta anotación es muy importante, si no se agrega no corre bien el setUp()
@ExtendWith(MockitoExtension.class)
class BookControllerTest {

    @Mock
    BookService bookService;

    @Mock
    AuthorService authorService;

    @Mock
    BookTypeService bookTypeService;

    @InjectMocks
    BookController controller;

    MockMvc mockMvc;

    Author author;
    Set<BookType> bookTypes;

    @BeforeEach
    void setUp() {

        author = Author.builder().id(1L).build();

        bookTypes = new HashSet<>();
        bookTypes.add(BookType.builder().id(1L).name("Novel").build());
        bookTypes.add(BookType.builder().id(2L).name("Poetry").build());

        mockMvc = MockMvcBuilders
                .standaloneSetup(controller)
                .build();

    }

    @Test
    void initCreationForm() throws Exception {
        when(authorService.findById(anyLong())).thenReturn(author);
        when(bookTypeService.findAll()).thenReturn(bookTypes);

        mockMvc.perform(get("/authors/1/books/new"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("author"))
                .andExpect(model().attributeExists("book"))
                .andExpect(view().name("books/createOrUpdateBookForm"));

        //verificar si se guardó
        //verify(bookService).save(any());

    }

    @Test
    void processCreationForm() throws Exception {
        when(authorService.findById(anyLong())).thenReturn(author);
        when(bookTypeService.findAll()).thenReturn(bookTypes);

        mockMvc.perform(post("/authors/1/books/new"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/authors/1"));

        verify(bookService).save(any());
    }

    @Test
    void initUpdateForm() throws Exception {
        when(authorService.findById(anyLong())).thenReturn(author);
        when(bookTypeService.findAll()).thenReturn(bookTypes);
        when(bookService.findById(anyLong())).thenReturn(Book.builder().id(2L).build());

        mockMvc.perform(get("/authors/1/books/2/edit"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("author"))
                .andExpect(model().attributeExists("book"))
                .andExpect(view().name("books/createOrUpdateBookForm"));
    }

    @Test
    void processUpdateForm() throws Exception {
        when(authorService.findById(anyLong())).thenReturn(author);
        when(bookTypeService.findAll()).thenReturn(bookTypes);

        mockMvc.perform(post("/authors/1/books/2/edit"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/authors/1"));

        verify(bookService).save(any());
    }

    @Test
    void populatePetTypes() {
        //todo impl
    }

    @Test
    void findOwner() {
        //todo impl
    }

    @Test
    void initOwnerBinder() {
        //todo impl
    }
}