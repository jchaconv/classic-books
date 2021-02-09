package expert.springframework.classicbooks.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "books")
public class Book extends BaseEntity {

    @Builder
    public Book(Long id, String name, BookType bookType, Author author, Set<Publication> publications) {
        super(id);
        this.name = name;
        this.bookType = bookType;
        this.author = author;

        if (publications == null || publications.size() > 0) {
            this.publications = publications;
        }

    }

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private BookType bookType;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "book")
    private Set<Publication> publications = new HashSet<>();


}
