package expert.springframework.classicbooks.bootstrap;

import expert.springframework.classicbooks.model.Author;
import expert.springframework.classicbooks.model.Editor;
import expert.springframework.classicbooks.services.AuthorService;
import expert.springframework.classicbooks.services.EditorService;
import expert.springframework.classicbooks.services.map.AuthorServiceMap;
import expert.springframework.classicbooks.services.map.EditorServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final AuthorService authorService;
    private final EditorService editorService;

    public DataLoader() {
        authorService = new AuthorServiceMap();
        editorService = new EditorServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {

        Author author1 = new Author();
        author1.setId(1L);
        author1.setFirstName("Mario");
        author1.setLastName("Vargas Llosa");

        authorService.save(author1);

        Author author2 = new Author();
        author2.setId(2L);
        author2.setFirstName("César");
        author2.setLastName("Vallejo");

        authorService.save(author2);

        System.out.println("Cargando autores ... ");

        Editor editor1 = new Editor();
        editor1.setId(1L);
        editor1.setFirstName("André");
        editor1.setLastName("Coyné");

        editorService.save(editor1);

        Editor editor2 = new Editor();
        editor1.setId(2L);
        editor2.setFirstName("André");
        editor2.setLastName("Coyné");

        editorService.save(editor2);

        System.out.println("Cargando editores ... ");

    }
}