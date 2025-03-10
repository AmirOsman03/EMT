package mk.finki.ukim.mk.lab_1.model;

import jakarta.persistence.*;
import lombok.Data;
import mk.finki.ukim.mk.lab_1.model.enums.Category;

@Data
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Category category;

    @ManyToOne
    private Author author;

    private Integer availableCopies;

    private Boolean rented;

    public Book() {}

    public Book(String name, Author author, Category category, Integer availableCopies, Boolean rented) {
        this.author = author;
        this.availableCopies = availableCopies;
        this.category = category;
        this.name = name;
        this.rented = rented;
    }
}
