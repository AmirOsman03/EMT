package mk.finki.ukim.mk.lab_1.service.domain.impl;

import mk.finki.ukim.mk.lab_1.model.domain.Author;
import mk.finki.ukim.mk.lab_1.repository.AuthorRepository;
import mk.finki.ukim.mk.lab_1.service.domain.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public void deleteById(Long id) {
        this.authorRepository.deleteById(id);
    }

    @Override
    public List<Author> findAll() {
        return this.authorRepository.findAll();
    }

    @Override
    public Optional<Author> findById(Long id) {
        return this.authorRepository.findById(id);
    }

    @Override
    public Optional<Author> save(Author author) {
        return Optional.of(authorRepository.save(author));
    }

    @Override
    public Optional<Author> update(Long id, Author author) {
        return authorRepository.findById(id).map(existingAuthor -> {
            if (author.getName() != null &&
                    author.getSurname() != null &&
                    author.getCountry() != null) {
                existingAuthor.setName(author.getName());
                existingAuthor.setSurname(author.getSurname());
                existingAuthor.setCountry(author.getCountry());
            }
            return authorRepository.save(existingAuthor);
        });
    }
}
