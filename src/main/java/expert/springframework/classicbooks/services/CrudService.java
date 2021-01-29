package expert.springframework.classicbooks.services;

import java.util.Set;

//this is a replica of the spring data repositories
public interface CrudService<T, ID> {

    Set<T> findAll();

    T findById(ID id);

    T save(T object);

    void delete(T object);

    void deleteById(ID id);


}
