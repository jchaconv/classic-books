package expert.springframework.classicbooks.services.map;

import expert.springframework.classicbooks.model.Editor;
import expert.springframework.classicbooks.model.Editorial;
import expert.springframework.classicbooks.services.EditorService;
import expert.springframework.classicbooks.services.EditorialService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class EditorMapService extends AbstractMapService<Editor, Long> implements EditorService {

    private final EditorialService editorialService;

    public EditorMapService(EditorialService editorialService) {
        this.editorialService = editorialService;
    }

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

        if (object.getEditorials().size() > 0) {
            object.getEditorials().forEach(editorial -> {
                if (editorial.getId() == null) {
                    Editorial savedEditorial = editorialService.save(editorial);
                    editorial.setId(savedEditorial.getId());
                }
            });
        }

        return super.save(object);

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
