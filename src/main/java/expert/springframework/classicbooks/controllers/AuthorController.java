package expert.springframework.classicbooks.controllers;

import expert.springframework.classicbooks.model.Author;
import expert.springframework.classicbooks.services.AuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping("/authors")
@Controller
public class AuthorController {

    private static final String VIEWS_AUTHOR_CREATE_OR_UPDATE_FORM = "authors/createOrUpdateAuthorForm";

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    //spring 1.2
    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    /*@RequestMapping({"", "/", "/index", "/index.html"})
    public String listAuthors(Model model) {
        *//*El string "authors" es el campo que el model buscará
        en el template. Es la lista que recorrerá. Debe agregarse.*//*
        model.addAttribute("authors", authorService.findAll());

        return "authors/index";
    }*/

    @RequestMapping({"/find"})
    public String findAuthors(Model model) {
        model.addAttribute("author", Author.builder().build());
        return "authors/findAuthors";
    }

    @GetMapping
    public String processFindForm(Author author, BindingResult result, Model model) {

        if (author.getLastName() == null) {
            author.setLastName("");
        }

        //find authors by lastName
        List<Author> authorList = authorService.findAllByLastNameLike("%" + author.getLastName() + "%");

        if (authorList.isEmpty()) {
            result.rejectValue("lastName", "notFound", "not found");
            return "authors/findAuthors";
        } else if (authorList.size() == 1) {
            author = authorList.iterator().next();
            return "redirect:/authors/" + author.getId();
        } else {
            //selections -> lista recorrida en el template
            model.addAttribute("selections", authorList);
            return "authors/authorsList";
        }


    }

    @GetMapping("/{authorId}")
    public ModelAndView showAuthor(@PathVariable("authorId") Long authorId) {

        ModelAndView mav = new ModelAndView("authors/authorDetails");
        mav.addObject(authorService.findById(authorId));
        return mav;

    }

    @GetMapping("/new")
    public String initCreationForm(Model model) {
        model.addAttribute("author", Author.builder().build());
        return VIEWS_AUTHOR_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/new")
    public String processCreationForm(@Validated Author author, BindingResult result) {
        if (result.hasErrors()) {
            return VIEWS_AUTHOR_CREATE_OR_UPDATE_FORM;
        } else {
            Author savedAuthor = authorService.save(author);
            return "redirect:/authors/" + savedAuthor.getId();
        }
    }

    @GetMapping("/{authorId}/edit")
    public String initUpdateOwnerForm(@PathVariable Long authorId, Model model) {
        model.addAttribute(authorService.findById(authorId));
        return VIEWS_AUTHOR_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/{authorId}/edit")
    public String processUpdateOwnerForm(@Validated Author author, BindingResult result, @PathVariable Long authorId) {
        if (result.hasErrors()) {
            return VIEWS_AUTHOR_CREATE_OR_UPDATE_FORM;
        } else {
            author.setId(authorId);
            Author savedAuthor = authorService.save(author);
            return "redirect:/authors/" + savedAuthor.getId();
        }
    }


}
