package expert.springframework.classicbooks.bootstrap;

import expert.springframework.classicbooks.model.Author;
import expert.springframework.classicbooks.model.BookType;
import expert.springframework.classicbooks.model.Editor;
import expert.springframework.classicbooks.services.AuthorService;
import expert.springframework.classicbooks.services.BookTypeService;
import expert.springframework.classicbooks.services.EditorService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final AuthorService authorService;
    private final EditorService editorService;
    private final BookTypeService bookTypeService;

    //not need Autowired


    public DataLoader(AuthorService authorService, EditorService editorService, BookTypeService bookTypeService) {
        this.authorService = authorService;
        this.editorService = editorService;
        this.bookTypeService = bookTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        BookType novela = new BookType();
        novela.setName("Novela");
        BookType savedNovelaBookType = bookTypeService.save(novela);

        BookType romance = new BookType();
        novela.setName("Romance");
        BookType savedRomanceBookType = bookTypeService.save(romance);

        BookType poesia = new BookType();
        novela.setName("Poesia");
        BookType savedPoesiaBookType = bookTypeService.save(poesia);


        Author author1 = new Author();
//        author1.setId(1L);
        author1.setFirstName("Mario");
        author1.setLastName("Vargas Llosa");

        authorService.save(author1);

        Author author2 = new Author();
//        author2.setId(2L);
        author2.setFirstName("César");
        author2.setLastName("Vallejo");

        authorService.save(author2);

        System.out.println("Cargando autores ... ");

        Editor editor1 = new Editor();
//        editor1.setId(1L);
        editor1.setFirstName("André");
        editor1.setLastName("Coyné");

        editorService.save(editor1);

        Editor editor2 = new Editor();
//        editor2.setId(2L);
        editor2.setFirstName("Juan");
        editor2.setLastName("Espejo");

        editorService.save(editor2);

        System.out.println("Cargando editores ... ");

    }
}
