package mk.finki.ukim.mk.lab_1.dto.updateDto;

import mk.finki.ukim.mk.lab_1.model.domain.Country;

import java.util.List;
import java.util.stream.Collectors;

public record UpdateCountryDto(
        Long id,
        String name,
        String continent
) {
    public static UpdateCountryDto from(Country country) {
        return new UpdateCountryDto(
                country.getId(),
                country.getName(),
                country.getContinent()
        );
    }

    public static List<UpdateCountryDto> from(List<Country> countries) {
        return countries.stream().map(UpdateCountryDto::from).collect(Collectors.toList());
    }

    public Country toCountry() {
        return new Country(name, continent);
    }
}
