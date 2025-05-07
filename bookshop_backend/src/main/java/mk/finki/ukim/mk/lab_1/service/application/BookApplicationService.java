package mk.finki.ukim.mk.lab_1.service.application;

import mk.finki.ukim.mk.lab_1.dto.createDto.CreateBookDto;
import mk.finki.ukim.mk.lab_1.dto.displayDto.DisplayBookDto;
import mk.finki.ukim.mk.lab_1.dto.updateDto.UpdateBookDto;
import mk.finki.ukim.mk.lab_1.model.views.BooksPerAuthorView;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

public interface BookApplicationService {

    Optional<DisplayBookDto> save(CreateBookDto bookDto);

    Optional<DisplayBookDto> update(Long id, UpdateBookDto bookDto);

    Optional<DisplayBookDto> findById(Long id);

    List<DisplayBookDto> findAll();

    void deleteById(Long id);

    List<DisplayBookDto> findByName(String name);

    Optional<DisplayBookDto> rent(Long id);

    List<BooksPerAuthorView> getBooksCountByAuthor();

    Page<DisplayBookDto> findAll(Pageable pageable);

}
