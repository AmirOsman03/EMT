package mk.finki.ukim.mk.lab_1.dto;

import mk.finki.ukim.mk.lab_1.model.domain.Author;
import mk.finki.ukim.mk.lab_1.model.domain.Book;
import mk.finki.ukim.mk.lab_1.model.enums.Category;

import java.util.List;
import java.util.stream.Collectors;

public record DisplayBookDto(
        Long id,
        String name,
        Category category,
        Long author,
        Integer availableCopies,
        Boolean rented
) {
    public static DisplayBookDto from(Book book) {
        return new DisplayBookDto(
                book.getId(),
                book.getName(),
                book.getCategory(),
                book.getAuthor().getId(),
                book.getAvailableCopies(),
                book.getRented()
        );
    }

    public static List<DisplayBookDto> from(List<Book> books) {
        return books.stream().map(DisplayBookDto::from).collect(Collectors.toList());
    }

    public Book toBook(Author author) {
        return new Book(name, category, author, availableCopies, rented);
    }
}
