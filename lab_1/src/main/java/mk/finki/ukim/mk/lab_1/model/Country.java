package mk.finki.ukim.mk.lab_1.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "countries")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String continent;

    public Country() {}

    public Country(String name, String continent) {
        this.name = name;
        this.continent = continent;
    }
}
