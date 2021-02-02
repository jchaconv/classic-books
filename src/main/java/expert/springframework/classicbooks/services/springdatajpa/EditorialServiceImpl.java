package expert.springframework.classicbooks.services.springdatajpa;

import expert.springframework.classicbooks.model.Editorial;
import expert.springframework.classicbooks.repositories.EditorialRepository;
import expert.springframework.classicbooks.services.EditorialService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class EditorialServiceImpl implements EditorialService {

    private final EditorialRepository editorialRepository;

    public EditorialServiceImpl(EditorialRepository editorialRepository) {
        this.editorialRepository = editorialRepository;
    }

    @Override
    public Set<Editorial> findAll() {
        Set<Editorial> editorials = new HashSet<>();
        editorialRepository.findAll().forEach(editorials::add);
        return editorials;
    }

    @Override
    public Editorial findById(Long id) {
        return editorialRepository.findById(id).orElse(null);
    }

    @Override
    public Editorial save(Editorial editorial) {
        return editorialRepository.save(editorial);
    }

    @Override
    public void delete(Editorial editorial) {
        editorialRepository.delete(editorial);
    }

    @Override
    public void deleteById(Long id) {
        editorialRepository.deleteById(id);
    }
}
