package mk.finki.ukim.mk.lab_1.service.domain.impl;

import mk.finki.ukim.mk.lab_1.model.domain.Author;
import mk.finki.ukim.mk.lab_1.events.AuthorCreatedEvent;
import mk.finki.ukim.mk.lab_1.repository.AuthorRepository;
import mk.finki.ukim.mk.lab_1.repository.AuthorsPerCountryViewRepository;
import mk.finki.ukim.mk.lab_1.service.domain.AuthorService;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorsPerCountryViewRepository authorsPerCountryViewRepository;
    private final AuthorRepository authorRepository;
    private final ApplicationEventPublisher eventPublisher;

    public AuthorServiceImpl(AuthorsPerCountryViewRepository authorsPerCountryViewRepository, AuthorRepository authorRepository, ApplicationEventPublisher eventPublisher) {
        this.authorsPerCountryViewRepository = authorsPerCountryViewRepository;
        this.authorRepository = authorRepository;
        this.eventPublisher = eventPublisher;
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
        List<Author> authors = this.authorRepository.findAll();

        if (authors.contains(author)) {
            return Optional.empty();
        }

        authorRepository.save(author);
        eventPublisher.publishEvent(new AuthorCreatedEvent(author));
        return Optional.of(author);
    }

    @Override
    public Optional<Author> update(Long id, Author author) {
        return authorRepository.findById(id).map(existingAuthor -> {
            if (author.getName() != null) {
                existingAuthor.setName(author.getName());
            }
            if (author.getSurname() != null) {
                existingAuthor.setSurname(author.getSurname());
            }
            if (author.getCountry() != null) {
                existingAuthor.setCountry(author.getCountry());
            }

            Author updated = authorRepository.save(existingAuthor);
            eventPublisher.publishEvent(new AuthorCreatedEvent(author));
            return updated;
        });
    }

    @Override
    public void refreshMaterializedView() {
        authorsPerCountryViewRepository.refreshMaterializedViews();
    }

}
