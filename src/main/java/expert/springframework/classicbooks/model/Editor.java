package expert.springframework.classicbooks.model;

import java.util.Set;

public class Editor extends Person {

    private Set<Editorial> editorials;

    public Set<Editorial> getEditorials() {
        return editorials;
    }

    public void setEditorials(Set<Editorial> editorials) {
        this.editorials = editorials;
    }
}
