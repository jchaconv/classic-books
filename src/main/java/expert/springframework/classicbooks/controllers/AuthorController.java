package expert.springframework.classicbooks.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/authors")
@Controller
public class AuthorController {

    @RequestMapping({"", "/", "/index", "/index.html"})
    public String listAuthors() {
        return "authors/index";
    }

}
