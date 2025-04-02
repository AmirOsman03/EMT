package mk.finki.ukim.mk.lab_1.service.application.impl;

import mk.finki.ukim.mk.lab_1.dto.*;
import mk.finki.ukim.mk.lab_1.service.application.CountryApplicationService;
import mk.finki.ukim.mk.lab_1.service.domain.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryApplicationServiceImpl implements CountryApplicationService {
    private final CountryService countryService;

    public CountryApplicationServiceImpl(CountryService countryService) {
        this.countryService = countryService;
    }

    @Override
    public void deleteById(Long id) {
        this.countryService.deleteById(id);
    }

    @Override
    public Optional<DisplayCountryDto> save(CreateCountryDto createBookDto) {
        return countryService.save(createBookDto.toCountry())
                .map(DisplayCountryDto::from);
    }

    @Override
    public Optional<DisplayCountryDto> update(Long id, UpdateCountryDto updateCountryDto) {
        return countryService.update(id, updateCountryDto.toCountry()).map(DisplayCountryDto::from);
    }

    @Override
    public Optional<DisplayCountryDto> findById(Long id) {
        return this.countryService.findById(id).map(DisplayCountryDto::from);
    }

    @Override
    public List<DisplayCountryDto> findAll() {
        return this.countryService.findAll().stream().map(DisplayCountryDto::from).toList();
    }
}
