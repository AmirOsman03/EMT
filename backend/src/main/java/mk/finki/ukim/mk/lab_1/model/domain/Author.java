package mk.finki.ukim.mk.lab_1.model.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String surname;

    @ManyToOne()
    private Country country;

    public Author() {}

    public Author(String name, String surname, Country country) {
        this.country = country;
        this.name = name;
        this.surname = surname;
    }
}
