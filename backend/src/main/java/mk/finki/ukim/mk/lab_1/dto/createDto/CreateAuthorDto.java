package mk.finki.ukim.mk.lab_1.dto.createDto;

import mk.finki.ukim.mk.lab_1.model.domain.Author;
import mk.finki.ukim.mk.lab_1.model.domain.Country;

import java.util.List;
import java.util.stream.Collectors;

public record CreateAuthorDto(
        String name,
        String surname,
        Long country
) {
    public static CreateAuthorDto from(Author author) {
        return new CreateAuthorDto(
                author.getName(),
                author.getSurname(),
                author.getCountry().getId()
        );
    }

    public static List<CreateAuthorDto> from(List<Author> authors) {
        return authors.stream().map(CreateAuthorDto::from).collect(Collectors.toList());
    }

    public Author toAuthor(Country country) {
        return new Author(name, surname, country);
    }
}
