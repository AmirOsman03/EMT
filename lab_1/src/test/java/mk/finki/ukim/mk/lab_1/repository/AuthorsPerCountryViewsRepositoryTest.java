package mk.finki.ukim.mk.lab_1.repository;

import mk.finki.ukim.mk.lab_1.model.domain.Author;
import mk.finki.ukim.mk.lab_1.model.views.AuthorsPerCountryView;
import mk.finki.ukim.mk.lab_1.service.domain.AuthorService;
import mk.finki.ukim.mk.lab_1.service.domain.CountryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthorsPerCountryViewsRepositoryTest {

    @Autowired
    private AuthorsPerCountryViewRepository authorsPerCountryViewRepository;

    @Autowired
    private CountryService countryService;

    @Autowired
    private AuthorService authorService;

    @Test
    public void testCreateNewBook() {
        List<AuthorsPerCountryView> list1 = authorsPerCountryViewRepository.findAll();

        Author author = new Author();
        author.setName("Test Author Name");
        author.setCountry(countryService.findAll().get(0));
        author.setSurname("Test Author Surname");

        authorService.save(author);

        List<AuthorsPerCountryView> list2 = authorsPerCountryViewRepository.findAll();
    }

}
