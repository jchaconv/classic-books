package expert.springframework.classicbooks.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "types")
public class BookType extends BaseEntity {

    @Column(name = "name")
    private String name;
}
