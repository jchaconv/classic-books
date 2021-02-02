package expert.springframework.classicbooks.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "authors")
public class Author extends Person {

    @Builder
    public Author(Long id, String firstName, String lastName, String address, String city,
                  String telephone, Set<Book> books) {
        super(id, firstName, lastName);
        this.address = address;
        this.city = city;
        this.telephone = telephone;

        if (books != null) {
            this.books = books;
        }
    }


    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "telephone")
    private String telephone;

    //si borro el autor también se borra el libro
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "author")
    Set<Book> books = new HashSet<>();


    /**
     * Return the Book with the given name, or null if none found for this Author.
     *
     * @param name to test
     * @return true if book name is already in use
     */
    public Book getBook(String name) {
        return getBook(name, false);
    }

    /**
     * Return the Book with the given name, or null if none found for this Author.
     *
     * @param name to test
     * @return true if pet name is already in use
     */
    public Book getBook(String name, boolean ignoreNew) {
        name = name.toLowerCase();
        for (Book book : books) {
            if (!ignoreNew || !book.isNew()) {
                String compName = book.getName();
                compName = compName.toLowerCase();
                if (compName.equals(name)) {
                    return book;
                }
            }
        }
        return null;
    }


}
