package mk.finki.ukim.mk.lab_1.service.application.impl;

import mk.finki.ukim.mk.lab_1.dto.CreateAuthorDto;
import mk.finki.ukim.mk.lab_1.dto.DisplayAuthorDto;
import mk.finki.ukim.mk.lab_1.dto.UpdateAuthorDto;
import mk.finki.ukim.mk.lab_1.model.domain.Country;
import mk.finki.ukim.mk.lab_1.service.application.AuthorApplicationService;
import mk.finki.ukim.mk.lab_1.service.domain.AuthorService;
import mk.finki.ukim.mk.lab_1.service.domain.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorApplicationServiceImpl implements AuthorApplicationService {
    private final AuthorService authorService;
    private final CountryService countryService;

    public AuthorApplicationServiceImpl(AuthorService authorService, CountryService countryService) {
        this.authorService = authorService;
        this.countryService = countryService;
    }

    @Override
    public void deleteById(Long id) {
        this.authorService.deleteById(id);
    }

    @Override
    public Optional<DisplayAuthorDto> save(CreateAuthorDto createAuthorDto) {
        Optional<Country> country = countryService.findById(createAuthorDto.country());

        if (country.isPresent()) {
            return authorService.save(
                    createAuthorDto.toAuthor(country.get()
                    )
            ).map(DisplayAuthorDto::from);
        }

        return Optional.empty();
    }

    @Override
    public Optional<DisplayAuthorDto> update(Long id, UpdateAuthorDto updateAuthorDto) {
        Optional<Country> country = countryService.findById(updateAuthorDto.country());

        return authorService.update(id,
                updateAuthorDto.toAuthor(country.orElse(null)))
                .map(DisplayAuthorDto::from);
    }

    @Override
    public Optional<DisplayAuthorDto> findById(Long id) {
        return authorService.findById(id).map(DisplayAuthorDto::from);
    }

    @Override
    public List<DisplayAuthorDto> findAll() {
        return authorService.findAll().stream().map(DisplayAuthorDto::from).toList();
    }
}
