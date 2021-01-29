package expert.springframework.classicbooks.services;

import expert.springframework.classicbooks.model.Editor;

import java.util.Set;

public interface EditorService {

    Editor findById(Long id);

    Editor save(Editor editor);

    Set<Editor> findAll();

}
