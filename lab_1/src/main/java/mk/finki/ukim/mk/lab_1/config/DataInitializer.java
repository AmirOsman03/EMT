package mk.finki.ukim.mk.lab_1.config;

import jakarta.annotation.PostConstruct;
import mk.finki.ukim.mk.lab_1.model.Author;
import mk.finki.ukim.mk.lab_1.model.Book;
import mk.finki.ukim.mk.lab_1.model.Country;
import mk.finki.ukim.mk.lab_1.model.enums.Category;
import mk.finki.ukim.mk.lab_1.repository.AuthorRepository;
import mk.finki.ukim.mk.lab_1.repository.BookRepository;
import mk.finki.ukim.mk.lab_1.repository.CountryRepository;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;

    public DataInitializer(BookRepository bookRepository, AuthorRepository authorRepository, CountryRepository countryRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
    }

    @PostConstruct
    public void init() {
        Country country1 = new Country("Country1", "Continent1");
        Country country2 = new Country("Country2", "Continent2");

        countryRepository.save(country1);
        countryRepository.save(country2);

        Author author1 = new Author("Author1", "Surname1", country1);
        Author author2 = new Author("Author2", "Surname2", country2);
        Author author3 = new Author("Author3", "Surname3", country2);

        authorRepository.save(author1);
        authorRepository.save(author2);
        authorRepository.save(author3);

        Book book1 = new Book("Book1", author1, Category.DRAMA, 5, true);
        Book book2 = new Book("Book2", author2, Category.BIOGRAPHY, 3, true);
        Book book3 = new Book("Book3", author3, Category.FANTASY, 1, false);
        Book book4 = new Book("Book4", author1, Category.CLASSICS, 7, false);

        bookRepository.save(book1);
        bookRepository.save(book2);
        bookRepository.save(book3);
        bookRepository.save(book4);
    }
}
