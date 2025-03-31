package mk.finki.ukim.mk.lab_1.service.domain;

import mk.finki.ukim.mk.lab_1.model.domain.Country;

import java.util.List;
import java.util.Optional;

public interface CountryService {
    List<Country> findAll();

    Optional<Country> findById(Long id);

    Optional<Country> save(Country country);

    Optional<Country> update(Long id, Country country);

    void deleteById(Long id);
}
