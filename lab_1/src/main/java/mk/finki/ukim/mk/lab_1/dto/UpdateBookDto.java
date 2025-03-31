package mk.finki.ukim.mk.lab_1.dto;

import mk.finki.ukim.mk.lab_1.model.domain.Author;
import mk.finki.ukim.mk.lab_1.model.domain.Book;
import mk.finki.ukim.mk.lab_1.model.enums.Category;

public record UpdateBookDto(
        String name,
        Category category,
        Long author,
        Integer availableCopies,
        Boolean rented
) {
    public static UpdateBookDto from(Book book) {
        return new UpdateBookDto(
                book.getName(),
                book.getCategory(),
                book.getAuthor().getId(),
                book.getAvailableCopies(),
                book.getRented()
        );
    }

    public static void updateBook(Book book, Author author) {
        if (book.getName() != null) book.setName(book.getName());

        if (book.getCategory() != null) book.setCategory(book.getCategory());

        if (book.getAuthor() != null) book.setAuthor(author);

        if (book.getRented() != null) book.setRented(book.getRented());
    }

    public Book toBook(Author author) {
        return new Book(name, category, author, availableCopies, rented);
    }
}
