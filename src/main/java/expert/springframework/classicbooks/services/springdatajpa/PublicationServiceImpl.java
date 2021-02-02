package expert.springframework.classicbooks.services.springdatajpa;

import expert.springframework.classicbooks.model.Publication;
import expert.springframework.classicbooks.repositories.PublicationRepository;
import expert.springframework.classicbooks.services.PublicationService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class PublicationServiceImpl implements PublicationService {

    private final PublicationRepository publicationRepository;

    public PublicationServiceImpl(PublicationRepository publicationRepository) {
        this.publicationRepository = publicationRepository;
    }

    @Override
    public Set<Publication> findAll() {
        Set<Publication> publications = new HashSet<>();
        publicationRepository.findAll().forEach(publications::add);
        return publications;
    }

    @Override
    public Publication findById(Long id) {
        return publicationRepository.findById(id).orElse(null);
    }

    @Override
    public Publication save(Publication publication) {
        return publicationRepository.save(publication);
    }

    @Override
    public void delete(Publication publication) {
        publicationRepository.delete(publication);
    }

    @Override
    public void deleteById(Long id) {
        publicationRepository.deleteById(id);
    }
}
