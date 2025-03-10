package mk.finki.ukim.mk.lab_1.service;

import mk.finki.ukim.mk.lab_1.model.Book;
import mk.finki.ukim.mk.lab_1.model.dto.BookDto;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> findAll();

    Optional<Book> findById(Long id);

    Optional<Book> save(BookDto book);

    Optional<Book> update(Long id, BookDto book);

    void deleteById(Long id);
}
