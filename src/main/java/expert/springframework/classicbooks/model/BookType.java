package expert.springframework.classicbooks.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "types")
public class BookType extends BaseEntity {

    @Builder
    public BookType(Long id, String name) {
        super(id);
        this.name = name;
    }

    @Column(name = "name")
    private String name;
}
