package mk.finki.ukim.mk.lab_1.service.application;

import mk.finki.ukim.mk.lab_1.dto.CreateAuthorDto;
import mk.finki.ukim.mk.lab_1.dto.DisplayAuthorDto;
import mk.finki.ukim.mk.lab_1.dto.UpdateAuthorDto;

import java.util.List;
import java.util.Optional;

public interface AuthorApplicationService {

    Optional<DisplayAuthorDto> save(CreateAuthorDto createAuthorDto);

    Optional<DisplayAuthorDto> update(Long id, UpdateAuthorDto updateAuthorDto);

    Optional<DisplayAuthorDto> findById(Long id);

    List<DisplayAuthorDto> findAll();

    void deleteById(Long id);

}
