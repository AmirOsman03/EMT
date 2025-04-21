package mk.finki.ukim.mk.lab_1.repository;

import mk.finki.ukim.mk.lab_1.model.domain.Book;
import mk.finki.ukim.mk.lab_1.model.enums.Category;
import mk.finki.ukim.mk.lab_1.model.views.BooksPerAuthorView;
import mk.finki.ukim.mk.lab_1.service.domain.AuthorService;
import mk.finki.ukim.mk.lab_1.service.domain.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BooksPerAuthorViewsRepositoryTest {

    @Autowired
    private BooksPerAuthorViewRepository booksPerAuthorViewRepository;

    @Autowired
    private AuthorService authorService;

    @Autowired
    private BookService bookService;

    @Test
    public void testCreateNewBook() {
        List<BooksPerAuthorView> list1 = booksPerAuthorViewRepository.findAll();

        Book book = new Book();
        book.setName("Test Book");
        book.setAuthor(authorService.findAll().get(0));
        book.setCategory(Category.CLASSICS);
        book.setAvailableCopies(5);

        bookService.save(book);

        List<BooksPerAuthorView> list2 = booksPerAuthorViewRepository.findAll();
    }

}
