package expert.springframework.classicbooks.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "editors")
public class Editor extends Person {

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "editor_editorials", joinColumns = @JoinColumn(name = "editor_id"),
            inverseJoinColumns = @JoinColumn(name = "editorial_id"))
    private Set<Editorial> editorials = new HashSet<>();

}
