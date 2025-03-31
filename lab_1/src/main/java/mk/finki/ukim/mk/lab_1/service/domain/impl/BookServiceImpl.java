package mk.finki.ukim.mk.lab_1.service.domain.impl;

import mk.finki.ukim.mk.lab_1.model.domain.Book;
import mk.finki.ukim.mk.lab_1.repository.AuthorRepository;
import mk.finki.ukim.mk.lab_1.repository.BookRepository;
import mk.finki.ukim.mk.lab_1.service.domain.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public void deleteById(Long id) {
        this.bookRepository.deleteById(id);
    }

    @Override
    public List<Book> findByName(String name) {
        return bookRepository.findAllByNameContainingIgnoreCase(name);
    }

    @Override
    public Optional<Book> rent(Long id) {
        return bookRepository.findById(id)
                .map(existingBook -> {
                    if (existingBook.getAvailableCopies() > 0) {
                        existingBook.setAvailableCopies(existingBook.getAvailableCopies() - 1);
                        existingBook.setRented(true);
                        return bookRepository.save(existingBook);
                    }
                    return null;
                });
    }

    @Override
    public List<Book> findAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return this.bookRepository.findById(id);
    }

    @Override
    public Optional<Book> save(Book book) {
        if (book.getAuthor() != null &&
                this.authorRepository.findById(book.getAuthor().getId()).isPresent() &&
                book.getCategory() != null &&
                book.getName() != null &&
                book.getAvailableCopies() != null) {
            return Optional.of(
                    this.bookRepository.save(new Book(book.getName(),
                            this.authorRepository.findById(book.getAuthor().getId()).get(),
                            book.getCategory(),
                            book.getAvailableCopies()
                    )));
        }
        return Optional.empty();
    }

    @Override
    public Optional<Book> update(Long id, Book book) {
        return this.bookRepository.findById(id)
                .map(existingBook -> {
            if (book.getName() != null) {
                existingBook.setName(book.getName());
            }
            if (book.getAuthor() != null && this.authorRepository.findById(book.getAuthor().getId()).isPresent()) {
                existingBook.setAuthor(authorRepository.findById(book.getAuthor().getId()).get());
            }
            if (book.getCategory() != null) {
                existingBook.setCategory(book.getCategory());
            }
            if (book.getAvailableCopies() != null) {
                existingBook.setAvailableCopies(book.getAvailableCopies());
            }
            if (book.getRented() != null) {
                existingBook.setRented(book.getRented());
            }

            return bookRepository.save(existingBook);
        });
    }
}
