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
@Table(name = "editorials")
public class Editorial extends BaseEntity {

    @Column(name = "description")
    private String description;
}
