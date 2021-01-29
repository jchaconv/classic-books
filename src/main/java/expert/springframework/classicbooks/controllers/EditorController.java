package expert.springframework.classicbooks.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EditorController {

    @RequestMapping({"/editors", "/editors/index", "/editors/index.html"})
    public String listEditors() {
        return "editors/index";
    }

}