package expert.springframework.classicbooks.services.map;

import expert.springframework.classicbooks.model.Editorial;
import expert.springframework.classicbooks.services.EditorialService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class EditorialMapService extends AbstractMapService<Editorial, Long> implements EditorialService {

    @Override
    public Set<Editorial> findAll() {
        return super.findAll();
    }

    @Override
    public Editorial findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Editorial save(Editorial object) {
        return super.save(object);
    }

    @Override
    public void delete(Editorial object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
