package mk.finki.ukim.mk.lab_1.repository;

import mk.finki.ukim.mk.lab_1.model.domain.Author;
import mk.finki.ukim.mk.lab_1.model.projections.AuthorProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query("SELECT a.name as name, a.surname as surname FROM Author a")
    List<AuthorProjection> getAllNameAndSurname();

}
