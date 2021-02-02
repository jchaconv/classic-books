package expert.springframework.classicbooks.services.map;

import expert.springframework.classicbooks.model.Publication;
import expert.springframework.classicbooks.services.PublicationService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
//@Profile({"default", "map"})
public class PublicationMapService extends AbstractMapService<Publication, Long> implements PublicationService {

    @Override
    public Set<Publication> findAll() {
        return super.findAll();
    }

    @Override
    public Publication findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Publication save(Publication publication) {

        if (publication.getBook() == null || publication.getBook().getAuthor() == null || publication.getBook().getId() == null
                || publication.getBook().getAuthor().getId() == null) {
            throw new RuntimeException("Invalid Publication");
        }

        return super.save(publication);
    }

    @Override
    public void delete(Publication publication) {
        super.delete(publication);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

}
