package mk.finki.ukim.mk.lab_1.model.dto;

import lombok.Data;
import mk.finki.ukim.mk.lab_1.model.enums.Category;

@Data
public class BookDto {
    private String name;

    private Category category;

    private Long author;

    private Integer availableCopies;

    private Boolean rented;

    public BookDto() {}

    public BookDto(String name, Long author, Category category, Integer availableCopies, Boolean rented) {
        this.author = author;
        this.availableCopies = availableCopies;
        this.category = category;
        this.name = name;
        this.rented = rented;
    }
}
