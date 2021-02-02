package expert.springframework.classicbooks.services.springdatajpa;

import expert.springframework.classicbooks.model.Editor;
import expert.springframework.classicbooks.repositories.EditorRepository;
import expert.springframework.classicbooks.services.EditorService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class EditorServiceImpl implements EditorService {

    private EditorRepository editorRepository;

    public EditorServiceImpl(EditorRepository editorRepository) {
        this.editorRepository = editorRepository;
    }

    @Override
    public Set<Editor> findAll() {

        Set<Editor> editors = new HashSet<>();
        editorRepository.findAll().forEach(editors::add);
        return editors;
    }

    @Override
    public Editor findById(Long id) {
        return editorRepository.findById(id).orElse(null);
    }

    @Override
    public Editor save(Editor editor) {
        return editorRepository.save(editor);
    }

    @Override
    public void delete(Editor editor) {
        editorRepository.delete(editor);
    }

    @Override
    public void deleteById(Long id) {
        editorRepository.deleteById(id);
    }
}
