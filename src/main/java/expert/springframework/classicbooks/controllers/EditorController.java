package expert.springframework.classicbooks.controllers;

import expert.springframework.classicbooks.model.Editor;
import expert.springframework.classicbooks.services.EditorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Set;

@Controller
public class EditorController {

    private final EditorService editorService;

    public EditorController(EditorService editorService) {
        this.editorService = editorService;
    }

    @RequestMapping({"/editors", "/editors/index", "/editors.html", "/editors/index.html"})
    public String listEditors(Model model) {
        model.addAttribute("editors", editorService.findAll());
        return "editors/index";
    }

    @GetMapping("/api/editors")
    public @ResponseBody
    Set<Editor> getEditorsJson() {
        return editorService.findAll();
    }


}
