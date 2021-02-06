package expert.springframework.classicbooks.controllers;

import expert.springframework.classicbooks.model.Author;
import expert.springframework.classicbooks.services.AuthorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
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

    /*@Test
    void listAuthors() throws Exception {

        when(service.findAll()).thenReturn(authors);

        mockMvc.perform(get("/authors"))
                .andExpect(status().isOk())
                .andExpect(view().name("authors/index"))
                .andExpect(model().attribute("authors", hasSize(2)));

    }*/

    @Test
    void findAuthors() throws Exception {

        //Si invoco a "/authors/find" debe retornar la vista "notimplemented"
        /*mockMvc.perform(get("/authors/find"))
                .andExpect(status().isOk())
                .andExpect(view().name("notimplemented"));

        verifyNoInteractions(service);*/

        //falta implementar
        mockMvc.perform(get("/authors/find"))
                .andExpect(status().isOk())
                .andExpect(view().name("authors/findAuthors"))
                .andExpect(model().attributeExists("author"));

        verifyNoInteractions(service);

    }

    @Test
    void processFindFormReturnMany() throws Exception {

        when(service.findAllByLastNameLike(anyString())).thenReturn(Arrays.asList(Author.builder().id(1L).build(),
                Author.builder().id(2L).build()));

        mockMvc.perform(get("/authors"))
                .andExpect(status().isOk())
                .andExpect(view().name("authors/authorsList"))
                .andExpect(model().attribute("selections", hasSize(2)));
    }

    @Test
    void processFindFormReturnOne() throws Exception {

        when(service.findAllByLastNameLike(anyString())).thenReturn(Arrays.asList(Author.builder().id(1L).build()));

        mockMvc.perform(get("/authors"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/authors/1"));
        //.andExpect(model().attribute("authors", hasSize(2)));
    }


    @Test
    void displayAuthor() throws Exception {

        when(service.findById(anyLong())).thenReturn(Author.builder().id(1L).build());

        mockMvc.perform(get("/authors/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("authors/authorDetails"))
                .andExpect(model().attribute("author", hasProperty("id", is(1L))));
    }


    @Test
    void initCreationForm() throws Exception {

        mockMvc.perform(get("/authors/new"))
                .andExpect(status().isOk())
                .andExpect(view().name("authors/createOrUpdateAuthorForm"))
                .andExpect(model().attributeExists("author"));

        verifyNoInteractions(service);

    }

    @Test
    void processCreationForm() throws Exception {

        when(service.save(ArgumentMatchers.any())).thenReturn(Author.builder().id(1L).build());

        mockMvc.perform(post("/authors/new"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/authors/1"))
                .andExpect(model().attributeExists("author"));

        verify(service).save(ArgumentMatchers.any());

    }

    @Test
    void initUpdateAuthorForm() throws Exception {

        when(service.findById(anyLong())).thenReturn(Author.builder().id(1L).build());

        mockMvc.perform(get("/authors/1/edit"))
                .andExpect(status().isOk())
                .andExpect(view().name("authors/createOrUpdateAuthorForm"))
                .andExpect(model().attributeExists("author"));

        verifyZeroInteractions(service);

    }

    @Test
    void processUpdateAuthorForm() throws Exception {

        when(service.save(ArgumentMatchers.any())).thenReturn(Author.builder().id(1L).build());

        mockMvc.perform(post("/authors/1/edit"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/authors/1"))
                .andExpect(model().attributeExists("author"));

        verify(service).save(ArgumentMatchers.any());

    }


}