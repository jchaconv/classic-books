package expert.springframework.classicbooks.services.map;

import expert.springframework.classicbooks.model.Editor;
import expert.springframework.classicbooks.services.EditorService;

import java.util.Set;

public class EditorServiceMap extends AbstractMapService<Editor, Long> implements EditorService {

    @Override
    public Set<Editor> findAll() {
        return super.findAll();
    }

    @Override
    public Editor findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Editor save(Editor object) {
        return super.save(object.getId(), object);
    }

    @Override
    public void delete(Editor object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
