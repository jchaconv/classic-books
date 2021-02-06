package expert.springframework.classicbooks.controllers;

import expert.springframework.classicbooks.services.AuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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

    @GetMapping("/{authorId}")
    public ModelAndView showAuthor(@PathVariable("authorId") Long authorId) {

        ModelAndView mav = new ModelAndView("authors/authorDetails");
        mav.addObject(authorService.findById(authorId));
        return mav;

    }


}
