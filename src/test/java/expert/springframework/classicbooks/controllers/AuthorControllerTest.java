package expert.springframework.classicbooks.controllers;

import expert.springframework.classicbooks.model.Author;
import expert.springframework.classicbooks.services.AuthorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class AuthorControllerTest {

    @Mock
    AuthorService service;

    @InjectMocks
    AuthorController controller;

    Set<Author> authors;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        authors = new HashSet<>();
        authors.add(Author.builder().id(1L).firstName("Julio").build());
        authors.add(Author.builder().id(2L).firstName("César").build());

        //set an environment for the controller
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

    }

    @Test
    void listAuthors() throws Exception {

        when(service.findAll()).thenReturn(authors);

        mockMvc.perform(get("/authors"))
                .andExpect(status().isOk())
                .andExpect(view().name("authors/index"))
                .andExpect(model().attribute("authors", hasSize(2)));

    }

    @Test
    void findAuthors() throws Exception {

        mockMvc.perform(get("/authors/find"))
                .andExpect(status().isOk())
                .andExpect(view().name("notimplemented"));

        verifyNoInteractions(service);

    }
}