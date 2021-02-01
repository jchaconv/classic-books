package expert.springframework.classicbooks.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "editors")
public class Editor extends Person {

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "editor_editorials", joinColumns = @JoinColumn(name = "editor_id"),
            inverseJoinColumns = @JoinColumn(name = "editorial_id"))
    private Set<Editorial> editorials = new HashSet<>();

    public Set<Editorial> getEditorials() {
        return editorials;
    }

    public void setEditorials(Set<Editorial> editorials) {
        this.editorials = editorials;
    }
}
