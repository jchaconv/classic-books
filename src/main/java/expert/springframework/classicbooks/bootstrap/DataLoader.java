package expert.springframework.classicbooks.bootstrap;

import expert.springframework.classicbooks.model.*;
import expert.springframework.classicbooks.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final AuthorService authorService;
    private final EditorService editorService;
    private final BookTypeService bookTypeService;
    private final EditorialService editorialService;
    private final PublicationService publicationService;

    //not need Autowired


    public DataLoader(AuthorService authorService, EditorService editorService, BookTypeService bookTypeService, EditorialService editorialService, PublicationService publicationService) {
        this.authorService = authorService;
        this.editorService = editorService;
        this.bookTypeService = bookTypeService;
        this.editorialService = editorialService;
        this.publicationService = publicationService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = bookTypeService.findAll().size();

        if (count == 0) {
            loadData();
        }

    }

    private void loadData() {
        BookType novel = new BookType();
        novel.setName("Novel");
        BookType savedNovelBookType = bookTypeService.save(novel);

        BookType romance = new BookType();
        romance.setName("Romance");
        BookType savedRomanceBookType = bookTypeService.save(romance);

        BookType poetry = new BookType();
        poetry.setName("Poetry");
        BookType savedPoetryBookType = bookTypeService.save(poetry);

        Editorial alfaguara = new Editorial();
        alfaguara.setDescription("Alfaguara");
        Editorial savedAlfaguara = editorialService.save(alfaguara);

        Editorial atalanta = new Editorial();
        atalanta.setDescription("Atalanta");
        Editorial savedAtalanta = editorialService.save(atalanta);

        Editorial galloNegro = new Editorial();
        galloNegro.setDescription("Gallo Negro");
        Editorial savedGalloNegro = editorialService.save(galloNegro);


        Author author1 = new Author();
//        author1.setId(1L);
        author1.setFirstName("Mario");
        author1.setLastName("Vargas Llosa");
        author1.setAddress("Resides in Spain");
        author1.setCity("Madrid");
        author1.setTelephone("55559-9632-1");

        Book mariosBook = new Book();
        mariosBook.setBookType(savedNovelBookType);
        mariosBook.setAuthor(author1);
        //mariosBook.setPublicationDate(LocalDate.now());
        mariosBook.setName("La ciudad y los perros");
        author1.getBooks().add(mariosBook);

        authorService.save(author1);

        Author author2 = new Author();
//        author2.setId(2L);
        author2.setFirstName("César");
        author2.setLastName("Vallejo");
        author2.setAddress("Santiago de Chuco");
        author2.setCity("La Libertad");
        author2.setTelephone("444259035566");

        Book cesarsBook = new Book();
        cesarsBook.setBookType(savedPoetryBookType);
        cesarsBook.setAuthor(author2);
        //cesarsBook.setPublicationDate(LocalDate.now());
        cesarsBook.setName("Los heraldos negros");
        author2.getBooks().add(cesarsBook);

        authorService.save(author2);

        Publication cesarsBookPublication = new Publication();
        cesarsBookPublication.setBook(cesarsBook);
        cesarsBookPublication.setDate(LocalDate.now());
        cesarsBookPublication.setDescription("Publication of Los Heraldos Negros");


        System.out.println("Loading authors ... ");

        Editor editor1 = new Editor();
//        editor1.setId(1L);
        editor1.setFirstName("André");
        editor1.setLastName("Coyné");
        editor1.getEditorials().add(savedAlfaguara);


        editorService.save(editor1);

        Editor editor2 = new Editor();
//        editor2.setId(2L);
        editor2.setFirstName("Juan");
        editor2.setLastName("Espejo");
        editor2.getEditorials().add(savedAtalanta);

        editorService.save(editor2);

        System.out.println("Loading editors ... ");
    }
}
