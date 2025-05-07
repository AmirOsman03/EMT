package mk.finki.ukim.mk.lab_1.service.application.impl;

import mk.finki.ukim.mk.lab_1.dto.createDto.CreateBookDto;
import mk.finki.ukim.mk.lab_1.dto.displayDto.DisplayBookDto;
import mk.finki.ukim.mk.lab_1.dto.updateDto.UpdateBookDto;
import mk.finki.ukim.mk.lab_1.model.domain.Author;
import mk.finki.ukim.mk.lab_1.model.views.BooksPerAuthorView;
import mk.finki.ukim.mk.lab_1.repository.BooksPerAuthorViewRepository;
import mk.finki.ukim.mk.lab_1.service.application.BookApplicationService;
import mk.finki.ukim.mk.lab_1.service.domain.AuthorService;
import mk.finki.ukim.mk.lab_1.service.domain.BookService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;


@Service
public class BookApplicationServiceImpl implements BookApplicationService {
    private final BookService bookService;
    private final AuthorService authorService;
    private final BooksPerAuthorViewRepository booksPerAuthorViewRepository;

    public BookApplicationServiceImpl(BookService bookService, AuthorService authorService, BooksPerAuthorViewRepository booksPerAuthorViewRepository) {
        this.bookService = bookService;
        this.authorService = authorService;
        this.booksPerAuthorViewRepository = booksPerAuthorViewRepository;
    }

    @Override
    public void deleteById(Long id) {
        bookService.deleteById(id);
    }

    @Override
    public List<DisplayBookDto> findByName(String name) {
        return bookService.findByName(name).stream().map(DisplayBookDto::from).toList();
    }

    @Override
    public Optional<DisplayBookDto> rent(Long id) {
        return bookService.rent(id).map(DisplayBookDto::from);
    }

    @Override
    public Optional<DisplayBookDto> save(CreateBookDto bookDto) {
        Optional<Author> author = authorService.findById(bookDto.author());

        if (author.isPresent()) {
            return bookService.save(bookDto.toBook(author.get())).map(DisplayBookDto::from);
        }
        return Optional.empty();
    }

    @Override
    public Optional<DisplayBookDto> update(Long id, UpdateBookDto bookDto) {
        Optional<Author> author = authorService.findById(bookDto.author());

        return bookService.update(id,
                bookDto.toBook(author.orElse(null)
                )
        ).map(DisplayBookDto::from);
    }

    @Override
    public Optional<DisplayBookDto> findById(Long id) {
        return bookService.findById(id).map(DisplayBookDto::from);
    }

    @Override
    public List<DisplayBookDto> findAll() {
        return bookService.findAll().stream().map(DisplayBookDto::from).toList();
    }

    @Override
    public List<BooksPerAuthorView> getBooksCountByAuthor() {
        return booksPerAuthorViewRepository.findAll();
    }

    @Override
    public Page<DisplayBookDto> findAll(Pageable pageable) {
        return bookService.findAll(pageable)
                .map(DisplayBookDto::from);
    }
}
