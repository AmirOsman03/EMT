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
        // Creating Countries
        Country usa = new Country("United States", "North America");
        Country uk = new Country("United Kingdom", "Europe");
        Country france = new Country("France", "Europe");
        Country japan = new Country("Japan", "Asia");

        countryRepository.save(usa);
        countryRepository.save(uk);
        countryRepository.save(france);
        countryRepository.save(japan);

        // Creating Authors
        Author author1 = new Author("George", "Orwell", uk);
        Author author2 = new Author("Harper", "Lee", usa);
        Author author3 = new Author("J.K.", "Rowling", uk);
        Author author4 = new Author("Victor", "Hugo", france);
        Author author5 = new Author("F. Scott", "Fitzgerald", usa);
        Author author6 = new Author("Haruki", "Murakami", japan);

        authorRepository.save(author1);
        authorRepository.save(author2);
        authorRepository.save(author3);
        authorRepository.save(author4);
        authorRepository.save(author5);
        authorRepository.save(author6);

        // Creating Books
        Book book1 = new Book("1984", author1, Category.CLASSICS, 10, true);
        Book book2 = new Book("Animal Farm", author1, Category.BIOGRAPHY, 5, false);
        Book book3 = new Book("To Kill a Mockingbird", author2, Category.CLASSICS, 7, true);
        Book book4 = new Book("Harry Potter and the Sorcerer’s Stone", author3, Category.FANTASY, 15, true);
        Book book5 = new Book("Harry Potter and the Chamber of Secrets", author3, Category.FANTASY, 12, true);
        Book book6 = new Book("Les Misérables", author4, Category.BIOGRAPHY, 8, true);
        Book book7 = new Book("The Hunchback of Notre-Dame", author4, Category.CLASSICS, 6, false);
        Book book8 = new Book("The Great Gatsby", author5, Category.DRAMA, 9, true);
        Book book9 = new Book("Kafka on the Shore", author6, Category.FANTASY, 4, true);
        Book book10 = new Book("Norwegian Wood", author6, Category.DRAMA, 3, false);

        bookRepository.save(book1);
        bookRepository.save(book2);
        bookRepository.save(book3);
        bookRepository.save(book4);
        bookRepository.save(book5);
        bookRepository.save(book6);
        bookRepository.save(book7);
        bookRepository.save(book8);
        bookRepository.save(book9);
        bookRepository.save(book10);
    }
}
