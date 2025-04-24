package mk.finki.ukim.mk.lab_1.dto.updateDto;

import mk.finki.ukim.mk.lab_1.model.domain.Author;
import mk.finki.ukim.mk.lab_1.model.domain.Country;

public record UpdateAuthorDto(
        Long id,
        String name,
        String surname,
        Long country
) {
    public static UpdateAuthorDto from(Author author) {
        return new UpdateAuthorDto(
                author.getId(),
                author.getName(),
                author.getSurname(),
                author.getCountry().getId()
        );
    }

    public static void update(Author author, Country country) {
        if (author.getName() != null) author.setName(author.getName());

        if (author.getSurname() != null) author.setSurname(author.getSurname());

        if (author.getCountry() != null) author.setCountry(country);
    }

    public Author toAuthor(Country country) {
        return new Author(name, surname, country);
    }
}
