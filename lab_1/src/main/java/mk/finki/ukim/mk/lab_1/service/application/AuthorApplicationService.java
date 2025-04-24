package mk.finki.ukim.mk.lab_1.service.application;

import mk.finki.ukim.mk.lab_1.dto.createDto.CreateAuthorDto;
import mk.finki.ukim.mk.lab_1.dto.displayDto.DisplayAuthorDto;
import mk.finki.ukim.mk.lab_1.dto.updateDto.UpdateAuthorDto;
import mk.finki.ukim.mk.lab_1.model.projections.AuthorProjection;
import mk.finki.ukim.mk.lab_1.model.views.AuthorsPerCountryView;

import java.util.List;
import java.util.Optional;

public interface AuthorApplicationService {

    Optional<DisplayAuthorDto> save(CreateAuthorDto createAuthorDto);

    Optional<DisplayAuthorDto> update(Long id, UpdateAuthorDto updateAuthorDto);

    Optional<DisplayAuthorDto> findById(Long id);

    List<DisplayAuthorDto> findAll();

    void deleteById(Long id);

    List<AuthorsPerCountryView> getAuthorsPerCountry();

    List<AuthorProjection> getAllByNameAndSurname();

}
