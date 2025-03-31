package mk.finki.ukim.mk.lab_1.service.application;

import mk.finki.ukim.mk.lab_1.dto.*;

import java.util.List;
import java.util.Optional;

public interface CountryApplicationService {

    Optional<DisplayCountryDto> save(CreateCountryDto createBookDto);

    Optional<DisplayCountryDto> update(Long id, UpdateCountryDto updateCountryDto);

    Optional<DisplayCountryDto> findById(Long id);

    List<DisplayCountryDto> findAll();

    void deleteById(Long id);

}
