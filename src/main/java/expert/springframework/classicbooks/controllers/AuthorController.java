package expert.springframework.classicbooks.controllers;

import expert.springframework.classicbooks.services.AuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/authors")
@Controller
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @RequestMapping({"", "/", "/index", "/index.html"})
    public String listAuthors(Model model) {
        /*El string "authors" es el campo que el model buscará
        en el template. Es la lista que recorrerá. Debe agregarse.*/
        model.addAttribute("authors", authorService.findAll());

        return "authors/index";
    }

    @RequestMapping({"/find"})
    public String findAuthors() {
        return "notimplemented";
    }


}
